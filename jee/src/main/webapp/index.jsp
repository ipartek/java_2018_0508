<!doctype html>

<html lang="es">
<head>
<meta charset="utf-8">

<title>Gestion_libros</title>
<meta name="description"
	content="App Web Java 3.0 para gestionar prestamos libros">
<meta name="author" content="Valeria Valencia">
<link rel="stylesheet" href="css/styles.css">

</head>

<body>
	<h1>CMS Prestamo Libros</h1>

	<nav>
		<ul>
			<li><a href="listado.jsp">Listar Libros</a></li>
			<li><a href="saludo?nombre=pepe&ape1=Gomez&ape2=Otilio">Saludo</a></li>
			<li><a href="ejemplo-response">Ejemplo Response</a></li>
			<li><a href="jugandoConCss.jsp">jugando con Css</a></li>
		</ul>
	</nav>
	<div class="ahorcado fallo1"></div>
	<style>
	
	</style>
	

	<form action="saludo" method="post">

		<input name="nom" type="text" placeholder="Dime tu Nombre"> 
		
		<input type="submit" value="Enviar">

	</form>
		
	
</body>
</html>