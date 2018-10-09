<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<%@include file="../includes/alert.jsp"%>


	<main role="main" class="container">

		<h1>Perros registrados en Txakur-Etxe</h1>
		
		<a href="backoffice/formulario.jsp" class="btn btn-success btn-nuevo-perro">Nuevo Perro</a>

		<table id="listadoPerros" class="display">
			<thead>
			    <tr>
			    	<th>ID</th>
			        <th>Nombre</th>
			        <th>Edad</th>
			        <th>Raza</th>
			        <th>Peso</th>
			        <th>Apadrinado</th>
			        <th>Latitud</th>
			        <th>Longitud</th>
			        <th>Imagen</th>
			    </tr>
			</thead>
			<tbody>
			    
				<c:forEach items="${perros}" var="p">
				    	
				    <tr>
				    	<td>${p.chip.id}</td>
				    	<td>${p.nombre}</td>
				    	<td>${p.edad}</td>
				    	<td>${p.raza}</td>
				    	<td>${p.peso}</td>
				    	<td>${ (p.apadrinado)?'Sí' : 'No' }</td>
				    	<td>${p.chip.latitud}</td>
				    	<td>${p.chip.longitud}</td>		
				    	<td><img src="${p.imagen}" alt="imagen_perro" title="imagen_perro" /></td>			    	
				    </tr>
				    
				</c:forEach>
			        
			</tbody>
		</table>

				
	</main>

<%@include file="../includes/footer.jsp"%>