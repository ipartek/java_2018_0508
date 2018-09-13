
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- El detalle con un card -->
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<main class="container" role="main">

	<h1> <i class="fas fa-file"></i>

	Formulario para subir ficheros</h1>
	<div class="row justify-content-center	">
		<div class="col-md-6">
			<form action="subida-fichero" method="post" enctype="multipart/form-data">
				<div class="custom-file mb-3 mt-3">
				  <input type="file" class="custom-file-input" id="customFile">
				  <label class="custom-file-label" for="customFile">Choose file</label>
				  <input type="button" class="custom-file-input" >
				  <a href="subida-fichero" value="subir" class="btn btn-primary btn-block">Subir</a>
		</div>
			
			
			</form>
		</div>
		
	</div>
</main>