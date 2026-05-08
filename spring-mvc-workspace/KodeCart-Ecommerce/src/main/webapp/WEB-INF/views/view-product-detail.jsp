<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${product.name} | KodeCart</title>

<style>
body {
	font-family: 'Segoe UI', sans-serif;
	margin: 0;
	background: #f5f7fa;
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
	font-size: 22px;
	font-weight: bold;
	color: #2c3e50;
	text-decoration: none;
}

/* MAIN */
.container {
	max-width: 1200px;
	margin: 40px auto;
	display: flex;
	gap: 30px;
	padding: 20px;
}

/* IMAGE */
.image-box {
	flex: 1;
	background: white;
	padding: 20px;
	border-radius: 15px;
	box-shadow: 0 4px 12px rgba(0,0,0,0.05);
	text-align: center;
}

.image-box img {
	max-width: 100%;
	max-height: 400px;
	object-fit: contain;
}

/* DETAILS */
.details {
	flex: 1.5;
	background: white;
	padding: 25px;
	border-radius: 15px;
	box-shadow: 0 4px 12px rgba(0,0,0,0.05);
}

.title {
	font-size: 26px;
	font-weight: 600;
	margin-bottom: 10px;
}

.price {
	font-size: 28px;
	color: #27ae60;
	font-weight: bold;
	margin: 15px 0;
}

.desc {
	color: #555;
	margin-bottom: 20px;
}

/* BUY BOX */
.buy-box {
	flex: 1;
	background: white;
	padding: 20px;
	border-radius: 15px;
	box-shadow: 0 4px 12px rgba(0,0,0,0.05);
	height: fit-content;
}

.stock {
	font-size: 16px;
	margin-bottom: 15px;
	color: green;
}

.out {
	color: red;
}

/* BUTTONS */
.btn {
	display: block;
	width: 100%;
	padding: 12px;
	border-radius: 25px;
	border: none;
	font-weight: bold;
	cursor: pointer;
	margin-bottom: 10px;
}

.btn-cart {
	background: #2ecc71;
	color: white;
}

.btn-cart:hover {
	background: #27ae60;
}

.btn-buy {
	background: #3498db;
	color: white;
}

.btn-buy:hover {
	background: #2980b9;
}
</style>
</head>

<body>

<header>
	<a href="customer" class="logo">KodeCart</a>
</header>

<div class="container">

	<!-- IMAGE -->
	<div class="image-box">
		<img src="https://via.placeholder.com/400x400?text=Product+Image"
			 alt="${product.name}">
	</div>

	<!-- DETAILS -->
	<div class="details">
		<div class="title">${product.name}</div>

		<div class="price">
			Rs ${product.price != null ? product.price.amount : 0}
		</div>

		<div class="desc">
			<strong>Description:</strong><br>
			${product.description}
		</div>

		<ul>
			<li><strong>ID:</strong> ${product.id}</li>
			<li><strong>Status:</strong> ${product.status}</li>
		</ul>
	</div>

	<!-- BUY BOX -->
	<div class="buy-box">

		

		<div class="stock ${product.inventory.quantity == 0 ? 'out' : ''}">
			Stock: ${product.inventory.quantity}
		</div>

		<form action="addToCart" method="post">
			<input type="hidden" name="productId" value="${product.id}">
			<button type="submit" class="btn btn-cart">Add to Cart</button>
		</form>

		<button class="btn btn-buy">Buy Now</button>

	</div>

</div>

</body>
</html>