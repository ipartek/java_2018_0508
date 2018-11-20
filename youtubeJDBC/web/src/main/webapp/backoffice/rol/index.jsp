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
				      			<a href="<%=request.getContextPath()%>/backoffice/rol?view=form&op=4" class="btn btn-success">Crear Nuevo</a>
				      		</div>	
                        </div>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                        <%@ include file="../includes/optionsRol.jsp" %>
                        
                        	<!-- VISTA LISTA -->                   	                      	
                        	<c:if test="${view == 'tree'}">
	                            <table width="100%" class="userDataTable table table-striped table-bordered table-hover " id="userDataTable">
	                                <thead>
	                                    <tr>
	                                    	<th>Id</th>
	                                        <th>rol</th>
	                                       <!--  <th>Contraseña</th> -->
	                                        
	                                        
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                	<c:forEach items="${roles}" var="r">
		                                    <tr class="odd gradeX">
		                                    	<td><a href="<%=request.getContextPath()%>/backoffice/rol?id=${r.id }&op=4">${r.id }</a></td>
		                                        <td>${r.nombre }</td>
		                                        <%-- <td>${u.pass }</td> --%>
		                                       <%-- 	<td>${(r.rol == 1)?'normal':'administrador' }</td> --%>
		                                    </tr>
	                                    </c:forEach>
	                                   
	                                </tbody>
	                            </table>      
                            </c:if>
                            <!-- VISTA KANBAN --> 
                            <c:if test="${view == 'kanban'}">
                            	<div class="contenedor-cartas">
                            		<c:forEach items="${roles}" var="r">
                            		
	                            		<div class="card" style="width: 18rem;">
											  <img class="card-img-top" src="https://static.thenounproject.com/png/17241-200.png" alt="Card image cap">
											  <div class="card-body">
											     <ul class="list-group list-group-flush">
												    <li class="list-group-item">Nombre : ${ r.nombre}</li>
												   
												  </ul>
											    <a href="#" class="btn btn-primary">Editar</a>
											  </div>
										</div>
									</c:forEach>
								</div>                            	
                            </c:if>
                            <!-- VISTA FORMULARIO --> 
                            <c:if test="${view == 'form'}">
                            	Vista formulario
                            	 <div class="${alerta.tipo }">
									${alerta.texto }
								</div>
                            	<div class="row">
	                            	<form action="<%=request.getContextPath()%>/backoffice/rol" method="post">
			                            	<div class="col-lg-12">
			                            		
			                            		<h1 class="page-header">${rolSeleccionado.id  == -1?'crear Usuario' : rolSeleccionado.nombre }</h1>
			                            		<!-- PAGINACION -->
												<%-- <ul class="pagination">
												  <li><a href="usuario?accion=menos&usuarioId=${usuarioSeleccionado.id }">&laquo;</a></li>
												  <li><a href="usuario?accion=mas&usuarioId=${usuarioSeleccionado.id }">&raquo;</a></li>
												</ul> --%>
												<div class="form-group">
				                            		
				                            		<input name="op" type="hidden" value="2"   placeholder="operacion">
			                            		</div>
			                            		<div class="form-group">
				                            		
				                            		<input name="id" type="hidden" value="${rolSeleccionado.id }"  readonly placeholder="numero de id">
			                            		</div>
			                            		<div class="form-group">
				                            		<label for="nombreRol">Rol</label>
				                            		<input type="text" name="nombre" value="${rolSeleccionado.nombre }"  placeholder="nombre de rol" autofocus>
				                            	</div>
				                            	
				                            	
			                            	</div>
		                            	</div>
                            			<!-- TODO MIRAR PORQUE NO COJE EL CAMBIO DE VALUE-->
                            			<%-- <input type="submit" value="${usuario.id == -1 ?'Crear' : 'Modificar' }" class="btn btn-primary btn-block"> --%>
	                            		<input type="submit" value="${(empty rolSeleccionado.id )?'Crear': 'Modificar' }" class="btn btn-primary btn-block">
	                            		<c:if test="${not empty rolSeleccionado.id}">
						      				<a href="<%=request.getContextPath()%>/backoffice/rol?id=${rolSeleccionado.id}&op=<%=BackofficeUsuarioControllerPuente.OP_ELIMINAR%>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
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
