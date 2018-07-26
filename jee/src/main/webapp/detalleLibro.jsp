<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>Detalle Libro</title>
  <meta name="description" content="App Web Java 3.0 para gestionar prestamos de libros">
  <meta name="author" content="Rakel Pastor Villarroel">
  
  <link rel="stylesheet" href="css/styles.css?v=1.0">
</head>

<body>

	<h1>Detalles Libro</h1>
	
	<h4>Titulo: <%=request.getAttribute("titulo")%></h4>
	<h4>Editorial: <%=request.getAttribute("editorial")%></h4>
	<h4>ISBN: <%=request.getAttribute("isbn")%></h4>
</body>
</html>