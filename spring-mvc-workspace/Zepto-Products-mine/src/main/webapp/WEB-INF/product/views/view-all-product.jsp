<%@ page import="java.util.List"%>
<%@ page import="com.zepto.product.entity.ProductEntity"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Products Details</title>
</head>
<body>

	<h3>All Products</h3>

	<table border="1">
		<tr>
			<th>Product ID</th>
			<th>Name</th>
			<th>Product Price</th>
			<th>Product Qty</th>
			<th>Product Description</th>
			<th>Product Sold By</th>
			
		</tr>

		<%
		List<ProductEntity> products = (List<ProductEntity>) request.getAttribute("products");

		if (products != null) {
			for (ProductEntity p : products) {
		%>
		<tr>
			<td><%=p.getproductId()%></td>
			<td><%=p.getName()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getQty()%></td>
			<td><%=p.getDescription()%></td>
			<td><%=p.getSoldBy()%></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="2">No Data Found</td>
		</tr>
		<%
		}
		%>

	</table>

</body>
</html>