

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.oop.models.RegisteredUser" %>
<%@ page import="com.oop.models.Game" %>
<%@ page import="com.oop.models.ProGame" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.oop.models.Category" %>

<%
	RegisteredUser user = null;
	boolean loggedIn = false;
	if (session.getAttribute("user") != null) {
		loggedIn = true;
		user = (RegisteredUser) session.getAttribute("user");
	}
%>

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
<script src="scripts/explore.js"></script>

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
				String categoryParameters = request.getParameter("categories");
				ArrayList<String> categoryList = new ArrayList<String>();
				if (categoryParameters != null && !categoryParameters.equals("")) {
					categoryList = new ArrayList(Arrays.asList(categoryParameters.split(",")));
				}
				for (Category cat : categories) {
					if (categoryList.contains(cat.getCname())) {
						out.write("<li class=\"selected\">");
					} else {
						out.write("<li>");
					}
			%>
				<a href="#" onclick="addCategory(event)">
					<% cat.print(out); %>
				</a>
			</li>
			<%
				}
			%>
		</ul>
		<br><br><br>
    </aside>
	<div class="wrapper">
		<h3>Search For Games</h3>
		<input id="game-search" type="search" placeholder="Search..." value="<% out.write(request.getParameter("query")); %>">
        <button id="Gobutton">GO</button>
		<br><br>
		<%
			for (String cat : categoryList) {
				out.write("<div class='category-removable'>");
				Category.fromCname(cat).print(out);
				out.write("<a href='#' onclick='removeCategory(event)'>x</a></div>");
			}
		%>
		<div style="color: var(--secondary-text-color);"><% out.write(Integer.toString(categoryList.size())); %> categories selected...</div>

		<% if (
			(request.getParameter("query") == null || request.getParameter("query").equals(""))
			&& (request.getParameter("categories") == null || request.getParameter("categories").equals(""))
		) { %>
		<section class="trending-section">
		<h2><i class="fa-solid fa-arrow-trend-up"> </i> Trending Games </h2>
		<div class="scrollable-game-list">
		<%
		
			ArrayList<Game> trendingGames = Game.getTrendingGames();
			for (Game tgame  : trendingGames) {
				tgame.print(out);			
			}
		%>
		</div>
		</section>

		<% if (loggedIn) { %>
		<section class="recommended-section">
			<h2><i class="fa-solid fa-thumbs-up"></i> Recommended Games</h2>
			<div class="scrollable-game-list">
			<%
				ArrayList<Game> recommendedGames = Game.getRecommendedGames();
				for (Game rgame  : recommendedGames) {
					rgame.print(out);
		 		}
			%>
			</div>
		</section>
		<% } %>

		<% if (loggedIn && user.isPro()) { %>
		<section class="pro-section">
		<h2><i class="fa-brands fa-web-awesome"></i> Pro Games</h2>
		<%
			ArrayList<ProGame> proGames = ProGame.getAllGames();
			for (ProGame pGame : proGames) {
				pGame.print(out);
			}
		%>
		</section>
		<% } %>

		<section class="search-section">
		<h2><i class="fa-solid fa-gamepad"></i> Search For More Games</h2>
		<%
		
			ArrayList<Game> games = Game.getAllGames();
			for (Game game  : games) {				
				game.print(out);
			}

		%>
		

		</section>
		<% } else {
			ArrayList<Game> games = Game.searchGames(request.getParameter("query"), new ArrayList<Category>());
			for (Game game : games) {				
				game.print(out);
			}
		} %>

</body>
</html>
