<!doctype html>

<html lang="es">
	<head>
	<meta charset="utf-8">
		<title>Juego Ahorcado</title>
		<meta name="description" content="App web Java 3.0 para gestionar Prestamos de Libros">
		<meta name="author" content="Alain Muñoz Arrizabalaga">
		
		<link rel="stylesheet" href="css/styles.css?v=1.2">
	</head>
	
	<body>
		<h1>Juego Ahorcado</h1>
		
		<div class="ahorcado">
			<img src="img/ahorcado.jpg?v2" alt="sprite del juego del ahorcado">
		</div><br>
		
		<p>${mostrar}</p>
		
		<form method="post" action="juega">
			<input type="text" name="letra" placeholder="Introduce una letra"><br><br>
			<p>${resultado}</p>
			<p>Respuesta: ${respuesta}</p>
			<input type="submit" value="¡Comprueba!">
		</form>
		
		<p>Vidas: ${contVidas}</p>
		
		<script src="js/scripts.js"></script>
	</body>
</html>