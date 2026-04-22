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

<form action="updateProductForm" method="post">

<input type="hidden" name="id" value="${product.id}">

Name:<input type="text" name="name" value="${product.name}">
Description:<input type="text" name="description" value="${product.description}">
Quantity:<input type="text" name="stock_quantity" value="${product.stock_quantity}">
Price:<input type="text" name="productPrice" value="${product.price.productPrice}">

<select name="currency">
  <option value="INR" ${product.price.currency == 'INR' ? 'selected' : ''}>INR</option>
  <option value="USD" ${product.price.currency == 'USD' ? 'selected' : ''}>USD</option>
</select>

<input type="submit" value="submit">
</form>
</body>
</html>