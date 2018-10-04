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
				      			<a href="<%=request.getContextPath()%>/backoffice/video?view=form" class="btn btn-success">Crear Nuevo</a>
				      		</div>	
                        </div>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">   
                        <%@ include file="../includes/optionsVideo.jsp" %> 
                        	<!-- VISTA LISTA -->                   	                      	
                        	<c:if test="${view == 'tree'}">
	                            <table width="100%" class="userDataTable table table-striped table-bordered table-hover " id="userDataTable">
	                                <thead>
	                                    <tr>
	                                    	<th>Id</th>
	                                        <th>codigo</th>
	                                        <th>nombre</th> 
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                	<c:forEach items="${videos}" var="v">
		                                    <tr class="odd gradeX">
		                                    	<td><a href="<%=request.getContextPath()%>/backoffice/video?videoId=${v.id }">${v.id }</a></td>
		                                        <td>${v.codigo }</td>
		                                        <td>${v.nombre }</td>
		                                    </tr>
	                                    </c:forEach>
	                                   
	                                </tbody>
	                            </table>      
                            </c:if>
                            <!-- VISTA KANBAN --> 
                            <c:if test="${view == 'kanban'}">
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
                            <c:if test="${view == 'form'}">
                            	Vista formulario
                            	&{usuario}           	
								<form action="usuario" method="post">                          	
                            	<div class="row">
	                            	<div class="col-lg-12">
	                            		
	                            		<h1 class="page-header">${video.id == -1?'crear Video' : video.nombre }</h1>
	                            		<!-- PAGINACION -->
										<ul class="pagination">
										  <li><a href="#">&laquo;</a></li>
										  <li><a href="#">&raquo;</a></li>
										</ul>
	                            		<div class="form-group">
		                            		<label for="videoId">id</label>
		                            		<input name="videoId" type="text" readonly placeholder="numero de id">
	                            		</div>
	                            		<div class="form-group">
		                            		<label for="codigoVideo">Codigo</label>
		                            		<input type="text" name="codigoVideo" value="${video.codigo }" placeholder="nombre de usuario" autofocus>
		                            	</div>
		                            	<div class="form-group">
		                            		<label for="nombreCancion">Nombre</label>
		                            		<input type="text" name="nombreCancion" value="${video.nombre }" >
		                            	</div>

	                            	</div>
                            	</div>
                            	<div class="row">
	                            	
	                            		<input type="submit" value="${video.id == 1?'Crear' : 'Modificar' }" class="btn btn-primary btn-block">
	                            		<c:if test="${video.id == 0 }">
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
