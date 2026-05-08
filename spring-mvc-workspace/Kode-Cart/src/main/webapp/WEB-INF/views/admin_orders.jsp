<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>KodeKart - All Orders</title>
</head>
<body>
    <h2>All Orders (Admin View)</h2>
    <a href="/admin/products">Manage Products</a> | <a href="/logout">Logout</a>
    <hr/>
    <table border="1" cellpadding="5">
        <tr>
            <th>Order ID</th>
            <th>Customer</th>
            <th>Date</th>
            <th>Total Amount</th>
            <th>Items</th>
        </tr>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.user.name} (${order.user.email})</td>
                <td><fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>$${order.totalAmount}</td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${order.orderItems}">
                            <li>${item.product.name} (Qty: ${item.quantity})</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
