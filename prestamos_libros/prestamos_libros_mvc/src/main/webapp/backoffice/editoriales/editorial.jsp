<%@page
	import="com.ipartek.formacion.prestamolibros.controller.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/nav.jsp"%>

<div id="page-wrapper">
	<%@include file="../includes/alert.jsp"%>

	<div class="row divTitulo">
        <div class="col-md-8">
            <h1 class="page-header titulo">Editoriales <span class="badge">${fn:length(editoriales)}</span></h1>
        </div>
            
    
		<div class="col-md-4 btn-crear">
  			<a href="editoriales?id=-1&op=<%=CrudControllable.OP_IR_FORMULARIO%>" class="btn btn-primary">Crear nueva editorial</a>  			
  		</div>
	</div>

	<table id="tablaOrdenable" class="display">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${editoriales}" var="e">

				<tr>
					<td>${e.id }</td>
					<td><a
						href="editoriales?id=${e.id }&op=<%=CrudControllable.OP_IR_FORMULARIO %>">${e.editorial }</a></td>
				</tr>

			</c:forEach>

		</tbody>
		<tfoot>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
			</tr>
		</tfoot>
	</table>


</div>
<%@include file="../includes/footer.jsp"%>