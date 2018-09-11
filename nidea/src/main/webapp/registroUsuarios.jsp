<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<div class="container">

	<fieldset>
			<legend>Registro de usuarios</legend>
			<form action="usuarioRegistroControler" method="post">
				<div class="form-group login">
					<label for="nombre">Nombre:</label> 
			        <input type="text" autofocus placeholder="Escribe tu nombre" name="nombre" required="required" pattern="[a-zA-Z\s]{5,}"/>
			        <span class="invalid">*El nombre es requerido</span><br>
	
			        <label for="email">Email: </label>
			        <input type="email" name="email" required="required" placeholder="Introduce tu email"/>
			        <span class="invalid" >*El email es requerido</span><br>
			        
			        <label for="passwrod">Password:</label>
			        <input id="pass1" type="password" name="email" required="required" placeholder="Introduce su password"/>
			        <span class="invalid" >*El password es requerido</span><br>
			        
			        
					<!-- onBlur="compruebaPassword()" -->
			        <label for="passwrod">Password:</label>
			        <input id="pass2" type="password"  name="emailConfirmado" required="required" placeholder="Introduzca nuevamente su password"/>
			        <span class="invalid" >*Introduzca nuevamente el password</span><br>
		        

		        <div>
		        	<input type="submit" value="Enviar" id="enviar"/>
		        </div>
		       

			</form>
		</fieldset>
</div>