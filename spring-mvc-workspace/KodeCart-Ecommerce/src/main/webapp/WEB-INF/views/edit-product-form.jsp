<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product | KodeCart</title>

<style>
body {
	font-family: 'Segoe UI', sans-serif;
	margin: 0;
	background: #f5f7fa;
}

.wrapper {
	display: flex;
	flex-direction: column;
	min-height: 100vh;
}

/* HEADER */
header {
	background: white;
	padding: 15px 30px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	box-shadow: 0 2px 8px rgba(0,0,0,0.05);
}

.logo {
	font-size: 20px;
	font-weight: bold;
	color: #2c3e50;
	text-decoration: none;
}

nav a {
	text-decoration: none;
	color: #555;
	font-weight: 500;
}

/* CENTER */
.container {
	flex: 1;
	display: flex;
	justify-content: center;
	align-items: center;
	background: linear-gradient(135deg, #667eea, #764ba2);
	padding: 20px;
}

/* CARD */
.card {
	background: white;
	width: 450px;
	padding: 30px;
	border-radius: 15px;
	box-shadow: 0 4px 15px rgba(0,0,0,0.1);
}

h2 {
	text-align: center;
	margin-bottom: 20px;
}

/* INPUTS */
input, select {
	width: 100%;
	padding: 10px;
	margin-bottom: 12px;
	border-radius: 8px;
	border: 1px solid #ddd;
	outline: none;
}

input:focus, select:focus {
	border-color: #667eea;
	box-shadow: 0 0 5px rgba(102,126,234,0.3);
}

/* ROW */
.row {
	display: flex;
	gap: 10px;
}

/* BUTTON */
button {
	width: 100%;
	padding: 12px;
	border-radius: 25px;
	border: none;
	background: #3498db;
	color: white;
	font-weight: bold;
	cursor: pointer;
	margin-top: 10px;
}

button:hover {
	background: #2980b9;
}
</style>

</head>

<body>

<div class="wrapper">

	<header>
		<a href="reseller" class="logo">KodeCart Admin</a>
		<nav>
			<a href="reseller">Dashboard</a>
		</nav>
	</header>

	<div class="container">

		<div class="card">
			<h2>Edit Product</h2>

			<form action="update-product" method="post">

				<input type="hidden" name="id" value="${product.id}">

				<input type="text" name="name" value="${product.name}" required>

				<input type="text" name="description" value="${product.description}" required>

				<div class="row">
					<select name="currency">
						<option value="USD" ${product.price.currency == 'USD' ? 'selected' : ''}>USD</option>
						<option value="INR" ${product.price.currency == 'INR' ? 'selected' : ''}>INR</option>
					</select>

					<input type="text" name="price" value="${product.price.amount}" required>
				</div>

				<div class="row">
					<input type="number" name="quantity" value="${product.inventory.quantity}" min="1" required>

					<select name="status">
						<option value="active" ${product.status == 'active' ? 'selected' : ''}>Active</option>
						<option value="inactive" ${product.status == 'inactive' ? 'selected' : ''}>Inactive</option>
					</select>
				</div>

				<button type="submit">Update Product</button>

			</form>
		</div>

	</div>

</div>

</body>
</html>