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
		<!--font awesome-->
		<script src="https://kit.fontawesome.com/36fdbb8e6c.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="styles/login.css">
		<title>Login</title>
		<% 
    		String error = (String) request.getAttribute("error");
    		if (error != null) {
		%>
    	<script>
        	alert('<%= error %>');
    	</script>
		<%
    		}
		%>
	</head>
	<body>
		<div class="wrapper">
			<body>

				<h2>Login</h2>
				<div class="container">
					<h1>Welcome back</h1>
					<br>
					<form method="POST" action="">
						<label for="username">Username:</label><br>
						<input type="text" name="username" id="username" placeholder="Enter your username"><br><br>
						<label for="password">Password:</label><br>
						<input type="password" name="password" id="password" placeholder="Enter your password"><br><br>
						<section class="toright">
							<a href="/">Forgot password?</a><br>
							<input type="submit" name="submit" value="Login">
						</section>
						<br>
					</form>
					<div id="separator"><span>or</span></div>
					<i class="fa-brands fa-apple"></i>
					<i class="fa-brands fa-facebook"></i>
					<i class="fa-brands fa-google"></i>
					<br><br>
					Not a member? <a href="signup.php">Sign up</a>
					<br><br>
				</div>		
			</body>
		</div>
	</body>
</html>
