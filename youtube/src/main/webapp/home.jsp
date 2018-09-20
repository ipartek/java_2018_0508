<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="com.ipartek.formacion.youtube.pojo.Comentario"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Alert"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Video"%>
<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>

<%@ include file="includes/navbar.jsp" %>

<!-- Contenido -->
<main class="container" role="main">

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
		<ul class="navbar-nav m-3 align-items-left">
			<li class="nav-item active">
				<h2 class="text-secondary">Añade una nueva cancion:</h2>
				<!-- Formulario para dar de alta un nuevo video -->
				<form action="inicio" method="post" class="form-inline">
					<input name="id" class="form-control m-1" type="text" placeholder="ID 11 caracerteres" title="11 caracteres"
					 required pattern=".{11,11}">
					<input name="nombre" class="form-control m-1" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
					<button class="btn btn-outline-info m-1" type="submit">Añadir</button>
				</form>
			</li>
		</ul>
	</c:if>

	<h1 class="text-center text-success">Youtube Java Edition</h1>
	<div class="row pt-4">
		<div class="col-lg-4">
			<section>
				<h1 class="text-primary">Lista Reproduccion</h1>
				<ul class="list-group">
					<c:if test="${not empty videos}">
						<c:forEach items="${videos}" var="v">
							<li class="list-group-item d-flex justify-content-between align-items-center">
							<a href="inicio?id=${v.id}">${v.nombre}</a>
							<a href="inicio?id=${v.id}&op=${HomeController.OP_ELIMINAR}"><i class="fas fa-trash-alt text-danger"></i></a>
						</li>
						</c:forEach>
					</c:if>
				</ul>
			</section>
			<section>
				<h2 class="text-secondary">Lista del Usuario</h2>
				<c:if test="${not empty usuario}">
					<ul class="list-group">
						<c:if test="${not empty videosUsuario}">
							<c:forEach items="${videosUsuario}" var="vu">
								<li class="list-group-item d-flex justify-content-between align-items-center">
									<a href="inicio?id=${vu.id}">${vu.nombre}</a>
								</li>
							</c:forEach>
							
						</c:if>
					</ul>
				</c:if>
				<c:if test="${empty usuario}">
					<a href="#">Accede con tu usuario</a>
				</c:if>
			</section>
		</div>
		<div class="col-lg-8">

			<div class="card">
				<div class="container">
					<c:if test="${not empty videoInicio}">
						<iframe id="iframe" src="https://www.youtube.com/embed/${videoInicio.id}?autoplay=0" frameborder="0" allow="autoplay; encrypted-media"
						 allowfullscreen></iframe>
					</c:if>
					<c:if test="${empty videoInicio}">
						<iframe id="iframe" src="https://www.youtube.com/embed/${videoInicio.id}?autoplay=0" frameborder="0" allow="autoplay; encrypted-media"
						 allowfullscreen></iframe>
					</c:if>
				</div>
				<div class="card-body">
					<h3 class="card-title">${videoInicio.nombre}</h3>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic
						aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis
						molestias iure, ducimus!</p>
					<span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
					4.0 stars
				</div>
			</div><!-- /.card -->

			<div class="card card-outline-secondary m-2">
				<div class="card-header bg-primary">
					<div class="row align-items-center">
						<div class="col-6">
							<h2>Comentarios</h2>
						</div>
						<div class="col-6 text-right">
							<a href="#form-comentario" class="btn btn-outline-dark">Escribe un comentario</a>
						</div>
					</div>
				</div>
				<div class="card-body">
					<!-- Si hay comentarios los pinta -->
					<c:if test="${not empty comentario}">
						<ul class="group-list">
						<c:forEach items="${comentario}" var="c">
							<li class="list-group-item">
								<p class="card-text">${c.texto}</p>
								<small class="text-muted">Escrito por ${c.autor}</small>
							</li>
						</c:forEach>
						</ul>
					</c:if>
					<!-- Si no los hay, saca este texto -->
					<c:if test="${empty comentario}">
						<h4 class="text-danger">Aun no hay ningun comentario...</h4>
					</c:if>
					<!-- Si el usuario esta logueado le deja escribir comentarios -->
					<c:if test="${not empty usuario}">
						<form id="form-comentario" action="comentario" method="post">
							<div class="form-group">
								<label for="comentario-usuario">Escribe tu comentario:</label>
								<textarea name="comentario-usuario" class="form-control" id="comentario-usuario" rows="3"></textarea>
							</div>
							<input type="submit" class="btn btn-outline-success mb-2" value="Enviar comentario">
						</form>
					</c:if>
				</div>
			</div><!-- /.card -->
		</div>
	</div>
	<!-- /row -->
</main>
<!-- /.container -->

<!-- Footer -->
<footer class="bg-dark p-3">
	<p class="text-center text-white">Copyright &copy; Adrian Perozzo</p>
</footer>

<%@ include file="includes/footer.jsp" %>