<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listado de videojuegos</title>
	</head>
	<body>
	
		<c:if test="${not empty juego}">
			<h2>Video juego creado:</h2>
			<p>Id: ${juego.id}</p>
			<p>Titulo: ${juego.titulo}</p>
			<p>Fecha de lanzamiento: ${juego.fechaLanzamiento}</p>
		</c:if>
	
		
		
	</body>
</html>