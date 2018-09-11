<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>

<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main role="main" class="container">
	<h1 class="text-capitalize">resultado</h1>
	
	<% Producto p = (Producto) request.getAttribute("producto");%>
	
		<div class="card justify-content-center" style="width: 20rem;">
			<div class="card-custom-header">
				<span class="badge badge-secondary"><%=p.getPrecio()%> &euro;</span>
				<img class="card-img-top" src="<%=p.getImagen()%>" alt="Imagen producto">
				<span class="star"><i class="fas ${(producto.oferta)?'fa-star':''}"></i></span>
			</div>
			
			<div class="card-body">
			    <h5 class="font-weight-bold text-primary"> <%=p.getNombre()%> </h5>
			    <h6 class="card-title">	<%=p.getCodigo()%> </h6>
			    <p class="card-text"><%=p.getDescripcion()%></p>
			</div>
			<div class="card-footer">
			  <a href="#" class="btn btn-outline-primary btn-lg btn-block" role="button">Ver Detalle</a>
			</div>
		</div>
			
</main>

<%@include file="includes/footer.jsp"%>