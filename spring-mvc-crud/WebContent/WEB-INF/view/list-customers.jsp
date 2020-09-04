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
	
	<!-- add button -->
	<input type="button" value="Add Customer" onclick="window.location.href='showAddForm'; return false;" class="add-button"/>
	
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				
				
				<!-- loop in customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<td>${ tempCustomer.firstName }</td>
						<td>${ tempCustomer.lastName }</td>
						<td>${ tempCustomer.email }</td>
						<td>
							<a href="/spring-mvc-crud/customers/update?customerId=${tempCustomer.id}">Update</a>
							|
							<a href="/spring-mvc-crud/customers/delete/${tempCustomer.id}"
							onclick = "if(!(confirm('are you sure?'))) return false" >Delete</a>
						</td>
					</tr>
				
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>