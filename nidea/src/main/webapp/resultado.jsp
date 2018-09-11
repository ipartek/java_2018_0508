<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>


	<main role="main" class="container">
		<h1>Resultado</h1>
		<%
			Producto p=(Producto)request.getAttribute("parametro");
			out.print(p);
		%>
		<hr>
		<h2>EL - Expresion Language</h2>
		
		${producto}
		<hr>
		<div class="card" style="width: 18rem;">
		
			<div class="card-custom-header">
				<i class="fas fa-star"></i>
  				<span class="badge badge-secondary">${producto.precio} &euro;</span>
  				<img class="card-img-top" src="${producto.imagen}" alt="Imagen detalle ${producto.imagen }">
  			</div>
  		</div>
		    
  			<div class="card-body">
  			<div class="row">
	    		<div class="col">
		    		<h5 class="card-title">${producto.nombre}</h5>
	    		</div>
    		</div>
  			<p class="card-text">
    			<%
				out.print(request.getParameter("descripcion"));
				%>
			</p>
  			</div>
		</div>
		
	</main>


<%@include file="includes/footer.jsp" %>