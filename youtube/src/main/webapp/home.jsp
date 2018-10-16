<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>

<%@ include file="includes/navbar.jsp" %>

<!-- Contenido -->
<main class="container" role="main">
	<%@ include file="includes/ventanasModales.jsp" %>
	<!-- Tratamiento de las alertas -->
	<c:if test="${not empty alert}">
		<div class="container">
			<div class="alert alert-${alert.tipo} alert-dismissible fade show" role="alert">
				<strong>${alert.texto}</strong>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>
	<!-- Formulario de añadir video, solo cuando el usuario este logueado -->
	<c:if test="${not empty usuario}">
		<ul class="navbar-nav m-3 p-3 align-items-left bg-pika">
			<li class="nav-item">
				<h2 class="text-pika-blue">Añade una nueva cancion:</h2>
				<!-- Formulario para dar de alta un nuevo video -->
				<form action="inicio" method="post" class="form-inline">
					<input type="hidden" value="${usuario.id}" name="id_usuario">
					<input name="codigo" class="form-control m-1" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
					<input name="nombre" class="form-control m-1" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
					<button class="btn-main btn-outline-pika-blue m-1" type="submit">Añadir</button>
				</form>
			</li>
		</ul>
	</c:if>

	<div class="row pt-4">
		<%@ include file="includes/listadosVideos.jsp" %>
		<%@ include file="includes/videoActual.jsp" %>
	</div>
	<!-- /row -->
</main>
<!-- /.container -->

<%@ include file="includes/footer.jsp" %>