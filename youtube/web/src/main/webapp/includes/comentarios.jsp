<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<div class="card card-outline-secondary my-4">
		<div class="card-header">Comentarios <span class="badge badge-secondary">${fn:length(comentarios)}</span></div>
		<div class="card-body">
		
			<div class="form-comentario">
			
				<c:if test="${not empty sessionScope.usuario}">
					<p><b class="text-warning">${sessionScope.usuario.nombre}</b> queremos saber que opinas de este video.</p>
				</c:if>
				
				<c:if test="${empty sessionScope.usuario}">
					<p class="text-danger"><i>* Para poder comentar debes iniciar sesión</i></p>
				</c:if>
			
				<form action="publicar" method="post" class="form-inline d-flex align-items-stretch">
					<textarea class="form-control" name="texto" rows="5" placeholder="Danos tu opinión..." required ${(empty sessionScope.usuario)?'disabled' : '' }></textarea>
					<input type="hidden" name="id_video" value="${videoInicio.id}" />
					<input type="submit" class="form-control ml-auto btn btn-outline-primary" value="Comentar" ${(empty sessionScope.usuario)?'disabled':'' } />
				</form>
			</div>
			
			<hr>
			
			<c:forEach items="${comentarios}" var="c">
		
				<p class="comentario-publico">${c.texto}</p>
				<hr>
				<small class="text-muted row justify-content-between detalleComentario"><b>${c.usuario.nombre}</b> <span><fmt:formatDate value="${c.fecha}" pattern="dd/MM/yyyy HH:mm"/></span></small>
				
				<hr>
				
			</c:forEach>
		</div>
	</div>
<!-- /.card -->