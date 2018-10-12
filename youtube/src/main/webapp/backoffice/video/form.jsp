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
		<div class="row">
			<div class="col-12">
				<h1 class="text-pika-blue">${(usuario.id == -1)?'Crear Rol': rol.nombre }</h1>
			</div>
		</div>
		<!-- Contenido de la pagina actual -->
		<div class="row m-auto">
			<div class="col-md-6">
				<form
					action="backoffice/rol?op=<%=BackofficeRolController.OP_GUARDAR%>"
					method="post">
					<div class="form-group">
						<input name="id" type="text" class="form-control"
							value="${rol.id}" readonly />
					</div>
					<div class="form-group">
						<label for="nombre">Nombre:</label> <input name="nombre"
							type="text" class="form-control" value="${rol.nombre}"
							autofocus required pattern="{1,50}" />
					</div>
					<input type="submit"
						value="${(rol.id == -1)?'Crear':'Modificar'}"
						class="btn btn-primary btn-block" />
					<c:if test="${usuario.id>0}">
						<span data-toggle="modal" data-target="#modal-eliminar"
							class="btn btn-danger btn-block">Eliminar</span>
					</c:if>
				</form>
			</div>
		</div>
		<!-- /row del form -->
	</div>
</div>
<div id="modal-eliminar" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-pika-red">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Cuidadin</h4>
			</div>
			<div class="modal-body">
				<p>¿Estas seguro de querer eliminar este video?</p>
				<a id="btnEliminar"
					href="backoffice/usuario?id=${rol.id}&op=<%= BackofficeRolController.OP_ELIMINAR %>"
					class="btn btn-outline-info btn-outline-pika-red">Eliminar <i
					class="fas fa-trash-alt"></i></a>
				<button type="button"
					class="btn btn-outline-info btn-outline-pika-red"
					data-dismiss="modal">Cerrar</button>
			</div>
			<div class="modal-footer bg-pika-red"></div>
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp"%>