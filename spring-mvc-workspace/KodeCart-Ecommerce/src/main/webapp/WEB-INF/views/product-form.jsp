<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product | KodeCart</title>

<style>
body {
	font-family: 'Segoe UI', sans-serif;
	margin: 0;
	background: #f5f7fa;
}

/* WRAPPER */
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

/* CENTER AREA */
.container {
	flex: 1;
	display: flex;
	justify-content: center;
	align-items: center;
	background: linear-gradient(135deg, #667eea, #764ba2);
	padding: 20px;
}

/* FORM CARD */
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
	background: #2ecc71;
	color: white;
	font-weight: bold;
	cursor: pointer;
	margin-top: 10px;
}

button:hover {
	background: #27ae60;
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
			<h2>Add New Product</h2>

			<form action="create-product" method="post">

				<input type="text" name="name"
					placeholder="Product Name (e.g. Echo Dot 5th Gen)" required>

				<input type="text" name="description"
					placeholder="Product Description" required>

				<div class="row">
					<select name="currency">
						<option value="USD">USD</option>
						<option value="INR">INR</option>
					</select>

					<input type="text" name="price" placeholder="Price" required>
				</div>

				<div class="row">
					<input type="number" name="quantity" min="1" placeholder="Quantity" required>

					<select name="status">
						<option value="active">Active</option>
						<option value="inactive">Inactive</option>
					</select>
				</div>

				<button type="submit">Create Product</button>

			</form>
		</div>

	</div>

</div>

</body>
</html>