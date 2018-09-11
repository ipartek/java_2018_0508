<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>


<main class="container" role="main">
	<div class="row justify-content-center">
		<div class="col col-md-6">
			<h1><i class="fas fa-users"></i> Loggin</h1>
			<form>
	  		<div class="form-group">
	    		<label for="usuario">Usuario</label>
	    		<input type="email" class="form-control" id="usuario" aria-describedby="emailHelp" placeholder="nombre@email.com">
	    		<small id="emailHelp" class="form-text text-muted">El usuario es el correo electronico.</small>
	  		</div>
	  		<div class="form-group">
	    		<label for="pass">Contraseña</label>
	    		<input type="password" class="form-control" id="pass" placeholder="Password">
	  		</div>
	  		<div class="form-group form-check">
	    		<input type="checkbox" class="form-check-input" id="exampleCheck1">
	    		<label class="form-check-label" for="exampleCheck1">Conectarse</label>
	  		</div>
	  		<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</main>


<%@include file="includes/footer.jsp"%>