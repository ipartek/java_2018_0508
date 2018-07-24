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

	<h1>EL Ahorcado</h1>
	<%
	
		char[] huecos = (char[]) request.getAttribute("huecos");
	
		out.print(huecos);	
	
	%>
	
	
	<h2>Descubre la palabra</h2>
	<form action="ahorcado" method="POST">
		
		<input name="letra" type="text" placeholder="Dime una letra" maxlength="1">
		<input type="submit" value="Enviar">
		
	</form>

	<script src="js/scripts.js"></script>
	
</body>

</html>