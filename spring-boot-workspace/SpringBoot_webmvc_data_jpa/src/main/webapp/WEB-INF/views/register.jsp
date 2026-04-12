<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="bg">
	<h3>Register</h3>
	
	<c:if test="${not empty successMsg}">
	<h4 style="color: green">${successMsg}</h4>
	</c>
	
	<c:if test="${not empty errorMsg}">
	<h4 style="color: green">${errorMsg}</h4>
	</c>
	
	<form action="registerForm" method="post">
	Name:<input type="text" name="name"/>
	Email:<input type="text" name="email"/>
	Password:<input type="password" name="password"/>
	Name:<input type="text" name="phoneno"/>
	<input type="submit" value="Register"/>
	</form>
	If already registered...<a href="loginPage">Click here</a>
</body>
</html>