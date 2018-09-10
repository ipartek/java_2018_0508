<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>


<main role="container">

<div class="container">
<h1>Formulario Alta Producto</h1>

<form action="" method="post">
	<div class="form-group">
	<label for="Nombre">Nombre:</label>
	<input class="form-control" type="text" name="nombre" autofocus required placeholder="Nombre del producto" tabindex="1"><br>
	</div>
	
	<div class="row">
    	<div class="col">
			<div class="form-group">
			<label for="Codigo">Código:</label>
			<input class="form-control" type="text" name="codigo" required placeholder="Código del producto" tabindex=""><br>
			</div>
		</div>
		<div class="col">
			<div class="form-group">
			<label for="Precio">Precio:</label>
			<input class="form-control" type="number" name="precio" required step="0.1" tabindex="2"><br>
			</div>
		</div>
		<div class="col">
			<div class="form-group">
				<div class="form-check">
			    	<input class="form-check-input" type="checkbox" id="oferta" tabindex="3">
			    	<label class="form-check-label" for="Oferta">
			   		Oferta:
			   		</label>
			 	</div>
			 </div>
		 </div>
	</div>
	
	<div class="form-group">
	<textarea class="form-control" name="descripcion" rows="5" cols="50" tabindex="4"></textarea><br>
	</div>
	<div class="form-group">
		<div class="custom-file">
	  		<input type="file" class="custom-file-input" id="customFileLang" lang="es">
	  		<label class="custom-file-label" for="customFileLang">Seleccionar Archivo</label>
		</div>
	</div>
	<div class="form-group">
		<input class="btn btn-primary btn-lg btn-block" type="submit" value="Nueva Alta">
	</div>
</form>
</div>

</main>


<%@include file="includes/footer.jsp"%>
