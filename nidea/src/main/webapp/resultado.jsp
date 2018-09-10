<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<main role="main" class="container">
		<h1>Resultado</h1>
		
		
		<h2>Scriplet</h2>
		<%
			Producto p = (Producto)request.getAttribute("producto");
			//out.print(p);
		%>
		
		<div class="card" style="width: 18rem;">
			  <img class="card-img-top rounded float-left" src= <%p.getImagen(); %> alt="imagen del producto">
			  <div class="card-body">
			    <h5 class="card-title"><%p.getNombre(); %></h5>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			  </div>
			  <ul class="list-group list-group-flush">
			    <li class="list-group-item">Cras justo odio</li>
			    <li class="list-group-item">Dapibus ac facilisis in</li>
			    <li class="list-group-item">Vestibulum at eros</li>
			  </ul>
			  <div class="card-body">
			    <a href="#" class="card-link">Card link</a>
			    <a href="#" class="card-link">Another link</a>
			  </div>
		</div>
		
		
		
		<!-- 
			<hr><!-- linea entera en la pantalla --!>
		
			<h2>EL - Expresion Lenguage</h2>
				${producto}
		 -->
	</main>


<%@include file="includes/footer.jsp" %>


<!-- El toString del resultado.jsp hacer un card:
			 imagen,al lado del titulo poner simbolo del dolar.
			 si esta en oferta PONER algo 	que represente que está en oferta.
			 
			 
			 en forma dinamica por CSS:
			 en el label  class "required" poner asterisco con el seudoselector befor. -->


