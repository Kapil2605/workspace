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
<form action="updateProduct" method="post">

    <input type="hidden" name="productId" value="${product.productId}" />

    Name: <input type="text" name="productName" value="${product.name}" /><br>

    Qty: <input type="text" name="qty" value="${product.qty}" /><br>

    Description: <input type="text" name="description" value="${product.description}" /><br>

    Price: <input type="text" name="price" value="${product.price}" /><br>

    Sold By: <input type="text" name="soldBy" value="${product.soldBy}" /><br>

    <button type="submit">Update</button>

</form>
</body>
</html>