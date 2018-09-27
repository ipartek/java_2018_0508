<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main class="container" role="main">

	<%@include file="includes/alert.jsp"%>
	
	<%@include file="includes/buscarPagina.jsp"%>

	<div class="jumbotron">
		<h1 class="display-4">El Señor de los Anillos</h1>
		<h2 class="mt-2">${pagina.titulo}</h2>
		<p class="lead">«Tres Anillos para los Reyes Elfos bajo el cielo.
			Siete para los Señores Enanos en palacios de piedra.
			Nueve para los Hombres Mortales condenados a morir.
			Uno para el Señor Oscuro, sobre el trono oscuro
			en la Tierra de Mordor donde se extienden las Sombras.
			Un Anillo para gobernarlos a todos. Un Anillo para encontrarlos,
			un Anillo para atraerlos a todos y atarlos en las tinieblas
			en la Tierra de Mordor donde se extienden las Sombras».
		</p>
	 </div>
	
</main> 

<%@include file="includes/navPaginas.jsp"%>

<%@include file="includes/footer.jsp"%>