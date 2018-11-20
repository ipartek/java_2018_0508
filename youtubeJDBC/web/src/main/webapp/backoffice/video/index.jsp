<%@page import="com.ipartek.formacion.youtube.controller.back.*"%>
<%@page import="com.ipartek.formacion.youtube.pojo.*"%>
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
				      			<form action="/backoffice/video" class="form-inline">
								  <div class="form-group">
								    <label class="sr-only" for="exampleInputAmount"></label>
								    <div class="input-group">

								      <input type="text" class="form-control" id="exampleInputAmount" placeholder="Busqueda">
								      <!-- <div class="input-group-addon">.00</div> -->
								    </div>
								  </div>
								  <button type="submit" class="btn btn-primary"><i class="fas fa-search "></i></button>
								</form>
				      		</div>
				      		<div class="col-md-4">
				      			<a href="<%=request.getContextPath()%>/backoffice/video?view=form&op=4" class="btn btn-success">Crear Nuevo</a>
				      		</div>	
                        </div>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">   
                        <%@ include file="../includes/optionsVideo.jsp" %> 
                        	<!-- VISTA LISTA -->                   	                      	
                        	<c:if test="${vista == 'lista-video'}">
                        		${videos}
	                            <table width="100%" class="userDataTable table table-striped table-bordered table-hover " id="userDataTable">
	                                <thead>
	                                    <tr>
	                                    	<th>Id</th>
	                                        <th>codigo</th>
	                                        <th>nombre</th> 
	                                        <th>imagen</th>
	                                        <th>subir por</th>
	                                        
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                	<c:forEach items="${videos}" var="v">
		                                    <tr class="odd gradeX">
		                                    	<td><a href="<%=request.getContextPath()%>/backoffice/video?videoId=${v.id }&op=4">${v.id }</a></td>
		                                        <td>${v.codigo }</td>
		                                        <td>${v.nombre }</td>
		                                        <th><img class="thumbnail" src="http://img.youtube.com/vi/${v.codigo }/0.jpg" alt="Imagen por defecto"/></th>
		                                        <td>${v.usuario.nombre	 }</td><!--  -->
		                                        
		                                    </tr>
	                                    </c:forEach>
	                                   
	                                </tbody>
	                            </table>      
                            </c:if>
                            <!-- VISTA KANBAN --> 
                            <c:if test="${vista == 'kanban-video'}">
                            	<div class="contenedor-cartas">
                            		<c:forEach items="${videos}" var="v">
                            		
	                            		<div class="card" style="width: 18rem;">
											  <img class="card-img-top" src="https://static.thenounproject.com/png/17241-200.png" alt="Card image cap">
											  <div class="card-body">
											     <ul class="list-group list-group-flush">
												    <li class="list-group-item">Codigo : ${ v.codigo}</li>
												    <li class="list-group-item">Contraseña : ${ v.nombre} </li>
												  </ul>
											    <a href="#" class="btn btn-primary">Editar</a>
											  </div>
										</div>
									</c:forEach>
								</div>                            	
                            </c:if>
                            <!-- VISTA FORMULARIO --> 
                            <c:if test="${vista == 'form-video'}">
                            	Vista formulario
                            	${video }        	
								<form action="video" method="post">                          	
                            	<div class="row">
	                            	<div class="col-lg-12">
	                            		
	                            		<h1 class="page-header">${video.id == -1?'crear Video' : video.nombre }</h1>
	                            		<!-- PAGINACION -->
										<ul class="pagination">
										  <li><a href="#">&laquo;</a></li>
										  <li><a href="#">&raquo;</a></li>
										</ul>
	                            		<div class="form-group">
		                            		<input name="videoId" type="hidden" value="${video.id }" placeholder="numero de id">
		                            		<input name="op" type="hidden" value="2" placeholder="numero de id">
	                            		</div>
	                            		<div class="form-group">
		                            		<label for="codigoCancion">Codigo</label>
		                            		<input type="text" name="codigoCancion" value="${video.codigo }" placeholder="11 caracteres" autofocus>
		                            	</div>
		                            	<div class="form-group">
		                            		<label for="nombreCancion">Nombre</label>
		                            		<input type="text" name="nombreCancion" value="${video.nombre }" >
		                            	</div>
		                            	<%-- <div class="form-group">
		                            		<label for="usuarioCancion">Subido por</label>
		                            		<input type="text" name="usuarioCancion" value="${video.id_usuario }" >
		                            	</div> --%>
		                            	<label>subido por</label>
		                            	<select name="usuarioCancion" class="form-control">
		                            		<c:forEach items="${usuarios }" var="u">
		                            			<option value="${u.id}" ${u.id  == video.usuario.id ? 'selected':''}> ${u.nombre}</option>
		                            		</c:forEach>
		                            	</select>

	                            	</div>
                            	</div>
                            	<div class="row">
	                            	
	                            		<input type="submit" value="${video.id > 0?'Modificar' : 'Crear' }" class="btn btn-primary btn-block">
	                            		<c:if test="${video.id > 0 }">
	                            			<a href="video?videoId=${video.id}&op=<%=BackofficeUsuarioController.OP_ELIMINAR%>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
	                            		</c:if>
	                            	</form>
	                            	<script>
	                            	/*pasamos event desde la funcion y con esto nos evitamos un modal a la hora de 
	                            	confirmar/noconfirmar accion de registro
	                            	*/
	                            	function showModalEliminar( idVideo, operacion ){
	                        			console.log('showModalEliminar id=' + idVideo);
	                        			$('#modalEliminar').modal('show');
	                        			var btn = document.getElementById('btnEliminar');
	                        			btn.href = 'inicio?id='+ idVideo + '&op=' + operacion;			
	                        		}
	                        		
	                        		function showModalModificar( idVideo, nombre ){
	                        			
	                        			console.log('showModalModificar id=' + idVideo +  " nombre=" + nombre);
	                        			$('#modalModificar').modal('show');
	                        			document.getElementById('id').value = idVideo;
	                        			document.getElementById('nombre').value = nombre;
	                        						
	                        		}
	                        		
	                        		function confirmar(event){
                            			
                            			if(confirm('Estas seguro de querer eliminar')){
                            				console.log("Confirmado eliminar");
                            			}else{
                            				//previene el evento
                            				event.preventDefault();
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
