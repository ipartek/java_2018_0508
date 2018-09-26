<!-- Page codification -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Cabecera -->
<%@ include file="/include/header.jsp" %>

<!-- Navegador -->
<%@ include file="/include/navbar.jsp" %>

<main class="container mt-5" role="main">

	<!-- Gestión de alertas -->
	<c:if test="${not empty sessionScope.alert}">
		<div class="row align-middle">
	        <div class="col color-primary">	
				<%@include file="../include/alert.jsp" %>
			</div>
		</div>
	</c:if>
	
	<section>
		
		<div class="row mt-2">
		
		<!-- AVANZAR PÁGINA CON INPUT -->
		<nav>
			<div class="col">		
				<form action="inicio">
					<div class="form-group row">
					    
						<label for="numPagina" class="col-form-label">Avanzar a la Página</label>
					    
					    <div class="col-xs-2">
					      <input type="number" class="form-control ml-2" name="numPagina" value="${pagActual.id+1 }">
					    </div>
					    
					    <button type="submit" class="btn btn-primary ml-2">Ir</button>
					</div>		  
				</form>	
				
			</div> <!-- / .col -->	
		</nav>		
					
		</div>	<!-- / .row -->	
		
		<!-- AVANZAR PÁGINA CON FLECHAS -->
		<nav>
			<div class="row">
				<div class="col d-flex justify-content-center">
					<span><a type="button" class="btn btn-info" href="inicio?op=prev"><i class="fas fa-backward"></i></a></span>
					<span><a type="button" class="btn btn-info" href="inicio?op=next"><i class="fas fa-forward"></i></a></span>	
				</div>	
			</div>
		</nav>
		
		<div class="row justify-content-center">
			<div class="col">
			
				<div class="card">
				
				  <div class="card-header">
				  	<h1 class="h1 text-center">${pagActual.titulo}</h1>
				   	<h4 class="h4 text-right">${pagActual.id+1 } de ${numPaginas} Páginas</h4>
				  </div>
				  
				  <div class="card-body">
				    <blockquote class="blockquote mb-0">
				      <p class="text-justify">${pagActual.contenido}</p>
				      <footer class="blockquote-footer">Publicado por <cite title="Source Title"">${pagActual.autor}</cite></footer>
				    </blockquote>
				  </div>
				</div> <!-- / .card -->	
					
			</div>	<!-- / .col -->			
		</div>	<!-- / .row -->	
		
		<!-- AVANZAR PÁGINA CON FLECHAS -->
		<nav>
			<div class="row">
				<div class="col d-flex justify-content-center">
					<span><a type="button" class="btn btn-info" href="inicio?op=prev"><i class="fas fa-backward"></i></a></span>
					<span><a type="button" class="btn btn-info" href="inicio?op=next"><i class="fas fa-forward"></i></a></span>	
				</div>	
			</div>
		</nav>
		
	</section>	
	
</main>

	<!-- Pie de Página -->
	<div class="row align-center fixed-bottom">
		<div class="col-md-12 color-primary">
			<%@ include file="/include/footer.jsp" %>
		</div>
	</div>