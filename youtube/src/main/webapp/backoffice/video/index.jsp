<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeRolController"%>
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
				Roles <span class="badge bg-pika-yellow text-pika-blue">${nRoles}</span>
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
					href="backoffice/rol?id=-1&op=<%=BackofficeRolController.OP_IR_FORMULARIO%>"
					class="btn btn-outline-info">Crear Nuevo</a>
			</div>
		</div>
		<div class="container">
			<table id="tablaBackoffice" class="display" style="width: 100%">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${roles}" var="r">
						<tr>
							<td>${r.id}</td>
							<td><a
								href="backoffice/rol?id=${r.id}&op=<%= BackofficeRolController.OP_IR_FORMULARIO%>">${r.nombre}</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<!-- / Col de datos -->
</div>
<!-- / Row Principal -->
<%@ include file="../includes/footer.jsp"%>
