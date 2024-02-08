<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello World Form</title>
</head>
<body>
Enter Student Information
<br><br>
	<form action="processForm" method="GET">
		<input type="text" name="firstName" placeholder="What's your name ?" />
		<input type="submit" value = "Submit"/>
	</form>
</body>
</html>