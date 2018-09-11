  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@include file="includes/header.jsp" %>
  <%@include file="includes/navbar.jsp" %>
  
  <main class="container" role="main">
  
  	<h1><i class="fas fa-file"></i>Subir ficheros</h1>
  	<div class="row justify-content-center">
  		<div class="col col-md-6">
  			<form action="subida-fichero" method="post"  enctype="multipart/form-data" >
  				<div class="custom-file mb-3 mt-3">
				  <input type="file"  id="fichero" class="custom-file-input">
				  <label class="custom-file-label" for="fichero">Selecciona fichero</label>
				</div>
  				<button type="submit" class="btn btn-outline-primary btn-lg btn-block">Subir Fichero</button>
  			
  			</form>
  		
  		</div>
  	
  	
  	</div>
  	
  	
  </main>
  
  
  
   <%@ include file="includes/footer.jsp" %>