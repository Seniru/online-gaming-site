<%@ page import="com.oop.models.Ticket" %>
<%@ page import="com.oop.models.RegisteredUser" %>
<%@ page import="com.oop.models.CustomerSupportAgent" %>

<%
	// authorization
	
	final boolean ANY_ACCESS = false;
	final boolean USER_ACCESS = true;
	final boolean AGENT_ACCESS = true;

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
  Ticket ticket = Ticket.fromTicketID(Integer.parseInt(request.getParameter("id")));
  if (role.equals("user") && !ticket.getUser().getUsername().equals(user.getUsername())) {
    response.sendRedirect("explore");
		return;
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
		<!--font awesome-->
		<script src="https://kit.fontawesome.com/36fdbb8e6c.js" crossorigin="anonymous"></script>
		<title>Ticket</title>
	</head>
	<body>
		<jsp:include page="./views/header.jsp" />
		<div class="wrapper">
        
            
            <form method="POST" action="" class="container">
            <i class="fa-solid fa-user"></i>

            <h1>Ticket interaction | <% out.write(ticket.getTitle()); %></h1>
            <br>
            <h3>Ticket ID</h3>
            <input type="text" name="id" value="<% out.write(Integer.toString(ticket.getTicketID())); %>" readonly>
            <br>
            <h3>Name</h3>
            <input type="text" value="<% out.write(ticket.getUser().getUsername()); %>" readonly> 
            <br>
            <i class="fa-solid fa-envelope"></i>
            <h3>Email</h3>
            <input type="text" value="<% out.write(ticket.getUser().getEmail()); %>" readonly>
            <br>  
            <h3>Created Date</h3>
            <input type="text" value="<% out.write(ticket.getCreatedDate()); %>" readonly>  
            <br>
            <h3>Status</h3>
            <% String status = ticket.isClosed() ? "Closed" : "Open"; %>
            <input type="text" value="<% out.write(status); %>" readonly>
            <br><br>
            <h3>Body</h3>
            <p>
              <% out.write(ticket.getBody()); %>
            </p>

             <input type="submit" name="delete" value="Delete Ticket" style="float: right; margin: 3px; background-color: #F44336;">
             <%
                if (role.equals("agent")) {
              %>
              <input type="submit" name="resolve" value="Resolve Ticket" style="float:right; margin: 3px;">
              <% } %>
             <br><br>
           </form>
       
	</body>
</html>