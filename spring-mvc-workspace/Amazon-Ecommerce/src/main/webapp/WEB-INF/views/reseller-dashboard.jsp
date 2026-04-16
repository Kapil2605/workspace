<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reseller Dashboard</title>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	background-color: #f6f6f6;
}

/* HEADER */
header {
	background-color: #232f3e;
	padding: 10px 20px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	gap: 20px;
}

.logo {
	color: white;
	font-weight: bold;
	font-size: 18px;
	text-decoration: none;
}

/* SEARCH BAR */
.search-container {
	flex: 1;
	display: flex;
	justify-content: center;
}

.search-container form {
	display: flex;
	width: 60%;
	max-width: 500px;
}

.search-container input {
	flex: 1;
	padding: 10px;
	border: none;
	border-radius: 4px 0 0 4px;
	outline: none;
	font-size: 14px;
}

.search-container button {
	background: #febd69;
	border: none;
	padding: 10px 15px;
	border-radius: 0 4px 4px 0;
	cursor: pointer;
	font-weight: bold;
}

/* NAV */
nav a {
	color: white;
	text-decoration: none;
	font-size: 14px;
}

/* CONTENT */
.content {
	padding: 20px;
}

/* TITLE */
.title {
	text-align: center;
	margin-bottom: 20px;
	color: #333;
}

/* TABLE CONTAINER */
.table-container {
	width: 90%;
	margin: auto;
	background: white;
	border-radius: 8px;
	box-shadow: 0 2px 8px rgba(0,0,0,0.1);
	overflow: hidden;
}

/* TABLE */
table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background-color: #232f3e;
	color: white;
	padding: 12px;
	font-size: 14px;
}

td {
	padding: 12px;
	text-align: center;
	border-bottom: 1px solid #eee;
	font-size: 14px;
}

/* ROW HOVER */
tr:hover {
	background-color: #f9f9f9;
}

/* BUTTONS */
.btn {
	padding: 6px 12px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 13px;
}

.btn-edit {
	background-color: #007bff;
	color: white;
}

.btn-edit:hover {
	background-color: #0056b3;
}

.btn-delete {
	background-color: #dc3545;
	color: white;
}

.btn-delete:hover {
	background-color: #a71d2a;
}

/* EMPTY MESSAGE */
.empty {
	padding: 20px;
	text-align: center;
	color: #777;
}
</style>

</head>
<body>

<!-- HEADER -->
<header>

	<!-- LOGO -->
	<a href="reseller" class="logo">Reseller Dashboard</a>

	<!-- SEARCH -->
	<div class="search-container">
		<form action="searchProduct" method="get">
			<input type="text" name="keyword" placeholder="Search products...">
			<button type="submit">🔍</button>
		</form>
	</div>

	<!-- NAV -->
	<nav>
		<a href="createProductForm">+ Create Product</a>
	</nav>

</header>

<!-- CONTENT -->
<div class="content">

	<h2 class="title">Product List</h2>

	<div class="table-container">

		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Status</th>
				<th>Price</th>
				<th>Currency</th>
				<th>Quantity</th>
				<th>Actions</th>
			</tr>

			<%
			java.util.List<com.ecommerce.entity.Product> products =
				(java.util.List<com.ecommerce.entity.Product>) request.getAttribute("products");

			if (products != null && !products.isEmpty()) {
				for (com.ecommerce.entity.Product p : products) {
			%>

			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getName()%></td>
				<td><%=p.getDescription()%></td>
				<td><%=p.getStatus()%></td>
				<td><%=(p.getPrice() != null ? p.getPrice().getAmount() : "-")%></td>
				<td><%=(p.getPrice() != null ? p.getPrice().getCurrency() : "-")%></td>
				<td><%=(p.getInventory() != null ? p.getInventory().getQuantity() : "-")%></td>

				<td>
					<a href="editProductForm?id=<%=p.getId()%>">
						<button class="btn btn-edit">Edit</button>
					</a>

					<a href="deleteProduct?id=<%=p.getId()%>"
					   onclick="return confirm('Are you sure you want to delete this product?')">
						<button class="btn btn-delete">Delete</button>
					</a>
				</td>
			</tr>

			<%
				}
			} else {
			%>

			<tr>
				<td colspan="8" class="empty">No products available</td>
			</tr>

			<%
			}
			%>

		</table>

	</div>

</div>

</body>
</html>