<!doctype html>

<%@page import="com.ipartek.formacion.ahorcado.controller.AhorcadoController"%>
<html lang="es">
<head>
	<meta charset="utf-8">	
	<title>Juego del Ahorcado</title>
	<meta name="description" content="App Web Java 3.0 para gestioar préstamos de libros">
	<meta name="author" content="Adriana Prado Alonso">	
	<link rel="stylesheet" href="css/styles.css">
</head>

<body>
	<h1>Juego del Ahorcado</h1>
	
	<form action="ahorcado" method="post" >
		<label>${letras[0]} </label>
		<label>${letras[1]} </label>
		<label>${letras[2]} </label>
		<label>${letras[3]} </label>
		<label>${letras[4]} </label>
		<br><br>
		<input name="letra" type="text" placeholder="Introduce una letra">
		<input type="submit" value="Enviar">
		<br><br>
		<p class="text-danger">${msg}</p>
	</form>
	
	<br>
	
	<div  class="ahorcado fallo<%out.print(AhorcadoController.contFallos);%>">
	</div>
	
	<br/>
	
	<%
		boolean isTerminado = (boolean)request.getAttribute("isTerminado");
		if ( isTerminado ){
			%>
				<a href="ahorcado?jdn=1">Jugar de Nuevo</a>
			<%
		}
	%>
	
	<script src="js/scripts.js"></script>
</body>
</html>