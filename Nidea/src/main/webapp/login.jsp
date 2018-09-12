<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main class="container " role="main" >
	<h1 class="text-center">Iniciar sesión</h1>
	
	<form action="login" method="post">
		<div class="form-row">
			<div class="col">
				<div class="form-group">
				   <label for="nombre">Usuario: </label>
				   <input class="form-control" type="text" name="usuario" placeholder="Escribe tu nombre de usuario" required autofocus tabindex="1">
				   <div class="invalid-feedback">
		          		Por favor, elige un nombre de usuario.
		        	</div>
				</div>
			</div>
		</div>
		
		<div class="form-row">
			<div class="col">
				<div class="form-group">
				    <label for="pswd">Contraseña: </label>
				    <input class="form-control" type="password" name="pswd" placeholder="Escribe tu contraseña" tabindex="3" required minlength="5" minlength="25">
				</div>
			</div>	
		</div>
		
		<input class="form-control btn btn-outline-primary" type="submit" value="Entrar">
	</form>
</main>

<%@include file="includes/footer.jsp"%>