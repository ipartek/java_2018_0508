<!doctype html>

<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Gestión Libros</title>
	<meta name="description"
		content="App Web Java 3.0 para gestioar préstamos de libros">
	<meta name="author" content="Adriana Prado Alonso">
	<link rel="stylesheet" href="css/styles.css?v=1.0">
</head>

<body>
	<h1>CMS Préstamo Libros</h1>
	<%
		//Esto es Java
		out.print("<p>Soy Java</p>");
	%>

	<a href="listar">Listar Libros</a>

	<!-- 
		<a href="saludo?nombre=pepe"> Saludar </a>
		<a href="saludo?nombre=pepe, ape1=otilio, ape2=gomez"> Saludar </a>
	 -->
	 
	<a href="saludo?nombre=pepe&ape1=otilio&ape2=gomez"> Saludar </a>
	
	<form action="saludo" method="post" >
	
		<input name="nom" type="text" placeholder="Dime tu nombre">
		<p class="text-danger">${msg}</p>
		<input type="submit" value="Enviar">
	
	</form>

	<%
		//Crear un nuevo controlador que tenga de mapping saludo y se le envia un parametro nombre por GET
		//<a href="saludo?nombre=pepe&ape1="Otilio"&ape2="Gomez"> Saludar </a>
		//recibir un atributo en una jsp
		//String nombre = (String) request.getAttribute("nombre");
		//out.print("nombre: " + nombre);
	%>

	<script src="js/scripts.js"></script>
</body>
</html>