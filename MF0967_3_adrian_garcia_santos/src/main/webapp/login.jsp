<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>


	<main role="main" class="container">
	
		<div id="conenidoLogin">
			<h1>Login</h1>
		
			<form action="login" method="post">
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Máximo 50 caracteres" max="50" />
				</div>
				<div class="form-group">
					<label for="pass">Contraseña:</label>
					<input type="password" class="form-control" name="pass" id="pass" placeholder="Máximo 20 caracteres" max="20" />
				</div>
				<button type="submit" class="btn btn-success btn-block">Acceder</button>
			</form>
		
		</div>
	</main>

<%@include file="includes/footer.jsp"%>