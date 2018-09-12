<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

 <main role="main" class="container" >
		<h1>Acceso a Nidea</h1>
		<p class="font-italic text-secondary">Los campos con * son obligatorios</p>
		
		<form action="login" method="post">
		
		
	<!-- .form-email -->	
		<div class="form-row">
			<div class="col">
				<div class="form-group">
					<label for="email" class="obligatorio">*Correo Electrònico:</label>
					<input type="email" name="email" autofocus class="form-control" required placeholder="nidea@hormail.com" tabindex="1">	
			</div>
		</div>	
	</div>
		
		
	<!-- .form-password -->	
		<div class="form-row">
			<div class="col">
				<div class="form-group">
					<label for="password" class="obligatorio">*Contraseña:</label>
					<input type="password" name="password" autofocus class="form-control" required placeholder="Escribe Contraseña" tabindex="1"  minlength="5" maxlength="10">	
			</div>
		</div>	
	</div>	
	
	
	
	<div class="form-group">
				<input type="submit" value="Entrar" class="btn btn-primary btn-block">
			</div>			
		</form>
		
		
	</main>






<%@include file="includes/footer.jsp" %>