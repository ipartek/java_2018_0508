
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>


<main role="main" class="container"> 


<div class="jumbotron">

	<div class="row">
		<h1>Ejemplos</h1>
	</div>
	<div class="row">
		<p class="lead">Ejemplos con Bootstrap</p>
	</div>
	
	<div class="row">
		<div class="card-group">
	
			<div class="col">
		
				<div class="card h-100" style="width: 18rem;">
			
					<img class="card-img-top" src="img/index-card.jpg" alt="Index Card Image">
					
					<div class="card-body">
						<h5 class="card-title text-uppercase">Index</h5>
						<p class="card-text">
						Bienvenido a Nidea. Un lugar maravilloso donde comprar muebles baratos mientras
						que aprendes un poco de Boostrap y Java Enterprise Edition.
						</p>	
					</div>
					
					<div class="card-footer">
							<a href="index.jsp" class="btn btn-outline-primary btn-block">Ver ejemplo</a>
					</div>
				</div>
			</div>
	
			<div class="col">
				<div class="card h-100" style="width: 18rem;">
			
					<img class="card-img-top" src="img/bootstrap.png" alt="Bootstrap Card Image">
					
					<div class="card-body">
						<h5 class="card-title text-uppercase">Grid System</h5>
						<p class="card-text">
						Sistema de rejillas que utiliza bootstrap representado mediante
						un ejemplo.
						</p>
					</div>
					
					<div class="card-footer">
							<a href="index.jsp" class="btn btn-outline-primary btn-block">Ver ejemplo</a>
					</div>
				</div>
			</div>
		
			<div class="col">
				<div class="card h-100" style="width: 18rem;">
					
					<img class="card-img-top" src="img/components.png" alt="Components Card Image">
					
					<div class="card-body">
						<h5 class="card-title text-uppercase">Components</h5>
						<p class="card-text">
						Componentes diversos que se pueden utilizar con bootstrap, con ejemplos reales 
						y enlaces directos a la documentación.
						</p>	
					</div>
					
					<div class="card-footer">
							<a href="components.jsp" class="btn btn-outline-primary btn-block">Ver ejemplo</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</div>
</main>

<%@include file="includes/footer.jsp"%>

