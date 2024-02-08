<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation</title>
</head>
<body>
The customer is Confirmed : ${customer.firstName} ${customer.lastName}
<br><br>
Number of Free Passes : ${customer.freePass}
<br><br>
Postal Code : ${customer.postalCode}
<br><br>
Course Code : ${customer.courseCode}
</body>
</html>