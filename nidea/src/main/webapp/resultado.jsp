<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<main role="main" class="container">
	
		<%
			Producto p = (Producto)request.getAttribute("producto");
		%>
		<div class="row bg-dark m-3">
			<div class="col-12 col-md-4 offset-md-4">
			<h1 class="text-primary text-center">Resultado</h1>
				<div class="card m-2" style="width: 18rem;">
				  <img class="card-img-top" src="<%=p.getImagen() %>" alt="Imagen del producto">
				  <div class="card-body">
				  	<div class="row">
				  		<div class="col">
				  			<h5 class="card-title text-primary text-uppercase font-weight-bold"><%=p.getNombre() %></h5>
				  			<h6 class="card-title text-info"><%=p.getCodigo() %></h6>
				  		</div>
				  		<div class="col text-right"><h5 class="card-title text-info font-weight-light font-italic"><%=p.getPrecio() %>&#8364;</h5></div>
				  	</div>
				    <p class="card-text font-italic"><%=p.getDescripcion() %></p>
				    <% 
				    	if(p.isOferta()){ 
				    %>
				    	<span class="badge badge-pill badge-success text-uppercase oferta"><i class="fas fa-certificate fa-lg"></i>Oferta</span>
				    <%
				    	}
				    %>
				  </div>
				</div>
			
			</div>
		
		</div>		
		
	</main>

<%@include file="includes/footer.jsp" %>


<!-- El toString del resultado.jsp hacer un card:
			 imagen,al lado del titulo poner simbolo del dolar.
			 si esta en oferta PONER algo 	que represente que está en oferta.
			 
			 
			 en forma dinamica por CSS:
			 en el label  class "required" poner asterisco con el seudoselector befor. -->


