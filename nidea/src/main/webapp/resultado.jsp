<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<%

	Producto p = (Producto) request.getAttribute("producto");

%>

	<main role="main" class="container">
	
		<h1 class="text-capitalize">maquetación más elegante</h1>
	
		<div class="card" style="width: 18rem;">
		
			<div class="card-custom-header">	<!-- Estilo propio, no es de Bootstrap -->
			
				<i class="fas ${(producto.oferta)?'fa-gift':'' } fa-2x"></i>		
				<span class="badge badge-secondary">${producto.precio} &euro;</span>
				<img class="card-img-top" src="${producto.imagen}" alt="${producto.nombre}">
			
			</div>
			
			<div class="card-body">
			
				<h5 class="card-title text-primary">${producto.nombre}</h5>
				<h6 class="font-weight-bold">${producto.codigo}</h6>
				<p class="card-text">${producto.descripcion}</p>
			</div>
		</div>
	
	</main>

<%@include file="includes/footer.jsp" %>