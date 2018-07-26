<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Usuario</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
	<link rel="stylesheet" href="css/styles.css?<%=System.currentTimeMillis()%>">
</head>
<body>
	<h1>LOG IN</h1>
	<form action="login" method="post">
		<label for="usuario">Usuario:</label>
		<input type="text" name="usuario" autofocus required pattern="^[A-Za-z0-9_]{3,25}$">
		<br/>
		<label for="contrasena">Contraseña:</label>
		<input id="pass" type="password" name="contrasena" required>
		<i id="eye" class="fas fa-eye" onmouseenter="show()" onmouseleave="show()"></i>
		<br/>
		<input type="submit" value="Entrar" />
	</form>

	<p class="text-danger">${msg}</p>
	
	<script>
		function show() {
			console.log('click en show');
			var pass = document.getElementById('pass');
			var eye = document.getElementById('eye');
			
			if ( pass.type == "password" ){
				pass.type = "text"; 
				eye.classList.replace("fa-eye","fa-eye-slash");				
			}else{
				pass.type = "password"; 
				eye.classList.replace("fa-eye-slash","fa-eye");
			}			
		}		
	</script>
	
</body>
</html>