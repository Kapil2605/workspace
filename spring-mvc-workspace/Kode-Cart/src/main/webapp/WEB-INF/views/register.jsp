<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false" %>
<html>
<head>
    <title>KodeKart - Register</title>
</head>
<body>
    <h2>Register to KodeKart</h2>
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
    <form action="/register" method="post">
        Name: <input type="text" name="name" required/><br/><br/>
        Email: <input type="email" name="email" required/><br/><br/>
        Phone: <input type="text" name="phone"/><br/><br/>
        Password: <input type="password" name="password" required/><br/><br/>
        Role: 
        <select name="role">
            <option value="USER">User</option>
            <option value="ADMIN">Admin</option>
        </select><br/><br/>
        <button type="submit">Register</button>
    </form>
    <br/>
    <a href="/login">Already have an account? Login here</a>
</body>
</html>
