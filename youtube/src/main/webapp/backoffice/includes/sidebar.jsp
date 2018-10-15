<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeVideoController"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeRolController"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeUsuarioController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Menu Lateral -->
<div class="col-3">
	<h2 class="m-4 text-pika-blue">Panel de Acceso</h2>
	<ul class="list-group list-group-flush">
		<li class="list-group-item"><a href="backoffice/inicio"
			class="btn-block text-pika-blue"><i class="fas fa-tachometer-alt fa-lg"></i> Inicio</a></li>
		<li class="list-group-item"><a
			href="backoffice/usuario?op=<%=BackofficeUsuarioController.OP_LISTAR%>"
			class="btn-block text-pika-blue"><i class="fas fa-users fa-lg"></i> Usuarios</a></li>
			<li class="list-group-item"><a
			href="backoffice/rol?op=<%=BackofficeRolController.OP_LISTAR%>"
			class="btn-block text-pika-blue"><i class="fas fa-theater-masks fa-lg"></i> Roles</a></li>
		<li class="list-group-item"><a href="backoffice/video?op=<%= BackofficeVideoController.OP_LISTAR%>"
			class="btn-block text-pika-blue"><i class="fab fa-youtube fa-lg"></i> Videos</a></li>
		<li class="list-group-item"><a href="backoffice/comentario/aprobar"
			class="btn-block text-pika-blue"><i class="fas fa-comment-slash fa-lg"></i>Comentarios Pendientes</a></li>
	</ul>
</div>