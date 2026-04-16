<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amazon Ecommerce</title>

<style>
:root {
	--amazon-navy: #131921;
	--amazon-light-navy: #232f3e;
	--amazon-yellow: #ffd814;
	--amazon-yellow-hover: #f7ca00;
	--amazon-orange: #ff9900;
	--amazon-text: #0f1111;
	--amazon-link: #007185;
	--amazon-price: #b12704;
}

body {
	font-family: "Amazon Ember", Arial, sans-serif;
	margin: 0;
	background-color: #e3e6e6;
	color: var(--amazon-text);
}

/* HEADER */
header {
	background-color: var(--amazon-navy);
	padding: 10px 20px;
	display: flex;
	align-items: center;
	gap: 15px;
}

.logo {
	color: white;
	font-weight: bold;
	font-size: 22px;
	text-decoration: none;
	padding: 5px 10px;
	border: 1px solid transparent;
}

.logo:hover {
	border: 1px solid white;
}

.search-container {
	flex: 1;
	display: flex;
}

.search-container form {
	display: flex;
	width: 100%;
	max-width: 700px;
}

.search-container input {
	flex: 1;
	padding: 12px;
	border: none;
	border-radius: 4px 0 0 4px;
	font-size: 14px;
	outline: none;
}

.search-container button {
	background-color: var(--amazon-orange);
	border: none;
	padding: 0 15px;
	border-radius: 0 4px 4px 0;
	cursor: pointer;
	font-size: 18px;
}

nav a {
	color: white;
	text-decoration: none;
	font-size: 14px;
	font-weight: bold;
	padding: 10px;
	border: 1px solid transparent;
}

nav a:hover {
	border: 1px solid white;
}

/* CONTENT LAYOUT */
.hero-banner {
	height: 250px;
	background: linear-gradient(to bottom, rgba(0, 0, 0, 0) 60%, #e3e6e6
		100%),
		url('https://images-eu.ssl-images-amazon.com/images/G/31/img21/Fashion/Event/Gateway/WRS-Jun/PC_Bunk_prime-1500-unrec._CB667377721_.jpg');
	background-size: cover;
	background-position: center;
}

.content {
	max-width: 1500px;
	margin: -120px auto 50px;
	padding: 0 20px;
}

.product-grid {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(260px, 1fr));
	gap: 20px;
}

/* PRODUCT CARD */
.product-card {
	background: white;
	padding: 20px;
	display: flex;
	flex-direction: column;
	z-index: 1;
	border: 1px solid #ddd;
}

.image-container {
	height: 200px;
	margin-bottom: 15px;
	display: flex;
	align-items: center;
	justify-content: center;
	overflow: hidden;
}

.image-container img {
	max-width: 100%;
	max-height: 100%;
	object-fit: contain;
}

.product-name {
	font-size: 16px;
	color: var(--amazon-link);
	font-weight: 500;
	margin-bottom: 8px;
	height: 44px;
	overflow: hidden;
	line-height: 1.3;
}

.product-price {
	font-size: 21px;
	color: var(--amazon-text);
	font-weight: 500;
	margin-bottom: 5px;
}

.currency {
	font-size: 13px;
	vertical-align: super;
	margin-right: 2px;
}

.product-status {
	font-size: 12px;
	color: #565959;
	margin-bottom: 15px;
}

/* AMAZON STYLE BUTTONS */
.btn-container {
	display: flex;
	flex-direction: column;
	gap: 8px;
	margin-top: auto;
}

.btn {
	display: block;
	text-align: center;
	padding: 8px;
	border-radius: 20px;
	font-size: 13px;
	text-decoration: none;
	color: #0f1111;
	border: 1px solid #d5d9d9;
}

.btn-view {
	background: white;
	box-shadow: 0 2px 5px rgba(213, 217, 217, 0.5);
}

.btn-cart {
	background-color: var(--amazon-yellow);
	border-color: #fcd200;
}

.btn-cart:hover {
	background-color: var(--amazon-yellow-hover);
}
</style>
</head>
<body>

	<header>
		<a href="customer" class="logo">Amazon Ecommerce</a>

		<div class="search-container">
			<form action="customer/searchProduct" method="get">
				<input type="text" name="keyword"
					placeholder="Search for products, brands and more">
				<button type="submit">🔍</button>
			</form>
		</div>

		<nav>
			<a href="#">Welcome,Kapil <a href="cart" style="font-size: 18px;">🛒 Cart</a>
		</nav>
	</header>

	<div class="hero-banner"></div>

	<div class="content">
		<div class="product-grid">

			<%
			java.util.List<com.ecommerce.entity.Product> products = (java.util.List<com.ecommerce.entity.Product>) request
					.getAttribute("products");

			if (products != null && !products.isEmpty()) {
				for (com.ecommerce.entity.Product p : products) {

					if (p.getStatus() != null && p.getStatus().equalsIgnoreCase("active")) {
			%>

			<div class="product-card">

				<div class="product-name"><%=p.getName()%></div>
				<div class="product-status"><%=p.getDescription()%></div>

				<div class="product-price">
					<span class="currency"> <%=(p.getPrice() != null ? p.getPrice().getCurrency() : "$")%>
					</span>
					<%=(p.getPrice() != null ? p.getPrice().getAmount() : "0.00")%>
				</div>

				<div class="product-status">
					Stock:
					<%=(p.getInventory() != null ? p.getInventory().getQuantity() : "Out of Stock")%>
				</div>

				<div class="btn-container">
					<a href="viewProduct?id=<%=p.getId()%>" class="btn btn-view">
						View details </a> 
						<form action="addToCart" method="post">
						    <input type="hidden" name="productId" value="<%=p.getId()%>" />
						    <button type="submit" class="btn btn-cart">Add to Cart</button>
						</form>
				</div>

			</div>

			<%
			} // ✅ end if active
			}
			} else {
			%>

			<div
				style="grid-column: 1/-1; text-align: center; background: white; padding: 50px;">
				<h3>No products found.</h3>
			</div>

			<%
			}
			%>

		</div>
	</div>

</body>
</html>