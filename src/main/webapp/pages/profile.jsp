<%@ page import="com.oop.models.RegisteredUser" %>

<% RegisteredUser profileUser = (RegisteredUser) session.getAttribute("user"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!--google fonts-->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">		<link rel="stylesheet" href="../styles/components.css">
		<link rel="stylesheet" href="styles/components.css">
		<link rel="stylesheet" href="styles/profile.css">
		<!--font awesome-->
		<script src="https://kit.fontawesome.com/36fdbb8e6c.js" crossorigin="anonymous"></script>
		<title>Profile</title>
	</head>
	<body>
		<jsp:include page="./views/header.jsp" />
		<div class="wrapper">
			<div id="user-info">
				<img src="images/user-solid.svg">
				<div>
					<h1><% out.print(profileUser.getUsername()); %></h1>
					<span class="badge staff">Staff</span>
					<span class="badge pro">Pro</span>
					<span class="badge dev">Developer</span>
				</div>
			</div>
			<br>
			<hr>
			<section class="trending-section">
			<h2>Recent games </h2>
			<div class="game container">
					<img src="../images/game.avif">
				<span>Title</span>
			</div>
			<div class="game container">
				<img src="../images/game.avif">
				<span>Title</span>
			</div>
			<div class="game container">
					<img src="../images/game.avif">
				<span>Title</span>
			</div>
			<div class="game container">
					<img src="../images/game.avif">
				<span>Title</span>
			</div>
			<div class="game container">
					<img src="../images/game.avif">
				<span>Title</span>
			</div>
			</section>

		<section class="recommended-section">
		<h2> Saved Games</h2>
		<div class="game container">
				<img src="../images/game.avif">
			<span>Title</span>
		</div>
		<div class="game container">
			<img src="../images/game.avif">
			<span>Title</span>
		</div>
		<div class="game container">
				<img src="../images/game.avif">
			<span>Title</span>
		</div>
		<div class="game container">
				<img src="../images/game.avif">
			<span>Title</span>
		</div>
		<div class="game container">
				<img src="../images/game.avif">
			<span>Title</span>
		</div>

		</section>
		<section class="pro-section">
			<h2> Developed Games</h2>
			<div class="game container">
					<img src="../images/game.avif">
				<span>Title</span>
			</div>
			<div class="game container">
				<img src="../images/game.avif">
				<span>Title</span>
			</div>
			<div class="game container">
					<img src="../images/game.avif">
				<span>Title</span>
			</div>
			<div class="game container">
					<img src="../images/game.avif">
				<span>Title</span>
			</div>
			<div class="game container">
					<img src="../images/game.avif">
				<span>Title</span>
			</div>

		</section>
	
		</div>
		<br>
		<br>
		<br>
		<div class="container">
            <h1>Details</h1>
            <form method="POST" action="">
            	<label for="name">Username:</label><br>
            	<input type="text" id="name" name="name" placeholder="Enter your name" value="<% out.print(profileUser.getUsername()); %>"><br><br>
            	<label for="Email">Email:</label><br>
            	<input type="text" id="Email" name="Email" placeholder="Enter your Email" value="<% out.print(profileUser.getEmail()); %>"><br><br>
            	<label for="New password">New Password:</label><br>
            	<input type="password" id="pwd" name="Password"placeholder="Enter a new password"><br><br>
				<label for="Confirm new password">Confrim New Password:</label><br>
            	<input type="password" id="conf-pwd" placeholder="Re-Enter new password"><br><br>

            	<br><br>
            	<input type="submit" value="Save changes" name="Save Changes">
        	</form>
		</div>
		<div class="wrapper">
			<h1>Extra actions</h1>
			<input type="submit" value="Become a pro!" name="Save Changes">
			<input type="submit" value="Become a devoloper" name="Save Changes">		
		</div>
	</body>
</html>