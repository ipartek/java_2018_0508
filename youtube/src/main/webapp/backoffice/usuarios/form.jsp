<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeUsuarioController"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

<%@ include file="../includes/nav.jsp" %>

<%@ include file="../includes/sidebar.jsp" %>


 <div id="page-wrapper">
 ${sessionScope.alert=null}
 					<c:if test="${not empty alert}">
						<div class="alert ${alert.tipo} alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<strong>${alert.texto}</strong>
						</div>
						${sessionScope.alert=null}
						${alert=null}
					</c:if>
 					
            <div class="row">
                <div class="col-lg-12">
                
                	<h1 class="page-header">${(usuario.id== -1)?'Crear Usuario':usuario.nombre } </h1>
					    
                    
                </div>
            </div><!-- /.row -->
            
            <div class="row">
            
            	<form action="usuarios" method="post">
            	
            	<div class="form-group">
            		<label for="id">ID</label>
					<input type="text" class="form-control" id="id" name="id" value="${usuario.id}" readonly>            	
            	
            	</div>
            	
            	<div class="form-group">
            		<label for="nombre">Nombre</label>
					<input type="text" class="form-control" id="nombre" name="nombre" value="${usuario.nombre}" autofocus>            	
            	
            	</div>
            	
            	
            	<div class="form-group">
            		<label for="pass">Password</label>
					<input type="password" class="form-control" id="pass" name="pass" value="${usuario.pass}">            	
            	
            	</div>
            	
            	
            	<div class="form-group">
            		<label for="rol">Rol</label>
					<select name="rol">
						<option value="${Usuario.ROL_USER}" ${(usuario.rol==Usuario.ROL_USER)?'selected':'' }>Usuario</option>
  						<option value="${Usuario.ROL_ADMIN }"${(usuario.rol==Usuario.ROL_ADMIN)?'selected':''} >Administrador</option>
					
					</select>            	
            	</div>
            	
            	<input type="hidden" name="op" value="${BackofficeUsuarioController.OP_GUARDAR}"/>
            	<input type="submit" value="${(usuario.id== -1)?'Crear':'Modificar' }" class="btn btn-primary btn-block">
            	<c:if test="${usuario.id>0}">
            	
            		<a href="usuarios?id=${usuario.id}&op=<%=BackofficeUsuarioController.OP_ELIMINAR%>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(confirmar)</a>
            	</c:if>
            	</form>
            
            </div>
            
                
 </div><!-- /#page-wrapper -->
            
      
        




























<%@ include file="../includes/footer.jsp" %>