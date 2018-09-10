
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>


<main role="main" class="container"> 

	<div class="row">
		<div class="col">
			<h1>Formulario de Alta de Producto</h1>	
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			
			<form action="formulario" method="post">
				<div class="form-row">
				
					<div class="form-group col-md-6">
			    		<label for="cod">Código</label>
			    		<input type="text" required autofocus class="form-control" name="cod" placeholder="Código del producto.">
			  		</div>
			  		
			  		<div class="form-group col-md-6">
		    			<label for="nombre">Nombre</label>
		    			<input type="text" class="form-control" name="nombre" placeholder="Nombre del producto.">
		  			</div>
		  			
				</div>
				
				<div class="form-row">
				
					<div class="form-group col-md-6">
			    		<label for="precio">Precio</label>
			    		<input type="text" class="form-control" name="precio" placeholder="Precio del producto.">
			  		</div>
			  		
					<div class="form-group col-md-6">
	    				<label for="img">Imagen del producto</label>
	    				<input type="file" class="form-control-file" name="img" accept="image/png, image/jpeg" />
	  				</div>	
	  				
		        </div>
		        
		        <div class="form-group">
		        	<div class="custom-control custom-checkbox col-md-4">
    					<input type="checkbox" class="custom-control-input" name="ckbxOferta">
    					<label class="custom-control-label" for="ckbxOferta">Oferta</label>
					</div>
		        </div>
  				
	  			<div class="form-group">
	    			<label for="desc">Descripción</label>
	    			 <textarea class="form-control"name="desc" rows="3"></textarea>
	  			</div>
	  			
		  		
		  			
		  			
				<button type="submit" class="btn btn-primary btn-block">Alta</button>

			</form> 
		</div>
	</div>	
</main>

<%@include file="includes/footer.jsp"%>

