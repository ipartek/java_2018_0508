<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<%@include file="includes/navbar.jsp" %>

	<main class="container" role="main">
		<h1 class="text-center"><i class="fas fa-user-circle"></i>Login</h1>
		
		<div class="row justify-content-center">
			<div class="col col-md-6">
				<form>
				  <div class="form-group">
				    <label for="usuario">Usuario:</label>
				    <input name="usuario" type="text" class="form-control" id="usuario" aria-describedby="emailHelp" placeholder="Enter email">
				  </div>
				  <div class="form-group">
				    <label for="contrasenya">Contraseña:</label>
				    <input name="contrasenya" type="password" class="form-control" id="contrasenya" placeholder="Password">
				  </div>
				  <input type="submit" value="Iniciar Sesion" class="btn btn-outline-primary btn-block">
				</form>
			</div>
		</div>
	</main>

<%@include file="includes/footer.jsp" %>