<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>


<main role="main" class="container">
			<h1>Formulario Alta Producto</h1>
		
			<form action="formulario" method="post" class="needs-validation" >
					
						<div class="form-group">	
							<label for="image">Imagen:</label>
							<input type="image"  class="form-control" name="imagen" required placeholder="imagen del producto">
						</div>
						<div class="form-group">
							<label for="nombre" class="required">Nombre:</label>
							<input type="text" class="form-control" name="nombre" autofocus required placeholder="nombre del producto" tabindex="1">
							<div class="">
							
							</div>
						</div>
						
						
					<div class="form-row">	
						
							<div class="form-group col">	
								<label for="codigo" class="required">Codigo:</label>
								<input type="text" class="form-control" name="codigo" required placeholder="codigo del producto" tabindex="3">
							</div>
							
							<div class="form-group col">	
								<label for="oferta">En oferta:</label>
								<input type="checkbox" name="oferta" class="form-control" tabindex="2">	
							</div>
						
							<div class="form-group col">	
								<label for="precio" class="required">Precio:</label>
								<input type="number" class="form-control" name="precio" required step="0.1"placeholder=" precio del producto" tabindex="4">
							</div>
						
						
						<!-- Div form-row -->
					</div>
					<div class="form-group col">	
						<label for="descripcion" class="required">Descripcion:</label>
						<textarea name="descripcion" class="form-control"  rows="5"  placeholder="descripcion del producto" tabindex="5"></textarea>
					</div>
					<input type="submit" class="btn-primary btn-block" value="nueva alta">
				</form>
		
</main>

<%@ include file="includes/footer.jsp" %>