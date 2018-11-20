<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>

<div id="page-wrapper">
<%@ include file="../includes/alert.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				<i class="fas fa-users-cog list"></i>Usuarios <span class="badge badge-secondary">${fn:length(usuarios)}</span>
			</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-md-4">
			<form action="usuarios" method="post">
				<div class="input-group">
  					<input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
  					<span class="input-group-addon"><i class="fas fa-search"></i></span>
				</div>
			</form>
		</div>
		<div class="col-md-4">
			<a href="usuarios?id=-1&op=<%=CrudControllable.OP_IR_FORMULARIO %>" class="btn btn-success">Crear Nuevo</a>
		</div>
	</div>

	<div class="row">
		<main class="container" role="main">

		<table id="listado" class="display">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Rol</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${usuarios}" var="u">
					<tr>
						<td>${u.id}</td>
			            <td><a href="usuarios?id=${u.id}&op=<%=CrudControllable.OP_IR_FORMULARIO%>">${u.nombre}</a></td>			                
						<td>${u.rol.nombre}</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

		</main>


<%@ include file="../includes/footer.jsp"%>