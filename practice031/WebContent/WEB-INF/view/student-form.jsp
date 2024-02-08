<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registartion Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
First Name : <form:input path="firstName" />
		<br>
		<br>
Last Name : <form:input path="lastName" />
		<br>
		<br>
Country : 
<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		<br>
		<br>
Favorite Programming Language :  
JAVA <form:radiobutton path="favoriteLanguage" value="JAVA" />
Python <form:radiobutton path="favoriteLanguage" value="Python" />
JS <form:radiobutton path="favoriteLanguage" value="JS" />
C# <form:radiobutton path="favoriteLanguage" value="C#" />
		<br>
		<br>
Operating Systems :
Linux <form:checkbox path="operatingSystems" value="Linux" />
MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
MAC <form:checkbox path="operatingSystems" value="MAC" />
		<br>
		<br>
		<input type="submit" value="Submit" />
		<br>
		<br>
	</form:form>
</body>
</html>