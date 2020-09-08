<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
</head>
<body>
	<h3>HEELLO FROM SIMPLE MAVEN</h3>
	
	<!-- display username and roles from spring security -->
	<%-- <p>
		User: <security:authentication property="principal.name"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p> --%>
	
	<!-- link to /leader/** -->
	<a href="${pageContext.request.contextPath}/leaders">leaders only</a>
	
	<!-- link to /systems/** -->
	<a href="${pageContext.request.contextPath}/admins">admin only</a>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="logout" />
	</form:form>
</body>
</html>