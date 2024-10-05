<%@ page import="com.oop.models.RegisteredUser" %>

<header>
	<img src="images/logo.png" class="logo-image">
	<nav>
		<input type="search" placeholder="Search games">
		<button>Go</button>
		<ul>
			<li><a href="./">Browse Games</a></li>
			<li><a href="./">Support</a></li>
		</ul>
	</nav>
	<div id="profile-actions">
		<%
			RegisteredUser user = (RegisteredUser) session.getAttribute("user");
			if (user != null) {
		%>
		<a href='logout'><button>Logout</button></a>
		<div>
			<img class='profile-image' src='images/user-solid.svg'>
			<div id="profile-name">
				<% out.print(user.getUsername()); %>
				<button id='profile-dropdown'>v</button>
			</div>
		</div>
		<% } else { %>
		<a href='login'><button>Login</button></a>
		<% } %>
	</div>
</header>
