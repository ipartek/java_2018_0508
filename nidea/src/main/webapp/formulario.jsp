<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>


<main role="main" class="container">
	
	
		
			<h1>Formulario Alta Producto</h1>
		
			<form action="formulario" method="post" novalidate>
					<div class="form-group">
						<label >Nombre:</label>
						<input type="text" name="nombre" required placeholder="nombre del producto">
					</div>
					<div class="form-group">	
						<label>Codigo:</label>
						<input type="text" name="codigo" required placeholder="codigo del producto">
					</div>
					<div class="form-group">	
						<label>Descripcion:</label>
						<input type="text" name="descripcion" required placeholder="descripcion del producto">
					</div>
					<div class="form-group">	
						<label>En oferta:</label>
						<input type="checkbox" name="oferta" required>
					</div>
					<div class="form-group">	
						<label>Precio:</label>
						<input type="text" name="precio" required placeholder=" precio del producto">
					</div>
					<div class="form-group">	
						<label>Imagen:</label>
						<input type="image" name="imagen" required placeholder="imagen del producto">
					</div>
					<div class="form-group">
						<input type="submit" value="nueva alta">
					</div>
				</form>
		
</main>

<%@ include file="includes/footer.jsp" %>