<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zepto Product Dashboard</title>

<style>
body {
	margin: 0;
	padding: 0;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background: linear-gradient(to right, #6a11cb, #2575fc);
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container {
	background: white;
	padding: 40px;
	border-radius: 12px;
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
	text-align: center;
	width: 350px;
}

h2 {
	margin-bottom: 25px;
	color: #333;
}

.nav-links a {
	display: block;
	text-decoration: none;
	margin: 10px 0;
	padding: 12px;
	border-radius: 8px;
	font-size: 16px;
	font-weight: 600;
	color: white;
	transition: 0.3s;
}

.create {
	background: #28a745;
}

.read {
	background: #17a2b8;
}

.update {
	background: #ffc107;
	color: black;
}

.delete {
	background: #dc3545;
}

.nav-links a:hover {
	transform: scale(1.05);
	opacity: 0.9;
}
</style>

</head>
<body>

	<div class="container">
		<h2>🛒 Product Dashboard</h2>

		<div class="nav-links">
			<a href="searchProductById" class="read">📋 Search Product</a> <a
				href="createProduct" class="create">➕ Create Product</a> <a
				href="viewProducts" class="read">📋 View Products</a> 
		</div>
	</div>

</body>
</html>