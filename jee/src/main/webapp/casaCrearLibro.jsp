<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/styles.css?">
	</head>
	<body>
		<h1>Crear libro</h1>	
		<form action="libro" method="post">
			<label>ISBN:</label>
			<input name="isbnForm" type="text" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{5,20}$" required>
			<br/>
			<label>Titulo:</label>
			<input name="tituloForm" type="text" required>
			<br/>
			<label>Editorial:</label>
			<input name="editorialForm" type="text" required>
			<br/>
			<div required>
			<label>prestado:</label>
			<input name="prestadoForm" type="radio" value="si" required><label>Si</label>
			<input name="prestadoForm" type="radio" value="no" required><label>No</label>		
			</div>
			<input name="botonCrear" type="submit" value="Crear">
		</form>

	<p class="text-danger">${msg}</p>

	</body>
</html>