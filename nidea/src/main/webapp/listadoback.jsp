
<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<%!int count = 12;%>
<main role="main" class="container">
<div class="jumbotron">
	<h1>Productos de Nidea</h1>
	<p class="lead">Seleccion de productos Nidea</p>

	<div class="row justify-content-center">
		<%
			for (int i = 0; i < count; i++) {
		%>
		<div class="col col-md-3">
			<div class="card border-light text-center h-100">
				<div class="card-custom-header">
					<i class="fas fa-star"></i> <span class="badge badge-secondary">0000
						&euro;</span> <img class="card-img-top" src="images/nodisponible.png"
						alt="Imagen detalle">
				</div>
				<div class="card-body">
					<h5 class="card-title text-uppercase">Producto</h5>
					<p class="card-text">Descripcion.</p>
				</div>
			</div>
		</div>

		<%
			}
		%>
	</div>
	<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-end">
		<li class="page-item disabled"><a class="page-link" href="#"
			tabindex="-1">Previous</a></li>
		<li class="page-item"><a class="page-link" href="#">1</a></li>
		<li class="page-item"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
		<li class="page-item"><a class="page-link" href="#">Next</a></li>
	</ul>
</nav>
</div>

</main>


<%@include file="includes/footer.jsp"%>