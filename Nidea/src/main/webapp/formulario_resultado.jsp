
<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>


	<main role="main" class="container"> 

		<div class="row">
			<div class="col">
				<h1>Resultado de Alta de Producto</h1>	
			</div>
		</div>
		
		<div class="row">
			<div class="col">
			
			<%
				Producto p = (Producto) request.getAttribute("producto");
				out.println(p);
			%>
			</div>
			
			<div class="row">
		<div class="card-group">
	
			<div class="col">
		
				<div class="card h-100" style="width: 18rem;">
			
					<img class="card-img-top" src=<%p.getImg();%> alt="Index Card Image">
					
					<div class="card-body">
						<h5 class="card-title text-uppercase"><%p.getNombre(); %></h5>
						<%
							if (p.isEsOferta()) {		
						%> <img src = "img/discount.png" alt="Offer image" id="discount"><%	
						}
						%>
						<p class="card-text">
						<%p.getDescripcion(); %>
						</p>	
					</div>
					
					<div class="card-footer">
							<a href="index.jsp" class="btn btn-outline-primary btn-block">Ver ejemplo</a>
					</div>
					
				</div>
			</div>
	
			
			<div class="row">
				<div class="col">
					<button type="button" class="btn btn-primary">Añadir Producto</button>	
				</div>
			</div>
			
		</div>

	
	</main>

<%@include file="includes/footer.jsp"%>

