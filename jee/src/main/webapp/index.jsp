<!doctype html>
<html lang="es">
<head>
	  <meta charset="utf-8">	
	  <title>Gestion Libros</title>
	  <meta name="description" content="App web java 3.0 para gestionar prestamos de libros">
	  <meta name="author" content="Andrea Perez">	
	  
	  <link rel="stylesheet" href="css/styles.css?v=1.0">
</head>

<body>

	<h1>CMS Prestamo libros </h1>	
		
	<%//esto es Java 
	out.print("<p>Soy Java</p>");
	%>
	
	<a href="listar">Listar libros</a>
	
	 <a href="saludo?nombre=pepe&ape1=Otilio&ape2=Gomez">saludo</a>  
	 
	
	<!-- 2 ejercicio DOPOST .....placeholder= para poner en los campos y dar pista al usuario de que lo que tiene que hacer-->
	<form action="saludo" method="post">
	
	
	<input name="nom" type="text" placeholder="Dime tu nombre">
	${msg}
	<input type="submit" value="Enviar" >
	<div id="txt"></div>
	</form>
	
  	<script src="js/scripts.js">
  	
  
  	
  	</script>
</body>
</html>