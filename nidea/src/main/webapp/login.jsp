<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<main class="container" role="main">
		<h1>Login</h1>
		
		<div class="row justify-content-center">
			<div class="col col-md-6">
				<form>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Email:</label>
				    <input type="email" autofocus class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Introduce email">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Contraseña:</label>
				    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Introduce contraseña">
				  </div>
				  <button type="submit" class="btn btn-primary btn-block">Logear</button>
				</form>
			</div>
		</div>
		
		
	
	</main>

<%@include file="includes/footer.jsp" %>