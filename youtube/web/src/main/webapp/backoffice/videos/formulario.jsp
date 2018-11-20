<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeVideoController"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>

<div id="page-wrapper">
<%@ include file="../includes/alerts.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${(video.id == -1)?'Crear Video': video.nombre }</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
            	<div class="col-md-2"></div>
            	<div class="col-md-8 justify-content-center">
	            	<form action="videos" method="post" class="col-3 shadow p-3 mb-5 bg-white rounded">
	            		<div class="form-group">
	            			<label for="id">ID:</label>
	            			<input type="text" name="id" id="id" value="${(video.id == -1)? -1: video.id }" placeholder="" class="form-control" readonly>
	            		</div>
	            		
	            		<div class="form-group">
	            			<label for="codigo">Codigo:</label>
	            			<input type="text" name="codigo" id="codigo" value="${(video.id == -1)? '': video.codigo }" placeholder="Codigo (11 car)" class="form-control" autofocus>
	            		</div>
	            		
	            		<div class="form-group">
	            			<label for="nombre">Nombre:</label>
	            			<input type="text" name="nombre" id="nombre" value="${(video.id == -1)? '': video.nombre }" placeholder="Nombre (max. 150 car)" class="form-control">
	            		</div>
	            		
	            		<div class="form-group">
		            		<label for="usuario">Usuario propietario:</label>
		            		<select name="usuario" id="usuario" class="form-control">
		            			<c:forEach items="${usuarios}" var="u">
		            				<option value="${u.id}">${u.nombre}</option>
		            			</c:forEach>
		            		</select>
	            		</div>
	            		
	            		<input type="hidden" name="op" value="<%=BackofficeVideoController.OP_GUARDAR%>">
	            		<input type="submit" value="${(video.id == -1)?'Crear': 'Modificar' }" class="btn btn-primary btn-block">
	            		<c:if test="${video.id > 0}">
	            			<a href="videos?id=${video.id}&op=<%=BackofficeVideoController.OP_ELIMINAR%>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar (Modal)</a>
	            		</c:if>
	            	</form>
	            	
	            	<script>
	            		function confirmar(e){
	            			if(confirm('¿Estas seguro que quieres ELIMINAR?')){
	            				console.log('Confirmado eliminar');
	            			}else{
	            				//Prevenir el evento por defecto del enlace
	            				e.preventDefault();
	            			}
	            		}
	            	</script>
	            	
            	</div>
            	<!-- .col-md-8 -->
            	<div class="col-md-2"></div>
            </div>
</div>
<!-- /#page-wrapper -->

<%@include file="../includes/footer.jsp" %>