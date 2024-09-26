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
		<title>Customer Support</title>
	</head>
	<body>
		<jsp:include page="./views/header.jsp" />
		<div class="wrapper">
        <div class="container">
            <h1>Customer Support Page</h1>
            <form method="POST" action="">
            	<label for="name">Name:</label><br>
            	<input type="text" id="name" Name="name" placeholder="Enter your name"><br><br>
            	<label for="Email">Email:</label><br>
            	<input type="text" id="Email" name="Email" placeholder="Enter your Email"><br><br>
            	<label for="Contact Number">Contact Number:</label><br>
            	<input type="text" id="ContactNumber" name="ContactNumber"placeholder="Enter your contact number"><br><br>
            	<label for="Request/Inquiry Type">Request/Inquiry Type:</label><br>
            	<select name="type">
            	    <option value="inquiries">Inquiries</option>
            	    <option value="complaints">Complaints</option>
            	</select>
            	<br><br>
            	<label for="Subject">Subject:</label><br>
            	<input type="text" id="Subject" name="Subject"placeholder="Type here" required><br><br>
            	<label for="Message">Message:</label><br>
            	<textarea id="content" name="content" rows="8" cols="80"placeholder="Type here" required></textarea><br><br>
            	<input type="submit" value="Submit" name="submit">
        	</form>
        </div>


	</body>
</html>
