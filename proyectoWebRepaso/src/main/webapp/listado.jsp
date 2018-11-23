<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listado Videojuegos</title>
	</head>
	<body>
		<c:if test="${not empty juego }">
			<h2>Videojuego ${juego.titulo} Creado !!!</h2>
			<br>
			Id: ${juego.id }
			<br>
			Titulo: ${juego.titulo}
			<br>
			Fecha lanzamiento: ${juego.fechaLanzamiento}
		</c:if>
	
		<c:if test="${ empty juegos }">
			<h2>Lo sentimospero no tenemos juegos todavia</h2>
			
		</c:if>
			<c:forEach items="${juegos}" var="j">
	
					<ul>
						<li>${j.id}</li>
						<li>${j.titulo}</li>
						<li>${j.fechaLanzamiento}</li>
					</ul>
	
			</c:forEach>
		
	</body>
</html>