<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
	<div class="row">
		<div class="col-md-2">
			<a href="#" class="logo">Logo</a>
		</div>
		<div class="col-md-9">
			<div class="pull-right">
				<ul class="list-inline" style="margin: 10px 0px;">
					<li>Welcome</li>
					<li>
					<%if (request.getSession().getAttribute("emp")!= null) { %>
						<a href="${pageContext.request.contextPath}/employee/${emp.employee_id}">
							<img src="<c:url value="/resources/img/no_avatar.jpg"/>" class="header-avatar img-circle img-thumbnail" alt="avatar">
						</a>
					<%}%>
					</li>
				</ul>
			</div>
		</div>
		
		<div class="col-md-1">
		<%if (request.getSession().getAttribute("emp")!= null){ %>
			<button class="navicon">
				<span>&#9776;</span>
				<div class="mainNavDropDown">
					<ul style="list-style-type:none">
						<li>My Profile</li>
						<li>Change Password</li>
						<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
					</ul>
				</div>
			</button>
		<%}%>
		</div>
	</div>
</nav>