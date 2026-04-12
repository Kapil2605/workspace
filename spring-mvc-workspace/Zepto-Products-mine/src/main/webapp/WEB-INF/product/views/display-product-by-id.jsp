<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f6fa;
    }

    .container {
        width: 40%;
        margin: 60px auto;
        background: white;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
    }

    h3 {
        text-align: center;
        color: #2f3640;
        margin-bottom: 20px;
    }

    .row {
        margin: 10px 0;
        font-size: 16px;
    }

    .label {
        font-weight: bold;
        color: #353b48;
    }

    .value {
        color: #192a56;
    }
</style>

</head>
<body>

<div class="container">
    <h3>📦 Product Details</h3>

    <div class="row">
        <span class="label">Product ID:</span>
        <span class="value">${product.productId}</span>
    </div>

    <div class="row">
        <span class="label">Name:</span>
        <span class="value">${product.name}</span>
    </div>

    <div class="row">
        <span class="label">Quantity:</span>
        <span class="value">${product.qty}</span>
    </div>

    <div class="row">
        <span class="label">Price:</span>
        <span class="value">₹ ${product.price}</span>
    </div>

    <div class="row">
        <span class="label">Description:</span>
        <span class="value">${product.description}</span>
    </div>

    <div class="row">
        <span class="label">Sold By:</span>
        <span class="value">${product.soldBy}</span>
    </div>
	<a href="editProduct?productId=${product.productId}">
    <button>Update</button>
	<a href="deleteProduct?productId=${product.productId}">
    <button>Delete</button>
</a>
</div>

</body>
</html>