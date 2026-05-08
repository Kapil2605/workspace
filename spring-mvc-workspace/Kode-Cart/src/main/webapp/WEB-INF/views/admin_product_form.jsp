<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>KodeKart - Admin Product Form</title>
</head>
<body>
    <h2>${empty product.id ? 'Add New' : 'Edit'} Product</h2>
    <form action="/admin/products/save" method="post">
        <input type="hidden" name="id" value="${product.id}"/>
        Name: <input type="text" name="name" value="${product.name}" required/><br/><br/>
        Category: <input type="text" name="category" value="${product.category}" required/><br/><br/>
        Price: <input type="number" step="0.01" name="price" value="${product.price}" required/><br/><br/>
        Stock: <input type="number" name="quantity" value="${product.quantity}" required/><br/><br/>
        Description: <textarea name="description">${product.description}</textarea><br/><br/>
        <button type="submit">Save</button>
    </form>
    <a href="/admin/products">Cancel</a>
</body>
</html>
