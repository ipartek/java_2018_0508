<!doctype html>

<html lang="es">
<head>
	<meta charset="utf-8">
	
	<title>Gestion Libros</title>
	<meta name="description" content="App Web Java 3.0 para Gestionar Prestamo de Libros">
	<meta name="author" content="Adrian Perozzo">
	
	<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>

	<h1>CMS Prestamo Libros</h1>

	<nav class="center">
		<ul id="menu">
			<li>
				<a href="listar">Listar Libros</a>
			</li>
			<li>
				<a href="saludo?nombre=Pepe&ap1=Otilio&ap2=Gomez">Saludar</a>
			</li>
			<li>
				<a href="ejemplo-response">Ejemplo Response</a>
			</li>
			<li>
				<a href="jugandoConCSS.jsp">Jugando con CSS</a>
			</li>
			<li>
				<a href="ahorcado">Ahorcado</a>
			</li>
		</ul>
	</nav>
	<%
		// Esto es Java
		//out.print("<p>Soy Java</p>");
	%>
	<br><br>
	<h2>Por POST</h2>
	<form action="saludo" method="POST">
		
		<input name="nombre" type="text" placeholder="Dime tu nombre">
		<p class="text-danger">${msg}</p>
		<input name="ap1" type="text" placeholder="Dime tu primer apellido"><br><br>
		<input name="ap2" type="text" placeholder="Dime tu segundo apellido"><br><br>
		<input type="submit" value="Enviar">
		
	</form>

	<script src="js/scripts.js"></script>
	
</body>

</html>