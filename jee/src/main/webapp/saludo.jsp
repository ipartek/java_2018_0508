<!doctype html>

<html lang="es">
	<head>
	<meta charset="utf-8">
		<title>Gestion libros</title>
		<meta name="description" content="App web Java 3.0 para gestionar Prestamos de Libros">
		<meta name="author" content="Alain Muñoz Arrizabalaga">
		
		<link rel="stylesheet" href="css/styles.css?v=1.1">
	</head>
	
	<body>
		<h1>Saludos</h1>

		<%
			//recibir Atributo en una JSP con GET
			String nombreCompleto = (String)request.getAttribute("nombreCompleto");
			out.println(nombreCompleto);
			
		%>	
		
		<hr>
		<!-- Expression Language -->
		<b>${nombreCompleto}</b>
		
		<hr>
		
		<%=request.getAttribute("nombreCompleto") %>	

	</body>
</html>