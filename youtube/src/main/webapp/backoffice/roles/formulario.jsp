<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeRolController"%>
<%@ page import="com.ipartek.formacion.youtube.pojo.Rol"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>   
<%@include file="../includes/nav.jsp" %>   


 	<div id="page-wrapper" class="contenedor">
 	  
	<%@include file="../includes/alert.jsp" %> 
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${(rol.id == -1)? 'Crear rol' : rol.nombre }</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
	
		<div class="row">
		${rol }
			<form action="roles" method="post">
				
				<div class="form-group">
					<label for="id">ID:</label>
					<input type="text" class="form-control" id="id" name="id" value="${rol.id }" readonly />
				</div>
				
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" class="form-control" id="nombre" name="nombre" value="${rol.nombre }" autofocus />
				</div>
				
				<input type="hidden" name="op" value="${BackofficeRolController.OP_GUARDAR}" />
				
				<input type="submit" value="${(rol.id == -1)? 'Crear' : 'Modificar' }" class="btn btn-success btn-block" />
			
				<c:if test="${rol.id >= 0 }">
					<a href="roles?id=${rol.id}&op=${BackofficeRolController.OP_ELIMINAR}" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar</a>				
				</c:if>
			
			</form>
		
		</div>
		
	</div>
<%@include file="../includes/footer.jsp"%>