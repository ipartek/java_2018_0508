<!-- pies o metros 
comprobar usuario escriba algo inadecuado vacio,algo k no es numero,
 -->
<html lang="es">
<head>
<meta charset="utf-8">
<title>Ahorcado</title>
<meta name="description" content="Juegos del Ahorcado">
<meta name="author" content="Rakel Pastor Villarroel">

<link rel="stylesheet" href="css/styles.css?v=1.0">
</head>
<body>
	<h1>JUEGO DEL CONVERSOR</h1>



	<h3>- Conversor de Pies a Metros -</h3>

	<form action="conversor" method="post">
		<input name="formulario" type="hidden" value="1"><br> <label>Pies</label>
		<input name="pies" type="text" placeholder="Introduce un numero"><br>
		<br> <label>Metros</label>
		<p>${metros}</p>
		<input type="submit" value="convertir" />
	</form>

	<h3>- Conversor de Metros a Pies -</h3>

	<form action="conversor" method="post">
		<input name="formulario" type="hidden" value="2"><br> <label>Metros</label>
		<input name="metros" type="text" placeholder="Introduce un numero"><br>
		<br> <label>Pies</label>
		<p>${pies}</p>
		<input type="submit" value="convertir" />

		<p class="text-danger">${msg}</p>

	</form>
	<script src="js/scripts.js"></script>
</body>
</html>
