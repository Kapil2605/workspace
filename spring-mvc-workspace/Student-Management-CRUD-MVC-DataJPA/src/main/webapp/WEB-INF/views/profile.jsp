<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome Student:${response.getName()}</h3>
	<h3>Student Id:${response.getId()}</h3>
	<h3>Student Email:${response.getEmail()}</h3>
	<h3>Student Course:${response.getCourse()}</h3>
	
	<a href="editPage/${response.getId()}">Edit</a>
	<a href="deleteStudent/${response.getId()}">Delete</a>
	
</body>
</html>