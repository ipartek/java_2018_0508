<!doctype html>
<html lang="es">
<head>
	<meta charset="utf-8">
		
	<title>Login</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
	<meta name="description" content="App Web Java 3.0 para gestionar préstamos de libros">
	<meta name="author" content="Adrian Garcia">
		
	<link rel="stylesheet" href="css/styles.css?<%=System.currentTimeMillis()%>">
	
</head>
	
<body>

	<div id="login">
		<form action="login" method="post">
			<fieldset>
				<legend><img src="https://image.freepik.com/free-icon/male-user-shadow_318-34042.jpg" /></legend>
				<label for="usuario">Usuario:</label>
				<br/>
				<input type="text" name="usuario" value="${usuarioEscrito}" autofocus required pattern="^[A-Za-z0-9_]{3,25}$" />
				<br/>
				<label for="pass">Contraseña:</label>
				<br/>
				<input id="pass" type="password" name="pass" value="${passEscrita}" required pattern="^[A-Za-z0-9_]{3,25}$"/>
				<i id="eye" class="fas fa-eye" onmouseover="show()" onmouseleave="show()"></i>
				<br/>
				<input type="submit" value="Login" />
				
				<a href="#">${msgOlvido}</a>
				<p class="text-danger">${msgIncorrecto}</p>
			</fieldset>
		</form>
	</div>

	<script>
	
	function show(){
		//console.log('click en show');
		
		var pass = document.getElementById('pass');
		var eye = document.getElementById('eye');
		
		if(pass.type == "password"){
			pass.type = "text";
			eye.classList.replace("fa-eye", "fa-eye-slash");
			
		}else{
			pass.type = "password";
			eye.classList.replace("fa-eye-slash", "fa-eye");
		}
		
	}
	
	</script>
</body>
</html>