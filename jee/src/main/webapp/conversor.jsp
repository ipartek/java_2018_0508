<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>Gestion Libros</title>
	<meta name="description" content="App web Javaa 3.0 paragestionar prestamos de libros">
	<meta name="author" content="SitePoint">
	
	<link rel="stylesheet" href="css/styles.css?v=1.0">
</head>
<body>

	<div class="conversor">
		<form id="conversor_pies" action="conversor" method="post">
			<label for="Metros"><b>Metros:</b></label> 
			<input type="number" placeholder="Introduce metros" name="value" value="${value1}">
			<input type="hidden" name="formulario" value ="1">
			<span>${pies} pies</span>
			<button type="submit">Convert</button>
			<p id="msg">${msg1}</p>
			
		</form>
	</div>
	<div  class="conversor">
		<form id="conversor_metros" action="conversor" method="post">
			<label for="Pies"><b>Pies:  </b></label> 
			<input type="number" placeholder="Introduce pies" name="value" value="${value2}">
			<input type="hidden" name="formulario" value ="2">
			<span>${metros} metros</span>
			<button type="submit">Convert</button>
			<p id="msg">${msg2}</p>
			
		</form>
	</div>

</body>
</html>