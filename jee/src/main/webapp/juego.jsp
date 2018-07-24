<!doctype html>

<html lang="es">
<head>
<meta charset="utf-8">
<title>JUEGO</title>
<meta name="description"
	content="App web Java 3.0 para jugar al ahorcado">
<meta name="author" content="Ainara Goitia">

<link rel="stylesheet" href="css/styles.css?v=1.1">
</head>

<body>
	<h1>Ahorcado</h1>

	<%
		//recibir Atributo en una JSP. Expression Languaje es lo mismo que lo de abajo.
		String letra = (String) request.getAttribute("letra");
		out.println("Letra: " + letra);
	%>
	<form action="juego" method="post">
	
		<input name="letra" type="text">
		<input type="submit" value="enviar">
		<p style="color: red">${msg }</p>
		<p style="color: green">${resultado }</p>
		
	</form>

</body>
</html>