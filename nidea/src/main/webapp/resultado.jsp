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
		
			
			  <img class="card-img-top " src="<%=p.getImagen()%>"  alt="imagen del producto">
			  
			  <%
				  	//Si está el producto el oferta pintamos circulo verde con el texto "Oferta"
				  		if(p.isOferta()){
				  	%>
				  			<span class="badge badge-pill badge-success text-warning"> Oferta</span>
		      <% }%>
		      
			  <div class="card-body">					    
				    <div class="row">
				    	<div class=col text-left>
				    		<h5 class="card-title text-dark text-uppercase text-justify"><%=p.getNombre()%></h5>
					  		
				    	</div>
				    	
				    	<div class="col text-center">
					    	<h5 class="card-title font-weight-light text-justify text-secondary"><%=p.getCodigo() %></h5>
				  		</div>
				  		
				    	<div class="col text-right">
					    	<h5 class="card-title text-info font-weight-light text-justify"><%=p.getPrecio() %>&#8364;</h5>
				  		</div>				  		
				  		
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


