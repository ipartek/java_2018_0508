<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="es">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Libro</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="css/styles.css">

<!-- Comienza todas las URLs desde el href indicado -->
<base href="${pageContext.request.contextPath }/">
</head>
<body>

	<form action="login" method="post">
		<div class="form-group">
			<label for="nombre">Nombre</label> 
			<input type="text" class="form-control" id="nombre" name="nombre" placeholder="" /> 
		</div>
		<div class="form-group">
			<label for="pass">Contraseña</label> 
			<input type="password" class="form-control" id="pass" name="pass" placeholder="" /> 
		</div>
		
		<button type="submit" class="btn btn-primary">Acceder</button>
	</form>

</body>
</html>