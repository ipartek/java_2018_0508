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
				Comentarios para aprobar <span class="badge bg-pika-yellow text-pika-blue">${nComentarios}</span>
			</h2>
		</div>
		<div class="row m-5">
			<div class="col-6">
			</div>
			<div class="col-6">
			</div>
		</div>
		<div class="container">
			<form action="backoffice/comentario/aprobar" method="post">
			<table id="tablaBackoffice" class="display" style="width: 100%">
				<thead>
					<tr>
						<th></th>
						<th>ID</th>
						<th>Fecha</th>
						<th>Texto</th>
						<th>Usuario</th>
						<th>Video</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach items="${comentarios}" var="c">
							<tr>
								<td><input type="checkbox" value="${c.id}" name="ids"></td>
								<td>${c.id}</td>
								<td>${c.fecha}</td>
								<td>${c.texto}</td>
								<td>${c.usuario.nombre}</td>
								<td>${c.video.nombre}</td>
							</tr>
						</c:forEach>	
				</tbody>
				<tfoot>
					<tr>
						<th></th>
						<th>ID</th>
						<th>Fecha</th>
						<th>Texto</th>
						<th>Usuario</th>
						<th>Video</th>
					</tr>
				</tfoot>
			</table>
			<input type="submit" value="Aprobar" class="btn-main btn-outline-pika">
			<a href="" class="btn-main btn-outline-pika-red">Eliminar</a>
			</form>
		</div>
	</div>
	<!-- / Col de datos -->
</div>
<!-- / Row Principal -->
<%@ include file="../includes/footer.jsp"%>
