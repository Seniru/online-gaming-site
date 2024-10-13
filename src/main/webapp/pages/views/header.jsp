<%@ page import="com.oop.models.BaseUser" %>
<%@ page import="com.oop.models.RegisteredUser" %>
<%@ page import="com.oop.models.CustomerSupportAgent" %>

<header>
	<script>
		let search = () => {
			let query = document.getElementById("header-search")
			let urlParams = new URLSearchParams(location.search)
			urlParams.set("query", query.value)
			window.location = "explore?" + urlParams.toString()
		}
	</script>
	<img src="images/logo.png" class="logo-image">
	<nav>
		<input type="search" placeholder="Search games" id="header-search">
		<button onclick="search()">Go</button>
		<ul>
			<li><a href="explore">Browse Games</a></li>
			<li><a href="support">Support</a></li>
		</ul>
	</nav>
	<div id="profile-actions">
		<%
			BaseUser u = (BaseUser) session.getAttribute("user");
			String r = (String) session.getAttribute("role");
			if (u != null) {
		%>
		<a href='logout'>
			<button> Logout </button>
		</a>
		<div>
			<img class='profile-image' src='images/user-solid.svg'>
			<div id="profile-name">
				<% out.print(u.getUsername()); %>
				<button id='profile-dropdown' title="<%= r.equals("user") ? "Profile" : "Tickets" %>">
					<a href="<%= r.equals("user") ? "profile" : "tickets" %>">
						<i class="fa-solid fa-chevron-right"></i>
					</a>
				</button>
			</div>
		</div>
		<% } else { %>
		<a href='login'><button>Login</button></a>
		<% } %>
	</div>
</header>
