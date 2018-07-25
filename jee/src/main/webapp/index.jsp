<!doctype html>

<html lang="es">
	<head>
	<meta charset="utf-8">
		<title>Gestion libros</title>
		<meta name="description" content="App web Java 3.0 para gestionar Prestamos de Libros">
		<meta name="author" content="Alain Muñoz Arrizabalaga">
		
		<link rel="stylesheet" href="css/styles.css?v=1.1">
	</head>
	
	<body>
		<h1>CMS Prestamos Libros</h1>
		
		<nav>
			<ul>
				<li><a href="listar">Listar Libros</a></li>
				<li><a href="saludo?nombre=Pepe&apellido1=Otilio&apellido2=Gomez">Saludo</a></li>
				<li><a href="ejemplo-response">Ejemplo Response</a></li>
				<li><a href="ahorcado.jsp">Juego Ahorcado</a></li>
				<li><a href="jugandoConCss.jsp">Jugando con CSS</a></li>
				<li><a href="conversor">Conversores</a></li> <!-- De metros a pies  -->
			</ul>
		</nav>
		
		<%
			//Esto es java
			out.print("<p>Soy Java</p>");
		%>
		
		<form action="saludo" method="post">
			<input name="nombre" type="text" placeholder="Dime tu nombre"><br>
			<input name="apellido1" type="text" placeholder="Dime tu primer apellido"><br>
			<input name="apellido2" type="text" placeholder="Dime tu segundo apellido"><br>
			<p style="color: red">${msg}</p>
			<input type="submit" value="Enviar">
		</form>

		
		<script src="js/scripts.js"></script>
	</body>
</html>