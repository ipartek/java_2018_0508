<!doctype html>

<%@page import="com.ipartek.formacion.gestor.libros.controller.ConversorController"%>

<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Conversor</title>
	<meta name="description"
		content="App Web Java 3.0 para gestionar préstamos de libros">
	<meta name="author" content="Adriana Prado Alonso">
	<link rel="stylesheet" href="css/styles.css?v3">
</head>

<body>
	<h1>Conversor metros y pies</h1>
	
	<form action="conversor" method="post" >		
		<label for="metros">Metros => Pies</label>
		<!-- 
		<span>Metros</span>
		 -->
		<input name="metros" type="text" placeholder="Introduce los metros" value="${metros}">
		<input name="formulario" type="hidden" value="<%=ConversorController.FORMULARIO1%>">
		<input type="submit" value="Enviar">
		<br><br>
		<span>Pies:</span>
		<span>${metros} metros son ${metrosConvertidos} pies.</span>
	</form>
	
	<hr>
	
	<form action="conversor" method="post" >		
		<label for="pies">Pies => Metros</label>
		<!-- 
		<span>Pies</span>
		 -->		
		<input name="pies" type="text" placeholder="Introduce los pies" value="<%=request.getAttribute("pies")%>">
		<input name="formulario" type="hidden" value="<%=ConversorController.FORMULARIO2%>">
		<input type="submit" value="Enviar">
		<br><br>
		<span>Metros:</span>
		<span>${pies} pies son ${piesConvertidos} metros.</span>
		
		<p class="text-danger">${msg}</p>
	</form>

	<script src="js/scripts.js"></script>
</body>
</html>