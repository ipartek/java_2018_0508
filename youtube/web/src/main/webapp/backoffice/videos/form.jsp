<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Rol"%>
<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<div id="page-wrapper">
<%@ include file="../includes/alert.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">${(video.id==-1)?'Crear video': video.nombre }</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<div class="row">
	${videos}
		<form action="videos" method="post">
			<div class="form-group">
				<label for="id" class="required">Id</label>
				<input type="text" class="form-control" name="id" id="id" readonly value="${video.id }"/>
			</div>
			<div class="form-group">
				<label for="codigo" class="required">Codigo</label>
				<input type="text" class="form-control" name="codigo"  id="codigo" value="${video.codigo}" autofocus />
			</div>
			<div class="form-group">
				<label for="nombre" class="required">Nombre</label>
				<input type="text" class="form-control" name="nombre"  id="nombre" value="${video.nombre}" autofocus />
			</div>

			
			<div class="form-group">
				<label for="usuario">Usuario</label>
					<select name="usuario" class="form-control">
					<c:forEach items="${usuarios}" var="u">
					<option value="${u.id}"${(u.id==video.usuario.id)?'selected':''}>${u.nombre}</option>
					</c:forEach>
				</select>
			</div>
			<input type="hidden" name="op" value="<%=CrudControllable.OP_GUARDAR%>">
			<input type="submit"
				value="${(video.id==-1)?'Crear video': 'Modificar video' }"
				class="btn btn-primary btn-block">
			<c:if test="${video.id > 0}">
      				<a href="videos?id=${video.id}&op=<%=CrudControllable.OP_ELIMINAR %>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
			</c:if>
		</form>
		
		<script>
			function confirmar(e){
				if(confirm('¿Estas seguro de que deseas ELIMINAR?')){
					console.log('confirmado eliminar');
				}else{
					//prevenir el evento por defecto del enlace
					e.preventDefault();
				}
			}
		</script>
	</div>



</div>
<%@ include file="../includes/footer.jsp"%>
