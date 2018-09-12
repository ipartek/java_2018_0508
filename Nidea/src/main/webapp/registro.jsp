<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main class="container" role="main">
	<h1 class="text-center">Registro nuevos usuarios</h1>
	<p>Los campos con * son obligatorios.</p>
	
	<form action="registro" method="post">
		<div class="form-row">
			<div class="col">
				<div class="form-group">
				   <label class="required" for="usuario">Usuario: </label>
				   <input class="form-control" type="text" name="usuario" placeholder="Mínimo 3 caracteres y máximo 10" minlength="4" maxlength="10" required autofocus tabindex="1" required>
				   <div class="invalid-feedback">
		          		Please choose a username.
		        	</div>
				</div>
			</div>
		</div>
		
		<div class="form-row">
			<div class="col">
				<div class="form-group">
				    <label class="required" for="pswd">Contraseña: </label>
				    <input class="form-control" type="password" name="pswd" placeholder="Mínimo 8 caracteres y al menos una mayúscula y un carácter numérico" minlength="8" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" tabindex="3" required>
				</div>
			</div>	
			<div class="col">
				<div class="form-group">
				    <label class="required" for="pswd">Repite la contraseña: </label>
				    <input class="form-control" type="password" name="pswd" placeholder="Repite la contraseña anterior" minlength="8" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" tabindex="3" required>
				</div>
			</div>
		</div>
		
		<div class="form-row">
			
			<div class="col">
				<div class="form-group">
			   		<label class="required" for="email">Correo electrónico: </label>
			   		<input class="form-control" type="email" name="email" step="0.1" placeholder="Introduce un correo válido" tabindex="4" required>
				</div>
			</div>
			
			<div class="col">
				<div class="form-group">
			   		<label class="required" for="email">Repite el correo electrónico: </label>
			   		<input class="form-control" type="email" name="email" step="0.1" placeholder="Repite tu correo" tabindex="4" required>
				</div>
			</div>
		</div>
		
		<input class="form-control btn btn-outline-primary" type="submit" value="Dar de Alta">
	</form>
</main>

<%@include file="includes/footer.jsp"%>