<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Usuario</title>
	<link rel="stylesheet" href="css/styles.css?">
</head>
<body>
	<h1>LOG IN</h1>
	<form action="login" method="post">
		<label for:"usuario">Usuario:</label>
		<input type="text" name="usuario">
		<br/>
		<label for:"contrasena">Contraseña:</label>
		<input type="password" name="contrasena">
	
		<input type="submit" value="Entrar" />
	</form>

	<p class="text-danger">${msg}</p>
</body>
</html>