<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<main class="container">

	<h1>Login</h1>
			 <div class="Icon">
	                    <!--Icono de usuario-->
	                   <span >&#xe008;</span>
	         </div>
			 <div class="ContentForm">
			 	<form action="" method="post" name="FormEntrar">
			 		<div class="input-group input-group-lg">
					  <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-envelope"></i></span>
					  <input type="email" class="form-control" name="correo" placeholder="Correo" id="Correo" aria-describedby="sizing-addon1" required>
					</div>
					<br>
					<div class="input-group input-group-lg">
					  <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
					  <input type="password" name="contra" class="form-control" placeholder="******" aria-describedby="sizing-addon1" required>
					</div>
					<br>
					<button class="btn btn-lg btn-primary btn-block btn-signin" id="IngresoLog" type="submit">Entrar</button>
					<div class="opcioncontra"><a href="">Olvidaste tu contraseña?</a></div>
			 	</form>
			 </div>	
			 

<%@include file="includes/footer.jsp" %>