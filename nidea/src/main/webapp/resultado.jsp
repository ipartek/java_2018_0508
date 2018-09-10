<%@ page import="com.ipartek.formacion.nidea.pojo.Producto" %>
<%@include file="includes/header.jsp" %>

<%@include file="includes/navbar.jsp" %>

	<main role="main" class="container">
	
		<%
			Producto p = (Producto)request.getAttribute("producto");
		%>
		<div class="row bg-light m-3">
		
			<div class="col-12 col-md-4 offset-md-4">
			
				<h1 class="text-primary text-center">Resultado</h1>
				
				<div class="card" style="width: 18rem;">
				  <img class="card-img-top" src="<%=p.getImagen() %>" alt="Imagen del producto">
				  <div class="card-body">
				  	<div class="row">
				  		<div class="col"><h5 class="card-title"><%=p.getNombre() %></h5></div>
				  		<div class="col text-right"><h5 class="card-title"><%=p.getPrecio() %>&#8364;</h5></div>
				  	</div>
				    <p class="card-text"><%=p.getDescripcion() %></p>
				    <% 
				    	if(p.isOferta()){ 
				    %>
				    	<span class="badge badge-pill badge-success oferta">Oferta</span>
				    <%
				    	}
				    %>
				  </div>
				</div>
			
			</div>
		
		</div>		
		
	</main>

<%@include file="includes/footer.jsp" %>