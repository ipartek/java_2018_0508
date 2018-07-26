<!doctype html>

<html lang="es">
<head>
<meta charset="utf-8">

<title>Gestion_libros</title>
<meta name="description"
	content="App Web Java 3.0 para gestionar prestamos libros">
<meta name="author" content="Valeria Valencia">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/styles.css?v=1.1">

</head>

<body>


	<h1>LOGIN</h1>

	<form method="POST" action="login">
		Usuario:<input type="text" name="usu" autofocus required
			pattern="^[A-Za-z0-9_]{3,25}$" /><br /> Password:<input id="passw"
			type="password" name="pass" required />
			 <i id="eye" class="fas fa-eye" onmouseenter="show()"  onmouseleave="show()" ></i> <br /> <input
			type="submit" value="login" />
	</form>
	<script>
		function show() {
			console.log('click en show');
			var passw = document.getElementById('passw');
			var eye = document.getElementById('eye');


			if (passw.type == "password") {
				passw.type = "text";
			} else {
				passw.type = "password";
			}
		}
	</script>

</body>
</html>