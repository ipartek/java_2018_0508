<%@include file="includes/header.jsp" %>

<%@include file="includes/navbar.jsp" %>

	<div class="container">
	
		<div class="alert alert-info alert-dismissible fade show" role="alert">
		  <p><strong>Holy guacamole!</strong> Si quieres mas detalles sobre bootstrap, <a href="https://getbootstrap.com/docs/4.1/getting-started/introduction/" target="_blank" class="alert-link">visita la documentacion oficial.</a></p>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<h1 class="text-primary">Componentes</h1>
		
		<section>
			<h2>Botones</h2>
			<div class="row">
				<div class="col">
					<button type="button" class="btn btn-primary">Boton</button>
					<p>Etiqueta <strong>button</strong></p>
				</div>
				<div class="col">
					<a class="btn btn-primary" href="#">Enlace</a>
					<p>Etiqueta <strong>a</strong></p>
				</div>
				
			</div>
		</section>
		
	</div>
	
<%@include file="includes/footer.jsp" %>