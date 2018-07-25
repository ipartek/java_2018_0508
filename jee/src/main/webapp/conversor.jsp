<!doctype html>

<html lang="es">
<head>
	<meta charset="utf-8">
	
	<title>Gestion_libros</title>
	<meta name="description" content="App Web Java 3.0 para gestionar prestamos libros">
	<meta name="author" content="Valeria Valencia">
	<link rel="stylesheet" href="css/styles.css">

</head>

<body>

	
	<form action="convertir" method="post">
	<div><input type="text" name="valor"></div>
	<div>
		<div><input type="radio" name="tipo" value="m"> Metros -> Pies</div>
		<div><input type="radio" name="tipo" value="p"> Pies -> metros</div>
	</div>
	<button type="submit">Convertir</button>
	</form>

	<p>${resultado}</p>

	
	
</body>
</html>