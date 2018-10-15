<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeVideoController"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeRolController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>

	<%@ include file="includes/nav.jsp" %>
	
	<div class="row mt-5">
		<%@ include file="includes/sidebar.jsp" %>
		<div class="col-8">
			<div class="row">
				<!-- include file="includes/alertas.jsp" -->
			</div><!-- / Gestion de alertas -->
			<div class="row">
				<div class="col-4 mt-1">
					<div class="card text-center">
						<div class="card-body bg-pika-kard">
							<i class="fas fa-users fa-5x text-pika-purple"></i>
							<i class="ml-3 badge bg-pika-purple text-pika-yellow">${usuarios}</i>
						</div>
						<div class="card-footer bg-pika-kard">
							<a href="backoffice/usuario?op=<%= BackofficeUsuarioController.OP_LISTAR%>" class="btn-block text-pika-purple">Usuarios</a>
						</div>
					</div>
				</div><!-- /Kard  usuarios -->
				<div class="col-4 mt-1">
					<div class="card text-center">
						<div class="card-body bg-pika-kard">
							<i class="fas fa-theater-masks fa-5x text-pika-purple"></i>
							<i class="ml-3 badge bg-pika-purple text-pika-yellow">${roles}</i>
						</div>
						<div class="card-footer bg-pika-kard">
							<a href="backoffice/rol?op=<%= BackofficeRolController.OP_LISTAR%>" class="btn-block text-pika-purple">Roles</a>
						</div>
					</div>
				</div><!-- /Kard  roles -->
				<div class="col-4 mt-1">
					<div class="card text-center">
						<div class="card-body bg-pika-kard">
							<i class="fab fa-youtube fa-5x text-pika-purple"></i>
							<i class="ml-3 badge bg-pika-purple text-pika-yellow">${videos}</i>
						</div>
						<div class="card-footer bg-pika-kard">
							<a href="backoffice/video?op=<%= BackofficeVideoController.OP_LISTAR%>" class="btn-block text-pika-purple">Videos</a>
						</div>
					</div>
				</div><!-- /Kard  videos -->
				<div class="col-4 mt-1">
					<div class="card text-center">
						<div class="card-body bg-pika-kard">
							<i class="fas fa-comment-slash fa-5x text-pika-purple"></i>
							<i class="ml-3 badge bg-pika-purple text-pika-yellow">${comentarios}</i>
						</div>
						<div class="card-footer bg-pika-kard">
							<a href="backoffice/comentario/aprobar" class="btn-block text-pika-purple">Comentarios Pedientes</a>
						</div>
					</div>
				</div><!-- /Kard  comentarios no aprobado -->
			</div>
		</div><!-- / Col de datos -->
	</div> <!-- / Row Principal -->
 <%@ include file="includes/footer.jsp" %>