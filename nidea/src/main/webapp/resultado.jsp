<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<%

	Producto p = (Producto) request.getAttribute("producto");

%>

	<main role="main" class="container">
	
		<div class="card resultado-card" style="width: 18rem;">
		
		<%
		
		if(p.isOferta()){
		
		%>
		
		
			<img src="https://www.freeiconspng.com/uploads/offers-icon-17.png" class="resultado-oferta" />
			
		<%
		
		}
		
		%>
			<img class="card-img-top" src="<%=p.getImagen() %>" alt="Card image cap">
			<div class="card-body">
			
				<div class="row justify-content-between">
			
					<h5 class="card-title"><%=p.getNombre() %></h5>
					<h5 id="resultado-precio"><%=p.getPrecio() %></h5>
				
				</div>
				
				
				<h6><%=p.getCodigo() %></h6>
				<p class="card-text"><%=p.getDescripcion() %></p>
			</div>
		</div>
	
	</main>

<%@include file="includes/footer.jsp" %>