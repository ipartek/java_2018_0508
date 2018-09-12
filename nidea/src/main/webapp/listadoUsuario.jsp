<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>


 <main class="container" role="main">
		<h1 class="text-center">Listado de Productos</h1>
		
		<div class="row justify-content-center">
			<div class="col">
				<div class="row ">
					<%
						for (int i = 0; i < 5; i++) {
							%>
							<div class="col-3 m-1">
								<div class="card">
								  <img class="card-img-top" alt="Detalle del producto" src="https://www.drusillas.co.uk/images/whats-on-card/redpanda-profile-400x400-984.jpg">
								  <div class="card-body">
								  	<div class="row">
								  		<div class="col">
								  			<h5 class="card-title text-primary text-uppercase font-weight-bold">Producto </h5>
								  			<h6 class="card-title text-info">Codigo </h6>
								  		</div>
								  		<div class="col text-right"><h5 class="card-title text-info font-weight-light font-italic">Precio &#8364;</h5></div>
								  	</div>
								    <p class="card-text font-italic">Descripcion </p>								    
								  </div>
								</div>
							</div>
							<!-- / .col -->
							<%
						}
					%>
				</div>
			</div>
		</div>
	</main>
<%@ include file="includes/footer.jsp" %>
