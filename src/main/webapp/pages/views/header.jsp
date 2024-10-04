<%@ page import="com.oop.models.RegisteredUser" %>

<header>
	<img src="./" class="logo-image">
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
		<button>Logout</button>
		<div>
			<img class='profile-image' src='images/user-solid.svg'>
			<div id="profile-name">
				<% out.print(user.getUsername()); %>
				<button id='profile-dropdown'>v</button>
			</div>
		</div>
		<% } else { %>
		<button>Login</button>
		<% } %>
	</div>
</header>
