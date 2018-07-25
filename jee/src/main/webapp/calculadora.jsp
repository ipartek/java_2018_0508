<!doctype html>

<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Calculadora</title>
	<meta name="description"
		content="App Web Java 3.0 para gestioar préstamos de libros">
	<meta name="author" content="Adriana Prado Alonso">
	<link rel="stylesheet" href="css/styles.css?v3">
</head>

<body>	
	<h1>Calculadora</h1>
	 	
	<form action="conversor" method="post" >
		<span>Número 1: </span>
		<input name="numero1" type="text" placeholder="${numero1}">
		<br><br>
		<span>Operando: </span>
		<input name="operando" type="text" placeholder="${operando}">
		<br><br>
		<span>Número 2: </span>
		<input name="numero2" type="text" placeholder="${numero2}">
		<br><br>
		<span></span>
		<input type="submit" value="Enviar">
		<br><br>
		<span>Resultado: ${numero1} ${operando} ${numero2} = ${resultado}</span>
		<span></span>
		
	<hr>
	
	</form>

	<script src="js/scripts.js"></script>
</body>
</html>