<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>
<%@ include file = "../include/header.jsp" %>

<!-- MENU -->
<%@ include file = "../include/nav.jsp" %>

<div class="container">
	
	<!-- ALERTS -->
	<%@ include file = "../include/alert.jsp" %>
	
	<div class="row">
		<h1 class="page-header">Libros</h1>
	</div>
	
	<div class="row margin-bottom-5">
      		<div class="col-md-4">
      			<a href="libros?id=-1&op=<%= ICRUDController.OP_IR_FORMULARIO %>" class="btn btn-success mb-3">Crear Nuevo</a>
      		</div>	
      </div>
	
	<!-- MODALES -->
	<%@ include file = "../include/modal.jsp" %>
	
	<div class="row">
		<!-- DATATABLE LIBROS -->
		<table id="tablaOrdenable" class="display">
		
		<thead>
			<tr>
				<th>ID</th>
				<th>Título</th>
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
				<a class="badge badge-primary" href="libros?op=<%= ICRUDController.OP_IR_FORMULARIO %>&id=${ l.id }&titulo=${ l.titulo }&isbn=${ l.isbn }&editorial=${ l.editorial.id }" >Editar</a>
				<a class="badge badge-danger" data-toggle="modal" onclick="showModalForm(2, ${ l.id }, <%= ICRUDController.OP_ELIMINAR %>);">Eliminar</a>
			</td>	                
			</tr>
			</c:forEach>
		</tbody>
			       
		<tfoot>
			<tr>
			<th>ID</th>
			<th>Título</th>
			<th>ISBN</th>
			<th>Editorial</th>
			<th>Operaciones</th>      
			</tr>
		</tfoot>
	   </table> 	<!-- table#tablaOrdenable -->		
	
	</div>	<!-- ./row -->

	
</div>	<!-- ./container -->

<%@ include file = "../include/footer.jsp" %>