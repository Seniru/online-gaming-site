<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.oop.models.RegisteredUser" %>
<%@ page import="com.oop.models.CustomerSupportAgent" %>

<%
	// authorization
	
	final boolean ANY_ACCESS = true;
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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!--google fonts-->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">		<link rel="stylesheet" href="../styles/components.css">
		<link rel="stylesheet" href="styles/components.css">
		<link rel="stylesheet" href="styles/signup.css">
		<script src="scripts/signup.js"></script>
		<!--font awesome-->
		<script src="https://kit.fontawesome.com/36fdbb8e6c.js" crossorigin="anonymous"></script>
		<title>Sign up</title>
	</head>
	<body class="wrapper">
		<a href="explore">&lt; Go back</a>
		<form id="signup-form" class="container" method="POST" action="" onsubmit="return validate(event)">
			<h1>Create an account...</h1>
			<div id="signup-options">
				<div id="signup-email-container">
					Username
					<input id="username" type="text" name="username" required>
					<br>
					Email
					<br>
					<input id="email" type="email" name="email" required>
					<br>
					Password
					<br>
					<input id="password" type="password" name="password" required>
					<br>
					Confirm password
					<br>
					<input id="re-password" name="re-password" type="password" required>
					<br>
					<input type="submit" name="submit" value="Sign up">
				</div>
				<div id="signup-other-container">
					Or create an account with...
					<br><br>
					<a href="./" id="signup-google">
						<button>
							<i class="fa-brands fa-google"></i>
 							Signup with Google
						</button>
					</a>
					<br>
					<a href="./" id="signup-microsoft">
						<button>
							<i class="fa-brands fa-microsoft"></i>
							Signup with Microsoft
						</button>
					</a>
				</div>
			</div>
		</form>
	</body>
</html>
