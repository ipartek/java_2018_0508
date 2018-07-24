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
		
		<%
			//Esto es java
			out.print("<p>Soy Java</p>");
		%>
		
		<a href="listar">Listar Libros</a> 
		<br>
		
		<a href="saludo?nombre=pepe&ape1=Otilio&ape2=Gomez">Saludo</a>
		
		
		
		<form action="saludo" method="post">
		
			<input name="nom" type="text" placeholder="Dime tu Nombre">
			<p class="text-danger">${msg}</p>
			
			<input type="submit" value="Enviar">
		
		</form>
		
		
		
		
		<script src="js/scripts.js"></script>
	</body>
</html>