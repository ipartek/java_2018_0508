<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conversor </title>
</head>
<body>

	<form action="conversor" method="post">
	<label>Metros</label>
		<input name="valor" type="text" placeholder="metros">
		<input type="submit" value="Convertir" />
		<input name="formulario" type="hidden" value="1">
		<br/>
		<span class="resultado">Pies: ${resultadoPies}</span>
		
	</form>
	
	<form action="conversor" method="post">
	<label>Pies</label>
		<input name="valor" type="text" placeholder="pies">
		<input type="submit" value="Convertir" />
		<input name="formulario" type="hidden" value="2">
		<br/>
		<span class="resultado">Metros: ${resultadoMetros}</span>
	
	</form>

	<p class="text-danger">${msg}</p>
</body>
</html>