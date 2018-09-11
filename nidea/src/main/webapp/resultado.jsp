<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<main role="main" class="container">
		
		<h1>Resultado</h1>	
		
		<%
			Producto p = (Producto)request.getAttribute("producto");
		%>		
		
		
		<div class="card" style="width: 20rem;">
			 <div class="card-custom-header"><!-- estilo propio -->
			  <%
				  	//Si está el producto el oferta pintamos circulo verde con el texto "Oferta"
				  		if(p.isOferta()){
				  	%>
				  			<span class="fas fa-certificate simbolo"></span>
		      <% }%>
		      		<img class="card-img-top " src="<%=p.getImagen()%>"  alt="imagen del producto">
		      		<div class="col text-right">
					    	<h6 class="badge badge-pill badge-success"><%=p.getPrecio() %>&#8364;</h6>
				  		</div>
			  </div>
			  <div class="card-body">					    
				    
				    	<div class="col" text-left>
				    		<h5 class="card-title text-dark text-uppercase text-justify"><%=p.getNombre()%></h5>					  		
				    	</div>
				  	
				  	<div class="col text-center">
					    	<h5 class="card-title font-weight-light text-justify text-secondary"><%=p.getCodigo() %></h5>
				  		</div>
				  	<p class="card-text font-italic text-muted text-justify"><%=p.getDescripcion() %></p>
				  	
			  </div>
		</div>
		
		
	</main>


<%@include file="includes/footer.jsp" %>


<!-- El toString del resultado.jsp hacer un card:
			 imagen,al lado del titulo poner simbolo del dolar.
			 si esta en oferta PONER algo 	que represente que está en oferta.
			 
			 
			 en forma dinamica por CSS:
			 en el label  class "required" poner asterisco con el seudoselector befor. -->


