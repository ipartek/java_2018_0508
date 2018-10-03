<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${(usuario.id == -1)?'Crear Usuario': usuario.nombre }</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
            	<div class="col-md-2"></div>
            	<div class="col-md-8 justify-content-center">
	            	<form action="usuarios" method="post" class="col-3 shadow p-3 mb-5 bg-white rounded">
	            		<div class="form-group">
	            			<label for="id">ID:</label>
	            			<input type="text" name="id" id="id" value="${(usuario.id == -1)? -1: usuario.id }" placeholder="" class="form-control" readonly>
	            		</div>
	            		
	            		<div class="form-group">
	            			<label for="nombre">Nombre:</label>
	            			<input type="text" name="nombre" id="nombre" value="${(usuario.id == -1)? '': usuario.nombre }" placeholder="Nombre (min. 3 max. 50 car)" class="form-control" autofocus>
	            		</div>
	            		
	            		<div class="form-group">
	            			<label for="password">Password:</label>
	            			<input type="password" name="password" id="password" value="${(usuario.id == -1)? '': usuario.password }" placeholder="Contraseña (min. 8 max. 20 car)" class="form-control">
	            		</div>
	            		
	            		<div class="form-group">
		            		<label for="rol">Rol:</label>
		            		<select name="rol" id="rol" class="form-control">
		            			<option value="<%=Usuario.ROL_USER%>" ${(usuario.rol == Usuario.ROL_USER)?'selected': '' }>Normal</option>
		            			<option value="<%=Usuario.ROL_ADMIN%>" ${(usuario.rol == Usuario.ROL_ADMIN)?'selected': '' } >Administrador</option>
		            		</select>
	            		</div>
	            		
	            		<input type="submit" value="${(usuario.id == -1)?'Crear': 'Modificar' }" class="btn btn-primary btn-block">
	            		<c:if test="${usuario.id > 0}">
	            			<a href="usuarios?id=${usuario.id}&op=45" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar (Modal)</a>
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