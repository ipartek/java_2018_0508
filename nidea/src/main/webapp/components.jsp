<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<div class="container">
		
		<div class="alert alert-info alert-dismissible fade show" role="alert">
			<p>Si quieres más detalles sobre componentes visita la <a href="https://getbootstrap.com/docs/4.1/components/alerts/" target="_blank">documentación oficial</a></p>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		
		<h1 class="text-primary">Componentes</h1>
		
		<section>
		
			<div class="row">
				<h2>Botones</h2>
				
				<div class="col">
					<button type="button" class="btn btn-primary">Botón</button>
					<p>Etiqueta <span class="badge badge-secondary">button</span></p>
				</div>
				
				<div class="col">
					<a class="btn btn-warning">Etiqueta</a>
					<p>Etiqueta <span class="badge badge-secondary">enlace o ancla</span></p>
				</div>

			</div>
		
		</section>
		
	</div>
	

<%@include file="includes/footer.jsp" %>