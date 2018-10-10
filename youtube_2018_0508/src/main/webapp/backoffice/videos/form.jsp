<%@page import="com.andrea.perez.controller.back.BackofficeVideoController"%>
<%@page import="com.andrea.perez.pojo.Video"%>
<%@page import="com.andrea.perez.pojo.Usuario"%>

<%@include file="../includes/header.jsp"%>

<!-- Listado de Videos -->

 <div id="wrapper">

		<%@include file="../includes/aside.jsp"%>

        <div id="page-wrapper">
        
        	<%@include file="../includes/alert.jsp"%>
        	
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${(video.id==-1)?'Crear Vídeo':video.titulo}</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default panel-tabla">
                        <div class="panel-heading">
                            Editar vídeo
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <form action="videos?op=${BackofficeVideoController.OP_GUARDAR}" method="post">
                            
                            	<div class="form-row">
                            		<div class="col">
										<div class="form-group col-md-6">
										   <label for="id">ID del vídeo: </label>
										   <input readonly="readonly" class="form-control" type="text" name="id" id="id" value="${(video.id==-1)?'':video.id}">
									   </div>
									</div>
									<div class="col">
										<div class="form-group col-md-6">
										   <label class="required" for="titulo">Título del vídeo: </label>
										   <input class="form-control" type="text" name="titulo" id="titulo" placeholder="Mínimo 3 caracteres y máximo 150" minlength="3" maxlength="150" autofocus tabindex="1" required
										   value="${(video.id==-1)?'':video.titulo}">
									   </div>
									</div>
								</div>
								
								<div class="form-row">
                            		<div class="col">
										<div class="form-group col-md-6">
										   <label for="codigo">Código del vídeo: </label>
										   <input class="form-control" type="text" name="codigo" id="codigo" placeholder="Deben ser 11 caracteres exactos" minlength="11" maxlength="11" tabindex="2" required
										   value="${(video.id==-1)?'':video.codigo}">
									   </div>
									</div>
									<div class="col">
										<div class="form-group col-md-6">
										   <label class="required" for="rol">Usuario asociado: </label>
										   <select class="form-control" required name="usuario" id="usuario">
												<c:forEach items="${usuarios}" var="u">
													<option value="${u.id}" ${(video.usuario.id==u.id)?'selected':''}>${u.nombre}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								
								<div class="form-row">
									<div class="form-group">
									   <input class="form-control" type="hidden" name="op" id="op" value="${(video.id==-1)?'0':'1'}">
								   </div>
								</div>
                            	
                            	<input type="submit" value="${(video.id==-1)?'Crear':'Modificar'}" class="form-control btn btn-primary btn-block" />
                            	<c:if test="${video.id >0 }">
                            		<a href="videos?id=${video.id}&op=${BackofficeVideoController.OP_ELIMINAR}" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
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