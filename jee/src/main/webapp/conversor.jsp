<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Conversor </title>
	<link rel="stylesheet" href="css/styles.css?">
</head>
<body>

	<h1>CONVERSOR METROS TO PIES</h1>
	<form action="conversor" method="post">
		<label>Metros</label>
		<input name="valor" type="text" placeholder="metros">
		<input type="submit" value="Convertir" />
		<input name="formulario" type="hidden" value="1">
		<br/>
		<span class="resultado"> ${resultadoPies}</span>
		
	</form>
	
	<form action="conversor" method="post">
		<label>Pies </label>
		<input name="valor" type="text" placeholder="pies">
		<input type="submit" value="Convertir" />
		<input name="formulario" type="hidden" value="2">
		<br/>
		<span class="resultado"> ${resultadoMetros}</span>
	
	</form>

	<p class="text-danger">${msg}</p>
</body>
</html>