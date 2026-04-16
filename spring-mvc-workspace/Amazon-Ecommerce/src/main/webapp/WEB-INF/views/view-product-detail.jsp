<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${product.name}|Amazon.in</title>

<style>
:root {
	--amazon-navy: #131921;
	--amazon-orange: #FF9900;
	--amazon-yellow: #FFD814;
	--amazon-yellow-hover: #F7CA00;
	--text-color: #0F1111;
	--link-color: #007185;
	--price-red: #B12704;
}

body {
	font-family: "Segoe UI", Arial, sans-serif;
	margin: 0;
	background-color: white;
	color: var(--text-color);
}

/* HEADER - Simplified Amazon Style */
header {
	background-color: var(--amazon-navy);
	padding: 10px 40px;
	display: flex;
	align-items: center;
}

.logo {
	color: white;
	font-weight: bold;
	font-size: 20px;
	text-decoration: none;
	margin-right: 20px;
}

/* PAGE LAYOUT */
.container {
	max-width: 1500px;
	margin: 20px auto;
	padding: 20px;
	display: flex;
	gap: 40px;
}

/* LEFT COLUMN: IMAGE */
.product-image-section {
	flex: 1;
	text-align: center;
	position: sticky;
	top: 20px;
	max-height: 600px;
}

.product-image-section img {
	max-width: 100%;
	max-height: 500px;
	object-fit: contain;
}

/* CENTER COLUMN: INFO */
.product-info-section {
	flex: 1.5;
}

.product-title {
	font-size: 24px;
	font-weight: 500;
	line-height: 1.3;
	margin-bottom: 10px;
	border-bottom: 1px solid #ddd;
	padding-bottom: 10px;
}

.rating {
	color: var(--link-color);
	font-size: 14px;
	margin-bottom: 15px;
}

.price-box {
	margin: 15px 0;
}

.price-label {
	color: #565959;
	font-size: 14px;
}

.price-value {
	color: var(--price-red);
	font-size: 28px;
	font-weight: 400;
}

.currency {
	font-size: 18px;
	vertical-align: super;
}

.product-description {
	margin-top: 20px;
}

.product-description h3 {
	font-size: 16px;
	font-weight: 700;
}

.product-description ul {
	padding-left: 20px;
	font-size: 14px;
	line-height: 1.6;
}

/* RIGHT COLUMN: BUY BOX */
.buy-box {
	flex: 0.7;
	border: 1px solid #ddd;
	border-radius: 8px;
	padding: 20px;
	height: fit-content;
}

.stock-status {
	color: #007600;
	font-size: 18px;
	margin-bottom: 15px;
	font-weight: 500;
}

.out-of-stock {
	color: var(--price-red);
}

.buy-box-row {
	margin-bottom: 10px;
	font-size: 14px;
}

.btn {
	display: block;
	width: 100%;
	padding: 10px 0;
	border-radius: 20px;
	text-align: center;
	text-decoration: none;
	font-size: 14px;
	margin-bottom: 10px;
	border: 1px solid #d5d9d9;
}

.btn-cart {
	background-color: var(--amazon-yellow);
	border-color: #FCD200;
}

.btn-cart:hover {
	background-color: var(--amazon-yellow-hover);
}

.btn-buy {
	background-color: var(--amazon-orange);
	border-color: #F08804;
}

.btn-buy:hover {
	background-color: #e47911;
}
</style>
</head>
<body>

	<header>
		<a href="customer" class="logo">Amazon Ecommerce</a>
	</header>

	<div class="container">

		<div class="product-image-section">
			<img id="mainProductImage"
				src="https://images.unsplash.com/photo-1505740420928-5e560c06d30e?q=80&w=1000&auto=format&fit=crop"
				alt="${product.name}"
				onerror="this.src='https://via.placeholder.com/500x500?text=Image+Not+Found'">


		</div>

		<div class="product-info-section">
			<h1 class="product-title">${product.name}</h1>

			<div class="rating">⭐⭐⭐⭐☆ | 1,240 ratings | Search this page</div>

			<div class="price-box">
				<span class="price-label">Price: </span> <span class="price-value">
					<span class="currency">${product.price.currency}</span>
					${product.price.amount}
				</span>
				<div style="font-size: 12px; color: #565959;">Inclusive of all
					taxes</div>
			</div>

			<hr>

			<div class="product-description">
				<h3>About this item</h3>
				<ul>
					<li>Product ID: <strong>${product.id}</strong></li>
					<li>Product Desc: <strong>${product.description}</strong></li>
					<li>Status: ${product.status}</li>

				</ul>
			</div>
		</div>

		<div class="buy-box">
			<div class="price-value">
				<span class="currency">${product.price.currency}</span>
				${product.price.amount}
			</div>

			<!-- <div class="buy-box-row" style="color: var(--link-color); margin-top: 5px;">
                FREE delivery <strong>Tomorrow</strong>
            </div> -->

			<div class="stock-status">Stock:${product.inventory.quantity}</div>

			<!-- <div class="buy-box-row">
                Ships from: <strong>Amazon Store</strong>
            </div>
            <div class="buy-box-row">
                Sold by: <strong>Retailer Cloud</strong>
            </div> -->

			<div style="margin-top: 20px;">
				<form action="addToCart" method="post">
					<input type="hidden" name="productId" value="${product.id}">
					<button type="submit" class="btn btn-cart">Add to Cart</button>
				</form>
				</a> <a href="#" class="btn btn-buy">Buy Now</a>
			</div>

			<div
				style="margin-top: 15px; font-size: 12px; color: var(--link-color);">
				🔒 Secure transaction</div>
		</div>

	</div>

</body>
</html>