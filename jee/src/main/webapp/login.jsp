<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">

<title>Login</title>
<meta name="description"
	content="App web Java 3.0 para gestionar préstamos de libros">
<meta name="author" content="raul">

<link rel="stylesheet" href="css/styles.css?v=1.0">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">


</head>

<body class="primerLogin">

	<!-- <h1>Login</h1> -->
	
	<div align="center">
		<form class="logingform" method="post" action="login">
		<input class="loginstyle1" name="nombre" type="text" placeholder="Nombre de usuario" autofocus required pattern="^[a-zA-Z0-9-_\.]{3,20}$">
		<br> 
		<input class="loginstyle1" id="pass" name="contrasena" type="password" placeholder="Contraseña" required pattern="^[a-zA-Z0-9-_\.]{3,20}$">
		<i id="eye" class="fas fa-eye" onmouseenter="show()" onmouseleave="Show()" ></i>
		<br> 
			<input name="enviar" type="submit" value="Enviar">
		</form>
	</div>
	
	<p>${ msg }</p>
	<script>
	function show(){
		console.log("Funcion show");
		
		var pass = document.getElementById('pass');
		var eye = document.getElementById('eye');
		if(pass.type == "password"){
			pass.type="text";
			eye.classList.replace("fa-eye","fa-eye")
		}else{
			pass.type="password";
			eye.classList.replace("fa-eye-slash","fa-eye")
		}
		
	}
	
		
	</script>
</body>
</html>