<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<main class="container" role="main">

<h1><i class="far fa-file-alt"></i>Formulario para subir ficheros</h1>

<div class="row justify-content-center">
	<div clarr="col col-md-6">
	
	<form action="subida-fichero" method="post" enctype="multipart/form-data" >
	
	<input type="submit" value="Subir Ficheros" class="btn btn-outline-primary btn-block">
	
	<div class="custom-file mb-3 mt-10">
 	 <input type="file"  id="fichero" name="fichero">
  	<label class="custom-file-label" for="fichero">Selecciona Fichero</label>
	</div>
	
	</form>
	
	
	
	</div>




</div>



</main>







<%@include file="includes/footer.jsp" %><%@include file="includes/footer.jsp" %>