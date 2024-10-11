<%@ page import="com.oop.models.Ticket" %>
<%@ page import="java.util.ArrayList" %>


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
					t.print(out);
				}
			%>

			<h1>Resolved tickets</h1>
			<%
				ArrayList<Ticket> closed = Ticket.getTickets(true);
				for (Ticket t : closed) {
					t.print(out);
				}
			%>

		</div>
	</body>
</html>
