<!doctype html>

<html lang="es">
	<head>
	<meta charset="utf-8">
		<title>Conversor</title>
		<meta name="description" content="App web Java 3.0 para gestionar Prestamos de Libros">
		<meta name="author" content="Alain Muñoz Arrizabalaga">
		
		<link rel="stylesheet" href="css/styles.css?v=1.1">
	</head>
	
	<body>
		<h1>Conversor</h1>
		
		<h2>Metros -> Pies </h2>
		<form action="conversor" method="post">
			<input name="metros" type="text" placeholder="Metros">
			<input name="formulario" type="hidden" value="1">
			<p>Pies: ${piesCv}</p>
			<input type="submit" value="Convierte" /><br><br>
			<p>${mensaje}</p>
			<p>${mensaje1}</p>
		</form>
		
		<h2>Pies -> Metros</h2>
		<form action="conversor" method="post">
			<input name="pies" type="text" placeholder="Pies">
			<input name="formulario" type="hidden" value="2">
			<p>Metros: ${metrosCv}</p>
			<input type="submit" value="Convierte" />
			<p>${mensaje}</p>
			<p>${mensaje2}</p>
		</form>

		<a href="conversor?rst=1">Reset</a>
		
		<script src="js/scripts.js"></script>
	</body>
</html>