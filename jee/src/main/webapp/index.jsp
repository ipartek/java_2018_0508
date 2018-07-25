<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>Gestion Libros</title>
  <meta name="description" content="App Web Java 3.0 para gestionar prestamos de libros">
  <meta name="author" content="Rakel Pastor Villarroel">
  
  <link rel="stylesheet" href="css/styles.css?v=1.0">
</head>
<body>
	<h1>CMS GESTION LIBROS</h1>
	
	<nav>
	<!-- GET  -->
		<ul>
			<li><a href="listar">Listar Libros</a></li>
			<li><a href="saludo?nombre=Pepe&ape1=Otilio&ape2=Gomez">Saludo</a></li>
			<li><a href="JugandoConCss.jsp">Jugando con CSS</a></li>
			<li><a href="ahorcado.jsp">Jugar Al Ahorcado</a></li>
			<li><a href="conversor.jsp">Conversores</a></li>
		</ul>
	</nav>
	
	
	<%
	 out.print("<p>Mensaje desde Java</p>");
	%>
	<!-- SPRITE -->
	<div class="ahorcado"></div>
	<style>
		.ahorcado{
			border:1px solid red;
			width:75px;
			height: 100px;
			overflow: hiddden;
			background-image: url(img/ahorcado.jpg);
			background-position-x:616px;
		}
		.fallo0{background-position-x:616px;}
		.fallo1{background-position-x:539px;}
		.fallo2{background-position-x:462px;}
		.fallo3{background-position-x:462px;}
		.fallo4{background-position-x:462px;}
		.fallo5{background-position-x:462px;}
		.fallo6{background-position-x:462px;}
	</style>
	
	
	<p> - POST - </p>
	<form action="bienvenida" method="post">
		<input name="nombre" type="text" placeholder="Dime tu nombre">
		<p class="text-danger">${msg}</p>
		<input type="submit" value="enviar">
	</form>
	
	<!-- AHORCADO --><br><br>
	
	
	
  <script src="js/scripts.js"></script>
</body>
</html>