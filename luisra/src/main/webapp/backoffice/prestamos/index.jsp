<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>
<%@ include file = "../include/header.jsp" %>

<!-- MENU -->
<%@ include file = "../include/nav.jsp" %>

<div class="container">
	
	<div class="row">
		<h1 class = "text-center">Préstamos</h1>
	</div>
	
	<!-- MODALES -->
	<%@ include file = "../include/modal.jsp" %>
	
	<div class="row">
		<!-- DATATABLE PRÉSTAMOS -->
		<table id="tablaOrdenable" class="display">
		
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Alumno</th>
				<th>Fecha Inicio</th>
				<th>Fecha Fin</th>
				<th>Devuelto</th>
				<th>Operaciones</th>                
			</tr>
		</thead>
			        
		<tbody>
			<c:forEach items="${ prestamos }" var="prestamo">
			<tr>
			<td>${ prestamo.libro.id }</td>
			<td>${ prestamo.alumno.id }</td>
			<td>${ prestamo.fechaInicio}</td>
			<td>${ prestamo.fechaFin }</td>
			<td>${ prestamo.estado }</td>
			<td>
				<a data-toggle="modal" onclick="showModalForm(2, ${ l.id }, <%= ICRUDController.OP_GUARDAR %>);">Editar</a>
				<a data-toggle="modal" onclick="showModalForm(2, ${ l.id }, <%= ICRUDController.OP_ELIMINAR %>);">Eliminar</a>
			</td>	                
			</tr>
			</c:forEach>
		</tbody>
			       
		<tfoot>
			<tr>
				<th>Titulo</th>
				<th>Alumno</th>
				<th>Fecha Inicio</th>
				<th>Fecha Fin</th>
				<th>Devuelto</th>
				<th>Operaciones</th>        
			</tr>
		</tfoot>
	   </table> 	<!-- table#tablaOrdenable -->		
	
	</div>	<!-- ./row -->
	<div class="row mt-3">
		<a onclick="showModalForm(2, ${ l.id }, <%= ICRUDController.OP_GUARDAR %>);" class="btn btn-primary btn-block">Crear Préstamo</a>
	</div>
	
</div>	<!-- ./container -->

<%@ include file = "../include/footer.jsp" %>