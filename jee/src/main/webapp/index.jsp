<!doctype html>

<html lang="es">
<head>
<meta charset="utf-8">
<title>Gestion libros</title>
<meta name="description"
	content="App web Java 3.0 para gestionar Prestamos de Libros">
<meta name="author" content="Ainara Goitia">

<link rel="stylesheet" href="css/styles.css?v=1.1">
</head>

<body>
	<h1>CMS Prestamos Libros</h1>

	<nav>
		<ul id="button">
			<li><a href="listar">Listar Libros</a></li>
			<li><a href="saludo?nombre=pepe&ape1=Lorenzo&ape2=Gomez">Saludo</a>
			</li>
			<li><a href="ejemplo-response">Ejemplo Response</a></li>
			<li><a href="jugandoConCss.jsp">Jugando con Css</a></li>
			<li><a href="ahorcado">Juego del ahorcado</a></li>
			<li><a href="conversor">Conversores</a></li>
		</ul>

	</nav>
	<br>
	<br>
	<br>
	<form action="saludo" method="post">
		Nombre:<input name="nom" type="text">
		<p style="color: red">${msg }</p>
		<input type="submit" value="enviar">
	</form>
	<script src="js/scripts.js"></script>
</body>
</html>