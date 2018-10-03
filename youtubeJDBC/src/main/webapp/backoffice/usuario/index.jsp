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
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">   
                        <%@ include file="../includes/options.jsp" %> 
                        	<!-- VISTA LISTA -->                   	                      	
                        	<c:if test="${view == 'tree'}">
	                            <table width="100%" class="table table-striped table-bordered table-hover" id="userDataTable">
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
		                                    	<td><a href="/backoffice/usuario?id=${u.id }">${u.id }</a></td>
		                                        <td>${u.nombre }</td>
		                                        <td>${u.pass }</td>
		                                       	<td>${u.rol }</td>
		                                    </tr>
	                                    </c:forEach>
	                                   
	                                </tbody>
	                            </table>
	                            <!-- /.table-responsive -->
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

<script type="text/javascript">
	$(document).ready( function () {
	    $('#userDataTable').DataTable();
	} );
</script>