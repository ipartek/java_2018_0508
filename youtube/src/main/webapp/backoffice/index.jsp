<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>

	<%@ include file="includes/nav.jsp" %>
	
	<div class="row mt-5">
		<%@ include file="includes/sidebar.jsp" %>
		<div class="col-9">
			<div class="row">
				<!-- include file="includes/alertas.jsp" -->
			</div><!-- / Gestion de alertas -->
			<div class="row">
				<div class="col-4 mt-1">
					<div class="card">
						<div class="card-body bg-pika-blue">
							<i class="fas fa-users fa-5x text-pika-yellow"></i>
							${usuarios}
						</div>
						<div class="card-footer bg-pika-purple">
							<a href="backoffice/usuario?op=<%= BackofficeUsuarioController.OP_LISTAR%>" class="btn-block text-pika-yellow">Usuarios</a>
						</div>
					</div>
				</div><!-- /Kard  usuarios -->
				<div class="col-4 mt-1">
					<div class="card">
						<div class="card-body bg-pika-red">
							<i class="fab fa-youtube fa-5x text-pika"></i>
							${videos}
						</div>
						<div class="card-footer bg-pika-purple">
							<a href="#" class="btn-block text-pika-yellow">Videos</a>
						</div>
					</div>
				</div><!-- /Kard  videos -->
			</div>
		</div><!-- / Col de datos -->
	</div> <!-- / Row Principal -->
 <%@ include file="includes/footer.jsp" %>