<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container">
<div class="row">
	<div class="col">
		<div class="card">
		  	<div class="card-body">
		    	<h3 class="card-title text-center">${ videoInicio.nombre }</h3>              
		        	
		        	<form class="form-inline" action="comentar" method="post"> 
		        		<textarea  name="texto" placeholder="Comparte tu opinión..." class="pb-cmnt-textarea" required></textarea>
		            	<input type="hidden" name="idVideo" value="${ videoInicio.id }">
		            	<span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
		              	 4.0 stars
		                <input type="submit" class="btn btn-primary ml-auto" value="Publicar Comentario"></button>
		            </form>
		        	
		    </div> <!-- /. card-body -->
		</div>	<!-- /.card -->
	     
	     <div class="card card-outline-secondary my-4">
	            <div class="card-header">
	            	<p>${ fn:length( videoInicio.comentarios ) } comentarios para " ${ videoInicio.nombre } "</p>
	            </div>
	            
	            <div class="card-body">
	            	<!-- CARGAR LOS COMENTARIOS DEL VIDEO -->
	            	<c:forEach items="${ videoInicio.comentarios }" var="comentario"> 
	            	 	<p>${ comentario.texto }</p>
	              		<small class="text-muted">Posted by ${ comentario.usuario.nombre } on 
	              		<fmt:formatDate value="${ comentario.fecha }" pattern="dd/MM/yyyy HH:mm"/></small>
	              		<hr>
	            	</c:forEach>
	            </div>
	     
	     </div> <!-- /.card-outline -->
     
     </div>	<!-- /.col -->
     
</div>	<!-- /.row -->

</div>	<!-- /.container -->