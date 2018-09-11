<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<div class="container">

	<fieldset>
			<legend>Identificacion de usuarios</legend>
			<form action="identificacionUsuarioControler" method="post">
				<div class="form-group login">
					<label for="nombreUsuario">Nombre:</label> 
			        <input type="text" autofocus placeholder="Escribe tu nombre" name="nombreUsuario" required="required" pattern="[a-zA-Z\s]{5,}"/>
			        <br>

			        <label for="passwordusuario">Password:</label>
			        <input id="pass1" type="password" name="passwordusuario" required="required" placeholder="Introduce su password"/>
			        <span class="invalid" >*El password es requerido</span><br>

		        <div>
		        	<input type="submit" value="Enviar" id="enviar"/>
		        </div>
		       

			</form>
		</fieldset>
</div>