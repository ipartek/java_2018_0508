<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<%@include file="includes/alert.jsp" %>


 <main role="main" class="container">
		<h1>REGISTRO DE USUARIOS</h1>
		<p class="font-italic text-secondary">Los campos con * son obligatorios</p>
		
		<form action="registro" method="post">
		
		
		<!-- .form-nombre -->	
		<div class="form-row">
			<div class="col">
		 		<div class="form-group">
		 			<label for="nombre" class="obligatorio"> * Nombre:</label>
					<input type="text" name="nombre" autofocus class="form-control" required placeholder="Minimo 50 letras y Maximo 50 letras" pattern="{5,50}">				
				</div>	
			</div>	
		</div>
		
	<!-- .form-password -->	
		<div class="form-row">
			<div class="col">
				<div class="form-group">
					<label for="password" class="obligatorio"> * Contraseña:</label>
					<input type="password" name="password" autofocus class="form-control" required placeholder="Minimo 8 caracteres y Minimo 20 caracteres" pattern="{8,20}">	
			</div>
		</div>	
	</div>	
	
	<!-- .form-password -->	
		<div class="form-row">
			<div class="col">
				<div class="form-group">
					<label for="passwordRepit" class="obligatorio"> * Vuelve a insertar la contraseña:</label>
					<input type="password" name="passwordRepit" autofocus class="form-control" required placeholder="Repite de nuevo contraseña por favor" pattern="{8,20}">	
			</div>
		</div>	
	</div>	
	
		
	<div class="form-group">
				<input type="submit" value="Crear Usuario" class="btn btn-primary btn-block">
			</div>			
		</form>
	</main>



<%@include file="includes/footer.jsp" %>