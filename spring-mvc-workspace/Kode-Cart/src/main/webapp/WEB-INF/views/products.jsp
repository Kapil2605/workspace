<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>KodeKart - Products</title>
</head>
<body>
    <h2>Welcome, ${sessionScope.loggedInUser.name}!</h2>
    <a href="/cart">View Cart</a> | <a href="/orders">My Orders</a> | <a href="/logout">Logout</a>
    <hr/>
    <h3>Products</h3>
    <form action="/products" method="get">
        Search: <input type="text" name="keyword" />
        <button type="submit">Search</button>
    </form>
    <table border="1" cellpadding="5">
        <tr>
            <th>Name</th>
            <th>Category</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.name}</td>
                <td>${product.category}</td>
                <td>$${product.price}</td>
                <td>${product.quantity}</td>
                <td>${product.description}</td>
                <td>
                    <form action="/cart/add" method="post" style="display:inline;">
                        <input type="hidden" name="productId" value="${product.id}"/>
                        <input type="number" name="quantity" value="1" min="1" max="${product.quantity}" style="width: 50px;"/>
                        <button type="submit">Add to Cart</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
