<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<main role="main" class="container">
      <div class="jumbotron">
        <h1>Ejemplos</h1>
        <p class="lead">Ejemplos con Bootstrap 4 y Java Enterprise Edition</p>
      
      <div class="row">
      	<div class="col">
      	   <div class="card text-center h-100">
				<img class="card-img-top" src="images/grid.png">
		  		<div class="card-body">
			    	<h5 class="card-title text-uppercase">grid system</h5>
			    	<p class="card-text">Ejemplo del sistema Grid basado en 12 columnas.</p>
			    </div>
			    <div class="card-footer">
			    	<a href="grid.jsp" class="btn btn-outline-primary btn-lg btn-block">Ver ejemplo</a>
			    </div>
			</div>
      	</div>
      	<div class="col">
	      	<div class="card text-center h-100">
				<img class="card-img-top" src="images/componentes.png">
			  	<div class="card-body">
			    	<h5 class="card-title text-uppercase">componentes</h5>
			    	<p class="card-text">Ejemplos varios de los componentes de Bootstrap</p>
			    </div>
			    <div class="card-footer">
			    	<a href="componentes.jsp" class="btn btn-outline-primary btn-lg btn-block">Ver ejemplo</a>
			  	</div>
			</div>
      	</div>
      	<div class="col">
	      	<div class="card text-center h-100">
				<img class="card-img-top" src="images/formulario.png">
			  	<div class="card-body">
			    	<h5 class="card-title text-uppercase">formularios</h5>
			    	<p class="card-text">Ejemplos de formularios.</p>
			    </div>
			    	<div class="card-footer">
			    	<a href="formulario" class="btn btn-outline-primary btn-lg btn-block">Ver ejemplo</a>
			  	</div>
			</div>
      	</div>
      	<div class="col">
	      	<div class="card text-center h-100">
				<img class="card-img-top" src="images/arcade.png">
			  	<div class="card-body">
			    	<h5 class="card-title text-uppercase">juego arcade</h5>
			    	<p class="card-text">Juego arcanoid de bloques sencillo.</p>
			    </div>
			    	<div class="card-footer">
			    	<a href="arkanoid.jsp" class="btn btn-outline-primary btn-lg btn-block">Ver ejemplo</a>
			  	</div>
			</div>
      	</div>
      	</div>
     </div>
	
</main> 
    	
<%@include file="includes/footer.jsp" %>
