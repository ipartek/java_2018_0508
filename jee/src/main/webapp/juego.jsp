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
	<div id="juego">
		<div id="ahorcado" class="${fail}"></div>	
		<form action="juego" method="post">
			<div class="container">
				<%
					if(!(boolean)request.getAttribute("finalizado") ){
				%>
					<p><b>${respuesta}</b></p>		
					<label for="Letra"><b>Introduce una letra</b></label>
					<input type="text" placeholder="letra" name="letra" maxlength="1" autocomplete="off" ${ finalizado ? 'disabled' : 'autofocus' }>
					<p id="msg">${msg}</p>
					<button type="submit">Try!</button>
				<%
					}else{
				%>
					<p id="msg">${msg}</p>
					<a href="juego">Nuevo juego</a>
				<%
					}
				%>
			</div>
		</form>
		
		
	</div>
</body>
</html>