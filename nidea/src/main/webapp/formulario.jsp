<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

	<main class="container">
		<div class="row justify-content-center">
			<div class="col-12 mb-3">
				<h1 class="text-center text-primary font-weight-light">Formulario Alta Producto</h1>
				<p>Los campos con * son obligatorios</p>
				<form action="formulario" method="post">
					
				  <div class="form-group">
				    <label for="nombre">Nombre</label>
				    <input name="nombre" type="text" class="form-control" autofocus tabindex="1" requiered placeholder="Nombre del producto">				   
				  </div>
				  <div class="form-row">
					  <div class="col form-group">
					    <label for="codigo">Codigo</label>
					    <input name="codigo" type="text" class="form-control" requiered tabindex="3" placeholder="Codigo del producto">				   
					  </div>
					  <div class="col form-group">
					    <label for="precio">Precio</label>
					    <input name="precio" type="number" class="form-control" requiered tabindex="4" placeholder="Precio del producto">

			   
					  </div>

					  <div class="col form-check mb-2">
				        <input class="form-check-input" type="checkbox" name="oferta" tabindex="2" requiered>
				        <label class="form-check-label" for="autoSizingCheck">Oferta</label>
				      </div>
					  
					  
				  
				  </div>
				  <div class="form-group">
				    <label for="descripcion">Descripcion</label>
				    <textarea name="descripcion" type="text" class="form-control" rows="5" tabindex="5" placeholder="Descripcion del producto"></textarea>			   
				  </div>
				 

				  
				  
				  <button type="submit" class="btn btn-primary" tabindex="6">Submit</button>
				</form>
				
			</div>
			
		</div>
	</main>

<%@ include file="includes/footer.jsp" %>