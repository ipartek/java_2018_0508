<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>
<%
	Producto p = (Producto) request.getAttribute("producto");
	out.println(p);	
%>


	<main role="main" class="container"> 

		<div class="row">
			<div class="col">
				<h1>Resultado de Alta de Producto</h1>	
			</div>
		</div>
			
		<div class="row">
				<div class="col">
					<div class="card h-100" style="width: 18rem;">
				
						<img class="card-img-top" src="${producto.img}" alt="Product Card Image">
						
						<div class="card-body">
							<h4 class="text-uppercase">${producto.codigo}</h4>
							<h5 class="card-title text-uppercase">${producto.nombre}</h5>
							<%
								if (p.isEsOferta()) {		
							%> <img src = "img/discount.png" alt="Offer image" class="discount"><%	
							}
							%>
							<p class="card-text">
							${producto.descripcion}</p>	
						</div>
						
						<div class="card-footer">
							<a href="index.jsp" class="btn btn-outline-primary btn-block">${producto.precio} €</a>
						</div>
					</div>
					<!-- END CARD -->
				</div>
				<!-- END COL -->
			</div>
			<!-- END ROW -->
	
			
			<div class="row">
				<div class="col">
					<button type="button" class="btn btn-primary btn-block">Añadir otro Producto</button>	
				</div>
			</div>
	</main>

<%@include file="includes/footer.jsp"%>

