<%@ page import="java.util.ArrayList" %>
<%@ page import="com.oop.models.Ticket" %>
<%@ page import="com.oop.models.RegisteredUser" %>
<%@ page import="com.oop.models.CustomerSupportAgent" %>

<%
	// authorization

	final boolean ANY_ACCESS = false;
	final boolean USER_ACCESS = true;
	final boolean AGENT_ACCESS = true;

	String role = (String) session.getAttribute("role");
	if (role == null) role = "unreg";

	if (
		(!ANY_ACCESS && role.equals("unreg"))
		|| (!USER_ACCESS && role.equals("user"))
		|| (!AGENT_ACCESS && role.equals("agent"))
	) {
		response.sendRedirect("explore");
		return;
	}

	CustomerSupportAgent agent = null;
	RegisteredUser user = null;
	if (role.equals("user")) {
		user = (RegisteredUser) session.getAttribute("user");
	} else {
		agent = (CustomerSupportAgent) session.getAttribute("agent");
	}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!--google fonts-->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">		<link rel="stylesheet" href="../styles/components.css">
		<link rel="stylesheet" href="styles/components.css">
		<link rel="stylesheet" href="styles/view-tickets.css">
		<!--font awesome-->
		<script src="https://kit.fontawesome.com/36fdbb8e6c.js" crossorigin="anonymous"></script>
		<title>View tickets</title>
	</head>
	<body>
		<jsp:include page="./views/header.jsp" />
		<div class="wrapper">
			<h1>Active tickets</h1>

			<%
				ArrayList<Ticket> open = Ticket.getTickets(false);
				for (Ticket t : open) {
					if (role.equals("user") && !t.getUser().getUsername().equals(user.getUsername())) continue;
					t.print(out);
				}
			%>

			<h1>Resolved tickets</h1>
			<%
				ArrayList<Ticket> closed = Ticket.getTickets(true);
				for (Ticket t : closed) {
					if (role.equals("user") && !t.getUser().getUsername().equals(user.getUsername())) continue;
					t.print(out);
				}
			%>

		</div>
	</body>
</html>
