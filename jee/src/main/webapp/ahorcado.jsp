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

	<a href="index.jsp" class="btn btn-danger">Volver a casa</a>

	<h1>El Ahorcado</h1>
	<h2 class="center">Descubre la palabra</h2>
	
	<section id="tablero">
	
		<div id="juego">
		
			<%
		
			char[] huecos = (char[]) request.getAttribute("huecos");
		
			out.print("<p class='center'>");
			for(int i = 0; i<huecos.length;i++){
				out.print(" "+huecos[i]+" ");
			}
			out.print("</p>");
		
			%>
			
			<div class="ahorcado fallo<%= request.getAttribute("fallos") %>">
			</div>
			
			<!-- <img src="img/ahorcado.jpg" alt="Imagen del juego del ahorcado."> -->
			
			<br>
			
			<form class="center" action="ahorcado" method="POST">
				
				<input name="letra" type="text" placeholder="Dime una letra" maxlength="1">
				<input type="submit" value="Enviar">
				
			</form>
		
			<p>${msg}</p>
		
		</div>
		<div></div>
		
	</section>
	

	<script src="js/scripts.js"></script>
	
</body>

</html>