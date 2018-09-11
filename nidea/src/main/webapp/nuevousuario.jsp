<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>


<main class="container" role="main">
	<div class="row justify-content-center">
		<div class="col col-md-6">
			<h1><i class="fas fa-user-plus"></i> Nuevo Usuario</h1>
			<form>
  			<div class="form-row">
    			<div class="form-group col-md-6">
      				<label for="usuario">Usuario</label>
      				<input type="email" class="form-control" id="inputEmail4" placeholder="Email">
    			</div>
	    		<div class="form-group col-md-6">
      				<label for="confirmusuario">Confirmar usuario</label>
      				<input type="email" class="form-control" id="inputEmail4" placeholder="Email">
    			</div>
  			</div>
	  		<div class="form-row">
	    		<div class="form-group col-md-6">
	      			<label for="pass">Contraseña</label>
	      			<input type="password" class="form-control" id="pass" placeholder="Password">
	    		</div>
	    		<div class="form-group col-md-6">
	      			<label for="confimpass">Confirmar contraseña</label>
	      			<input type="password" class="form-control" id="pass" placeholder="Password">
	    		</div>
  			</div>
	  		<button type="submit" class="btn btn-primary">Registrarse</button>
			</form>
		</div>
	</div>
</main>


<%@include file="includes/footer.jsp"%>