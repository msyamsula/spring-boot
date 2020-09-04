<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Custom login</title>
</head>

<body>
	<h3>My Custom Login</h3>
	<form:form action="${pageContext.request.contextPath}/user/login" method="POST">
	
		<!-- Check for login error -->
		
		<c:if test="${param.error != null}">
			<i>Sorry! you enter invalid username/password</i>
		</c:if>
		
		<!-- check for logout status -->
		<c:if test="${param.logout != null}">
			<div>
				you have logout
			</div>
		</c:if>
		
		<p>
			Username: <input type="username" name="username" />
		</p>
		
		<p>
			Password: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="login">
	
	</form:form>
</body>
</html>