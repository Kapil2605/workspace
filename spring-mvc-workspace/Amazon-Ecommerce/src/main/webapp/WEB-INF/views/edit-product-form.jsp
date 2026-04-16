<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product | Reseller</title>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	background-color: #f3f3f3;
}

header {
	background-color: #232f3e;
	padding: 12px 25px;
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.logo {
	color: white;
	font-weight: bold;
	text-decoration: none;
	font-size: 1.2rem;
}

nav a {
	color: white;
	text-decoration: none;
	margin-left: 20px;
	font-size: 14px;
}

.form-card {
	background: white;
	max-width: 450px;
	margin: 40px auto;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	border: 1px solid #ddd;
}

h2 {
	margin-top: 0;
	font-size: 22px;
	color: #111;
	border-bottom: 1px solid #eee;
	padding-bottom: 10px;
}

.field-group {
	margin-bottom: 15px;
}

.row {
	display: flex;
	gap: 10px;
}

.row .field-group {
	flex: 1;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
	font-size: 13px;
	color: #333;
}

input[type="text"], input[type="number"], select {
	width: 100%;
	padding: 10px;
	border: 1px solid #888;
	border-radius: 4px;
	box-sizing: border-box;
	background-color: white;
	height: 40px;
}

input:focus, select:focus {
	border-color: #e77600;
	outline: none;
	box-shadow: 0 0 3px #e77600;
}

input[type="submit"] {
	width: 100%;
	background-color: #ffd814;
	border: 1px solid #fcd200;
	border-radius: 8px;
	padding: 12px;
	cursor: pointer;
	font-weight: bold;
	margin-top: 10px;
}

input[type="submit"]:hover {
	background-color: #f7ca00;
}
</style>
</head>

<body>

<header>
	<a href="#" class="logo">Amazon Reseller</a>
	<nav>
		<a href="reseller">Dashboard</a>
	</nav>
</header>

<div class="form-card">
	<h2>Edit Product</h2>

	<form action="update-product" method="post">

		<!-- Hidden ID -->
		<input type="hidden" name="id" value="${product.id}">

		<div class="field-group">
			<label>Product Name</label>
			<input type="text" name="name" value="${product.name}" required>
		</div>

		<div class="field-group">
			<label>Description</label>
			<input type="text" name="description" value="${product.description}" required>
		</div>

		<div class="row">
			<div class="field-group">
				<label>Currency</label>
				<select name="currency">
					<option value="USD" ${product.price.currency == 'USD' ? 'selected' : ''}>USD</option>
					<option value="INR" ${product.price.currency == 'INR' ? 'selected' : ''}>INR</option>
				</select>
			</div>

			<div class="field-group" style="flex: 2;">
				<label>Price</label>
				<input type="text" name="price" value="${product.price.amount}" required>
			</div>
		</div>

		<div class="row">
			<div class="field-group">
				<label>Quantity</label>
				<input type="number" name="quantity" value="${product.inventory.quantity}" min="1" required>
			</div>

			<div class="field-group">
				<label>Product Status</label>
				<select name="status">
					<option value="active" ${product.status == 'active' ? 'selected' : ''}>Active</option>
					<option value="inactive" ${product.status == 'inactive' ? 'selected' : ''}>Inactive</option>
				</select>
			</div>
		</div>

		<input type="submit" value="Update Product">

	</form>
</div>

</body>
</html>