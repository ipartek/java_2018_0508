<%@page import="com.andrea.perez.controller.back.backofficeComentariosAprobar"%>
<%@include file="../includes/taglibs.jsp"%>
<%@include file="../includes/header.jsp"%>

<!-- Listado de Comentarios por aprobar -->

 <div id="wrapper">

        <%@include file="../includes/aside.jsp"%>

        <div id="page-wrapper">
        
        	<%@include file="../includes/alert.jsp"%>
        	
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Comentarios</h1>
                </div>
               
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default panel-tabla">
                        <div class="panel-heading">
                            Tabla de los Comentarios 
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <form action="comentarios/aprobar" method="post">
	                         <table width="100%" class="table table-striped table-bordered table-hover" id="dataTable-ordenable">
	                                <thead>
	                                    <tr>
	                                        <th>Aprobado</th>
	                                        <th>Usuario</th>
	                                        <th>Texto</th>
	                                        
	                                    </tr>
	                                </thead>
	                                <tbody>
		                                <c:forEach items="${comentarios}" var="c">
		                                	 <tr>
		                                        <td><input type="checkbox" name="aprobado" value="${c.id }"></td>
		                                        <td>${c.usuario.nombre}</td>
		                                        <td onclick="showModalComentario(${c.id},'${c.texto}')"><p class="comentarioCorto">${c.texto}</p></td>                   
		                                    </tr>
		                                </c:forEach>
	                                </tbody>
	                                <tfoot>
	                                	<tr>
	                                        <th>Aprobado</th>
	                                        <th>Usuario</th>
	                                        <th>Texto</th>                                        
	                                    </tr>
	                                </tfoot>
	                            </table>
	                            <!-- /.table-responsive -->
	                        </div>
	                        <!-- /.panel-body -->
	                        <input type="submit" name="aceptar" value="aprobar Comentarios">
                        </form>
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    
    <!-- Modal para leer comentario completo -->
		    <div class="modal fade" id="modalVerComentario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-fondo">						
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
    
    

<%@include file="../includes/footer.jsp"%>