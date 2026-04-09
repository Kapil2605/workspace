<%@ page import="java.util.List"%>
<%@ page import="com.zepto.product.entity.ProductEntity"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Product</title>
</head>
<body>

	<form action="searchProduct" method="post">
        
        <label>Enter Product Id</label>
        <input type="text" name="productId">
        <input type="submit" value="Search Product">
    </form>

</body>
</html>