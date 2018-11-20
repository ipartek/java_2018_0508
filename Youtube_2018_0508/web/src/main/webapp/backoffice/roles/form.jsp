<!-- Formulario de Roles -->

<%@include file="../includes/taglibs.jsp"%>

<%@page import="com.ipartek.formacion.controller.back.BackofficeRolController"%>

<%@include file="../includes/header.jsp"%>

<!-- Listado de Roles -->

 <div id="wrapper">

		<%@include file="../includes/aside.jsp"%>

        <div id="page-wrapper">
        
        	<%@include file="../includes/alerts.jsp"%>
        	
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${(rol.id==-1)?'Crear Rol':rol.nombre}</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default panel-tabla">
                        <div class="panel-heading">
                            Formulario de gestión de roles
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <form novalidate="novalidate" action="roles?op=${BackofficeRolController.OP_GUARDAR}" method="post">
                            
                            	<div class="form-row">
                            		<div class="col">
										<div class="form-group col-md-6">
										   <label for="id">ID del rol: </label>
										   <input readonly="readonly" class="form-control" type="text" name="id" id="id" value="${(rol.id==-1)?'':rol.id}">
									   </div>
									</div>
									<div class="col">
										<div class="form-group col-md-6">
										   <label class="required" for="nombre">Nombre del rol: </label>
										   <input  class="form-control" type="text" name="nombre" id="nombre" placeholder="Mínimo 3 caracteres y máximo 10" autofocus tabindex="1" required
										   value="${rol.nombre}">
									   </div>
									</div>
								</div>
                            	
                            	<input type="submit" value="${(rol.id==-1)?'Crear':'Modificar'}" class="form-control btn btn-primary btn-block" />
                            	<c:if test="${rol.id >0 }">
                            		<a href="roles?id=${rol.id}&op=${BackofficeRolController.OP_ELIMINAR}" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar</a>
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