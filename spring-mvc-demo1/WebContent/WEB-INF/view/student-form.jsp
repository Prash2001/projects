<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student-Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	First name :
	<form:input path="firstName" />
		<br>
		<br> 
	Last name :
	<form:input path="lastName" />
		<br>
		<br>
    Country :		
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
			<!--<form:option value="Brazil" label="Brazil" />
			<form:option value="France" label="France" />
			<form:option value="Germany" label="Germany" />
			<form:option value="India" label="India" />-->
		</form:select>
		<br>
		<br>
		Favorite Language :
	Java <form:radiobutton path="favoriteLanguage" value="Java" />
	C# <form:radiobutton path="favoriteLanguage" value="C#" />
	Python <form:radiobutton path="favoriteLanguage" value="Python" />
	PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
	<br><br>
Operating System :
	Linux <form:checkbox path="operatingSystems" value = "Linux"/>
	MS Windows <form:checkbox path="operatingSystems" value = "MS Windows"/>
	Mac OS <form:checkbox path="operatingSystems" value = "Mac OS"/>
	<br><br>
		<input type="submit" value="Submit" />
		<br>
		<br>
	</form:form>
</body>
</html>