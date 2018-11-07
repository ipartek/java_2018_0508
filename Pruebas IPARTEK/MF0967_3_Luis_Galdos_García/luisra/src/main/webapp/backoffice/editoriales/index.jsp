<%@page import="com.ipartek.formacion.libros.controller.backoffice.EditorialController"%>
<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file = "../include/header.jsp" %>

<!-- MENU -->
<%@ include file = "../include/nav.jsp" %>

<div class="container">
	
	<div class="row">
		<h1 class = "text-center">Editoriales</h1>
	</div>
	
	<!-- ALERTS -->
	<%@ include file = "../include/alert.jsp" %>
	
	<!-- MODALES -->
	<%@ include file = "../include/modal.jsp" %>
	
	
	<!-- DATATABLE EDITORIALES -->
	<div class="row">
		
		<table id="tablaOrdenable" class="display">
		
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Operaciones</th>                 
			</tr>
		</thead>
			        
		<tbody>
			<c:forEach items="${ editoriales }" var="editorial">
			<tr>
			<td>${ editorial.id }</td>
			<td>${ editorial.nombre }</td>
			<td>
				<a data-toggle="modal" onclick="showModalForm(4, ${ editorial.id }, <%= ICRUDController.OP_GUARDAR %>);">Editar</a>
				<a data-toggle="modal" onclick="showModalForm(4, ${ editorial.id },<%= ICRUDController.OP_ELIMINAR %>);">Eliminar</a>
			</td>	                
			</tr>
			</c:forEach>
		</tbody>
			       
		<tfoot>
			<tr>
			<th>ID</th>
			<th>Nombre</th>	
			<th>Operaciones</th> 
			</tr>
		</tfoot>
	   </table> 	<!-- /#tablaOrdenable -->		
	
	</div>	<!-- ./row -->
	
	<div class="row">
		<a class="btn btn-primary btn-block" data-toggle="modal" onclick="showModalForm(4, -1, ${ EditorialController.OP_GUARDAR });">Crear Editorial</a>
	</div>
	
</div>	<!-- ./container -->

<%@ include file = "../include/footer.jsp" %>