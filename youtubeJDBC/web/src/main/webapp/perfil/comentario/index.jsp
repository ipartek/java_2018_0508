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
                        
                       
                        	<c:if test="${tipoVista == 'lista-comentario' }">
                        	<!-- VISTA LISTA -->                   	                      	
								 <form action="<%=request.getContextPath()%>/perfil/inicio" method="post">
	                            <table width="100%" class="userDataTable table table-striped table-bordered table-hover " id="userDataTable">
	                                <thead>
	                                    <tr>
	                                    	<th>Video</th>
	                                    	<th>texto</th>
	                                    </tr>
	                                </thead>
	                                <tbody>
	                               
	                                	<c:forEach items="${comentarios}" var="c">
	                                	
		                                    <tr class="odd gradeX">
		                                    	<th>${c.video.nombre }</th>
		                                        <td class="hover-hand" ><a href="<%=request.getContextPath()%>/perfil/inicio?op=<%=PerfilController.OP_COMENTARIO%>&accion=<%=PerfilController.OP_MODIFICAR%>&comentarioId=${c.id }">${fn:substring(c.texto, 0, 30)}...  </a></td>	<%-- onclick="showModal('${c.video.nombre },${c.texto}')" --%>	                                        
												
		                                    </tr>
	                                    </c:forEach>
	                                   	
	                               
	                                </tbody>
	                            </table>     
	                             
				      			
					      			<!-- <button class="btn btn-success" type="submit">Aprobar</button> -->
					      		
					      		 <form>   
					      	</c:if>
					      	<!-- VISTA FORMULARIO -->
                        		<c:if test="${tipoVista == 'form-comentario' }">
                        			<h2>Edita tu video</h2>
                        			<form action="/perfil/video">
                        				<%-- <input name="comentarioTexto" type="text" value="${comentarioSeleccionado.texto }"> --%>
                        				<textarea class="textArea" name="comentarioTexto" >${comentarioSeleccionado.texto }</textarea>
                        				<button class="btn btn-success btn-block btn-lg" type="submit">Guardar</button>
                        			</form>      
                        		</c:if>         
							<script type="text/javascript">
								$(document).ready(function(){
								    $('[data-toggle="tooltip"]').tooltip();   
								});
							</script>
                           
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
			</div>
            <!-- /.row -->
       </div>
 </div>
    <%@ include file="../includes/footer.jsp"  %>