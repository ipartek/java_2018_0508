<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>Gestion Libros</title>
  <meta name="description" content="App Web Java 3.0 para gestionar prestamos de libros">
  <meta name="author" content="Rakel Pastor Villarroel">
  
  <link rel="stylesheet" href="css/styles.css?v=1.0">
</head>

<body>
	<h1>CMS GESTION LIBROS</h1>
	
	<%
	 out.print("<p>Mensaje desde Java</p>");
	%>
	
	<p> - GET - </p>
	<a href="listar">Listar Libros</a><br>
	<a href="saludo?nombre=Pepe&ape1=Otilio&ape2=Gomez">Saludo</a>
	
	<br>
	<p> - POST - </p>
	<!-- POST -->
	<form action="bienvenida" method="post">
		<input name="nombre" type="text" placeholder="Dime tu nombre">
		<p class="text-danger">${msg}</p>
		<input type="submit" value="enviar">
	</form>
	
  <script src="js/scripts.js"></script>
</body>
</html>