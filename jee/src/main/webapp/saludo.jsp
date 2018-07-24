<!doctype html>

<html lang="es">
<head>
	<meta charset="utf-8">	
	<title>Gestión Libros</title>
	<meta name="description" content="App Web Java 3.0 para gestioar préstamos de libros">
	<meta name="author" content="Adriana Prado Alonso">	
	<link rel="stylesheet" href="css/styles.css?v=1.0">
</head>

<body>
	<h1>Saludos <% out.print(request.getAttribute("nom")); %></h1>
	
	<% 
	String nombre = (String)request.getAttribute("nom");
	out.print(nombre); 
	%>
	
	<hr>
	Expression Language 
	<b>${nombre}</b>
	
	<%=request.getAttribute("nom")%>
	
	
	<script src="js/scripts.js"></script>
</body>
</html>