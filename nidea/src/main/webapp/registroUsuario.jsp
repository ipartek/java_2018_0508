<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<main class="container">

	<h1>Registro nuevo usuario</h1>
	<p>Los campos con * son obligatorios</p>
		
	<form action="Nombre-Controlador" method="post">			
			<div class="form-row">
			 	<div class="col">
			 		<div class="form-group">
				 		<label for="nombre" class="required">Nombre:</label>
						<input type="text" name="nombre" autofocus class="form-control" required placeholder="Minimo 4 caracteres" minlength="4">				
					</div>
				<div class="row">
						<div class="col">
							<div class="form-group ">
						 		<label for="contrasena" class="required">Contraseña:</label>
								<input type="password" name="contrasena"  class="form-control" required placeholder="Minimo 8 caracteres" minlength="8">				
							</div>
						</div>
						<div class="col">
							<div class="form-group" >
						 		<label for="comprob-password" class="required">Vuelva a insertar la contraseña:</label>
								<input type="password" name="comprob-password"  class="form-control" required placeholder="Minimo 8 caracteres" minlength="8">				
							</div>
						</div>
						
				</div>
					
					<div class="form-group">
				 		<label for="email" class="required">Email:</label>
						<input type="email" name="email" class="form-control" required placeholder="email">				
					</div>
					 <input type="submit" value="Dar de alta" class="btn btn-primary btn-block">
			 	</div>	
			</div>
	</form>
</main>



<%@include file="includes/footer.jsp" %>