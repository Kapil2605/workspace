<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register | KodeCart</title>

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

/* CENTER AREA */
.container {
	flex: 1;
	display: flex;
	justify-content: center;
	align-items: center;
	background: linear-gradient(135deg, #667eea, #764ba2);
}

/* FORM CARD */
.card {
	background: white;
	width: 400px;
	padding: 30px;
	border-radius: 15px;
	box-shadow: 0 4px 15px rgba(0,0,0,0.1);
}

h2 {
	text-align: center;
	margin-bottom: 20px;
}

input, select {
	width: 100%;
	padding: 10px;
	margin-bottom: 12px;
	border-radius: 8px;
	border: 1px solid #ddd;
	outline: none;
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

/* MESSAGE */
.error {
	background: #ffe6e6;
	color: #b30000;
	padding: 10px;
	border-radius: 6px;
	margin-bottom: 10px;
	text-align: center;
}

/* FOOTER LINK */
.footer {
	text-align: center;
	margin-top: 10px;
}

.footer a {
	color: #555;
	text-decoration: none;
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
		<h2>Create Account</h2>

		<%
		String error = (String) request.getAttribute("error");
		if (error != null) {
		%>
			<div class="error"><%=error%></div>
		<%
		}
		%>

		<form action="registerSubmit" method="post">
			<input type="text" name="name" placeholder="Full Name" required>
			<input type="email" name="email" placeholder="Email" required>
			<input type="text" name="phone" placeholder="Phone" required>
			<input type="password" name="password" placeholder="Password" required>

			<select name="role" required>
				<option value="">Select Role</option>
				<option value="USER">User</option>
				<option value="ADMIN">Admin</option>
			</select>

			<button type="submit">Register</button>
		</form>

		<div class="footer">
			Already have an account? <a href="loginPage">Login</a>
		</div>
	</div>

</div>

</div>

</body>
</html>