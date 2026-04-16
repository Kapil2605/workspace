<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product | Reseller</title>
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

/* Styled both inputs and selects */
input[type="text"], select {
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

input[type="number"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #888;
	border-radius: 4px;
	box-sizing: border-box;
	background-color: white;
	height: 40px;
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
		<h2>Add New Product</h2>

		<form action="create-product" method="post">
			<div class="field-group">
				<label>Product Name</label> <input type="text" name="name"
					placeholder="e.g. Echo Dot 5th Gen" required>
			</div>

			<div class="field-group">
				<label>Description</label> <input type="text" name="description"
					placeholder="Brief details about the product" required>
			</div>

			<div class="row">
				<div class="field-group">
					<label>Currency</label> <select name="currency">
						<option value="USD">USD</option>
						<option value="INR">INR</option>
					</select>
				</div>
				<div class="field-group" style="flex: 2;">
					<label>Price</label> <input type="text" name="price"
						placeholder="0.00" required>
				</div>
			</div>

			<div class="row">
				<div class="field-group" >
					<label>Quantity</label>
					 <input type="number" name="quantity" min="1" placeholder="Enter quantity" required>
					</select>
				</div>
				<div class="field-group">
					<label>Product Status</label> <select name="status">
						<option value="active">Active</option>
						<option value="inactive">In Active</option>
					</select>
				</div>
			</div>

			<input type="submit" value="Create Product">
		</form>
	</div>

</body>
</html>