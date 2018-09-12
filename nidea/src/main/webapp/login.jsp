<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<div class="container">

	<fieldset>
			<legend>Identificacion de usuarios</legend>
			<form action="LoginUsuariosControler" method="post">
				<div class="form-group login">
					<label for="nombreUsuario">Nombre:</label> 
			        <input class="form-control" type="text" autofocus placeholder="Escribe tu nombre" name="nombreUsuario" required="required" pattern="[a-zA-Z\s]{5,}"/>
			        <span class="invalid" >*El nombre es requerido</span><br>
			        <br>

			        <label for="passwordusuario">Password:</label>
			        <input class="form-control" id="pass1" type="password" name="passUsuario" required="required" placeholder="Introduce su password"/>
			        <span class="invalid" >*El password es requerido</span><br>
					<input class="form-control" type="submit" value="Enviar" id="enviar"/>
		        <div>
		        	
		        </div>
		       

			</form>
		</fieldset>
</div>