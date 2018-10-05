<%@page
	import="com.ipartek.formacion.youtube.controller.back.BackofficeUsuarioController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Menu Lateral -->
<div class="col-3">
	<h2 class="m-4 text-pika-blue">Panel de Acceso</h2>
	<ul class="list-group list-group-flush">
		<li class="list-group-item"><a href="backoffice/index.jsp"
			class="btn-block"><i class="fas fa-tachometer-alt"></i> Inicio</a></li>
		<li class="list-group-item"><a
			href="backoffice/usuario?op=<%=BackofficeUsuarioController.OP_LISTAR%>"
			class="btn-block"><i class="fas fa-users"></i> Usuarios</a></li>
		<li class="list-group-item"><a href="backoffice/video"
			class="btn-block"><i class="fab fa-youtube"></i> Videos</a></li>
	</ul>
</div>