<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../includes/header.jsp"%>

<%@include file="../includes/navbar.jsp"%>

<div class="container">
	<main role="main" class="container">
	
		<c:if test="${not empty param.msg}">
			<div class="alert alert-primary alert-dismissible fade show" role="alert">
			  ${param.msg}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		</c:if>
	
	    <h1 class="mt-2">Redactar nueva página</h1>
	
	    <form action="nuevapagina" method="post">
	
	        <div class="form-row">
	                
	            <div class="form-group col">
	                <label for="nom" class="required">Título:</label>
	                <input type="text" class="form-control" name="titulo" minlength="5" maxlength="20" required autofocus placeholder="De 5 a 20 caracteres" />
	            </div>
	                   
	        </div> <!-- /.form-row -->
	        
	        <div class="form-group">
	            <label for="desc">Contenido:</label>
	            <textarea id="desc" class="form-control" name="contenido" placeholder="Mínimo 25 caracteres" rows="15" required/></textarea>
	        </div>
	
	        <div class="form-group">
	            <input hidden="" type="text" class="form-control" name="nombreUsuario" value="${usuario.nombre}"/>
	        </div>
	
	        <button type="submit" class="btn btn-outline-primary btn-block">Enviar</button>
	
	    </form>
	    
	</main>
</div>

<%@include file="../includes/footer.jsp"%>