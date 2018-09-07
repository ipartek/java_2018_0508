<%@include file="includes/header.jsp" %>

<%@include file="includes/navbar.jsp" %>

<main role="main" class="container">
    <div class="jumbotron">
    	<h1>Ejemplos</h1>
        <p class="lead">Ejemplos con bootstrap 4 y Java Enterprise Edition</p>
        <div class="row">
        	<div class="col">
        		<div class="card" style="width: 18rem;">
				  <img class="card-img-top" src="images/imagen02.jpg" alt="Card image cap" width="180" height="180">
				  <div class="card-body">
				    <h5 class="card-title">Sistema Grid</h5>
				    <p class="card-text">Sistema grid de bootstrap, con sus breakpoints y ejemplos de columnas.</p>
				    <a href="grid.jsp" class="btn btn-outline-primary btn-lg btn-block text-uppercase">ver ejemplo</a>
				  </div>
				</div>
        	</div>
        	<div class="col">
        		<div class="card" style="width: 18rem;">
				  <img class="card-img-top" src="images/imagen03.png" alt="Card image cap" width="180" height="180">
				  <div class="card-body">
				    <h5 class="card-title">Componentes</h5>
				    <p class="card-text">Ejemplos de los diferentes componentes de bootstrap 4.</p>
				    <a href="componentes.jsp" class="btn btn-outline-secondary btn-lg btn-block text-uppercase">ver ejemplo</a>
				  </div>
				</div>
        	</div>
        	<div class="col">
        		<div class="card" style="width: 18rem;">
				  <img class="card-img-top" src="images/imagen04.jpg" alt="Card image cap" width="180" height="180">
				  <div class="card-body">
				    <h5 class="card-title">Arcanoid</h5>
				    <p class="card-text">Juego arcanoid hecho con HTML y CSS.</p>
				    <a href="arcanoid.jsp" class="btn btn-outline-primary btn-lg btn-block text-uppercase">ver ejemplo</a>
				  </div>
				</div>
        	</div>
        </div>
	</div>
</main>

<%@include file="includes/footer.jsp" %>