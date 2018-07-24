<!doctype html>

<html lang="es">
<head>
<meta charset="utf-8">

<title>Saludo</title>
<meta name="description"
	content="App Web 3.0 para gestionar prestamo de libros">
<meta name="author" content="Asier Cornejo">

<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>
	


	<h1>BIENVENIDO A MI PAGINA</h1>
	
	

	<a href="listar">Listar</a>
	<a href="saludo?nombre=Pakito&ap1=Chocolatero&ap2=Choco">Saludo</a>
	
	<form action="saludo" method="post">
		
		<input name="nombre" type="text" placeholder="Dime tu nombre">
		
		<!-- Mensaje si no se ha introducido ningun nombre. -->
		<p class="text-danger">${msg}</p>
		
		<input type="submit" value="Enviar">
	
	
	</form>



	<script src="js/scripts.js"></script>
</body>
</html>