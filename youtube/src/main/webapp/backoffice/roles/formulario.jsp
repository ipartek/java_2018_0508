<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeUsuarioController"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>

<div id="page-wrapper">
<%@ include file="../includes/alerts.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${(rol.id == -1)?'Crear Usuario': rol.nombre }</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
            	<div class="col-md-2"></div>
            	<div class="col-md-8 justify-content-center">
	            	<form action="roles" method="post" class="col-3 shadow p-3 mb-5 bg-white rounded">
	            		<div class="form-group">
	            			<label for="id">ID:</label>
	            			<input type="text" name="id" id="id" value="${(rol.id == -1)? -1: rol.id }" placeholder="" class="form-control" readonly>
	            		</div>
	            		
	            		<div class="form-group">
	            			<label for="nombre">Nombre:</label>
	            			<input type="text" name="nombre" id="nombre" value="${(rol.id == -1)? '': rol.nombre }" placeholder="Nombre (min. 3 max. 50 car)" class="form-control" autofocus>
	            		</div>
	            		
	            		<input type="hidden" name="op" value="<%=BackofficeUsuarioController.OP_GUARDAR%>">
	            		<input type="submit" value="${(rol.id == -1)?'Crear': 'Modificar' }" class="btn btn-primary btn-block">
	            		<c:if test="${rol.id > 0}">
	            			<a href="roles?id=${rol.id}&op=<%=BackofficeUsuarioController.OP_ELIMINAR%>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
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