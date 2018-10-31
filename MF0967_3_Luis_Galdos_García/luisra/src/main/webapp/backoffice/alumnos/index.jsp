<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file = "../include/header.jsp" %>

<!-- MENU -->
<%@ include file = "../include/nav.jsp" %>

<div class="container">

	<div class="row">
		<h1 class = "text-center">Alumnos</h1>
	</div>
	
	<!-- MODALES -->
	<%@ include file = "../include/modal.jsp" %>
	
	<div class="row">
		<!-- DATATABLE EDITORIALES -->
		<table id="tablaOrdenable" class="display">
		
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Operaciones</th>                
			</tr>
		</thead>
			        
		<tbody>
			<c:forEach items="${ alumnos }" var="a">
			<tr>
			<td>${ a.id }</td>
			<td>${ a.nombre }</td>
			<td>
				<a data-toggle="modal" onclick="showModalForm(3, ${ a.id }, <%= ICRUDController.OP_GUARDAR %>);">Editar</a>
				<a data-toggle="modal" onclick="showModalForm(3, ${ a.id }, <%= ICRUDController.OP_ELIMINAR %>);">Eliminar</a>
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
	   </table> 	<!-- table#tablaOrdenable -->		
	
	</div>	<!-- ./row -->
	<div class="row">
		<a onclick="showModalForm(3, -1, <%= ICRUDController.OP_GUARDAR %>);" class="btn btn-primary btn-block">Crear Alumno</a>
	</div>
	
</div>	<!-- ./container -->


<%@ include file = "../include/footer.jsp" %>