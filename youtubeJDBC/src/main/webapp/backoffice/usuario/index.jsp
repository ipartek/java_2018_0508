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
				      			TODO BUSCADOR con su lupita toda txula
				      		</div>
				      		<div class="col-md-4">
				      			<a href="<%=request.getContextPath()%>/backoffice/usuario?view=form" class="btn btn-success">Crear Nuevo</a>
				      		</div>	
                        </div>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">   
                        <%@ include file="../includes/optionsUsuario.jsp" %> 
                        	<!-- VISTA LISTA -->                   	                      	
                        	<c:if test="${view == 'tree'}">
	                            <table width="100%" class="userDataTable table table-striped table-bordered table-hover " id="userDataTable">
	                                <thead>
	                                    <tr>
	                                    	<th>Id</th>
	                                        <th>Nombre</th>
	                                        <th>Contraseña</th>
	                                        <th>Rol</th>
	                                        
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                	<c:forEach items="${usuarios}" var="u">
		                                    <tr class="odd gradeX">
		                                    	<td><a href="<%=request.getContextPath()%>/backoffice/usuario?id=${u.id }">${u.id }</a></td>
		                                        <td>${u.nombre }</td>
		                                        <td>${u.pass }</td>
		                                       	<td>${(u.rol == 1)?'normal':'administrador' }</td>
		                                    </tr>
	                                    </c:forEach>
	                                   
	                                </tbody>
	                            </table>      
                            </c:if>
                            <!-- VISTA KANBAN --> 
                            <c:if test="${view == 'kanban'}">
                            	<div class="contenedor-cartas">
                            		<c:forEach items="${usuarios}" var="u">
                            		
	                            		<div class="card" style="width: 18rem;">
											  <img class="card-img-top" src="https://static.thenounproject.com/png/17241-200.png" alt="Card image cap">
											  <div class="card-body">
											     <ul class="list-group list-group-flush">
												    <li class="list-group-item">Nombre : ${ u.nombre}</li>
												    <li class="list-group-item">Contraseña : ${ u.pass} </li>
												    <li class="list-group-item">Rol : ${ u.rol}</li>
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
                            	
                            	<div class="row">
	                            	<form action="usuario" method="post">
	                            	<div class="col-lg-12">
	                            		
	                            		<h1 class="page-header"><${usuarioSeleccionado.id == -1?'crear Usuario' : usuarioSeleccionado.nombre }</h1>
<!-- 	                            		<div class="form-group">
		                            		<label for="id">id</label>
		                            		<input name="id" type="text"  readonly placeholder="numero de id">
	                            		</div> -->
	                            		<div class="form-group">
		                            		<label for="nombreUsuario">Nombre</label>
		                            		<input type="text" name="nombreUsuario" value="${usuarioSeleccionado.nombre }" placeholder="nombre de usuario" autofocus>
		                            	</div>
		                            	<div class="form-group">
		                            		<label for="nombreUsuario">Contraseña</label>
		                            		<input type="password" name="passwordUsuario" value="${usuarioSeleccionado.pass }" placeholder ="password">
		                            	</div>
<%-- 		                            	<div class="form-group">
		                            		<label for="nombreUsuario">Rol</label>
		                            		<select name="rol" class="form-control">
		                            			<option value="${usuario.ROL_USER }">NORMAL</option>
		                            			<option value="${usuario.ROL_ADMIN }">ADMINISTRADOR</option>		
		                            		</select>
		                            	</div> --%>
	                            	</div>
                            	</div>
                            	
	                            		<input type="submit" value="${usuario.id == 1?'Crear' : 'Modificar' }" class="btn btn-primary btn-block">
	                            		<c:if test="${usuario.id == 0 }">
	                            			<a href="usuario" onclick="confirmar(event)" class="btn btn-danger btn-block">Elmiminar modal</a>
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
