<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-lg-8">
	<!-- Inicio Video -->
	<div class="card m-2">
		<div class="container">
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
		<div class="card-header bg-pika-red">
			<div class="row align-items-center">
				<div class="col-6">
					<h2>Comentarios</h2>
				</div>
				<div class="col-6 text-right">
					<a href=${(not empty usuario)?"#form-comentario":"#login"} class="btn btn-outline-dark btn-outline-pika">Escribe un comentario</a>
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
	</div>
	<!-- Fin Comentarios -->
</div>