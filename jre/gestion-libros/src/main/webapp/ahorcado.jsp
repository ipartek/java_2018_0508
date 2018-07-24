<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Juego del ahorcado</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<form method="post" action="ahorcado">
		<input name="letra" type="text" placeholder="Introduce una letra" /> <input
			type="submit" value="Enviar" /> <b> ${letra}</b> <br />
		<%
			
			
			out.print(request.getAttribute("contador"));
		%>


		<b>${respuesta}</b>

		<div id="ahorcado">

			<img alt="Sprite del juego del ahorcado" src="img/ahorcado.jpg">

		</div>

	</form>


</body>
</html>