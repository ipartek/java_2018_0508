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
			<div class="card-custom-header"><!-- estilo propio card-custom-header-->
				<i class="fas ${(p.oferta)?'fa-certificate':'' } fa-hamsa "></i>
				<span class="badge badge-secondary">Precio: <%=df.format(p.getPrecio())%></span>
	  			<img class="card-img-top" src="<%=p.getImagen()%>" alt="Card image cap">
  			</div>
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
		<hr>
		<h2>Maquetacion mas elaborada</h2>
		<div class="card" style="width: 18rem;">
		<span class="badge badge-secondary">New</span>
  <img class="card-img-top" src=".../100px180/?text=Image cap" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title text-primary font-weight-bold">Titulo</h5>
    <p class="card-text text-primary font-weight-bold">Codigo</p>
  </div>
		
		<%-- <h2>Scriplet</h2>
		
		
		<hr>
		
		<h2>EL - Expresion Lenguage</h2>
		${producto}
		 --%>
	</main>
	
	


<%@include file="includes/footer.jsp" %>