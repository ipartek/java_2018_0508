<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">

<title>Ahorcado</title>
<meta name="description"
	content="App web Java 3.0 para gestionar préstamos de libros">
<meta name="author" content="Luis">

<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>

	<h1>Ahorcado</h1>
	
	<form action="ahorcado">
		<input name="letraAhorcado" type="text" placeholder="Escribe letra..."> 
		<br> 
		<input type="submit" value="Enviar">
	</form>
	

	<%
		//Recibir atributo de una JSP
		String usuarioLetra = (String) request.getAttribute("letraAhorcado");
		String msg = (String) request.getAttribute("msg");
		String vidas = (String) request.getAttribute("vidas");
		
		out.println("<p> Letra seleccionada " +usuarioLetra);
		out.println(msg);
		//out.println(vidas);
		
	%>

	  <hr>
	Expression language
	<br>
	<b>${usuarioLetra}</b>
	


	<script src="js/scripts.js"></script>
	<hr>
	<img src="img/ahorcado.jpg" alt=""/>
</body>
</html>