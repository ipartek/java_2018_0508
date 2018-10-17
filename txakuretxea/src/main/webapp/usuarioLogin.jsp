<%@page import="com.casa.practicas.pojo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

    <!-- Page Content -->
    <div class=" login-container"><!-- align-self-center -->
    	<h1>Identificate</h1>
		<%@ include file="includes/alerta.jsp" %>
	    <div class="formularioAlta row "  >
	    <div class="col " >
	     	
			<form action="login" method="post">
				  <div class="form-row justify-content-md-center">
				  	
				  <div class="form-group col-lg-6 col-md-6 col-xs-3">
				 <p class="icono-login"> <i class="fas fa-user fa-5x "></i></p>
				  	
				     <input type="text" class="form-control inputLogin" name="nombreUsuario" autofocus required="required" value="scobby"  placeholder="Nombre de usuario" pattern="[A-Za-z]{5,45}">
				      <input type="password" class="form-control inputLogin" required="required" name="passUsuario" value="galletas" placeholder="Contraseña de usuario">
				      <input type="checkbox" class="inputLogin" name="recuerdame" ${checked }  checkbox"><span class="checkbox"> Recuerdame</span>
				    </div>
				    
				  </div>
				  <div class="center-button">
				  	<button  type="submit" class="btn boton-login btn-success btn-lg">Identificate</button>
				  </div>
			</form>
			</div>
	    </div>
	    
    </div>

<%@ include file="includes/footer.jsp" %>
