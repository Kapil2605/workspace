<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KodeCart Store</title>

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
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
}

.actions form {
	display: flex;
	gap: 6px;
	align-items: center;
}

.actions input[type="number"] {
	width: 60px;
	padding: 6px;
	border-radius: 6px;
	border: 1px solid #ddd;
}

.logo {
	font-size: 22px;
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
	padding: 10px 15px;
	border-radius: 25px;
	border: 1px solid #ddd;
	outline: none;
}

/* NAV */
nav {
	display: flex;
	align-items: center;
	gap: 15px;
}

nav a {
	text-decoration: none;
	color: #555;
	font-weight: 500;
}

/* USER NAME */
.user {
	font-weight: 600;
	color: #2c3e50;
}

/* LOGOUT BUTTON */
.logout-btn {
	background: #e74c3c;
	color: white !important;
	padding: 6px 14px;
	border-radius: 20px;
	font-size: 13px;
}

.logout-btn:hover {
	background: #c0392b;
}

/* HERO */
.hero {
	background: linear-gradient(135deg, #667eea, #764ba2);
	color: white;
	padding: 60px 30px;
	text-align: center;
}

.hero h1 {
	margin: 0;
	font-size: 32px;
}

/* PRODUCT GRID */
.container {
	padding: 30px;
	max-width: 1400px;
	margin: auto;
}

.grid {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
	gap: 25px;
}

/* PRODUCT CARD */
.card {
	background: white;
	border-radius: 15px;
	padding: 15px;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
	transition: 0.3s;
	display: flex;
	flex-direction: column;
}

.card:hover {
	transform: translateY(-5px);
}

/* TEXT */
.title {
	font-size: 15px;
	font-weight: 600;
	margin-bottom: 5px;
}

.desc {
	font-size: 13px;
	color: #777;
	margin-bottom: 10px;
	height: 35px;
	overflow: hidden;
}

.price {
	font-size: 20px;
	font-weight: bold;
	color: #27ae60;
	margin-bottom: 10px;
}

/* BUTTONS */
.actions {
	margin-top: auto;
}

.btn {
	display: block;
	text-align: center;
	padding: 8px;
	border-radius: 8px;
	text-decoration: none;
	font-size: 14px;
	margin-bottom: 8px;
}

.btn-view {
	border: 1px solid #ddd;
	color: #333;
}

.btn-cart {
	background: #2ecc71;
	color: white;
	border: none;
	cursor: pointer;
}

.btn-cart:hover {
	background: #27ae60;
}

/* EMPTY */
.empty {
	text-align: center;
	padding: 50px;
	background: white;
	border-radius: 10px;
}
</style>

</head>

<body>

	<!-- HEADER -->
	<header>
		<a href="customer" class="logo">KodeCart</a>

		<div class="search-box">
			<form action="customer/searchProduct">
				<input type="text" name="keyword" placeholder="Search products...">
			</form>
		</div>

		<nav>
			<span class="user">Hi, ${sessionScope.loggedInUser.name}</span> <a
				href="cart">🛒 Cart</a> <a href="logout" class="logout-btn">Logout</a>
		</nav>
	</header>

	<!-- HERO -->
	<div class="hero">
		<h1>Discover Amazing Products</h1>
	</div>

	<!-- PRODUCTS -->
	<div class="container">
		<div class="grid">

			<%
			java.util.List<com.ecommerce.entity.Product> products = (java.util.List<com.ecommerce.entity.Product>) request
					.getAttribute("products");

			if (products != null && !products.isEmpty()) {
				for (com.ecommerce.entity.Product p : products) {

					if (p.getStatus() != null && p.getStatus().equalsIgnoreCase("active")) {
			%>

			<div class="card">

				<div class="title"><%=p.getName()%></div>
				<div class="desc"><%=p.getDescription()%></div>

				<div class="price">
					Rs
					<%=(p.getPrice() != null ? p.getPrice().getAmount() : "0")%>
				</div>

				<div class="actions">

					<a href="viewProduct?id=<%=p.getId()%>" class="btn btn-view">View</a>

					<!-- ADD TO CART FORM WITH QUANTITY -->
					<form action="addToCart" method="post"
						style="display: flex; gap: 5px; align-items: center;">

						<input type="hidden" name="productId" value="<%=p.getId()%>" />

						<!-- QUANTITY INPUT -->
						<input type="number" name="quantity" value="1" min="1"
							style="width: 60px; padding: 6px; border-radius: 6px; border: 1px solid #ddd;">

						<button type="submit" class="btn btn-cart">Add</button>
					</form>

				</div>

			</div>

			<%
			}
			}
			} else {
			%>

			<div class="empty">
				<h3>No products found</h3>
			</div>

			<%
			}
			%>

		</div>
	</div>

</body>
</html>