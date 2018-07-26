<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Crear libro</title>
	<link rel="stylesheet" href="css/styles.css?<%=System.currentTimeMillis()%>">
</head>
<body>

	<h1>Agregar libro</h1>
	
	<form action="login" method="post">
		<label for="titulo">Titulo:</label>
		<input type="text" name="titulo" required autofocus>
		<br/>	
		<label for="isbn">ISBN:</label>
		<input  type="text" name="isbn" required>		
		<br/>	
		<label for="editorial">Editorial:</label>
		<input  type="text" name="editorial" required>		
		<br/>	
		<label for="prestado">Prestado:</label>
		<label>Si</label>
		<input  type="radio" name="prestado" value="si" >
		<label>No</label>
		<input  type="radio" name="prestado" value="no" >		
		<br/>		
		<input type="submit" value="crear" />
	</form>

	<p class="text-danger">${msg}</p>
	
	
</body>
</html>