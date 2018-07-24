<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Gestion Libros</title>
	<meta name="description" content="App web Javaa 3.0 paragestionar prestamos de libros">
	<meta name="author" content="SitePoint">
	<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div>
		<div id="ahorcado" class="${fail}"></div>		
		<form id="juego" action="juego" method="post">
			<div class="container">
				<p><b>${respuesta}</b></p>				
				<label for="Letra"><b>Introduce una letra</b></label> 
				<input type="text" placeholder="letra" name="letra">
				<p id="msg">${resultado}</p>
	
				<button type="submit">Try!</button>
			</div>
		</form>
	</div>
</body>
</html>