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
		<link rel="stylesheet" href="../styles/upload-games.css">
		<script src="../scripts/upload-games.js"></script>
		<!--font awesome-->
		<script src="https://kit.fontawesome.com/36fdbb8e6c.js" crossorigin="anonymous"></script>
		<title>Components</title>
	</head>
	<body>
		<jsp:include page="./views/header.jsp" />
		<div class="wrapper">
			<h2>Upload games</h2>
			<form class="container">
				<fieldset>
					<label>Title</label>
					<br>
					<input type="text" name="title">
					<br><br>
					<label>Description</label>
					<br>
					<textarea cols="80" rows="10"></textarea>
					<br>
					<label>Categories</label>
					<br><br>
					<label>
						<input type="checkbox" name="category[]" value="cat">
						Category 1
						<i class="fa-solid fa-dice-three fa-lg"></i>
					</label>
					<label>
						<input type="checkbox" name="category[]" value="cat">
						Category 2
						<i class="fa-solid fa-dice-three fa-lg"></i>
					</label>
					<label>
						<input type="checkbox" name="category[]" value="cat">
						Category 3
						<i class="fa-solid fa-dice-three fa-lg"></i>
					</label>
					<br><br>
					Cover image
					<input type="file">
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
						<input type="text" placeholder="Enter link">
					</div>
				</fieldset>
				<input type="submit" name="submit" value="Submit">
			</form>
		</div>
	</body>
</html>
