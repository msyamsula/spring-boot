<!-- boiler plate -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>list customers</title>
	<!-- link to css -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>CRM - Customer Relationship Manager</h1>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<!-- loop in customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<td>${ tempCustomer.first_name }</td>
						<td>${ tempCustomer.last_name }</td>
						<td>${ tempCustomer.email }</td>
					</tr>
				
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>