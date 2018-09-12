<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<%@include file="includes/navbar.jsp" %>

	<main class="container-fluid" role="main">
		<h1 class="text-center">Listado de Productos</h1>
		
		<div class="row bg-dark">
			<div class="col-12">
				<div class="row">
					<%
						for (int i = 0; i < 25; i++) {
							%>
							<div class="col-12 col-sm-6 col-md-2 mt-3">
								<div class="card">
								  <img class="card-img-top" alt="Detalle del producto" src="https://image.freepik.com/vector-gratis/bebe-oso-panda-celebra-vector-de-dibujos-animados-de-cumpleanos_1441-689.jpg">
								  <div class="card-body">
								  	<div class="row">
								  		<div class="col">
								  			<h5 class="card-title text-primary text-uppercase font-weight-bold">Producto <%=i %></h5>
								  			<h6 class="card-title text-info">Codigo <%=i %></h6>
								  		</div>
								  		<div class="col text-right"><h5 class="card-title text-info font-weight-light font-italic">Precio <%=i %>&#8364;</h5></div>
								  	</div>
								    <p class="card-text font-italic">Descripcion <%=i %></p>
								    <div class="text-right"><i class="fas fa-search"></i></div>
								  </div>
								</div>
							</div>
							<!-- / .col -->
							<%
						}
					%>
				</div>
			</div>
		</div>
	</main>

<%@include file="includes/footer.jsp" %>