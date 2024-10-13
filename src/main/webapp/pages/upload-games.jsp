<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.oop.models.Category" %>
<%@ page import="com.oop.models.RegisteredUser" %>
<%@ page import="com.oop.models.CustomerSupportAgent" %>

<%
	// authorization
	
	final boolean ANY_ACCESS = false;
	final boolean USER_ACCESS = true;
	final boolean AGENT_ACCESS = false;

	String role = (String) session.getAttribute("role");

	if (
		(!ANY_ACCESS && role == null)
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
		<link rel="stylesheet" href="styles/upload-games.css">
		<script src="scripts/upload-games.js"></script>
		<!--font awesome-->
		<script src="https://kit.fontawesome.com/36fdbb8e6c.js" crossorigin="anonymous"></script>
		<title>Upload games</title>
	</head>
	<body>
		<jsp:include page="./views/header.jsp" />
		<div class="wrapper">
			<h2>Upload games</h2>
			<form method="POST" action="" class="container">
				<fieldset>
					<label>Title</label>
					<br>
					<input type="text" name="title" required>
					<br><br>
					<label>Description</label>
					<br>
					<textarea name="description" cols="80" rows="10" required></textarea>
					<br><br>
					<label>Categories</label>
					<br>
					<%
						ArrayList<Category> categories = Category.getAllCategories();
						for (Category cat : categories) {
					%>
					<label style="padding: 3px; background-color: <% out.write(cat.getColor()); %>22; color: <% out.write(cat.getColor()); %>;">
						<input type="checkbox" name="category[]" value="<% out.write(cat.getCname()); %>">
						<% out.write(cat.getCname()); %>
						<i class="<% out.write(cat.getIcon()); %>"></i>
					</label>
					<%
						}
					%>
					
					<br><br>
					Cover image
					<br>
					<input name="file" type="file">
					<span> or </span>
					<input type="text" name="image" id="image-link" placeholder="Insert image link here..." required>
					<br><br>
					Preview
					<div id="image-preview">
	
					</div>
				</fieldset>
				<fieldset>
					<h2>Upload with</h2>
					<select id="upload-option">
						<option value="link">Link</option>
						<option value="file">File Upload</option>
					</select>
					<br><br>
					<div id="upload-method">
						<input name="url" type="text" placeholder="Enter link" required>
					</div>
				</fieldset>
				<input type="submit" name="submit" value="Submit">
			</form>
		</div>
	</body>
</html>
