<%@ page import="java.util.ArrayList" %>
<%@ page import="com.oop.models.Game" %>
<%@ page import="com.oop.models.RegisteredUser" %>
<%@ page import="com.oop.models.Comment" %>

<% 
	String title = request.getParameter("title");
	Game game = Game.fromTitle(title);

	RegisteredUser user = (RegisteredUser) session.getAttribute("user");
	if (user != null) {
		user.play(game);
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
		<link rel="stylesheet" href="styles/play.css">
		<script src="scripts/play.js"></script>
		<!--font awesome-->
		<script src="https://kit.fontawesome.com/36fdbb8e6c.js" crossorigin="anonymous"></script>
		<title>Play</title>
	</head>
	<body>
		<jsp:include page="./views/header.jsp" />
		<div class="wrapper">
			<div>
			<div id="gamebox">
				<embed type="text/html" src="<% out.print(game.getUrl());%> "width="860px" height="400px">
			</div>	
			<div id="title-row">
				<h1><% out.print(game.getTitle());%></h1>
				<div id="star">
					<div>
					<i class="fa-solid fa-star"></i>
					<i class="fa-solid fa-star"></i>
					<i class="fa-solid fa-star"></i>
					<i class="fa-solid fa-star"></i>
					<i class="fa-solid fa-star"></i>
					<i class="fa-solid fa-star"></i>
					</div>
					<div id="heart" onclick="saveGame()">
						<i class="fa-solid fa-heart"></i>
					</div>
				</div>
			</div>
			</div>
		<div class="chip">
			<i class="fa-solid fa-dice-three fa-lg"></i>
			<div class="name-container">Category 1</div>
		</div>
		<div class="chip">
			<i class="fa-solid fa-gamepad fa-lg" style="color: cornflowerblue;"></i>
			<div class="name-container">Category 2</div>

		</div>
		<p>
			<% out.print(game.getDescription());%>
		</p>

		</div>
		<h2>Comments</h2>
		<%
			ArrayList<Comment> comments = Comment.getComments(game);
			for (Comment comment : comments) {
				comment.print(out);
			}
		%>
				
		<form action="comment" method="POST">
			<input type="text" name="title" value="<% out.print(game.getTitle());%>" hidden readonly>
			<textarea placeholder="Post a comment" rows="5" cols="80" name="comment"></textarea>
			<br>
			<button type="submit">Submit</button>
		</form>
			

		</div>
	</body>
</html>