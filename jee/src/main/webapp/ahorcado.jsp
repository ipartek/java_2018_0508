<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">

<title>Ahorcado</title>
<meta name="description"
	content="App web Java 3.0 para gestionar préstamos de libros">
<meta name="author" content="Luis">

<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>

	<h1>Ahorcado</h1>
	<img class="ahorcado" alt="ahorcado.jpg">
	
	<p> Bienvenido al juego del ahorcado. Tiene 5 intentos para adivinar la palabra. <p>
	
	<form action="ahorcar" method="post">
		<input name="letra" type="text" placeholder="Escribe letra..."> 
		<br> 
		<input type="submit" value="Enviar"> <input type="submit" value="Solución">
	</form>
	<hr>
	<p class ="text-danger">${msg}</p>
	<h2> ${solucion} </h2>
	<hr>
	<p> Aciertos: ${aciertos} </p>
	<p> Intentos: ${intentos} </p>
	

	<script src="js/scripts.js"></script>

</body>
</html>