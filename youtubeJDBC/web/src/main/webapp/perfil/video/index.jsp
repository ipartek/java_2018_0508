<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeUsuarioControllerPuente"%>
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
                        		<c:if test="${tipoVista == 'lista-video' }">                 	                      	
								 <form action="<%=request.getContextPath()%>/backoffice/comentario/aprobar" method="post">
	                            <table width="100%" class="userDataTable table table-striped table-bordered table-hover " id="userDataTable">
	                                <thead>
	                                    <tr>
	                                    	<th>Video</th>
	                                        <th>Codigo</th>  
	                                    </tr>
	                                </thead>
	                                <tbody>
	                               
	                                	<c:forEach items="${videos}" var="v">
	                                	
		                                    <tr class="odd gradeX">                                  	
		                                    	<td><a href="<%=request.getContextPath()%>/perfil/inicio?op=<%=PerfilController.OP_VIDEO%>&accion=<%=PerfilController.OP_MODIFICAR%>&videoId=${v.id }">${v.nombre }</a></td>
												<td>${v.codigo }</td>
		                                    </tr>
	                                    </c:forEach>
	                                   	
	                               
	                                </tbody>
	                            </table>     
	                             
				      			
					      			<button class="btn btn-success" type="submit">Aprobar</button>
					      		
					      		 <form> 
					      	</c:if>  
					      	<!-- VISTA FORMULARIO -->
                        		<c:if test="${tipoVista == 'form-video' }">
                        			<div class="perfil-form">
                        			
	                        			<h2>Edita tu video</h2>
	                        			<form action="/perfil/video">
	                        				<label for="nombreCancion">Nombre</label>
	                        				<input name="nombreCancion" type="text" value="${videoSeleccionado.nombre }">
	                        				<label for="codigo">Codigo</label>
	                        				<input name="codigo" type="text" value="${videoSeleccionado.codigo }">
	                        			</form>      
	                        			<button class="btn btn-success btn-block btn-lg" type="submit">Guardar</button>
					      				<a href="<%=request.getContextPath()%>/backoffice/comentario?id=${comentarioSeleccionado.id}&op=<%=BackofficeUsuarioControllerPuente.OP_ELIMINAR%>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
	                        			
	                        		</div>
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