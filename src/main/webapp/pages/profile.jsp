<%@ page import="java.util.ArrayList" %>
<%@ page import="com.oop.models.RegisteredUser" %>
<%@ page import="com.oop.models.Game" %>

<%
	
	if (session.getAttribute("user") == null) {
		response.sendRedirect("explore");
		return;
	}

	RegisteredUser profileUser = (RegisteredUser) session.getAttribute("user");
	
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

			<section class="recent-section">
				<h2>Recent games </h2>
				<% 
					ArrayList<Game> recentGames = profileUser.getPlayedGames();
					int i = 0;

					for (Game game : recentGames) {
						game.print(out);
						if (++i == 5) break;
					}
				%>
			</section>

		<section class="recommended-section">
		<h2> Saved Games</h2>
		<% 
			ArrayList<Game> favourites = profileUser.getSavedGames();
			i = 0;

			for (Game game : favourites) {
				game.print(out);
				if (++i == 5) break;
			}
		%>

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
            	<input type="text" id="name" name="username" placeholder="Enter your name" value="<% out.print(profileUser.getUsername()); %>"><br><br>
            	<label for="Email">Email:</label><br>
            	<input type="text" id="Email" name="email" placeholder="Enter your Email" value="<% out.print(profileUser.getEmail()); %>"><br><br>
            	<label for="New password">New Password:</label><br>
            	<input type="password" id="pwd" name="password" placeholder="Enter a new password"><br><br>
				<label for="Confirm new password">Confirm New Password:</label><br>
            	<input type="password" id="conf-pwd" placeholder="Re-Enter new password"><br><br>

            	<br><br>
            	<input type="submit" value="Save changes" name="update">
        	</form>
		</div>
		<div class="wrapper" id="extra">
			<h1>Extra actions</h1>
			<form method="POST" action="">
				<input type="submit" name="action" value="Become a pro!">
			</form>
			<form method="POST" action="">
				<input type="submit" name="action" value="Become a developer">
			</form>
			<form method="POST" action="">
				<input type="submit" name="action" value="Delete account" style="background-color: #F44336;">
			</form>
		</div>
	</body>
</html>