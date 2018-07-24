<!doctype html>

<html lang="es">
	<head>
	<meta charset="utf-8">
		<title>Gestion libros</title>
		<meta name="description" content="App web Java 3.0 para gestionar Prestamos de Libros">
		<meta name="author" content="Ainara Goitia">
		
		<link rel="stylesheet" href="css/styles.css?v=1.1">
	</head>
	
	<body>
		<h1>Saludo2</h1>

		<%
			//recibir Atributo en una JSP
			String nombre = (String)request.getAttribute("nombre");
			out.println("Nombre: " + nombre);
			
			String apellido = (String)request.getAttribute("apellido");
			out.println("Apellido: " + apellido);
		%>	
		
	</body>
</html>