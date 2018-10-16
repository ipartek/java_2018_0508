<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-lg-8">
	<!-- Inicio Video -->
	<div class="card m-2">
		<div class="container pt-4 text-center">
			<c:if test="${not empty videoInicio}">
				<div id="video-placeholder"></div>
			</c:if>
			<c:if test="${empty videoInicio}">
				<div id="video-placeholder"></div>
			</c:if>
		</div>
		<div class="card-body">
			<h3 class="card-title">${videoInicio.nombre}</h3>
			<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic
			aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis
			molestias iure, ducimus!</p>
			<span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>4.0 stars
		</div>
	</div>
	<!-- Fin Video -->
	<!-- Inicio Comentarios -->
	<div class="card m-2">
		<div class="card-header bg-pika-purple">
			<div class="row align-items-center">
				<div class="col-6">
					<h2 class="text-pika">Comentarios</h2>
				</div>
				<div class="col-6 text-right">
					<a href=${(not empty usuario)?"#form-comentario":"login.jsp"} class="btn-main btn-outline-pika">Escribe un comentario</a>
				</div>
			</div>
		</div>
		<div class="card-body">
		<!-- Si hay comentarios los pinta -->
			<c:if test="${not empty comentarios}">
					<c:forEach items="${comentarios}" var="c">
						<div class="comentario">
							<p class="card-text">${c.texto}</p>
							<small class="text-pika-red">Escrito por ${c.usuario.nombre} -- ${c.fecha}</small>
						</div>
					</c:forEach>
			</c:if>
		<!-- Si no los hay, saca este texto -->
			<c:if test="${empty comentarios}">
				<h4 class="text-pika-red">Aun no hay ningun comentario...</h4>
			</c:if>
			<!-- Si el usuario esta logueado le deja escribir comentarios -->
			<c:if test="${not empty usuario}">
				<form id="form-comentario" action="comentario" method="post">
					<input type="hidden" value="${videoInicio.id}" name="id_video">
					<div class="form-group">
						<label for="comentario-usuario">Escribe tu comentario:</label>
						<textarea name="comentario-usuario" class="form-control" id="comentario-usuario" rows="3"></textarea>
					</div>
					<input type="submit" class="btn-main btn-outline-pika-blue btn-block mb-2" value="Enviar comentario">
				</form>
			</c:if>
		</div>
	</div>
	<!-- Fin Comentarios -->
</div>
<div id="modal-detalle" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-pika-blue">
				<h4 class="modal-title">Detalle del comentario</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<p id="texto_comentario"></p>
				<button type="button" class="btn-main btn-outline-pika-blue btn-block" data-dismiss="modal">Cerrar</button>
			</div>
			<div class="modal-footer bg-pika-blue"></div>
		</div>
	</div>
</div>