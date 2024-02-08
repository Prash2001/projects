<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style type="text/css">
.failed {
	color: red;
}
</style>
</head>
<body>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<c:if test="${param.error != null }">
			<i class="failed">Sorry! you entered invalid username/paaword.</i>
			<br>
			<br>
		</c:if>
		
User Name : <input type="text" name="username" />
		<br>
Password : <input type="password" name="password" />
		<br>
		<input type="submit" Value="Login" />
	</form:form>
</body>
</html>