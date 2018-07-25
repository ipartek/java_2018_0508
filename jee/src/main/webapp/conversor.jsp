<!doctype html>

<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Conversor</title>
	<meta name="description"
		content="App Web Java 3.0 para gestionar préstamos de libros">
	<meta name="author" content="Adriana Prado Alonso">
	<link rel="stylesheet" href="css/styles.css?v3">
</head>

<body>
	<h1>Conversor metros y pies</h1>
	
	<form action="conversor" method="post" >
		<span>Metros</span>
		<input name="metros" type="text" placeholder="Introduce los metros">
		<input name="formulario" type="hidden" value="1">
		<input type="submit" value="Enviar">
		<br><br>
		<span>Pies:</span>
		<span>${metros} metros son ${metrosConvertidos} pies.</span>
		
	<hr>
	
	</form>
	
	<form action="conversor" method="post" >
		<span>Pies</span>
		<input name="pies" type="text" placeholder="Introduce los pies">
		<input name="formulario" type="hidden" value="2">
		<input type="submit" value="Enviar">
		<br><br>
		<span>Metros:</span>
		<span>${pies} pies son ${piesConvertidos} metros.</span>
		
		<p class="text-danger">${msg}</p>
	</form>

	<script src="js/scripts.js"></script>
</body>
</html>