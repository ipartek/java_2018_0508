<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

	<main class="container">
		<div class="row justify-content-center">
			<div class="col-12 mb-3">
				<h1 class="text-center text-primary font-weight-light">Productos</h1>
				<h2>Scriplet</h2>
				
				<%
					Producto p = (Producto)request.getAttribute("producto");
					//out.print(p);
				%>
				
				<hr>
				<div class="card-group">
				  <div id="product-Card" class="col-3 card h-100">
				    <img class="card-img-top" src=${producto.imagen} alt="Card image cap">
				    <%
				    	if(p.isOferta()){
				    %>
				    <i class="fas fa-bell text-info"></i>
				    <%} %>
				    <div class="card-body">
				      <h5 class="card-title text-center">${producto.nombre}</h5>
				      <p class="card-text text-justify">${producto.descripcion}</p>
				      <p class="card-text"><small class="text-muted">${producto.precio} €</small></p>
				    </div>
				  </div>
				</div>
				
				
				
			</div>
			
		</div>
	</main>

<%@ include file="includes/footer.jsp" %>