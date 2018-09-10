<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- El detalle con un card -->
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<main role="main" class="container">
	
		<h1>Resultado</h1>
		<div class="card" style="width: 18rem;">
		
  			<img class="card-img-top" src="..." alt="Card image cap">
  			<div class="card-body">
    			<h5 class="card-title">Card title</h5>
    			<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    			<a href="#" class="btn btn-primary">Go somewhere</a>
  			</div>
		</div>
		
		<h2>Scriplet</h2>
		<%
			Producto p = (Producto)request.getAttribute("producto");
			out.print(p);
			/* out.print(p.getNombre()); */
		%>
		
		<hr>
		
		<h2>EL - Expresion Lenguage</h2>
		${producto}
		
	</main>
	


<%@include file="includes/footer.jsp" %>