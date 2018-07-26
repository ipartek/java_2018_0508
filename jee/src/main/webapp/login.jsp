<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Usuario</title>
	<link rel="stylesheet" href="css/styles.css?<%=System.currentTimeMillis()%>">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
</head>
<body>
	<h1>LOG IN</h1>
	<form action="login" method="post">
		<label for="usuario">Usuario:</label>
		<input type="text" name="usuario" required pattern="^[A-Za-z0-9_]{3,25}$" autofocus>
		<br/>
		<label for="contrasena">Contraseña:</label>
		<input id="pass" type="password" name="contrasena" required>
		<i id="ojo" class="fas fa-eye " id="ojo" onclick="show()" onmouseenter="show()" onmouseleave="show()"></i>
		<br/>
		<input type="submit" value="Entrar" />
	</form>

	<p class="text-danger">${msg}</p>
	
	<script>
	
	function show() {
		console.log('click en show');
		var pass = document.getElementById('pass');		
		var ojo = document.getElementById('ojo');
		
		if (pass.type=="password") {
			pass.type="text";
			ojo.classList.replace("fa-eye","fa-eye-slash");
		} else {
			pass.type="password";
			ojo.classList.replace("fa-eye-slash","fa-eye");
		}
		
	}
	
	
	
	
	
	
	</script>
	
</body>
</html>