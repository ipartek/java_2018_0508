<!-- Formulario de Usuarios -->

<%@page import="com.adriana.prado.pojo.Usuario"%>
<%@include file="../includes/taglibs.jsp"%>

<%@include file="../includes/header.jsp"%>

<!-- Listado de Usuarios -->

 <div id="wrapper">

		<%@include file="../includes/aside.jsp"%>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${(usuario.id==-1)?'Crear Usuario':usuario.nombre}</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Formulario de gestión de usuarios
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <form action="" method="post">
                            
                            	<div class="form-row">
                            		<div class="col">
										<div class="form-group col-md-6">
										   <label for="id">ID de usuario: </label>
										   <input readonly="readonly" class="form-control" type="text" name="id" id="id" value="${(usuario.id==-1)?'':usuario.id}">
									   </div>
									</div>
									<div class="col">
										<div class="form-group col-md-6">
										   <label class="required" for="nombre">Nombre de usuario: </label>
										   <input class="form-control" type="text" name="nombre" id="nombre" placeholder="Mínimo 3 caracteres y máximo 10" minlength="3" maxlength="10" autofocus tabindex="1" required
										   value="${(usuario.id==-1)?'':usuario.nombre}">
									   </div>
									</div>
								</div>
								
								<div class="form-row">
                            		<div class="col">
										<div class="form-group col-md-6">
										   <label for="contrasena">Contraseña: </label>
										   <input class="form-control" type="password" name="contrasena" id="contrasena" placeholder="Mínimo 3 caracteres y máximo 10" minlength="3" maxlength="10" tabindex="2" required
										   value="${(usuario.id==-1)?'':usuario.contrasena}">
									   </div>
									</div>
									<div class="col">
										<div class="form-group col-md-6">
										   <label class="required" for="rol">Rol: </label>
										   <select class="form-control" required name="rol" id="rol">
											   <option value="${Usuario.ROL_USER}" ${(usuario.rol==1)?'selected':''}>Usuario Normal</option>
											   <option value="${Usuario.ROL_ADMIN}" ${(usuario.rol==0)?'selected':''}>Administrador</option>
										   </select>
										</div>
									</div>
								</div>
                            	
                            	<input type="submit" value="${(usuario.id==-1)?'Crear':'Modificar'}" class="form-control btn btn-primary btn-block" />
                            	<c:if test="${usuario.id >0 }">
                            		<a href="usuarios?id=${usuario.id}&op=2" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
                            	</c:if>
                            </form>
                            
                            <script>
                            	function confirmar(e){
                            		if(confirm('¿Estás seguro de que quieres eliminar?')){
                            			console.log('Pulsado eliminar');
                            		}else{
                            			//Prevenir el evento por defecto del enlace
                            			e.preventDefault();
                            		}
                            	}
                            </script>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->

<%@include file="../includes/footer.jsp"%>