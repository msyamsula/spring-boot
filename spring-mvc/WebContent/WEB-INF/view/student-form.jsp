<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!-- boiler plate to make form become object -->

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Student Registration Form</title>
  </head>
  <body>
    <form:form action="processForm" modelAttribute="student">
    	<div> firstName : <form:input path="firstName"></form:input> </div>
    	<div> lastName : <form:input path="lastName"></form:input> </div>
    	<input type="submit" value="Submit">
    </form:form>
  </body>
</html>
