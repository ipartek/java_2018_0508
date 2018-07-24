<html lang="es">
<head>
  <meta charset="utf-8">
  <title>Ahorcado</title>
  <meta name="description" content="Juegos del Ahorcado">
  <meta name="author" content="Rakel Pastor Villarroel">
  
  <link rel="stylesheet" href="css/styles.css?v=1.0">
</head>
<body>
	<h1>AHORCADO</h1>
	
	<h3>Adivina la palabra</h3>
	<form action="ahorcado" method="post">
		<br><br>
		<input name="letra" type="text" placeholder="Introduce una letra">
		<input type="submit" value="enviar">
		<p class="text-danger">${msg}</p>
	</form>
	
	
  <script src="js/scripts.js"></script>
</body>
</html>