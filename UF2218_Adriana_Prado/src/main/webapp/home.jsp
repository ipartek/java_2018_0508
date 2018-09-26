<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main class="container" role="main">

	<c:if test="${not empty param.msg}">
		<div class="alert alert-primary alert-dismissible fade show" role="alert">
		  ${param.msg}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	</c:if>
	
	<form action="pagina" method="post">
		<div class="input-group mt-2 mb-2">
			<div class="input-group-prepend">
		    	<button type="submit" class="btn btn-outline-secondary" id="button-addon1">Ir a página</button>
		  	</div>
		  <input type="number" name="buscarPagina" step="1" class="form-control" placeholder="Acceder a página..." aria-label="Example text with button addon" aria-describedby="button-addon1">
		</div>
	</form>

 	<h1 class="mt-2">${pagina.titulo}</h1>
 	
 	<c:if test="${pagina.id > 0}">
 	
	 	<p>
	 		${pagina.contenido}
	 	</p>
 	
 	</c:if>
	
</main> 

 	<footer class="">
	 	<hr>
	 	
		 <div class="row justify-content-end m-0 mb-2">
		 	<span>Escrito por: ${pagina.nombreUsuario}</span> 
		 </div>
		
		<c:if test="${pagina.id > 0}"> 
			 <div class="row justify-content-center">
			 	<p>Página ${pagina.id} de ${totalPaginas - 1}</p>
			 </div>
		 </c:if>
		 
	 	<div class="row justify-content-${(pagina.id <= 0)?'end':'between'} m-0">
	 		<c:if test="${pagina.id > 0}">
	 			<a class="btn btn-dark" href="pagina?id=${pagina.id-1}" role="button">Anterior</a>
	 		</c:if>
	 		
	 		<c:if test="${!esUltimo}">
	 			<a class="btn btn-dark justify-content-end" href="pagina?id=${pagina.id+1}" role="button">Siguiente</a>
	 		</c:if>
	 	</div>
 	</footer>

<%@include file="includes/footer.jsp"%>