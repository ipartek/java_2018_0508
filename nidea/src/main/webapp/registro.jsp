<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<main role="main" class="container">
		<h1>Registro de nuevo usuario</h1>
		
		
		<form action="formulario" method="post">
		
			<div class="row justify-content-center">
				<div class="col col-md-5">
				 	
				 		<label for="nombre" class="required obligatorio">Nombre:</label>
						<input type="text" name="nombre" autofocus class="form-control" required placeholder="Nombre" tabindex="1">				
						
			
					
						<label for="pass" class="obligatorio">Contraseña:</label>			
						<input type="password" name="pass" class="form-control" required placeholder="Introduce la contraseña">
					
				
					
						<label for="pass" class="obligatorio">E-mail</label>			
						<input type="email" name="email" class="form-control" required placeholder="Introduce tu E-mail">
						
						<button type="submit" class="btn btn-outline-primary btn-lg btn-block">Registrar</button>
					</div>	
				</div>
			
		</form>
		
		
	</main>


<%@include file="includes/footer.jsp" %>