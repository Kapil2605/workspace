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
	<h3>Login</h3>
	
	<c:if test="${not empty successMsg}">
	<h4 style="color: green">${successMsg}</h4>
	</c>
	
	<c:if test="${not empty errMsg}">
	<h4 style="color: red">${errMsg}</h4>
	</c> 
	
	<form action="loginForm" method="post">
	
	Email:<input type="text" name="email"/>
	Password:<input type="password" name="password"/>
	<input type="submit" value="Login"/>
	</form>
	
	<br/><br/>
	
	If not registered...<a href="regPage">Click here</a>
</body>
</html>