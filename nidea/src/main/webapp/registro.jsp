<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<main class="container" role="main">
		<h1>Registro</h1>
		
		<div class="row justify-content-center">
			<div class="col col-md-6">
				<form>
				  <div class="form-group">
			 		<label for="nombre" class="obligatorio">Nombre:</label>
					<input type="text" name="nombre" autofocus class="form-control" required placeholder="Nombre" tabindex="1">				
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Email:</label>
				    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required placeholder="Introduce email">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Repetir Email:</label>
				    <input type="email" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp" required placeholder="Introduce email">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Contraseña:</label>
				    <input type="password" class="form-control" id="exampleInputPassword1" required placeholder="Introduce contraseña">
				  </div>
				  <button type="submit" class="btn btn-primary btn-block">Registrar</button>
				</form>
			</div>
		</div>
	
	</main>

<%@include file="includes/footer.jsp" %>