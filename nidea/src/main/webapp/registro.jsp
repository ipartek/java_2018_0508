<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<%@include file="includes/navbar.jsp" %>

	<main class="container" role="main">
		<h1 class="text-center"><i class="fas fa-user-circle"></i>Registro</h1>
		
		<div class="row justify-content-center">
			<div class="col col-md-6">
				<form>
				  <div class="form-group">
				    <label for="nombre">Nombre:</label>
				    <input name="nombre" type="text" autofocus class="form-control" id="nombre" placeholder="Nombre">
				  </div>
				  <div class="form-group">
				    <label for="mail">Email:</label>
				    <input type="email" class="form-control" id="mail" aria-describedby="emailHelp" placeholder="tunombre@tuempresa.es">
				    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
				  </div>
				  <div class="form-group">
				    <label for="contrasenya">Contraseña:</label>
				    <input name="contrasenya" type="password" class="form-control" id="contrasenya" placeholder="Password">
				  </div>
				  <div class="form-group">
				    <label for="contrasenya">Repita la contraseña:</label>
				    <input name="contrasenya" type="password" class="form-control" id="contrasenya" placeholder="Password">
				  </div>
				  <input type="submit" value="Registrarse" class="btn btn-outline-primary btn-block">
				</form>
			</div>
		</div>
	</main>

<%@include file="includes/footer.jsp" %>