<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeRolController"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Rol"%>
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
                
                	<h1 class="page-header">${(rol.id== -1)?'Crear nuevo rol':rol.nombre } </h1>
					    
                    
                </div>
            </div><!-- /.row -->
            
            <div class="row">
            
            	<form action="roles" method="post">
            	
            	<div class="form-group">
            		<label for="id">ID</label>
					<input type="text" class="form-control" id="id" name="id" value="${rol.id}"readonly>            	
            	
            	</div>
            	
            	<div class="form-group">
            		<label for="nombre">Nombre</label>
					<input type="text" class="form-control" id="nombre" name="nombre" value="${rol.nombre}" autofocus>            	
            	
            	</div>
            	
            	<input type="hidden" name="op" value="${BackofficeRolController.OP_GUARDAR}"/>
            	<input type="submit" value="${(rol.id== -1)?'Crear':'Modificar' }" class="btn btn-primary btn-block">
            	<c:if test="${rol.id>0}">
            		<a href="roles?id=${rol.id}&op=<%=BackofficeRolController.OP_ELIMINAR%>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(confirmar)</a>
            	</c:if>
            	</form>
            
            </div>
            
                
 </div><!-- /#page-wrapper -->
            

<%@ include file="../includes/footer.jsp" %>