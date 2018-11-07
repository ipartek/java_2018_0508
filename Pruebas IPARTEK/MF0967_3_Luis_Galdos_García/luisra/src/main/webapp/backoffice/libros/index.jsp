<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>
<%@ include file = "../include/header.jsp" %>

<!-- MENU -->
<%@ include file = "../include/nav.jsp" %>

<div class="container">
	
	<div class="row">
		<h1 class = "text-center">Libros</h1>
	</div>
	
	<!-- MODALES -->
	<%@ include file = "../include/modal.jsp" %>
	
	<div class="row">
		<!-- DATATABLE LIBROS -->
		<table id="tablaOrdenable" class="display">
		
		<thead>
			<tr>
				<th>ID</th>
				<th>Titulo</th>
				<th>ISBN</th>
				<th>Editorial</th>
				<th>Operaciones</th>                
			</tr>
		</thead>
			        
		<tbody>
			<c:forEach items="${ libros }" var="l">
			<tr>
			<td>${ l.id }</td>
			<td>${ l.titulo }</td>
			<td>${ l.isbn }</td>
			<th>${ l.editorial.nombre }</th>
			<td>
				<a data-toggle="modal" onclick="showModalForm(2, ${ l.id }, <%= ICRUDController.OP_GUARDAR %>);">Editar</a>
				<a data-toggle="modal" onclick="showModalForm(2, ${ l.id }, <%= ICRUDController.OP_ELIMINAR %>);">Eliminar</a>
			</td>	                
			</tr>
			</c:forEach>
		</tbody>
			       
		<tfoot>
			<tr>
			<th>ID</th>
			<th>Titulo</th>
			<th>ISBN</th>
			<th>Editorial</th>
			<th>Operaciones</th>      
			</tr>
		</tfoot>
	   </table> 	<!-- table#tablaOrdenable -->		
	
	</div>	<!-- ./row -->
	<div class="row">
		<a onclick="showModalForm(2, -1, <%= ICRUDController.OP_GUARDAR %>);" class="btn btn-primary btn-block">Crear Libro</a>
	</div>
	
</div>	<!-- ./container -->

<%@ include file = "../include/footer.jsp" %>