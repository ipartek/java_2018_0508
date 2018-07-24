<!doctype html>

<html lang="es">
<head>
	<meta charset="utf-8">
	
	<title>Gestion Libros</title>
	<meta name="description" content="App Web Java 3.0 para Gestionar Prestamo de Libros">
	<meta name="author" content="Adrian Perozzo">
	
	<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>

	<h1>Saludo</h1>
	
	<%
		String nombre = (request.getAttribute("nombre")!=null)?(String) request.getAttribute("nombre"):" ";
		String ap1 = (request.getAttribute("ap1")!=null)?(String) request.getAttribute("ap1"):" ";
		String ap2 = (request.getAttribute("ap2")!=null)?(String) request.getAttribute("ap2"):" ";
		
		out.print("<p>"+nombre+" "+ap1+" "+ap2+"</p>");
	%>
	
	<script src="js/scripts.js"></script>
	
</body>

</html>