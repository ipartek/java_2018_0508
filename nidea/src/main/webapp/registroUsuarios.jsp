<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

 <main role="main" class="container">
		<h1>REGISTRO DE USUARIOS</h1>
		<p class="font-italic text-secondary">Los campos con * son obligatorios</p>
		
		<form action="login" method="post">
		
		
		<!-- .form-nombre -->	
		<div class="form-row">
			<div class="col">
		 		<div class="form-group">
		 			<label for="nombre" class="obligatorio">Nombre:</label>
					<input type="text" name="nombre" autofocus class="form-control" required placeholder="Nombre" tabindex="1">				
				</div>	
			</div>	
		</div>
		
	<!-- .form-password -->	
		<div class="form-row">
			<div class="col">
				<div class="form-group">
					<label for="password" class="obligatorio">Password:</label>
					<input type="password" name="password" autofocus class="form-control" required placeholder="Password" tabindex="1">	
			</div>
		</div>	
	</div>	
	
	<!-- .form-password -->	
		<div class="form-row">
			<div class="col">
				<div class="form-group">
					<label for="password" class="obligatorio">Repetir Password:</label>
					<input type="password" name="password" autofocus class="form-control" required placeholder="Password" tabindex="1">	
			</div>
		</div>	
	</div>	
	
	
	<!-- .form-email -->	
		<div class="form-row">
			<div class="col">
				<div class="form-group">
					<label for="email" class="obligatorio">Email:</label>
					<input type="email" name="email" autofocus class="form-control" required placeholder="Email" tabindex="1">	
			</div>
		</div>	
	</div>
	
	<div class="form-group">
				<input type="submit" value="Nueva Alta" class="btn btn-primary btn-block">
			</div>			
			
			
			
			
			
			
				
		</form>
		
		
	</main>






<%@include file="includes/footer.jsp" %>