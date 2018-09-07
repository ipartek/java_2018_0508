<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<div class="container">
	<!-- Alerta informativa con enlace -->
	<div class="alert alert-secondary alert-dismissible fade show" role="alert">
	  <p>Si quieres más detalles sobre componentes visita la 
	  <a target="_blank" href="http://getbootstrap.com/docs/4.1/components/" 
	  class="alert-link">documentación oficial</a>.</p>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	  <span aria-hidden="true">&times;</span>
	  </button>
	</div>
	<h1 class="text-primary">Componentes</h1>
	
	<section>
	<h2>Botones</h2>
		<div class="row">
			<div class="col">
				<button type="button" class="btn btn-primary">BUTTON</button>
				<p>Etiqueta <span class="badge badge-secondary">Button</span></p>
				
			</div>
			<div class="col">
				<a type="button" class="btn btn-primary">ENLACE</a>
				<p>Etiqueta <span class="badge badge-secondary">Link</span></p>
			</div>
		</div>
	</section>
</div>

<%@include file="includes/footer.jsp"%>