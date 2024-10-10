

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%@ page import="com.oop.models.Game" %>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="com.oop.models.Category" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--google fonts-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="styles/components.css">
<link rel="stylesheet" href="styles/components.css">
<link rel="stylesheet" href="styles/explore.css">

<!--font awesome-->
<script src="https://kit.fontawesome.com/36fdbb8e6c.js"
	crossorigin="anonymous"></script>
<title>Explore</title>
</head>
<body>
	<jsp:include page="./views/header.jsp" />
    <aside class="container">
        <ul class="category-list">
			
			<%
						ArrayList<Category> categories = Category.getAllCategories();
						for (Category cat : categories) {

			%>
			<li>
				<a href="#">
					<div class="chip">
						<i class="<% out.write(cat.getIcon()); %>" style="color: <% out.write(cat.getColor()); %>"></i>
						<div class="name-container"><% out.write(cat.getCname()); %></div>
					</div>
				</a>
			</li>
	
			<%
				}
			%>
		</ul>
    </aside>
	<div class="wrapper">
		<h3>Search For Games</h3>
		<input id="game-search" type="search" placeholder="Search...">
        <button id="Gobutton">GO</button>
		
		<br>
		<div class="chip">
			<i class="fa-solid fa-dice-three fa-lg"></i>
			<div class="name-container">Category 1</div>
		</div>
		<div class="chip">
			<i class="fa-solid fa-gamepad fa-lg" style="color: cornflowerblue;"></i>
			<div class="name-container">Category 2</div>
		</div>
		<section class="trending-section">
		<h2><i class="fa-solid fa-arrow-trend-up"> </i> Trending Games </h2>
		<%
		
						ArrayList<Game> trendingGames = Game.getTrendingGames();
						for (Game tgame  : trendingGames) {
							
			%>
		<div class="game container">
				<img src="<% out.write(tgame.getImage()); %>">
				<span><a href="./play?title=<% out.write(tgame.getTitle()); %>"><% out.write(tgame.getTitle()); %></a></span>
		</div>
		<% } %>
		</section>

		<section class="recommended-section">
		<h2><i class="fa-solid fa-thumbs-up"></i> Recommended Games</h2>
		<%
		
						ArrayList<Game> recommendedGames = Game.getRecommendedGames();
						for (Game rgame  : recommendedGames) {
							
			%>
		<div class="game container">
			<img src="<% out.write(rgame.getImage()); %>">
			<span><a href="./play?title=<% out.write(rgame.getTitle()); %>"><% out.write(rgame.getTitle()); %></a></span>
		</div>
		<% } %>


		</section>
		<section class="pro-section">
		<h2><i class="fa-brands fa-web-awesome"></i> Pro Games</h2>
		
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
		<section class="search-section">
		<h2><i class="fa-solid fa-gamepad"></i> Search For More Games</h2>
		<%
		
						ArrayList<Game> games = Game.getAllGames();
						for (Game game  : games) {
							
			%>
			<div class="game container">
				<img src="<% out.write(game.getImage()); %>">
			<span><a href="./play?title=<% out.write(game.getTitle()); %>"><% out.write(game.getTitle()); %></a></span>
		</div>

		<%
			
	}


		%>
		

		</section>
</body>
</html>
