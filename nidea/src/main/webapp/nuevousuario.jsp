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
      				<label for="usuario">Nombre usuario</label>
      				<input type="email" class="form-control" id="inputEmail4" autofocus class="form-control" placeholder="Longitud entre 5 y 11 caracteres">
    			</div>
	    		<div class="form-group col-md-6">
      				<label for="confirmusuario">Email</label>
      				<input type="email" class="form-control" id="inputEmail4" placeholder="Ejemplo: nombre@gmail.com">
    			</div>
  			</div>
	  		<div class="form-row">
	    		<div class="form-group col-md-6">
	      			<label for="pass">Contraseña</label>
	      			<input type="password" class="form-control" id="pass" placeholder="Escriba 6 caracteres">
	    		</div>
	    		<div class="form-group col-md-6">
	      			<label for="confimpass">Confirmar contraseña</label>
	      			<input type="password" class="form-control" id="pass" placeholder="Vuelve a escribir la contraseña">
	    		</div>
  			</div>
	  		<button type="submit" class="btn btn-primary btn-lg btn-block">Registrarse</button>
			</form>
		</div>
	</div>
</main>


<%@include file="includes/footer.jsp"%>