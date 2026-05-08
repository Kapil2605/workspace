<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false" %>
<html>
<head>
    <title>KodeKart - Login</title>
</head>
<body>
    <h2>Login to KodeKart</h2>
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
    <form action="/login" method="post">
        Email: <input type="email" name="email" required/><br/><br/>
        Password: <input type="password" name="password" required/><br/><br/>
        <button type="submit">Login</button>
    </form>
    <br/>
    <a href="/Kode-Cart/register">Don't have an account? Register here</a>
</body>
</html>
