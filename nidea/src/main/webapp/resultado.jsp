<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page import="java.text.DecimalFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- El detalle con un card -->
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<%
	Producto p = (Producto)request.getAttribute("producto");
	DecimalFormat df = new DecimalFormat("#0.00€");

%>
	<main role="main" class="container">
	
		<h1>Resultado</h1>
		<div class="card" style="width: 18rem;">
			
  			<img class="card-img-top" src="<%=p.getImagen()%>" alt="Card image cap">
  			<div class="card-body">
    			<h5 class="card-title text-center">
	    			<%=p.getNombre()%>
    			</h5>
    			<p class="card-text">Codigo: <%=p.getCodigo()%></p>
    			<p class="card-text"><%= p.getDescripcion()%></p>
    			
  			</div>
  			<div class="card-footer">
				   	<p class="card-text">Precio: <%=df.format(p.getPrecio())%></p>
				</div>
		</div>
		
		<%-- <h2>Scriplet</h2>
		
		
		<hr>
		
		<h2>EL - Expresion Lenguage</h2>
		${producto}
		 --%>
	</main>
	
	


<%@include file="includes/footer.jsp" %>