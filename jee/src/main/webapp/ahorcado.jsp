<!doctype html>
<html lang="es">
<head>
	<meta charset="utf-8">
		
	<title>Ahorcado</title>
	<meta name="description" content="App Web Java 3.0 para jugar al ahorcado">
	<meta name="author" content="Adrian Garcia">
		
	<link rel="stylesheet" href="css/styles.css?v=1.0">
	
</head>
	
<body>

	<h1>Juego del ahorcado</h1>
	
	<%
		//Esto es Java
		
		
	
	%>
	
	<p>${encontrado}</p>
	<p>${noEncontrado}</p>
	<p>${msg}</p>
	
	<label>${letra0}</label>
	<label>${letra1}</label>
	<label>${letra2}</label>
	<label>${letra3}</label>
	<label>${letra4}</label>
	
	<form action="ahorcado" method="post">
	
		<input type="text" name="letra" placeholder="Escribe una letra" />
		<input type="submit" value="enviar"/>
	
	</form>
	
	<div class="ahorcado"></div>
	
	<p class="text-danger">${eliminado}</p>

	<script src="js/scripts.js"></script>
</body>
</html>