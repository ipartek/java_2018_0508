<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

  		
  	<main role="main" class="container">
      <div class="jumbotron">
        <h1>Ejemplos</h1>
        <p class="lead">Ejemplos con boostrap 4 y Java Enterprise Edition </p>
        
        
        <div class="row row-eq-height">
        	
        	<div class="col">
	        	<div class="card h-100">
				  <img class="card-img-top" src="https://csharpcorner-mindcrackerinc.netdna-ssl.com/article/bootstrap-grid-system/Images/1.png" alt="image Grid System">
				  <div class="card-body">
				    <h5 class="card-title text-uppercase">Grid System</h5>
				    <p class="card-text">Sistema rejilla de boostrap 4 basado 12 columnas y flexbox</p>				    
				  </div>
				  <div class="card-footer">
				  	<a href="grid.jsp" class="btn btn-outline-primary btn-block ">Ver Detalle</a>
				  </div>
				</div>
        	</div>
        	
        	<div class="col">
        	
	        	<div class="card h-100">	        	
				  <img class="card-img-top" src="http://www.boss-development.biz/sites/default/files/bootstrap-02.png" alt="image Componentes">				  
				  <div class="card-body">
				    <h5 class="card-title text-uppercase">Componentes</h5>
				    <p class="card-text">Componentes Reutilizables</p>				    
				  </div>				  
				  <div class="card-footer">
				  	<a href="components.jsp" class="btn btn-outline-primary btn-block">Ver Detalle</a>
				  </div>				  
				</div>
								
        	</div>
        	
        	
        	<div class="col">
	        	<div class="card  h-100">
				  <img class="card-img-top" src="https://www.classicgame.com/uploaded/thumb/arkanoid-mx300.jpg" alt="image juego arkanoid">
				  <div class="card-body">
				    <h5 class="card-title text-uppercase">Arkanoid</h5>
				    <p class="card-text">Juego de Arkanoid con Canva</p>				    
				  </div>
				  <div class="card-footer">
				  	<a href="arkanoid.jsp" class="btn btn-outline-primary btn-block ">Ver Detalle</a>
				  </div>
				</div>
        	</div>
        	
        	
        	<div class="col">
	        	<div class="card  h-100">
				  <img class="card-img-top" src="http://stacktips.com/wp-content/uploads/2016/06/Bootstrap-Horizontal-Form-Layout.png" alt="image formulario">
				  <div class="card-body">
				    <h5 class="card-title text-uppercase">Formulario</h5>
				    <p class="card-text">Formulario para enviar información al servidor</p>				    
				  </div>
				   <div class="card-footer">
				   	<a href="formulario" class="btn btn-outline-primary btn-block ">Ver Detalle</a>
				   </div>
				</div>
        	</div>
        	
        	
        	
        	
        </div>
        
      </div>
    </main>
  		
<%@include file="includes/footer.jsp" %>