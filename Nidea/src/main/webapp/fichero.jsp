<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>


<main role="main" class="container"> 

	<div class="row">
		<div class="col">
			<h1>Subida de Ficheros</h1>	
		</div>
	</div>
	
	<div class="row justify-content-center">
		<div class="col-md-6">
			<form action="subida-fichero" method="post" enctype="multipart/form-data">
			
				<div class="form-group">
    				<label for="fichero">Example file input</label>
    				<input type="file" class="form-control-file" name="file">
  				</div>
			
				<input type="submit" value="Subir ficheros" class="btn btn-primary btn-block mt-3"></input>
				
			</form>
		</div>
	</div>
	<!-- END ROW -->
		
</main>

<%@include file="includes/footer.jsp"%>

