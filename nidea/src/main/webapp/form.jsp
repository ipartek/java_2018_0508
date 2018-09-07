<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<link rel="stylesheet" href="css/form.css">
	<link rel="stylesheet" href="css/styles.css">


<title>nidea</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<header>


				<div class="col-12">
					<p>
					<h1>HEADER</h1>
					</p>
					<p>12 columnas</p>
				</div>

			</header>

			<div class="row">
				<div class="col-3"></div>
				<div class="col-6 align-items-center">
					<h1>Formulario web</h1>
					<!--fieldset crea como una caja con borde-->
					<fieldset>
			<legend>Detalles de contacto</legend>
			<form action="&">
				
				<label for="nombre">Nombre:</label> 
		        <input type="text" autofocus placeholder="Escribe tu nombre" name="nombre" required="required" pattern="[a-zA-Z\s]{5,}"/>
		        <span class="invalid">*El nombre es requerido</span>

		        <label for="email">Email:</label>
		        <input type="email" name="email" required="required" placeholder="Introduce tu email"/>
		        <span class="invalid" > El campo email es requerido</span>

		        <label for="telefono">Telefono:</label>
		        <input type="tel" name="telefono" required="required" placeholder="Introduce tu telefono" pattern="[1-9]{9,}"/>
		        <span class="invalid" > El campo telefono es requerido</span>

		        <label for="pais">Pais:</label>
		        <input type="tel" name="pais" list="paises" placeholder="Introduce tu pais" "/>
		        <span class="invalid" > El campo pais es requerido</span>
		        <datalist id="paises">
		        	<option>España</option>
		        	<option>Francia</option>
		        </datalist>

		        <label for="edad">Edad:</label>
		        <input type="number" name="edad" min="18" max="65">

	         	<label for="nacimiento">Fecha de nacimiento:</label>
		        <input type="date" name="nacimiento" min="1900-01-01" max="3000-12-31"/>

		        <div>
		        	<input type="submit" value="Enviar" id="enviar"/>
		        </div>


			</form>
</fieldset>
				</div>
			</div>


			<!-- Optional JavaScript -->
			<!-- jQuery first, then Popper.js, then Bootstrap JS -->
			<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
				integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
				crossorigin="anonymous"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
				integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
				crossorigin="anonymous"></script>
			<script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
				integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
				crossorigin="anonymous"></script>
</body>
</html>
</div>


</body>
</html>