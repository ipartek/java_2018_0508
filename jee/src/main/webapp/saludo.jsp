<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">

<title>Gestión de Libros</title>
<meta name="description"
	content="App web Java 3.0 para gestionar préstamos de libros">
<meta name="author" content="Luis">

<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>

	<h1>Saludo</h1>

	<%
		//Recibir atributo de una JSP
		String nombre = (String) request.getAttribute("nombre");
		String apellido1 = (String) request.getAttribute("apellido1");
		String apellido2 = (String) request.getAttribute("apellido2");

		out.println("<p> Saludos, " + nombre + " " + apellido1 + " " + apellido2);
	%>

	<hr>
	Expression language
	<br>
	<b>${nombre}</b>
	<b>${apellido1}</b>
	<b>${apellido2}</b>

	<script src="js/scripts.js"></script>

</body>
</html>