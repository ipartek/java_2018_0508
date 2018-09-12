<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main role="main" class="container">
	<div class="mb-3">
       	<h1 class="text-center">Lista productos en Cards</h1>
	</div>
       
    <!-- Card Deck -->
	<div class="card-deck">
		<div class="row">
       
       <%
       		for(int i=0;i<5;i++){	
       %>
       
       <!-- Card i -->
       		<div class="col-4 mb-3">
       			<div class="card" style="width: 20rem;">
					<div class="card-custom-header">
						<span class="badge badge-secondary">Precio &euro;</span>
						<img class="card-img-top" src="https://picsum.photos/200/?random" alt="Imagen producto">
					</div>
					
					<div class="card-body">
					    <h5 class="font-weight-bold text-primary"> Nombre </h5>
					    <h6 class="card-title">	Codigo </h6>
					    <p class="card-text">Descripción</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-outline-primary btn-lg btn-block" role="button">Ver Detalle</a>
					</div>
				</div>
       		</div>
	       
		<!-- /Card i -->
		
		<%
       		}
		%>
		</div>
	</div>
	<!-- /Card Deck -->

 </main>


<%@include file="includes/footer.jsp"%>