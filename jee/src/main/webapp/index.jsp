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
				<li><a href="listar">Listar Libros</a> </li>
				<li><a href="saludo?nombre=pepe&ape1=Otilio&ape2=Gomez">Saludo</a></li>
				<li><a href="ejemplo-response">Ejemplo Response</a>	</li>
				<li><a href="jugarAhorcado">Jugar al ahoracado</a></li>	
				<li><a href="jugandoConCss.jsp">Jugando con CSS</a> </li>	
				<li><a href="conversor.jsp">conversor mTOpies </a> </li>		
			</ul>		
		</nav>
		
		
		
		<%
			//Esto es java
			out.print("<p>Soy Java</p>");
		%>
		
		
		
		<form action="saludo" method="post">
		
			<input name="nom" type="text" placeholder="Dime tu Nombre">
			<p class="text-danger">${msg}</p>
			
			<input type="submit" value="Enviar">
		
		</form>
		
		
		
		
		<script src="js/scripts.js"></script>
	</body>
</html>