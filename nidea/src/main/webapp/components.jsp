<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
     <div class="container">
      
      	<div class="alert alert-warning alert-dismissible fade show" role="alert">
		  <p>Si quieres mas detalle sobre componentes visita la <a href="https://getbootstrap.com/docs/4.1/components/alerts/" target="blank">documentación oficial</a></p>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
      
        <h1 class="text-primary text-center border-bottom border-dark">Componentes</h1>
        
        <section>
        	<h2 class="text-success">Botones</h2>
        	<div class="row">
        		<div class="col offset-md-2">
        			<button type="button" class="btn btn-outline-primary">BUTTON</button>
        			<p>Etiqueta <strong>Button</strong> </p>
        		</div>
        		<div class="col">
        			<a class="btn btn-primary disabled">ENLACE</a>
        			<p>Etiqueta <strong>Enlace o Ancla</strong> </p>
        		</div>
        	</div>
        </section>
        
        <section>
        	<h2 class="text-success">Card</h2>
        	<div class="row">
        		<div class="col-3">
        			<div class="card shadow p-3 mb-5 bg-white rounded h-100" style="width: 18rem;">
					  <img class="card-img-top" src="http://cdn.alleywatch.com/wp-content/uploads/2013/05/grid.png" alt="Grid image">
					  <div class="card-body">
					    <h5 class="card-title text-uppercase">grid system</h5>
					    <p class="card-text">Sistema de rejilla de bootstrap 4 basado 12 columnas y flexbox</p>
					  </div>
					  <div class="card-footer">
					    	<a href="grid.jsp" class="btn btn-outline-dark btn-block">Ver ejemplo</a>
					  </div>
					</div>
        		</div>
        		<div class="col-3">
        			<div class="card shadow p-3 mb-5 bg-white rounded h-100" style="width: 18rem;">
					  <img class="card-img-top" src="https://camo.githubusercontent.com/8f5c20ae4a9015743cdc49ddbded8d0c399db99c/687474703a2f2f64657369676e73686f636b2e636f6d2f696d616765732f626f6f7473747261702f6c61796572732e6a7067" alt="Grid image">
					  <div class="card-body">
					    <h5 class="card-title text-uppercase">componentes</h5>
					    <p class="card-text">Componentes reutilizables</p>
					  </div>
					  <div class="card-footer">
					    	<a href="components.jsp" class="btn btn-outline-dark btn-block">Ver ejemplo</a>
					  </div>
					</div>
        		</div>
        		<div class="col-3">
        			<div class="card shadow p-3 mb-5 bg-white rounded h-100" style="width: 18rem;">
					  <img class="card-img-top" src="http://www.elmundodelspectrum.com/pix/201808/arkanoid-4345-zoom.gif" alt="Arkanoid image">
					  <div class="card-body">
					    <h5 class="card-title text-uppercase">arkanoid</h5>
					    <p class="card-text">Juego de Arknaoid con canva</p>
					  </div>
					  <div class="card-footer">
					    	<a href="arkanoid.jsp" class="btn btn-outline-dark btn-block">Ver ejemplo</a>
					  </div>
					</div>
        		</div>
        		<div class="col-3">
        			<div class="card shadow p-3 mb-5 bg-white rounded h-100" style="width: 18rem;">
					  <img class="card-img-top" src="https://obedalvarado.pw/blog/wp-content/uploads/2018/02/contact-form-php.png" alt="Grid image">
					  <div class="card-body">
					    <h5 class="card-title text-uppercase">formularios</h5>
					    <p class="card-text">Formularios para enviar información al servidor</p>
					  </div>
					  <div class="card-footer">
					    	<a href="formularios.jsp" class="btn btn-outline-dark btn-block">Ver ejemplo</a>
					  	</div>
					</div>
        		</div>
        	</div>
        </section>
        
     </div>
<%@include file="includes/footer.jsp" %>