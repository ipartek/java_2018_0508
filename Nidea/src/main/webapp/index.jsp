<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

 <main role="main" class="container">
      <div class="jumbotron">
        <h1>Ejemplos</h1>
        <p class="lead">Ejemplos con Bootstrap 4 y Java Enterprise Edition</p>
       </div>
       
       <!-- Card Deck -->
       <div class="card-deck">
       
       <!-- Card 1 -->
	       <div class="card justify-content-center" style="width: 18rem;">
			  <img class="card-img-top" src="https://i.stack.imgur.com/Cp970.png" alt="Imagen de ejemplo">
			  <div class="card-body">
			    <h5 class="card-title text-uppercase text-center">grid system</h5>
			    <p class="card-text text-center">Sistema de rejillas que usa Bootstrap con 12 columnas.</p>
			    </div>
			  <div class="card-footer">
    			 <a href="grid.jsp" class="btn btn-outline-primary btn-lg btn-block" role="button">Ver Detalle</a>
    		  </div>
			</div>
			<!-- /Card 1 -->
		
		<!-- Card 2 -->
		<div class="card justify-content-center" style="width: 18rem;">
		  <img class="card-img-top" src="https://camo.githubusercontent.com/8f5c20ae4a9015743cdc49ddbded8d0c399db99c/687474703a2f2f64657369676e73686f636b2e636f6d2f696d616765732f626f6f7473747261702f6c61796572732e6a7067" alt="Imagen de ejemplo">
		  <div class="card-body">
		    <h5 class="card-title text-uppercase text-center">componentes</h5>
		    <p class="card-text text-center">Componentes reutilizables de Bootstrap</p>
		    </div>
		  <div class="card-footer">
    			 <a href="components.jsp" class="btn btn-outline-primary btn-lg btn-block" role="button">Ver Detalle</a>
    	  </div>
		</div>
		<!-- /Card 2 -->
		
		<!-- Card 3 -->
		<div class="card justify-content-center" style="width: 18rem;">
		  <img class="card-img-top" src="https://cdn.tn.com.ar/sites/default/files/styles/1366x765/public/2015/03/04/arkanoidfoto.jpg" alt="Imagen de ejemplo">
		  <div class="card-body">
		    <h5 class="card-title text-uppercase text-center">arkanoid</h5>
		    <p class="card-text text-center">Lorem ipsum dolor sit amet consectetur adipiscing elit nulla posuere, malesuada primis fermentum dis tempus auctor suspendisse. Dignissim laoreet scelerisque in diam tellus fermentum sapien nullam, hac suscipit velit curabitur dictum ante cras, porta sed nulla ligula penatibus nunc et.</p>
		  </div>
			<div class="card-footer">
    			 <a href="arkanoid.jsp" class="btn btn-outline-primary btn-lg btn-block" role="button">Ver Detalle</a>
    		</div>
		</div>
		<!-- /Card 3 -->
		
		<!-- Card 4 -->
		<div class="card justify-content-center" style="width: 18rem;">
		  <img class="card-img-top" src="https://www.uniondemutuas.es/wp-content/uploads/2017/05/Formularios-768x768.jpg" alt="Imagen de ejemplo">
		  <div class="card-body">
		    <h5 class="card-title text-uppercase text-center">formularios</h5>
		    <p class="card-text text-center">Lorem ipsum dolor sit amet consectetur adipiscing elit nulla posuere, malesuada primis fermentum dis tempus auctor suspendisse. </p>
		   </div>
		  <div class="card-footer">
    			 <a href="formulario" class="btn btn-outline-primary btn-lg btn-block" role="button">Ver Detalle</a>
    		</div>
		</div>
		<!-- /Card 4 -->
      </div>
	<!-- /Card Deck -->

 </main>

<%@include file="includes/footer.jsp"%>

<!-- Componente Card. Con una imagen, esa imagen coger una imagen que represente 
el grid system de bootstrap x
titulo grid system x
texto: sistema de rejillas que usa bootstrap con 12 columnas x
Boton(ancla) de bloque, con outline y que se vea azul al hover, x
texto del boton centrado y tiene que poner Ver Ejemplo x
Titulo uppercase, escribir en minusculas, utilizando solo bootstrap x

todas las cards a la misma altura, y lo botones abajo del todo
--> 