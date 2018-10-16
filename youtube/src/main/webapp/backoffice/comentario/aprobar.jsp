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
								<td onclick="showModalDetalle('${c.texto}')">${fn:substring(c.texto,0,55)}...</td>
								<td>${c.usuario.nombre}</td>
								<td data-toggle="tooltip" data-placement="top" title="${c.video.nombre}">${fn:substring(c.video.nombre,0,25)}</td>
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
<div id="modal-detalle" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-pika-blue">
				<h4 class="modal-title">Detalle del comentario</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<p id="texto_comentario"></p>
				<button type="button" class="btn-main btn-outline-pika-blue btn-block" data-dismiss="modal">Cerrar</button>
			</div>
			<div class="modal-footer bg-pika-blue"></div>
		</div>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>
