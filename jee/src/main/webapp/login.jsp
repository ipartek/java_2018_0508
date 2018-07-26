<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">

	<title>Login</title>
	<meta name="author" content="Luis">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
	<link rel="stylesheet" href="css/styles.css?v=2.0">
	<link rel="stylesheet" href="css/loginstyles.css?v=4.0">
	
</head>

<body>
	
	<form name="login" method="post" action="inicia-sesion">
		<div class="form-group">
    		<input type="text" placeholder="Usuario." required class="form-control" name="usuario">
			<label><i class="fas fa-user-tie"></i></label>
		</div>
		<div class="form-group">
    		<input type="password" id="psw" placeholder="Contraseña." required class="form-control" name="psw">
    		<label onmouseenter="verPassword()" onmouseleave="verPassword()"><i id="eye" class="fas fa-eye"></i></label>
		</div>
			<input type="submit" value="Login">
		</form>
	<p class="text-danger">${msg}</p>
	
	<script type="text/javascript">

		function verPassword() {
			
   			var x = document.getElementById("psw");
   			var eye = document.getElementById("eye");
   			
    	if (x.type === "password") { // Si no es visible
        	x.type = "text"; // Lo hacemos visible
        	
        	eye.classList.replace("fa-eye","fa-eye-slash"); // Cambiamos el ojo a cerrado
    	
    	} else { // Si es visible
        	x.type = "password"; // Lo hacemos invisible
        	eye.classList.replace("fa-eye-slash","fa-eye"); // Cambiamos el ojo
    	}
	}
	</script>
</body>

</html>