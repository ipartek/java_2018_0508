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
<h1>Saludar</h1>

	<p><%="Nombre: " + request.getAttribute("nombre")%></p>
	<p><%="Apellido 1: " + request.getAttribute("ape1")%></p>
	<p><%="Apellido 2: " + request.getAttribute("ape2")%></p>
	
	<!-- otra forma de sacar datos por pantalla -->
	<% 
	String nombreComple=(String)request.getAttribute("nombreCompleto");
	out.println(nombreComple);
	%>
	<!-- otra forma de sacar datos por pantalla -->
	<hr>
	Expression Language
	<b>${nombreCompleto}</b>
  <script src="js/scripts.js"></script>


</body>
</html>