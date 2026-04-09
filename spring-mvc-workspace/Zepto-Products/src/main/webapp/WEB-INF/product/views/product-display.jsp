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
<h3>Displaying Product </h3>	
	Product ID:${response.getProductId()}<br>
	Confirmation:${response.getConfirmationMsg()}<br>
	
</body>
</html>