<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reseller Dashboard</title>

<style>
body {
	font-family: 'Segoe UI', sans-serif;
	margin: 0;
	background: #f5f7fa;
	color: #333;
}

/* HEADER */
header {
	background: white;
	padding: 15px 30px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	box-shadow: 0 2px 8px rgba(0,0,0,0.05);
}

.logo {
	font-size: 20px;
	font-weight: bold;
	color: #2c3e50;
	text-decoration: none;
}

/* SEARCH */
.search-box {
	flex: 1;
	margin: 0 30px;
}

.search-box input {
	width: 100%;
	padding: 10px;
	border-radius: 25px;
	border: 1px solid #ddd;
	outline: none;
}

/* NAV */
nav {
	display: flex;
	align-items: center;
	gap: 10px;
}

.nav-user {
	font-size: 14px;
	color: #333;
	font-weight: 500;
}

.nav-btn {
	text-decoration: none;
	padding: 8px 14px;
	border-radius: 20px;
	font-size: 13px;
	color: white;
}

.add-btn {
	background: #2ecc71;
}

.add-btn:hover {
	background: #27ae60;
}

.logout-btn {
	background: #e74c3c;
}

.logout-btn:hover {
	background: #c0392b;
}

/* HERO */
.hero {
	background: linear-gradient(135deg, #667eea, #764ba2);
	color: white;
	padding: 30px;
	text-align: center;
}

.hero h2 {
	margin: 0;
}

/* TABLE CARD */
.table-card {
	width: 90%;
	margin: -30px auto 30px;
	background: white;
	border-radius: 15px;
	box-shadow: 0 4px 15px rgba(0,0,0,0.05);
	overflow: hidden;
	padding: 10px;
}

/* TABLE */
table {
	width: 100%;
	border-collapse: collapse;
}

th {
	text-align: left;
	padding: 12px;
	background: #f8f9fa;
	font-size: 14px;
}

td {
	padding: 12px;
	border-bottom: 1px solid #eee;
	font-size: 14px;
}

/* ROW HOVER */
tr:hover {
	background: #f9f9f9;
}

/* BUTTONS */
.actions {
	display: flex;
	gap: 5px;
}

.btn {
	padding: 6px 10px;
	border-radius: 6px;
	font-size: 12px;
	border: none;
	cursor: pointer;
}

.btn-edit {
	background: #3498db;
	color: white;
}

.btn-edit:hover {
	background: #2980b9;
}

.btn-delete {
	background: #e74c3c;
	color: white;
}

.btn-delete:hover {
	background: #c0392b;
}

/* EMPTY */
.empty {
	text-align: center;
	padding: 30px;
	color: #777;
}
</style>

</head>

<body>

<!-- HEADER -->
<header>

	<a href="reseller" class="logo">KodeCart Admin</a>

	<div class="search-box">
		<form action="searchProduct">
			<input type="text" name="keyword" placeholder="Search products...">
		</form>
	</div>

	<nav>
		<span class="nav-user">
			 ${sessionScope.loggedInUser.name}
		</span>

		<a href="createProductForm" class="nav-btn add-btn">
			+ Add Product
		</a>

		<a href="logout" class="nav-btn logout-btn">
			Logout
		</a>
	</nav>

</header>

<!-- HERO -->
<div class="hero">
	<h2>Manage Your Products</h2>
</div>

<!-- TABLE -->
<div class="table-card">

	<table>
		<tr>
			<th>Name</th>
			<th>Status</th>
			<th>Price</th>
			<th>Stock</th>
			<th>Actions</th>
		</tr>

		<%
		java.util.List<com.ecommerce.entity.Product> products =
		(java.util.List<com.ecommerce.entity.Product>) request.getAttribute("products");

		if (products != null && !products.isEmpty()) {
			for (com.ecommerce.entity.Product p : products) {
		%>

		<tr>
			<td><%=p.getName()%></td>
			<td><%=p.getStatus()%></td>
			<td>₹ <%= (p.getPrice()!=null ? p.getPrice().getAmount() : "-") %></td>
			<td><%= (p.getInventory()!=null ? p.getInventory().getQuantity() : "-") %></td>

			<td class="actions">
				<a href="editProductForm?id=<%=p.getId()%>">
					<button class="btn btn-edit">Edit</button>
				</a>

				<a href="deleteProduct?id=<%=p.getId()%>"
				   onclick="return confirm('Delete this product?')">
					<button class="btn btn-delete">Delete</button>
				</a>
			</td>
		</tr>

		<%
			}
		} else {
		%>

		<tr>
			<td colspan="5" class="empty">No products available</td>
		</tr>

		<%
		}
		%>

	</table>

</div>

</body>
</html>