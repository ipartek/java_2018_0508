
<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>


	<main role="main" class="container">
	
		<h1>Resultado</h1>
		
		
		<h2>Scriplet</h2>
		<%
			Producto p = (Producto)request.getAttribute("producto");
			out.print(p);
		%>
		
		<hr>
		
		<h2>EL - Expresion Lenguage</h2>
		${producto}
		
		<hr>
		<h2 class="text-capitalize">Maquetación mas elegante</h2>
		
		<div class="card" style="width: 18rem;">
		
		  <div class="card-custom-header"> <!-- estilo propio, no es bootstrap -->	
		  <i class="fas ${producto.oferta}?'fa-certificate':''}"></i>
		  
		  
		  	<span class="badge badge-secondary">${producto.precio} &euro;</span>
		  	<img class="card-img-top" src="${producto.imagen}" alt="Imagen Detalle ${producto.nombre}">
		  </div>	
		  
		  <div class="card-body">
		    <h5 class="card-title text-primary">${producto.nombre}</h5>
		    <h6 class="font-weight-bold">${producto.codigo}</h6>
		    <p class="card-text">${producto.descripcion}</p>
			    
		  </div>
		</div>
		
		
		
		
	</main>


<%@include file="includes/footer.jsp" %>

<!-- El toString del resultado.jsp hacer un card:
			 imagen,al lado del titulo poner simbolo del dolar.
			 si esta en oferta PONER algo 	que represente que está en oferta.
			 
			 
			 en forma dinamica por CSS:
			 en el label  class "required" poner asterisco con el seudoselector befor. -->

