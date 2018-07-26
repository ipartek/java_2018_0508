<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Log-in Usuario</title>
<meta name="description"
	content="App Web Java 3.0 para gestionar prestamos de libros">
<meta name="author" content="Rakel Pastor Villarroel">

<link rel="stylesheet" href="css/styles.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
</head>
<body>

	<h1>LOGIN</h1>
	<form action="login" method="post">
		<label for="usuario">Usuario: </label>
		<input name="usuario" type="text" required pattern="^[A-Za-z0-9_]{3,25}$"/><br><br>
		<label for="contraseina">Contraseña: </label>
		<input id="pass" name="contraseina" type="password" required/>
		<i id="eye" class="far fa-eye" onmouseenter="show()" onmouseleave="show()"></i><br><br>
		
		<input type="submit" value="ENTRAR"/>
	</form>
	<p class="text-danger">${msg}</p>



	<script>
		function show(){
			console.log('click en show');
			
			var pass=document.getElementById("pass");
			var eye=document.getElementById("eye");
			
			if(pass.type=="password"){
				pass.type="text";
				eye.classList.replace("fa-eye","fa-eye-slash");
			}else{
			pass.type="password";
			eye.classList.replace("fa-eye-slash","fa-eye");
			}
		}
	</script>
</body>
</html>