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

	<h1>CMS Préstamos de Libros</h1>

	<%
		out.print("<p> Soy Java </p>");
	%>

	<h2> Listar </h2>
	<a href="listar">Listar libros</a>
	<hr>
	<h2> Saludar </h2>
	<p>Crear un nuevo controlador que tenga de Mapping Saludo y se le envie un parámetro "nombre" por GET.</p>
	<p>Redirigirá a una nueva vista que se llame Saludo.jsp</p>
	<a href="saludoGet?nombre=Luis&apellido1=Galdos&apellido2=Garcia">Saludar</a>
	<br><br>
	<form action="saludoPost">
		<input name="nombre" type="text" placeholder="Escribe aquí tu nombre"> 
		<p class="text-danger">${msg}</p>
		<input type="submit" value="Enviar">
	</form>
	<br><br>
	<hr>
	<h2> Calcular </h2>
	<form action="calcular">
		<input name="num1" type="text" placeholder="Escribe aquí un número"> 
		<br>
		<input name="num2" type="text" placeholder="Escribe aquí un número" required> 
		<br>
		<br>
		<input type="radio" name="operacion" value="+"> + 
		<input type="radio" name="operacion" value="-"> - 
		<input type="radio" name="operacion" value="*"> * 
		<input type="radio" name="operacion" value="/"> / 
		<br>
		<input type="submit" value="Enviar">
	</form>
	<br>
	<p class="text-danger">${resultado}</p>
	<script src="js/scripts.js"></script>

</body>
</html>