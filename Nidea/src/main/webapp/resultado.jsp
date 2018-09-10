<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>

<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main role="main" class="cointainer">
	<h1>Resultado</h1>
	
	<% Producto p = (Producto) request.getAttribute("producto");%>
	
	<div class="card" style="width: 18rem;">
	  <img class="card-img-top" src="<%=p.getImagen()%>" alt="Imagen producto">
	  <a class="star fas fa-star"></a>
	  <div class="card-body">
	    <h5 class="card-title">
	    	<%=p.getNombre()%>
	    </h5>
	    <p class="card-text"><%=p.getDescripcion()%></p>
	  </div>
	</div>
</main>

<%@include file="includes/footer.jsp"%>