<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.kodewala.entity.Product" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Products</title>
</head>
<body>

<h2>Product Items</h2>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Currency</th>
        <th>Price</th>
        <th>Description<th>
        <th>Quantity<th>
    </tr>

<%
    List<Product> products = (List<Product>) request.getAttribute("product");

    if (products != null) {
        for (Product item : products) {
%>
    <tr>
        <td><%= item.getName() %></td>
        <td><%= item.getPrice().getCurrency()%></td>
        <td><%= item.getPrice().getProductPrice()%></td>
        <td><%= item.getDescription() %></td>
        <td><%= item.getStock_quantity() %></td>
        <td>
	        <a href="updateProduct?id=<%= item.getId() %>">Update</a>
	        
	    </td>
	    <td>
	        <a href="deleteProduct?id=<%= item.getId() %>">delete</a>
	        
	    </td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="4">No Products Found</td>
    </tr>
<%
    }
%>

</table>

</body>
</html>