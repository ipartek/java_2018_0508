<%@page import="com.ipartek.formacion.personas.controller.HomeController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<!-- HEADER STARTS HERE -->
	<%@ include file="include/header.jsp"%>

	<!-- NAVBAR STARTS HERE -->
	<%@ include file="include/navbar.jsp"%>

<div class="container mt-5">

	<!-- NAVBAR STARTS HERE -->
	<%@ include file="include/alert.jsp"%>
	
	<div class="row mt-5">
		<div class="col"><h1 class="page-header">${ (persona.id == -1) ? 'Crear Persona' : persona.dni }</h1></div>
	</div>
	
	 <div class="row">
      
      <form action="inicio" method="post">
      
      <div class="row">
      	<div class="col">
      		
      	  <div class="form-group">
		    <label for="dni">DNI</label>
		    <input type="text" name="dni" class="form-control" id="dni" placeholder="9 caracteres." value="${ persona.dni }">
		  </div>
      	
      	</div>
      	
      	<div class="col">
      	
      	<div class="form-group">
		    <label for="nombre">Nombre</label>
		    <input type="text" name="nombre" class="form-control" id="nombre"placeholder="De 2 a 45 caracteres." value="${ persona.nombre }">
	  	</div>
      	
      	</div>
      </div>
      
      <div class="row">
      	<div class="col">
	      	<div class="form-group">
			    <label for="nombre">Apellido 1</label>
			    <input type="text" name="apellido1" class="form-control" id="apellido1" placeholder="De 2 a 45 caracteres." value="${ persona.apellido1 }">
		  	</div>
      	</div>
      	<div class="col">
      		<div class="form-group">
			    <label for="nombre">Apellido 2</label>
			    <input type="text" name="apellido2" class="form-control" id="apellido2" placeholder="De 2 a 45 caracteres." value="${ persona.apellido2 }">
		    </div>
      	</div>
      </div>
	  
	  <div class="form-group">
	    <label for="nombre">E-mail</label>
	    <input type="email" name="mail" class="form-control" id="mail" placeholder="De 2 a 45 caracteres." value="${ persona.email }">
	  </div>
	  
	  <div class="form-group">
	    <label for="rol">Cargo</label>
	    <input type="text" name="rol" class="form-control" id="rol" placeholder="De 2 a 45 caracteres." value="${ persona.rol }">
	  </div>
      
      <input type="submit" value="Guardar" class="btn btn-primary">
      </form>

	 </div>
</div>

<%@ include file="include/footer.jsp"%>


