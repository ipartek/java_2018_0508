<%@page
	import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>

<div id="wrapper">

	<%@include file="../includes/nav.jsp"%>

	<div id="page-wrapper" class="contenedor">
		<%@include file="../includes/alert.jsp"%>

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header titulo">Aprobar Comentarios <span class="badge nComentarios">${fn:length(comentarios)}</span>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>

		<div class="row titulo-tabla-comentario">
			<h4 class="col-lg-5">Aprobado</h4>
			<h4 class="col-lg-5">Usuario</h4>
			<h4 class="col-lg-5">Video</h4>
			<h4 class="col-lg-5">Fecha</h4>
			<h4 class="col-lg-5">Comentario</h4>
		</div>

		<form action="comentarios/aprobar" method="post">

			<input type="submit" class="btn btn-warning boton-aprobar"
				value="Aprobar comentarios" />

			<c:forEach items="${comentarios}" var="c">

				<div class="form-row">

					<div class="form-group col-lg-5">
						<input type="checkbox" name="id" class="checkComentario"
							value="${c.id}" />
					</div>

					<div class="form-group col-lg-5">
						<a href="usuarios?id=${c.usuario.id}&op=<%=CrudControllable.OP_IR_FORMULARIO%>" class="text-warning">${c.usuario.nombre}</a>
					</div>

					<div class="form-group col-lg-5">
						<a href="videos?id=${c.video.id}&op=<%=CrudControllable.OP_IR_FORMULARIO%>" class="text-warning" data-toggle="tooltip" data-placement="top" title="${c.video.nombre}">${c.video.nombre}</a>
					</div>

					<div class="form-group col-lg-5">
						<p>${c.fecha}</p>
					</div>

					<div class="form-group col-lg-5">
						<textarea class="form-control comentario-texto"
							onclick="showModalComentario('${c.usuario.nombre}', '${c.texto}')"
							cols="20" rows="5" readonly>${fn:substring(c.texto, 0, 100)}...</textarea>
					</div>

				</div>

			</c:forEach>
		</form>

		<!-- Modal comentario -->

		<div class="modal fade" id="modalComentario" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="cabeceraModal"></h4>
					</div>
					
					<div class="modal-body" id="textoComentario"></div>
					
					<div class="modal-footer">
						<button type="button" class="btn btn-warning" data-dismiss="modal">Cerrar</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->

	</div>
	<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<%@ include file="../includes/footer.jsp"%>
