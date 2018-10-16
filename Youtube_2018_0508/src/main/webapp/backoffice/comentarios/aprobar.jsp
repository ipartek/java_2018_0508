<%@include file="../includes/taglibs.jsp"%>

<%@include file="../includes/header.jsp"%>

<!-- Listado de Comentarios sin aprobar -->

 <div id="wrapper">

        <%@include file="../includes/aside.jsp"%>

        <div id="page-wrapper">
        
        	<%@include file="../includes/alerts.jsp"%>
        	
        	<form action="comentarios/aprobar" method="post">
        		<div class="row">
	                <div class="col-lg-12">
	                    <h1 class="page-header">Comentarios sin aprobar <span class="badge">${comentarios.size()}</span></h1>
	                </div>
	                <!-- /.col-lg-12 -->
            	</div>
            	<!-- /.row -->
	            <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-default panel-tabla">
	                        <div class="panel-heading">
	                            Tabla avanzada de los comentarios sin aprobar en la aplicación
	                        </div>
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
	                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTable-ordenable">
	                                <thead>
	                                    <tr>
	                                    	<th></th>
	                                    	<th>Id</th>
	                                    	<th>Fecha creación</th>
	                                        <th>Usuario</th>
	                                        <th>Comentario</th>
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                <c:forEach items="${comentarios}" var="c">
	                                	 <tr>
	                                	 	<td><input type="checkbox" value="${c.id}" name="checkboxAprobar"/> </td>
	                                	 	<td>${c.id}</td>
	                                	 	<td>${c.fecha}</td>
	                                        <td>${c.usuario.nombre}</td>
	                                        <td onclick="showModalComentario(${c.id},'${c.texto}')"><p class="comentarioCorto">${c.texto}</p></td>
	                                    </tr>
	                                </c:forEach>
	                                </tbody>
	                                <tfoot>
	                                	<tr>
	                                		<th></th>
	                                		<th>Id</th>
	                                		<th>Fecha creación</th>
	                                		<th>Usuario</th>
	                                		<th>Comentario</th>
	                                	</tr>
	                                </tfoot>
	                            </table>
	                            <!-- /.table-responsive -->
	                        </div>
	                        <!-- /.panel-body -->
	                    </div>
	                    <!-- /.panel -->
	                </div>
	                <!-- /.col-lg-12 -->
	            </div>
	            <!-- /.row -->
            	<div class="row">
	            	<div class="col-md-4 col-md-offset-8">
                    	<input type="submit" value="Aprobar Comentarios" class="form-control btn btn-primary btn-block" />
                	</div>
            	</div>
        	</form>
        	
        	<!-- Modal Mostrar Comentario -->
			<div class="modal fade" id="modalVerComentario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header bg-pika-red">
							<h5 class="modal-title text-pika-blue" id="exampleModalLabel">COMENTARIO COMPLETO</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<p><b>Comentario seleccionado completo:</b></p>
							<p id="comentarioCompleto"></p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-info btn-outline-pika-red" data-dismiss="modal">Cerrar</button>
						</div>
					</div>
				</div>
			</div>
        	
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->

<%@include file="../includes/footer.jsp"%>