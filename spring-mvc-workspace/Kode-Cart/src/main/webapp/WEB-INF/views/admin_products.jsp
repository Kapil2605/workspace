<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>KodeKart - Admin Dashboard</title>
</head>
<body>
    <h2>Admin Dashboard - Manage Products</h2>
    <a href="/admin/products/add">Add New Product</a> | <a href="/admin/orders">View All Orders</a> | <a href="/logout">Logout</a>
    <hr/>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.category}</td>
                <td>$${product.price}</td>
                <td>${product.quantity}</td>
                <td>
                    <a href="/admin/products/edit/${product.id}">Edit</a> | 
                    <a href="/admin/products/delete/${product.id}" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
