<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | KodeCart</title>

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
	box-shadow: 0 2px 8px rgba(0,0,0,0.05);
}

.logo {
	font-size: 22px;
	font-weight: bold;
	color: #2c3e50;
	text-decoration: none;
}

/* CENTER */
.container {
	flex: 1;
	display: flex;
	justify-content: center;
	align-items: center;
	background: linear-gradient(135deg, #667eea, #764ba2);
}

/* CARD */
.card {
	background: white;
	width: 350px;
	padding: 30px;
	border-radius: 15px;
	box-shadow: 0 4px 15px rgba(0,0,0,0.1);
}

h2 {
	text-align: center;
	margin-bottom: 20px;
}

input {
	width: 100%;
	padding: 10px;
	margin-bottom: 12px;
	border-radius: 8px;
	border: 1px solid #ddd;
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
}

button:hover {
	background: #27ae60;
}

/* ERROR */
.error {
	background: #ffe6e6;
	color: #b30000;
	padding: 10px;
	border-radius: 6px;
	margin-bottom: 10px;
	text-align: center;
}

.footer {
	text-align: center;
	margin-top: 10px;
}
</style>

</head>

<body>

<div class="wrapper">

<header>
	<a href="index.jsp" class="logo">KodeCart</a>
</header>

<div class="container">

	<div class="card">
		<h2>Login</h2>

		<%
		String error = (String) request.getAttribute("error");
		if (error != null) {
		%>
			<div class="error"><%=error%></div>
		<%
		}
		%>

		<form action="loginSubmit" method="post">
			<input type="email" name="email" placeholder="Email" required>
			<input type="password" name="password" placeholder="Password" required>
			<button type="submit">Login</button>
		</form>

		<div class="footer">
			New user? <a href="registerPage">Create account</a>
		</div>
	</div>

</div>

</div>

</body>
</html>