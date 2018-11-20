<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeComentarioController"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Comentario"%>
<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<div id="page-wrapper">
<%@ include file="../includes/alert.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">${(comentario.id==-1)?'Crear comentario': comentario.texto }</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<div class="row">
	${comentario}
		<form action="comentarios" method="post">
			<div class="form-group">
				<label for="id" class="required">Id</label>
				<input type="text" class="form-control" name="id" id="id" readonly value="${comentario.id }"/>
			</div>
			<div class="form-group">
				<label for="texto" class="required">Comentario</label>
				<input type="text" class="form-control" name="texto"  id="texto" value="${comentario.texto}" autofocus />
			</div>
			<div class="form-group">
				<label for="usuario">Usuario</label>
				<input type="text" class="form-control" name="usuario"  id="usuario" value="${comentario.usuario.nombre}" autofocus />
			</div>
			<div class="form-group">
				<label for="aprobado">Aprobado</label>
				<input type="text" class="form-control" name="aprobado"  id="aprobado" value="${(comentario.aprobado)?1: 0 }" autofocus />
			</div>
			<input type="hidden" name="op" value="<%=CrudControllable.OP_GUARDAR%>">
			<input type="submit"
				value="${(comentario.id==-1)?'Crear comentario': 'Modificar comentario' }"
				class="btn btn-primary btn-block">
			<c:if test="${comentario.id > 0}">
      				<a href="comentarios?id=${comentario.id}&op=<%=CrudControllable.OP_ELIMINAR %>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
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
