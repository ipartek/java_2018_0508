<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file = "../include/header.jsp" %>

<!-- MENU -->
<%@ include file = "../include/nav.jsp" %>

<div class="container">
	
	<!-- ALERTS -->
	<%@ include file = "../include/alert.jsp" %>
	
	<%@ include file="../include/modal.jsp" %>
	
	<div class="row">
		<h1 class="page-header">Alumnos</h1>
	</div>
	
	<div class="row margin-bottom-5">
      		<div class="col-md-4">
      			<a href="alumnos?id=-1&op=<%= ICRUDController.OP_IR_FORMULARIO %>" class="btn btn-success mb-3">Crear Nuevo</a>
      		</div>	
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
				<a class="badge badge-primary"  href="alumnos?op=<%= ICRUDController.OP_IR_FORMULARIO %>&id=${ a.id }&nombre=${ a.nombre }">Editar</a>
				<a class="badge badge-danger" data-toggle="modal" onclick="showModalForm(3, ${ a.id }, <%= ICRUDController.OP_ELIMINAR %>);">Eliminar</a>
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

	
</div>	<!-- ./container -->


<%@ include file = "../include/footer.jsp" %>