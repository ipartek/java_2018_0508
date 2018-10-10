<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page import="com.ipartek.formacion.youtube.pojo.Video"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>   
<%@include file="../includes/nav.jsp" %>   


 	<div id="page-wrapper" class="contenedor">
 	  
	<%@include file="../includes/alert.jsp" %> 
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${(video.id == -1)? 'Crear Video' : video.nombre }</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
	
		<div class="row">
		${video }
			<form action="videos" method="post">
				
				<div class="form-group">
					<label for="id">ID:</label>
					<input type="text" class="form-control" id="id" name="id" value="${video.id }" readonly />
				</div>
				
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" class="form-control" id="nombre" name="nombre" value="${video.nombre }" autofocus />
				</div>
				
				<div class="form-group">
					<label for="cod">Código:</label>
					<input type="text" class="form-control" id="cod" name="cod" value="${video.codigo }" />
				</div>
				
				<div class="form-group">
					<label for="usuario">Usuario:</label>
					<select id="usuario" name="usuario" class="form-control">
						<c:forEach items = "${usuarios}" var = "u">
							<option value="${u.id }" ${(u.id == video.usuario.id)? 'selected' : '' }>${u.nombre }</option>
						</c:forEach>
					</select>
				</div>
				
				<input type="hidden" name="op" value="<%=CrudControllable.OP_GUARDAR %>" />
				
				<input type="submit" value="${(video.id == -1)? 'Crear' : 'Modificar'}" class="btn btn-danger btn-block" />
			
				<c:if test="${video.id > 0}">
					<a href="videos?id=${video.id}&op=<%=CrudControllable.OP_ELIMINAR %>" onclick="confirmar(event)" class="btn eliminarVideo btn-block">Eliminar</a>				
				</c:if>
			
			</form>
		
		</div>
		
	</div>
<%@include file="../includes/footer.jsp"%>