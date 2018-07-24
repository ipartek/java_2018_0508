<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Gestion Libros</title>
<meta name="description"
	content="App web Javaa 3.0 paragestionar prestamos de libros">
<meta name="author" content="SitePoint">

<link rel="stylesheet" href="css/styles.css?v=2.0">

</head>
<body>
	<h1>CMS Prestamos de libros</h1>

	<div id="content">
		<h3>Opciones</h3>
		<div id="opciones">	
			<ul>
				<li><a href="listar">Listar Libros</a></li>
				<li><a href="saludo?nombre=pepe&ap1=Otilio&ap2=Gomez">Saludo</a></li>
			</ul>
		</div>

		<form action="saludo" method="post">
			<div class="container">
				<label for="Nombre"><b>Username*</b></label> 
				<input type="text" placeholder="Dime tu nombre" name="nombre">
				<p id="msg">${mensaje}</p>
	
				<button type="submit">Login</button>
			</div>
		</form>
	</div>
	<script src="js/scripts.js"></script>
	<script src="js/jquery.js"></script>

</body>
</html>