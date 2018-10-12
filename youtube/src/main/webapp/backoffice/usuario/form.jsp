<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>

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
				<h1 class="text-pika-blue">${(usuario.id == 0)?'Crear Usuario': usuario.nombre }</h1>
			</div>
		</div>
		<!-- Contenido de la pagina actual -->
		<div class="row m-auto">
			<div class="col-md-6">
				<form
					action="backoffice/usuario?op=<%=BackofficeUsuarioController.OP_GUARDAR%>"
					method="post">
					<div class="form-group">
						<input name="id" type="text" class="form-control"
							value="${usuario.id}" readonly />
					</div>
					<div class="form-group">
						<label for="nombre">Nombre:</label> <input name="nombre"
							type="text" class="form-control" value="${usuario.nombre}"
							autofocus required pattern="{1,50}" />
					</div>
					<div class="form-group">
						<label for="contrasenya">Contraseña:</label> <input
							name="contrasenya" type="pass" class="form-control"
							value="${usuario.contrasenya}" required pattern="{1,20}" />
					</div>
					<div class="form-group">
						<label for="rol">Rol:</label> <select name="rol" class="form-control">
							<c:forEach items="${roles}" var="r">
							
								<option value="${r.id}" ${(r.id==usuario.rol)?'selected':''} >${r.nombre}</option>
							
							</c:forEach>
						</select>
					</div>
					<input type="submit"
						value="${(usuario.id == 0)?'Crear':'Modificar'}"
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
					href="backoffice/usuario?id=${usuario.id}&op=<%= BackofficeUsuarioController.OP_ELIMINAR %>"
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