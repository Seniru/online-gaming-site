<%@ page import="java.util.ArrayList" %>
<%@ page import="com.oop.models.Game" %>
<%@ page import="com.oop.models.RegisteredUser" %>
<%@ page import="com.oop.models.Comment" %>
<%@ page import="com.oop.models.Category" %>
<%@ page import="com.oop.models.CustomerSupportAgent" %>

<%
	// authorization
	
	final boolean ANY_ACCESS = true;
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


<% 
	String title = request.getParameter("title");
	Game game = Game.fromTitle(title);
	boolean loggedIn = false;

	if (user != null) {
		user.play(game);
		loggedIn = true;
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
			<div style="display: grid; justify-content: start;">
				<div id="gamebox">
					<embed type="text/html" src="<% out.print(game.getUrl());%> "width="1000px" height="500px">
				</div>	
				<div id="title-row">
					<h1><% out.print(game.getTitle());%></h1>
					<div id="star">
						<div>
						<i style="color: gold;" class="fa-solid fa-star"></i>
						<i style="color: gold;" class="fa-solid fa-star"></i>
						<i style="color: gold;" class="fa-solid fa-star"></i>
						<i class="fa-solid fa-star"></i>
						<i class="fa-solid fa-star"></i>
						<i class="fa-solid fa-star"></i>
						</div>
						<div style="cursor: pointer; color: #ac478a" id="heart" onclick="saveGame()">
							<i class="fa-solid fa-heart"></i>
						</div>
					</div>
				</div>
			</div>
		<%
			for (Category c : game.getCategories()) {
				c.print(out);
			}
		%>
		<p>
			<% out.print(game.getDescription());%>
		</p>

		</div>
		<h2>Comments</h2>
		<%
			ArrayList<Comment> comments = Comment.getComments(game);
			for (Comment comment : comments) {
				out.write("<div class='comment-parent'>");
				comment.print(out);
				if (loggedIn && user.getUsername().equals(comment.getUser().getUsername())) {
		%>
			<a href="comment?action=delete&title=<% out.write(comment.getGame().getTitle()); %>&id=<% out.write(Integer.toString(comment.getCommentID())); %>">
				<button>X</button>
			</a>
			
		<%
				}
				out.write("</div>");
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