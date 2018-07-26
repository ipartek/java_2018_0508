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
		
		<div class="ahorcado fallo${fallos}"></div>	
		
		<span>Palabra Secreta: ${solucion}</span>
		<br/>
		<span>Intentos: ${intento}</span>
		
		<form action="jugarAhorcado" method="post">			
			<input name="letraUsuario" type="text" placeholder="Dime una letra">			
			<p class="text-danger">${msg}</p>
			
			<input type="submit" value="Enviar">
					
		</form>
		
		<a href="ahorcado?jdn=1">Jugar de Nuevo</a>
		
		
	</body>
</html>