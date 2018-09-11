<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main class="container" role="main">
	<h1>Registro nuevos usuarios</h1>
	<p>Los campos con * son obligatorios.</p>
	
	<form action="registro" method="post">
		<div class="form-row">
			<div class="col">
				<div class="form-group">
				   <label class="required" for="usuario">Usuario: </label>
				   <input class="form-control" type="text" name="usuario" placeholder="Nombre de usuario" required autofocus tabindex="1">
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
				    <input class="form-control" type="password" name="pswd" placeholder="Escribe una contraseña" tabindex="3">
				</div>
			</div>	
		</div>
		
		<div class="form-row">
			
			<div class="col">
				<div class="form-group">
			   		<label class="required" for="email">Correo Electrónico: </label>
			   		<input class="form-control" type="email" name="email" step="0.1" placeholder="Escribe tu correo" tabindex="4">
				</div>
			</div>
		</div>
		
		<input class="form-control btn btn-outline-primary" type="submit" value="Dar de Alta">
	</form>
</main>

<%@include file="includes/footer.jsp"%>