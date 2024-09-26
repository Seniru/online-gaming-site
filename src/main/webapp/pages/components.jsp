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
		<link rel="stylesheet" href="../styles/components.css">
		<!--font awesome-->
		<script src="https://kit.fontawesome.com/36fdbb8e6c.js" crossorigin="anonymous"></script>
		<title>Components</title>
	</head>
	<body>
		<jsp:include page="./views/header.jsp" />
		<div class="wrapper">
			<h1>Primary heading</h1>
			<h2>Secondary heading</h2>
			<h3>Tertiary heading</h3>
			<a href="./">Link</a>
			<p>
				Lorem, ipsum dolor sit amet consectetur adipisicing elit. Debitis voluptate tempore perspiciatis molestiae, illo, consectetur rerum ut mollitia in nemo excepturi aspernatur corporis accusantium quos saepe, temporibus obcaecati perferendis similique.
			</p>
			<button>Button</button>
			<br><br>
			<input type="text" placeholder="Enter text">
			<br><br>
			<input type="number" placeholder="Enter a number">
			<br><br>
			<input type="date">
			<br><br>
			<input type="search" placeholder="Search...">
			<br><br>
			<input type="checkbox"> Check #1
			<input type="checkbox" checked> Check #2
			<br>
			<input type="radio"> Radio #1
			<input type="radio" checked> Radio #2
			<br>
			<br>
			<select>
				<option>Option 1</option>
				<option>Option 2</option>
				<option>Option 3</option>
			</select>
			<br><br>
			<div class="chip">
				<i class="fa-solid fa-dice-three fa-lg"></i>
				<div class="name-container">Category 1</div>
			</div>
			<div class="chip">
				<i class="fa-solid fa-gamepad fa-lg" style="color: cornflowerblue;"></i>
				<div class="name-container">Category 2</div>
			</div>
			<br><br>
			<div class="container">
				<h1>Container</h1>
				Text
			</div>
		</div>
	</body>
</html>
