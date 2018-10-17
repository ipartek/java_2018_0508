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
                        	<form action="<%=request.getContextPath()%>/backoffice/comentario/aprobar" class="form-inline">
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
				      		
                        </div>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                       
                        
                        	<!-- VISTA LISTA -->                   	                      	
								 <form action="<%=request.getContextPath()%>/backoffice/comentario/aprobar" method="post">
	                            <table width="100%" class="userDataTable table table-striped table-bordered table-hover " id="userDataTable">
	                                <thead>
	                                    <tr>
	                                    	<th>Id</th>
	                                    	<th>Video</th>
	                                        <th>Codigo</th>
	                                        
	                                       
	                                        
	                                        
	                                    </tr>
	                                </thead>
	                                <tbody>
	                               
	                                	<c:forEach items="${videos}" var="c">
	                                	
		                                    <tr class="odd gradeX">
		                                    	<td><input name="registro" type="checkbox" value="${v.id }"></td>
		                                    	<%-- <td>${v.id }</td> --%>
		                                    	<td>${c.nombre }</td>
		                                        <%-- <td class="hover-hand" onclick="showModal('${c.video.nombre },${c.texto}')">${fn:substring(c.texto, 0, 30)}...  </td> --%>		                                        
												<td>${c.codigo }</td>
		                                    </tr>
	                                    </c:forEach>
	                                   	
	                               
	                                </tbody>
	                            </table>     
	                             
				      			
					      			<button class="btn btn-success" type="submit">Aprobar</button>
					      		
					      		 <form>   
							<script type="text/javascript">
								$(document).ready(function(){
								    $('[data-toggle="tooltip"]').tooltip();   
								});
							</script>
                           
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
            <!-- /.row -->
       </div>
 </div>
    <%@ include file="../includes/footer.jsp"  %>