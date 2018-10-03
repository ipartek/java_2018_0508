<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>   
<%@include file="../includes/nav.jsp" %>   


 	<div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${(usuario.id == -1)? 'Crear usuario' : usuario.nombre }</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
	
		<div class="row">
		${usuario }
			<form action="usuarios" method="post">
				
				<div class="form-group">
					<label for="id">ID:</label>
					<input type="text" class="form-control" id="id" name="id" value="${usuario.id }" readonly />
				</div>
				
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" class="form-control" id="nombre" name="nombre" value="${usuario.nombre }" autofocus />
				</div>
				
				<div class="form-group">
					<label for="pass">Contraseña:</label>
					<input type="password" class="form-control" id="pass" name="pass" value="${usuario.pass }" />
				</div>
				
				<div class="form-group">
					<label for="rol">Rol:</label>
					<select id="rol" name="rol" class="form-control">
						<option value="${Usuario.ROL_USER }">Normal</option>
						<option value="${Usuario.ROL_ADMIN }"  ${(usuario.rol == 0)?'selected' : ''}>Administrador</option>
					</select>
				</div>
				
				<input type="submit" value="${(usuario.id == -1)? 'Crear' : 'Modificar' }" class="btn btn-primary btn-block" />
			
				<c:if test="${usuario.id > 0 }">
					<a href="usuarios?id=${usuario.id}&op=2" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar</a>				
				</c:if>
			
			</form>
		
		</div>
		
	</div>
<%@include file="../includes/footer.jsp"%>