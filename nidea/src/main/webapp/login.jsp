<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>


<main role="main" class="container">
		<h1>Login</h1>
		
		
		<form action="formulario" method="post">
		
			<div class="row justify-content-center">
				<div class="col  col-md-5">
				 
				 		<label for="nombre" class="required obligatorio" >Nombre:</label>
						<input type="text" name="nombre" autofocus class="form-control"  minlength="4" maxlength="15"required  placeholder="Nombre" tabindex="1">				
					
			
			
				
					
						<label for="pass" class="obligatorio">Contraseña:</label>			
						<input type="password" name="pass" class="form-control" minlength="8" maxlength="20"required placeholder="Introduce la contraseña">
		
				
				
					
						<button type="submit" class="btn btn-outline-primary btn-lg btn-block">Login</button>
						
				</div>
			</div>
		</form>
		
		
	</main>




<%@include file="includes/footer.jsp" %>