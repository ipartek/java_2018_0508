<!doctype html>
<%@page import="com.ipartek.formacion.gestor.libros.controller.ConversorController"%>
<html lang="es">
<head>
	<meta charset="utf-8">
		
	<title>Conversor metros-pies</title>
	<meta name="description" content="App Web Java 3.0 para gestionar préstamos de libros">
	<meta name="author" content="Adrian Garcia">
		
	<link rel="stylesheet" href="css/styles.css?v=1.0">
	
</head>
	
<body>

	<h1>Conversor metros-pies</h1>
	
	<div class="grid">
	
		<form class="formConversor" action="conversor" method="post">
			<fieldset>
				<legend>Metros:</legend>
				<input type="text" name="metros" placeholder="Metros" />
				<input type="hidden" name="form" value="<%=ConversorController.FORM1 %>" />
				<label>${piesCalculados} pies</label>
				<p class="text-danger">${msgNoNumeroMetros}</p>
				<p class="text-danger">${msgVacioMetros}</p>
				<input type="submit" value="Convertir" />
			</fieldset>
		</form>
		
		<form class="formConversor" action="conversor" method="post">
			<fieldset>
				<legend>Pies:</legend>
				<input type="text" name="pies" placeholder="Pies" />
				<input type="hidden" name="form" value="<%=ConversorController.FORM2 %>" />
				<label>${metrosCalculados} metros</label>
				<p class="text-danger">${msgNoNumeroPies}</p>
				<p class="text-danger">${msgVacioPies}</p>
				<input type="submit" value="Convertir" />
			</fieldset>
		</form>
	
	</div>
	
</body>
</html>