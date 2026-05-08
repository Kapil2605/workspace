<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>KodeKart - Cart</title>
</head>
<body>
    <h2>Your Cart</h2>
    <a href="/products">Continue Shopping</a> | <a href="/logout">Logout</a>
    <hr/>
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
    <c:choose>
        <c:when test="${empty cartItems}">
            <p>Your cart is empty.</p>
        </c:when>
        <c:otherwise>
            <table border="1" cellpadding="5">
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Subtotal</th>
                    <th>Action</th>
                </tr>
                <c:set var="total" value="0" />
                <c:forEach var="item" items="${cartItems}">
                    <tr>
                        <td>${item.product.name}</td>
                        <td>$${item.product.price}</td>
                        <td>${item.quantity}</td>
                        <td>$${item.product.price * item.quantity}</td>
                        <td>
                            <a href="/cart/remove?cartId=${item.id}">Remove</a>
                        </td>
                    </tr>
                    <c:set var="total" value="${total + (item.product.price * item.quantity)}" />
                </c:forEach>
            </table>
            <h3>Total: $${total}</h3>
            <form action="/order/place" method="post">
                <button type="submit">Place Order</button>
            </form>
        </c:otherwise>
    </c:choose>
</body>
</html>
