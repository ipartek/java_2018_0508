<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>El ahorcado</title>
		
		<link rel="stylesheet" href="css/styles.css">
	</head>
	<body>
		<h1>JUEGO DEL AHORCADO</h1>
		
		<!-- Juego del ahorcado -->
		
		<div class="ahorcado fallo0"></div>
		
		<p>
			<span value=""><%=request.getAttribute("casilla0")%></span>
			<span><%=request.getAttribute("casilla1")%></span>
			<span><%=request.getAttribute("casilla2")%></span>
			<span><%=request.getAttribute("casilla3")%></span>
			<span><%=request.getAttribute("casilla4")%></span>		
		</p>
		
		<p>${intento}</p>
		<form action="jugarAhorcado" method="post">			
			<input name="letraUsuario" type="text" placeholder="Dime una letra">
			<p >${msg}</p>
			
			<input type="submit" value="Enviar">
					
		</form>
	</body>
</html>