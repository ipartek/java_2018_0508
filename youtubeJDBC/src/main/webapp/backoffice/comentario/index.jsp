<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeUsuarioControllerPuente"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeRolController"%>
<%@ include file="../includes/header.jsp" %>	

<%@ include file="../includes/nav.jsp"  %>



<div id="page-wrapper">	
 <!-- /.row -->

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            DataTables Advanced Tables
                        </div>
                        <div class="row">
                        	<div class="col-md-6" style="border:1px solid black">
                        	</div>
                        	<div class="col-md-6" style="border:1px solid black">
                        	</div>
                        </div>
                        <div class="row">
                        	<div class="col-md-8">
                        	<form action="/backoffice/rol" class="form-inline">
							  <div class="form-group">
							    <label class="sr-only" for="exampleInputAmount"></label>
							    <div class="input-group">
							      <div class="input-group-addon"><i class="fas fa-search "></i></div>
							      <input type="text" class="form-control" id="exampleInputAmount" placeholder="Busqueda">
							      <!-- <div class="input-group-addon">.00</div> -->
							    </div>
							  </div>
							  <button type="submit" class="btn btn-primary">Buscar</button>
							</form>
				      		</div>
				      		<div class="col-md-4">
				      			<a href="<%=request.getContextPath()%>/backoffice/comentario?vista=form-comentario&op=4" class="btn btn-success">Crear Nuevo</a>
				      		</div>	
                        </div>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                        <%@ include file="../includes/optionsComentario.jsp" %>
                        	<a href="<%=request.getContextPath()%>/backoffice/comentario/aprobar" type="submit" class="badge badge-info">Pendientes de aprobar</a>
                        	<!-- VISTA LISTA -->                   	                      	
                        	<c:if test="${vista == 'lista-comentario'}">
	                            <table width="100%" class="userDataTable table table-striped table-bordered table-hover " id="userDataTable">
	                                <thead>
	                                    <tr>
	                                    	<th>Id</th>
	                                        <th>Fecha</th>
	                                        <th>Texto</th>
	                                        <th>Aprobado</th>
	                                        <th>Video</th>
	                                        <th>Usuario</th>
	                                       
	                                        
	                                        
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                	<c:forEach items="${comentarios}" var="c">
		                                    <tr class="odd gradeX">
		                                    	<td><a href="<%=request.getContextPath()%>/backoffice/comentario?id=${c.id }&op=4">${c.id }</a></td>
		                                    	<td>${c.fecha }</td>
		                                        <td>${c.texto }</td>
		                                        <td>${c.aprobado == false ? 'NO' : 'SI' }</td>
		                                        <td><a href="<%=request.getContextPath()%>/backoffice/comentario?videoId=${c.video.id }&op=4">${c.video.nombre }</a></td>
		                                        <td><a href="<%=request.getContextPath()%>/backoffice/comentario?usuarioId=${c.usuario.id }&op=4">${c.usuario.nombre }</a></td>
		                                        
		                                        <%-- <td>${u.pass }</td> --%>
		                                       <%-- 	<td>${(r.rol == 1)?'normal':'administrador' }</td> --%>
		                                    </tr>
	                                    </c:forEach>
	                                   
	                                </tbody>
	                            </table>      
                            </c:if>
                            <!-- VISTA KANBAN --> 
                            <c:if test="${vista == 'kanban-formulario'}">
                            	<div class="contenedor-cartas">
                            		<c:forEach items="${comentarios}" var="c">
                            		
	                            		<div class="card" style="width: 18rem;">
											  <img class="card-img-top" src="https://static.thenounproject.com/png/17241-200.png" alt="Card image cap">
											  <div class="card-body">
											     <ul class="list-group list-group-flush">
												    <li class="list-group-item">Nombre : ${ c.texto}</li>
												   
												  </ul>
											    <a href="#" class="btn btn-primary">Editar</a>
											  </div>
										</div>
									</c:forEach>
								</div>                            	
                            </c:if>
                            <!-- VISTA FORMULARIO --> 
                            <c:if test="${vista == 'form-comentario'}">
                            	Vista formulario
                            	 <div class="${alerta.tipo }">
									${alerta.texto }
								</div>
                            	<div class="row">
	                            	<form action="<%=request.getContextPath()%>/backoffice/comentario" method="post">
			                            	<div class="col-lg-12">
			                            		
			                            		<h1 class="page-header">${comentarioSeleccionado.id  == -1?'crear Usuario' : comentarioSeleccionado.texto }</h1>
			                            		<!-- PAGINACION -->
												<ul class="pagination">
												  <li><a href="usuario?accion=menos&usuarioId=${comentarioSeleccionado.id }">&laquo;</a></li>
												  <li><a href="usuario?accion=mas&usuarioId=${comentarioSeleccionado.id }">&raquo;</a></li>
												</ul>
												<div class="form-group">
				                            		
				                            		<input name="op" type="hidden" value="2"   placeholder="operacion">
			                            		</div>
			                            		<div class="form-group">
				                            		
				                            		<input name="id" type="hidden" value="${comentarioSeleccionado.id }"  readonly placeholder="numero de id">
			                            		</div>
			                            		<div class="form-group">
				                            		<label for="texto">texto</label>
	                            		   	 		<textarea class="form-control" value="${comentarioSeleccionado.texto }" name="texto" rows="5" cols="70" placeholder="Danos tu opinión..." required>${comentarioSeleccionado.texto }</textarea>				                            		
				                            	</div>
				                            	<div class="form-group">
				                            		<label for="fecha">Fecha publicación</label>
 														<input type="date" name="fecha">
 													<label for="aprobado">¿Aprobado?</label>
 														<input type="checkbox">
 												</div>
				                            	<div class="form-group">
				                            		<label for="usuarioId">Usuario</label>
				                            		 <select name="usuarioId" class="form-control">
												   		<c:forEach items="${usuarios}" var="u">						  												   				
												   				<option value="${u.id }"  ${comentarioSeleccionado.usuario.id  == u.id ? 'selected':''} >${u.nombre}</option>										   			
												   		</c:forEach>
												   </select>
												   <label for="videoId">Video</label>
				                            		 <select name="videoId" class="form-control">
												   		<c:forEach items="${videos}" var="v">						  												   				
												   				<option value="${v.id }"  ${comentarioSeleccionado.video.id  == v.id ? 'selected':''} >${v.nombre}</option>										   			
												   		</c:forEach>
												   </select>
				                            	</div> 
				                            	
				                            	
				                            	
				                            	
			                            	</div>
		                            	</div>
                            			<!-- TODO MIRAR PORQUE NO COJE EL CAMBIO DE VALUE-->
                            			<%-- <input type="submit" value="${usuario.id == -1 ?'Crear' : 'Modificar' }" class="btn btn-primary btn-block"> --%>
	                            		<input type="submit" value="${(empty comentarioSeleccionado.id )?'Crear': 'Modificar' }" class="btn btn-primary btn-block">
	                            		<c:if test="${not empty comentarioSeleccionado.id}">
						      				<a href="<%=request.getContextPath()%>/backoffice/comentario?id=${comentarioSeleccionado.id}&op=<%=BackofficeUsuarioControllerPuente.OP_ELIMINAR%>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
						      			</c:if>	
	                            	</form>
	                            	<script>
	                            	/*pasamos event desde la funcion y con esto nos evitamos un modal a la hora de 
	                            	confirmar/noconfirmar accion de registro
	                            	*/
	                            		function confirmar(event){
	                            			
	                            			if(confirm('Estas seguro de querer eliminar')){
	                            				console.log("Confirmado eliminar");
	                            			}else{
	                            				//previene el evento
	                            				event.preventDefault():
	                            			}
	                            		}
	                            	</script>
                            	</div>
                            	
                            	
                            </c:if>
                            <div class="well">
                                <h4>DataTables Usage Information</h4>
                                <p>DataTables is a very flexible, advanced tables plugin for jQuery. In SB Admin, we are using a specialized version of DataTables built for Bootstrap 3. We have also customized the table headings to use Font Awesome icons in place of images. For complete documentation on DataTables, visit their website at <a target="_blank" href="https://datatables.net/">https://datatables.net/</a>.</p>
                                <a class="btn btn-default btn-lg btn-block" target="_blank" href="https://datatables.net/">View DataTables Documentation</a>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
</div>
<%@ include file="../includes/footer.jsp"  %>
