<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>KodeKart - Orders</title>
</head>
<body>
    <h2>Your Orders</h2>
    <a href="/products">Continue Shopping</a> | <a href="/logout">Logout</a>
    <hr/>
    <c:if test="${not empty message}">
        <p style="color:green">${message}</p>
    </c:if>
    <c:choose>
        <c:when test="${empty orders}">
            <p>You have no orders yet.</p>
        </c:when>
        <c:otherwise>
            <table border="1" cellpadding="5">
                <tr>
                    <th>Order ID</th>
                    <th>Date</th>
                    <th>Total Amount</th>
                    <th>Items</th>
                </tr>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td>${order.id}</td>
                        <td><fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>$${order.totalAmount}</td>
                        <td>
                            <ul>
                                <c:forEach var="item" items="${order.orderItems}">
                                    <li>${item.product.name} (Qty: ${item.quantity}) - $${item.price}</li>
                                </c:forEach>
                            </ul>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>
