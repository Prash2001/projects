<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>
	The Student is Confirmed ${student.firstName} ${student.lastName}
	<br>
	<br> Country : ${student.country}
	<br>
	<br> Favorite Programming Language : ${student.favoriteLanguage}
	<br>
	<br>
	ImageName : ${student.image}
	<br>
	<br> Operating Systems :
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
	<br><br>
	 <img src="data:image/png;base64,${student.data}" width="240" height="300"/>
</body>
</html>