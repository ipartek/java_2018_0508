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
	
	<%
		//Esto es Java
		
		String nombreCompleto = (String)request.getAttribute("nombreCompleto");
		
		out.print("<h1>Hola " + nombreCompleto + "</h1>"); //Forma de escribir una variable
		
		String nombrePost = (String)request.getAttribute("nombrePost");
		
		out.print("<h1>Nombre = " + nombrePost + "</h1>");
		
	%>
	
	<hr/>
	
	Expression Language
	<b>${nombreCompleto}</b>  <!-- Forma de escribir una variable -->
	
	<hr/>
	
	<%=request.getAttribute("nombreCompleto") %> <!-- Forma de escribir una variable -->

	<script src="js/scripts.js"></script>
</body>
</html>