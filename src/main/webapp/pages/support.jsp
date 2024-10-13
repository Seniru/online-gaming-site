<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.oop.models.RegisteredUser" %>
<%@ page import="com.oop.models.CustomerSupportAgent" %>

<%
	// authorization
	
	final boolean ANY_ACCESS = false;
	final boolean USER_ACCESS = true;
	final boolean AGENT_ACCESS = false;

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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!--google fonts-->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">		<link rel="stylesheet" href="../styles/components.css">
		<link rel="stylesheet" href="styles/components.css">
		<script src="scripts/support.js"></script>
		<!--font awesome-->
		<script src="https://kit.fontawesome.com/36fdbb8e6c.js" crossorigin="anonymous"></script>
		<title>Customer Support</title>
	</head>
	<body>
		<jsp:include page="./views/header.jsp" />
		<div class="wrapper">
        <div class="container">
            <h1>Customer Support Page</h1>
            <form method="POST" action="" onsubmit="return validate()">
            	<label for="Title">Title</label><br>
            	<input type="text" id="subject" name="title" placeholder="Type here" required><br><br>
            	<label for="Body">Body</label><br>
            	<textarea id="content" name="content" rows="8" cols="80"placeholder="Type here" required></textarea><br><br>
            	<input type="submit" value="Submit" name="submit">
        	</form>
        </div>
	</body>
</html>
