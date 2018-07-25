<!doctype html>
<html lang="es">
<head>
	<meta charset="utf-8">
		
	<title>Gestión Libros</title>
	<meta name="description" content="App Web Java 3.0 para gestionar préstamos de libros">
	<meta name="author" content="Adrian Garcia">
		
	<link rel="stylesheet" href="css/styles.css?v=1.0">
	
</head>
	
<body>

	<h1>CMS Préstamo Libros</h1>
		
	<nav>
		<ul>
			<li><a href="listar">Listar libros</a></li>
			<li><a href="saludo?nombre=Adrian&ap1=Garcia&ap2=Santos">Saludo personalizado</a></li>
			<li><a href="ejemplo-response">Ejemplo Response</a></li>
			<li><a href="ahorcado">Jugar al ahorcado</a></li>
			<li><a href="jugandoConCss.jsp">Jugando con CSS</a></li>
			<li><a href="conversor">Conversor metros-pies</a></li>
		</ul>
	</nav>
	
	<br/>
	<br/>
	
	<%
		//Esto es Java
		
		out.print("<p>Soy Java</p>");
	
	%>
	
	<div class="ahorcado"></div>
		
	<form action="saludo" method="post">
	
		<input type="text" name="nombrePost" placeholder="Escribe tu nombre" />
		<p class="text-danger">${msg}</p>
		<input type="submit" value="enviar"/>
	
	</form>

	<script src="js/scripts.js"></script>
</body>
</html>