<%@page import="com.ipartek.formacion.youtube.controller.CrudControllable"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeVideoController"%>
<%@page import="com.ipartek.formacion.youtube.pojo.UsuarioPrivado"%>
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
                
                	<h1 class="page-header">${(video.id== -1)?'Crear video':video.nombre } </h1>
					    
                    
                </div>
            </div><!-- /.row -->
            
            <div class="row">
            
            	<form action="videos" method="post">
            	
            	<div class="form-group">
            		<label for="id">ID</label>
					<input type="text" class="form-control" id="id" name="id" value="${video.id}" readonly>            	
            	
            	</div>
            	
            	
            	<div class="form-group">
            		<label for="codigo">Codigo</label>
					<input type="text" class="form-control" id="codigo" name="codigo" value="${video.codigo}" autofocus maxlength="11" minlength="11">            	
            	
            	</div>
            	
            	<div class="form-group">
            		<label for="nombre">Nombre del video</label>
					<input type="text" class="form-control" id="nombre" name="nombre" value="${video.nombre}" autofocus>            	
            	
            	</div>

            	
            	<div class="form-group">				
				   <label for="usuario">Usuario</label>
				   <select name="usuario" class="form-control">
				   		<c:forEach items="${usuarios}" var="u">
				   			<option value="${u.id}" ${(u.id==video.usuario.id)?'selected':'' }>${u.nombre}</option>

				   		</c:forEach>
				   </select>
				</div>
            	
            	<input type="hidden" name="op" value="<%=CrudControllable.OP_GUARDAR%>"/>
            	<input type="submit" value="${(video.id== -1)?'Crear':'Modificar' }" class="btn btn-primary btn-block">
            	<c:if test="${video.id>0}">
            	
            		<a href="videos?id=${video.id}&op=<%=CrudControllable.OP_ELIMINAR%>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(confirmar)</a>
            	</c:if>
            	</form>
            
            </div>
            
                
 </div><!-- /#page-wrapper -->
            


<%@ include file="../includes/footer.jsp" %>