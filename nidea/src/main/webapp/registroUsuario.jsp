<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<main class="container">

	<h1>Registro nuevo usuario</h1>
	<p>Los campos con * son obligatorios</p>
		
	<form action="formulario" method="post">			
			<div class="form-row">
			 	<div class="col">
			 		<div class="form-group">
				 		<label for="nombre" class="required">Nombre:</label>
						<input type="text" name="nombre" autofocus class="form-control" required placeholder="Nombre" tabindex="1">				
					</div>
					<div class="form-group">
				 		<label for="contrasena" class="required">Contraseña:</label>
						<input type="password" name="nombre" autofocus class="form-control" required placeholder="Contraseña" tabindex="2">				
					</div>
					<div class="form-group">
				 		<label for="contrasena" class="required">Vuelva a insertar la contraseña:</label>
						<input type="comprob-password" name="nombre" autofocus class="form-control" required placeholder="Contraseña" tabindex="3">				
					</div>
					<div class="form-group">
				 		<label for="email" class="required">Email:</label>
						<input type="email" name="email" autofocus class="form-control" required placeholder="email" tabindex="3">				
					</div>
					
			 	</div>	
			</div>
	</form>
</main>



<%@include file="includes/footer.jsp" %>