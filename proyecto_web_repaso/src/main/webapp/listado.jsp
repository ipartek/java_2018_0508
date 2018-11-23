<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<title>Listado de videojuegos</title>
	</head>
	<body>
		<main role="main" class="container">
			<c:if test="${not empty juego}">
				<h2>Video juego creado:</h2>
				<p>Id: ${juego.id}</p>
				<p>Titulo: ${juego.titulo}</p>
				<p>Fecha de lanzamiento: ${juego.fechaLanzamiento}</p>
			</c:if>
		
			<c:if test="${not empty juegos}">
			
				<h2>Listado de juegos disponibles:</h2>
				
				<c:forEach items="${juegos}" var="j">
					<p>Id: ${j.id}</p>
					<p>Titulo: ${j.titulo}</p>
					<p>Fecha de lanzamiento: ${j.fechaLanzamiento}</p>		
					<hr>		
				</c:forEach>
			
			</c:if>
			
			<c:if test="${empty juegos}">
			
				<h2 class="text-warning">Aun no disponemos de juegos en nuestra base de datos</h2>
			
			</c:if>
		</main>
		
	</body>
</html>