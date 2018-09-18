<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

<%@ include file="includes/navbar.jsp" %>
<main class="container">
<div class="container">
	<div class="logueo">
	
			
			<form action="LoginUsuariosControler" method="post">
				<div class=" login">
					
					<label  for="nombreUsuario">Nombre:</label> 	
			        <input class="form-control" type="text" autofocus placeholder="Escribe tu nombre (Requerido)" name="nombreUsuario" required="required" pattern="[a-zA-Z\s]{5,}"/>
			        <!-- <span class="invalid" >*El nombre es requerido</span><br> -->
			       
					
		        	<label  for="passwordusuario">Password:</label>	        
			        <input class="form-control" id="pass1" type="password" name="passUsuario" required="required" placeholder="Introduce su password (Requerido)"/>
			        <div class="input-group mb-3">
					  <div class="input-group-prepend">
					    <div class="input-group-text">
					      <input type="checkbox" aria-label="Checkbox for following text input">
					    </div>
					  </div>
					  <input type="text" readonly class="form-control" placeholder="No Soy un robot" aria-label="Text input with checkbox">
					</div>        
					<input class="btn secondary btn-lg btn-block"  type="submit" value="Enviar" id="enviar"/>
		        
		        	
		        </div>
		       

			</form>
		
	</div>	
</div>
</main>