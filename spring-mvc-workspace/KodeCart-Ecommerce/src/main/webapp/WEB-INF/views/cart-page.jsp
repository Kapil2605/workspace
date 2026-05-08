<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.dto.CartItemDTO" %>

<%
    List<CartItemDTO> cartItems = (List<CartItemDTO>) request.getAttribute("cartItems");
    double total = 0.0;
    int totalQuantity = 0;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart | KodeCart</title>

<style>
body {
	font-family: 'Segoe UI', sans-serif;
	margin: 0;
	background: #f5f7fa;
}

header {
	background: white;
	padding: 15px 30px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	box-shadow: 0 2px 8px rgba(0,0,0,0.05);
}

.logo {
	font-size: 22px;
	font-weight: bold;
	color: #2c3e50;
	text-decoration: none;
}

.container {
	display: flex;
	max-width: 1200px;
	margin: 30px auto;
	gap: 20px;
	padding: 20px;
}

.cart-box {
	flex: 2;
	background: white;
	padding: 20px;
	border-radius: 15px;
	box-shadow: 0 4px 12px rgba(0,0,0,0.05);
}

.cart-item {
	display: flex;
	align-items: center;
	border-bottom: 1px solid #eee;
	padding: 15px 0;
}

.item-img {
	width: 100px;
	height: 100px;
	object-fit: contain;
	margin-right: 15px;
}

.item-info {
	flex: 1;
}

.item-name {
	font-weight: 600;
	margin-bottom: 5px;
}

.item-price {
	color: #27ae60;
	font-weight: bold;
}

.qty-box {
	display: flex;
	align-items: center;
	gap: 10px;
	margin-top: 10px;
}

.qty-btn {
	padding: 5px 10px;
	border: none;
	border-radius: 5px;
	background: #ddd;
	cursor: pointer;
}

.qty-btn:hover {
	background: #ccc;
}

.delete {
	color: red;
	font-size: 13px;
	cursor: pointer;
}

.summary {
	flex: 1;
	background: white;
	padding: 20px;
	border-radius: 15px;
	box-shadow: 0 4px 12px rgba(0,0,0,0.05);
	height: fit-content;
}

.total {
	font-size: 20px;
	margin-bottom: 20px;
}

.checkout {
	width: 100%;
	padding: 12px;
	border-radius: 25px;
	border: none;
	background: #2ecc71;
	color: white;
	font-weight: bold;
	cursor: pointer;
}

.checkout:hover {
	background: #27ae60;
}

.empty {
	text-align: center;
	padding: 50px;
}
</style>

<script>
function updateQuantity(productId, action) {
	window.location.href = "updateQuantity?productId=" 
		+ productId + "&action=" + action;
}

function removeItem(productId) {
	window.location.href = "removeItem?productId=" + productId;
}
</script>

</head>

<body>

<header>
	<a href="customer" class="logo">KodeCart</a>
</header>

<div class="container">

	<!-- CART LIST -->
	<div class="cart-box">

		<h2>Your Cart</h2>

		<%
		if (cartItems != null && !cartItems.isEmpty()) {
			for (CartItemDTO item : cartItems) {

				double price = (item.getPrice() != null) ? item.getPrice() : 0.0;
				double itemTotal = price * item.getQuantity();

				total += itemTotal;
				totalQuantity += item.getQuantity();
		%>

		<div class="cart-item">

			<img src="https://via.placeholder.com/100" class="item-img">

			<div class="item-info">
				<div class="item-name"><%= item.getProductName() %></div>
				<div class="item-price">Rs <%= price %></div>

				<div class="qty-box">
					<button class="qty-btn"
						onclick="updateQuantity(<%= item.getProductId() %>, 'decrease')">-</button>

					<span>Qty: <%= item.getQuantity() %></span>

					<button class="qty-btn"
						onclick="updateQuantity(<%= item.getProductId() %>, 'increase')">+</button>
				</div>

				<div class="delete"
					onclick="removeItem(<%= item.getProductId() %>)">
					Remove
				</div>
			</div>

			<div>
				<strong>Rs <%= String.format("%.2f", itemTotal) %></strong>
			</div>

		</div>

		<%
			}
		} else {
		%>

		<div class="empty">
			<h3>Your cart is empty</h3>
			<a href="customer">Continue Shopping</a>
		</div>

		<%
		}
		%>

	</div>

	<!-- SUMMARY -->
	<div class="summary">

		<div class="total">
			Subtotal (<%= totalQuantity %> items)<br>
			<strong>Rs <%= String.format("%.2f", total) %></strong>
		</div>

		<button class="checkout">Proceed to Checkout</button>

	</div>

</div>

</body>
</html>