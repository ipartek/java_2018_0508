<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>


	<main role="main" class="container">

		<h1>Perros registrados en Txakur-Etxe</h1>

		<div class="row justify-content-around">
		<c:forEach items="${perros}" var="p">
			<div class="card col-md-3">
				<img class="card-img-top" src="${p.imagen }" alt="imagen_perro" title="imagen_perro" />
				<div class="card-body">
					<h5 class="card-title">${p.nombre}</h5>
					<div class="row justify-content-between">
						<span>${p.edad} años</span>
						<span>${p.raza}</span>
					</div>
					<div class="row justify-content-between">
						<span>${p.peso} Kg</span>
						<span class="${(p.apadrinado)? 'text-danger' : 'text-success'}">${(p.apadrinado)? 'Apadrinado' : 'No apadrinado'}</span>
					</div>
				</div>
				<div class="card-footer">
					<p>${p.chip.id }</p>
				</div>
			</div>
			
			</c:forEach>
		</div>

				
	</main>

<%@include file="includes/footer.jsp"%>