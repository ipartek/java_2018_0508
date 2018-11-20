<%@page
	import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>

<div id="page-wrapper">
	<%@ include file="../includes/alert.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				<i class="fas fa-comments"></i>Comentarios <span
					class="badge badge-secondary">${fn:length(comentarios)}</span>
			</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

	<div class="row">
		<main class="container" role="main">
		<form action="comentarios/aprobar" method="post">

			<table id="listado" class="display">
				<thead>
					<tr>
						<th>Aprobado</th>
						<th>ID</th>
						<th>Fecha</th>
						<th>Comentario</th>
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
							<td class="hover-hand" onclick="showModal('${c.texto}', 'Detalle Comentario' )">${fn:substring(c.texto,0,100)}...</td>
							<td>${c.usuario.nombre}</td>
							<td class="hover-hand" data-toggle="tooltip" data-placement="right" title="${c.video.nombre}">${fn:substring(c.video.nombre,0,25)}...</td>
						</tr>
					</c:forEach>
				</tbody>


			</table>
			<input type="submit" value="Aprobar"
				class="btn-main btn-outline-pika"> <a href=""
				class="btn-main btn-outline-pika-red">Eliminar</a>
		</form>
		</main>

<%@ include file="../includes/footer.jsp"%>