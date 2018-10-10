<!-- Formulario de Usuarios -->

<%@page import="com.ipartek.formacion.controller.back.BackofficeUsuarioController"%>
<%@page import="com.ipartek.formacion.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.pojo.Rol"%>
<%@include file="../includes/taglibs.jsp"%>

<%@include file="../includes/header.jsp"%>

<!-- Listado de Usuarios -->

 <div id="wrapper">

		<%@include file="../includes/aside.jsp"%>

        <div id="page-wrapper">
        
        	<%@include file="../includes/alerts.jsp"%>
        	
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${(usuario.id==-1)?'Crear Usuario':usuario.nombre}</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default panel-tabla">
                        <div class="panel-heading">
                            Formulario de gestión de usuarios
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <form novalidate="novalidate" action="usuarios?op=${BackofficeUsuarioController.OP_GUARDAR}" method="post">
                            
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
										   <input  class="form-control" type="text" name="nombre" id="nombre" placeholder="Mínimo 3 caracteres y máximo 10" autofocus tabindex="1" required
										   value="${usuario.nombre}">
									   </div>
									</div>
								</div>
								
								<div class="form-row">
                            		<div class="col">
										<div class="form-group col-md-6">
											<label for="contrasena">Contraseña: </label>
										   	<div class="input-group">
										  		<input class="form-control" type="password" name="contrasena" id="contrasena" placeholder="Mínimo 3 caracteres y máximo 10" tabindex="2" required
										  	 	value="${usuario.contrasena}">
										  		<span class="input-group-addon" id="basic-addon2" ><i id="eye" class="fas fa-eye" onclick="mostrar('contrasena')"></i></span>
											</div>
									   </div>
									   
									</div>
									<div class="col">
										<div class="form-group col-md-6">
										   <label class="required" for="rol">Rol: </label>
										   <select class="form-control" required name="rol" id="rol">
												<c:forEach items="${roles}" var="r">
													<option value="${r.id}" ${(usuario.rol.id==r.id)?'selected':''}>${r.nombre}</option>
												</c:forEach>
<%-- 											   <option value="${Usuario.ROL_USER}" ${(usuario.rol==Usuario.ROL_USER)?'selected':''}>Usuario Normal</option> --%>
<%-- 											   <option value="${Usuario.ROL_ADMIN}" ${(usuario.rol==Usuario.ROL_ADMIN)?'selected':''}>Administrador</option> --%>
											</select>
										</div>
									</div>
								</div>
                            	
                            	<input type="submit" value="${(usuario.id==-1)?'Crear':'Modificar'}" class="form-control btn btn-primary btn-block" />
                            	<c:if test="${usuario.id >0 }">
                            		<a href="usuarios?id=${usuario.id}&op=${BackofficeUsuarioController.OP_ELIMINAR}" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar</a>
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
                            
                            <script>
                            	function mostrar(contrasena){
                            		var pswd = document.getElementById(contrasena);
                            		var eye =  document.getElementById('eye');
                            		if(pswd.type == "text"){
                            			pswd.type = "password";
                            				eye.classList.replace("fa-eye","fa-eye-slash");
                            		}else{
                            			pswd.type = "text";
                            			eye.classList.replace("fa-eye-slash","fa-eye");
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