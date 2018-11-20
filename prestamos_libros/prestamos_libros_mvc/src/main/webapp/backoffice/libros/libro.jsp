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
            <h1 class="page-header titulo">Biblioteca <span class="badge">${fn:length(libros)}</span></h1>
        </div>
            
    
		<div class="col-md-4 btn-crear">
  			<a href="biblioteca?id=-1&op=<%=CrudControllable.OP_IR_FORMULARIO%>" class="btn btn-primary">Crear nuevo libro</a>  			
  		</div>
	</div>

	<table id="tablaOrdenable" class="display">
		<thead>
			<tr>
				<th>Id</th>
				<th>ISBN</th>
				<th>Título</th>
				<th>Editorial</th>
				
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${libros}" var="l">

				<tr>
					<td>${l.id }</td>
					<td>${l.isbn }</td>
					<td><a href="biblioteca?id=${l.id }&op=<%=CrudControllable.OP_IR_FORMULARIO %>">${l.titulo }</a></td>
					<td><a href="editoriales?id=${l.editorial.id}&op=<%=CrudControllable.OP_IR_FORMULARIO %>">${l.editorial.editorial }</a></td>
				</tr>

			</c:forEach>

		</tbody>
		<tfoot>
			<tr>
				<th>Id</th>
				<th>ISBN</th>
				<th>Título</th>
				<th>Editorial</th>
			</tr>
		</tfoot>
	</table>


</div>
<%@include file="../includes/footer.jsp"%>