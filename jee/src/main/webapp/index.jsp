<!doctype html>

<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Gestión Libros</title>
	<meta name="description"
		content="App Web Java 3.0 para gestioar préstamos de libros">
	<meta name="author" content="Adriana Prado Alonso">
	<link rel="stylesheet" href="css/styles.css?v3">
</head>

<body>
	<h1>CMS Préstamo Libros</h1>
	
	<nav>
		<ul>
			<li><a href="listar">Listar Libros</a></li>
			<li><a href="saludo?nombre=pepe&ape1=otilio&ape2=gomez">Saludar</a></li>
			<li><a href="ejemplo-response">Ejemplo Response</a></li>
			<li><a href="jugandoConCss.jsp">Jugando con CSS</a></li>
			<li><a href="ahorcado">Juego del ahorcado</a></li>			
			<li><a href="conversor.jsp">Conversor</a></li>
			<li><a href="calculadora.jsp">Calculadora</a></li>
		</ul>
	</nav>

	<!-- 
		<a href="saludo?nombre=pepe"> Saludar </a>
		<a href="saludo?nombre=pepe&ape1=otilio&ape2=gomez"> Saludar </a>
	 -->
	 
	<%
		//Esto es Java
		out.print("<p>Soy Java</p>");
	%>
	
	 	
	<form action="saludo" method="post" >
	
		<input name="nom" type="text" placeholder="Dime tu nombre">
		<p class="text-danger">${msg}</p>
		<input type="submit" value="Enviar">
	
	</form>

	<script src="js/scripts.js"></script>
</body>
</html>