<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="submitProduct" method="post">

Name:<input type="text" name="name">
Description:<input type="text" name="description">
Quantity:<input type="text" name="stock_quantity">
Price:<input type="text" name="productPrice">

<label for="currency">Choose Currency:</label>
<select name="currency" id="currency">
  <option value="INR">INR</option>
  <option value="USD">USD</option>
</select>
<input type="submit" value="submit">
</form>
</body>
</html>