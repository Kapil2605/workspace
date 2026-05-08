<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KodeCart</title>

<style>
body {
	font-family: 'Segoe UI', sans-serif;
	margin: 0;
	background: #f5f7fa;
	color: #333;
	height: 100%;
}

/* Wrapper for full height */
.wrapper {
	display: flex;
	flex-direction: column;
	min-height: 100vh;
}

/* HEADER (same as customer-home) */
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

/* HERO (modern gradient same style) */
.hero {
	flex: 1;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	text-align: center;
	background: linear-gradient(135deg, #667eea, #764ba2);
	color: white;
	padding: 40px 20px;
}

.hero h1 {
	font-size: 40px;
	margin-bottom: 10px;
}

.hero p {
	font-size: 18px;
	margin-bottom: 25px;
}

/* BUTTONS */
.hero a {
	text-decoration: none;
	padding: 12px 25px;
	border-radius: 25px;
	margin: 5px;
	font-weight: 500;
}

.btn-register {
	background: #2ecc71;
	color: white;
}

.btn-login {
	background: white;
	color: #333;
	border: 1px solid #ddd;
}

.btn-register:hover {
	background: #27ae60;
}

.btn-login:hover {
	background: #f0f0f0;
}

/* BROWSE BUTTON */
.btn-browse {
	background: #ff9800;
	color: white;
}

.btn-browse:hover {
	background: #e68900;
}

/* FOOTER */
footer {
	text-align: center;
	padding: 15px;
	background: white;
	font-size: 14px;
	box-shadow: 0 -2px 8px rgba(0,0,0,0.05);
}
</style>

</head>

<body>

<div class="wrapper">

	<header>
		<a href="#" class="logo">KodeCart</a>
		
	</header>
	

	<div class="hero">
		<h1>Welcome to KodeCart 🛒</h1>
		<p>Discover, Shop & Enjoy seamless experience</p>

		<div>
			<a href="registerPage" class="btn-register">Create Account</a>
			<a href="loginPage" class="btn-login">Login</a>
			
			<a href="customer" class="btn-browse">Browse Products</a>
		</div>
	</div>

	<footer>
		&copy; 2026 KodeCart. All rights reserved.
	</footer>

</div>

</body>
</html>