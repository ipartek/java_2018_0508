<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeVideoController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp"%>

<%@ include file="../includes/nav.jsp"%>

<div class="row mt-5">
	<%@ include file="../includes/sidebar.jsp"%>
	<div class="col-8 ml-4">
		<div class="row">
			<c:if test="${not empty alert}">
				<%@ include file="../includes/alertas.jsp"%>
			</c:if>
		</div>
		<!-- / Gestion de alertas -->
		<!-- Contenido de la pagina actual -->
		<div class="row">
			<h2 class="text-pika-blue">
				Videos <span class="badge bg-pika-yellow text-pika-blue">${nVideo}</span>
			</h2>
		</div>
		<div class="row m-5">
			<div class="col-8">
				<form action="" method="post">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Buscar..."
							name="buscar">
					</div>
				</form>
			</div>
			<div class="col-4">
				<a
					href="backoffice/video?id=-1&op=<%=BackofficeVideoController.OP_IR_FORMULARIO%>"
					class="btn btn-outline-info">Crear Nuevo</a>
			</div>
		</div>
		<div class="container">
			<table id="tablaBackoffice" class="display" style="width: 100%">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Codigo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${videos}" var="v">
						<tr>
							<td>${v.id}</td>
							<td><a
								href="backoffice/video?id=${v.id}&op=<%= BackofficeVideoController.OP_IR_FORMULARIO%>">${v.nombre}</a></td>
							<td>${v.codigo}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Codigo</th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<!-- / Col de datos -->
</div>
<!-- / Row Principal -->
<%@ include file="../includes/footer.jsp"%>
