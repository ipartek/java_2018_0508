
  <%@include file="includes/header.jsp" %>
  <%@include file="includes/navbar.jsp" %>
  
   <div role="main" class="container">
    <div class="alert alert-info alert-dismissible fade show" role="alert">
	 	<p>Si quieres más detalles sobre componentes visita la <a href="https://getbootstrap.com/docs/4.1/components/alerts/" target="_blank" >documentación oficial</a></p>
	  	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
  		</button>
	</div>
        <h1 class="text-primary">Componentes</h1>
       	<section>
       		<h2>Botones</h2>
       		
       		
       		<div class="row ">
       			<div class="col h-100 d-inline-block">
       				<button type="button" class="btn btn-primary">Button</button>
       				<p>Etiqueta <strong>Button</strong></p>
       			</div>
       			<div class="col">
       				<a class="btn btn-primary">Enlace o ancla</a>
       				<p>Etiqueta <strong>enlace o ancla</strong></p>
       			</div>
       		</div>
       		
       		
       		
       		
       			<div class="card-deck">
       		
       				<div class="card-deck">
						    <div class="card" style="width: 18rem;">
								  <img class="card-img-top" src="images/grid.png" alt="Imagen ejemplo grid bootstrap">
								  <div class="card-body">
									    <h5 class="card-title text-uppercase">grid system</h5>
									    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>   
								  </div>
								  
								  <div class="card-footer">
								  		<a href="https://getbootstrap.com/docs/4.1/layout/grid/" class="btn btn-outline-primary btn-lg btn-block">Ver detalles</a>
								  </div>
							</div>
						    
						    
						    <div class="card" style="width: 18rem;">
								  <img class="card-img-top" src="images/components.png" alt="Imagen componentes bootstrap">
								  <div class="card-body">
									    <h5 class="card-title text-uppercase">componentes de bootstrap</h5>
									    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>   
								  </div>
								  
								  <div class="card-footer">
								  		<a href="https://getbootstrap.com/docs/4.1/components/alerts/" class="btn btn-outline-primary btn-lg btn-block">Ver detalles</a>
								  </div>
							</div>
							
						    
						    <div class="card" style="width: 18rem;">
								  <img class="card-img-top" src="images/arkanoid.png" alt="Imagen componentes bootstrap">
								  <div class="card-body">
									    <h5 class="card-title text-uppercase">arkanoid</h5>
									    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>   
								  </div>
								  
								  <div class="card-footer">
								  		<a href="arkanoid.jsp" class="btn btn-outline-primary btn-lg btn-block">Jugar</a>
								  </div>
							</div>
							
						    
						    <div class="card" style="width: 18rem;">
								  <img class="card-img-top" src="images/form.png" alt="Imagen componentes bootstrap">
								  <div class="card-body">
									    <h5 class="card-title text-uppercase">formularios</h5>
									    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>   
								  </div>
								  
								  <div class="card-footer">
								  		<a href="formulario" class="btn btn-outline-primary btn-lg btn-block">Ver detalles</a>
								  </div>
							</div>
						     
					 </div>
				</div>
	       			
       		
       		

       	</section>
        
      </div>
   
  <%@ include file="includes/footer.jsp" %>