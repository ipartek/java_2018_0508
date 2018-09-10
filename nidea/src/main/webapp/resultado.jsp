<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<% Producto p=(Producto)request.getAttribute("producto");
out.print(p);
%>
	<main role="main" class="container">
		<h1>Resultado</h1>
		<div class="card-deck">
			<div class="card" style="width: 18rem;">
			  <img class="card-img-top" src="<%=p.getImagen()%>" alt="Card image cap">
			  <div class="card-body">
			 <div class="d-inline p-2">
			  <h5 class="card-title  float-left"><%=p.getNombre() %></h5>
			    <h5 class="card-title float-right"><%=p.getPrecio() %>€</h5>
			  </div>
			    
			    <p class="card-text card text-center"><%=p.getDescripcion() %></p>
			  </div>
			</div>
		</div>
		<hr>
		
		<h2>EL - Expresion Lenguage</h2>
		${producto}
		
	</main>


<%@include file="includes/footer.jsp" %>