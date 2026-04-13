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
	<form action="${pageContext.request.contextPath}/editStudent" method="post">
		<input type="hidden" name="id" value="${student.id}" />
		Name:<input type="text" name="name" value="${student.name}"><br> <br> 
		Email:<input type="text" name="email" value="${student.email}"><br> <br>
		Course:<input type="text" name="course" value="${student.course}"><br> <br> 
		<input type="submit" value="Edit Student" >
	</form>
</body>
</html>