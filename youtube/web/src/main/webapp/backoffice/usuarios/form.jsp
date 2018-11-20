<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeUsuarioController"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<div id="page-wrapper">
<%@ include file="../includes/alert.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">${(usuario.id==-1)?'Crear usuario': usuario.nombre }</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<div class="row">
	${usuario }
		<form action="usuarios" method="post">
			<div class="form-group">
				<label for="id" class="required">Id</label>
				<input type="text" class="form-control" name="id" id="id" readonly value="${usuario.id }"/>
			</div>
			<div class="form-group">
				<label for="nombre" class="required">Nombre</label>
				<input type="text" class="form-control" name="nombre"  id="nombre" value="${usuario.nombre}" autofocus />
			</div>
			<div class="form-group">
				<label for="password" class="required">Contraseña</label>
				<div class="input-group">
      		<div class="input-group-addon"><i class="fas fa-eye" onclick="showpass(event, 'password')"></i></div>
				<input type="password" class="form-control" name="password" id="password" value="${usuario.password}" />
			</div>
			</div>
			<div class="form-group">
				<label for="rol">Rol</label>
				
				<select name="rol" class="form-control">
					<c:forEach items="${roles}" var="rol">
					<option value="${rol.id}"${(rol.id==usuario.rol.id)?'selected':''}>${rol.nombre}</option>
					</c:forEach>
				</select>
			</div>
			<input type="hidden" name="op" value="<%=CrudControllable.OP_GUARDAR%>">
			<input type="submit"
				value="${(usuario.id==-1)?'Crear usuario': 'Modificar usuario' }"
				class="btn btn-primary btn-block">
			<c:if test="${usuario.id > 0}">
      				<a href="usuarios?id=${usuario.id}&op=<%=CrudControllable.OP_ELIMINAR %>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
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
