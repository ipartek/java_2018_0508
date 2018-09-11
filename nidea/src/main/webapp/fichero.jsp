<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<main class="container" role="main">
	
		<h1><i class="fas fa-file-alt"></i> Formulario para subir ficheros</h1>
		
		<div class="row justify-content-center">
			<div class="col col-md-6">
			
				<!-- Formulario para subir ficheros -->
				<form action="subida-fichero" method="post" enctype="multipart/form-data">
				
					<div class="custom-file mb-3 mt-3">
						<input type="file" id="fichero" name="fichero" class="custom-file-input" />
						<label class="custom-file-label" for="fichero">Selecciona fichero</label>
					</div>
				
					<input type="submit" value="Subir" class="btn btn-outline-primary btn-block" />
				
				</form>
			
			</div>
		</div>
	
	</main>

<%@include file="includes/footer.jsp" %>