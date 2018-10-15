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
                            Tabla de los Coemntarios 
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <form action="comentarios" method="post">
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
		                                        <td>${c.texto}</td>	                   
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

<%@include file="../includes/footer.jsp"%>