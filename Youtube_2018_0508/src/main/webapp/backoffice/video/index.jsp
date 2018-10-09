<%@include file="../includes/taglibs.jsp"%>

<%@include file="../includes/header.jsp"%>

<!-- Listado de Usuarios -->

 <div id="wrapper">

        <%@include file="../includes/aside.jsp"%>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Vídeos</h1>
                </div>
                <!-- /.col-lg-12 -->
                <div class="col-lg-12">
                    <a href="videos?id=-1" class="btn btn-success">Crear Nuevo</a>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Tabla avanzada de los vídeos creados en la aplicación
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTable-ordenable">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Código</th>
                                        <th>Título</th>
                                        <th>Icono</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${videos}" var="v">
                                	 <tr>
                                        <td>${v.id}</td>
                                        <td><a href="videos?id=${v.id}">${v.codigo}</a> </td>
                                        <td>${v.titulo}</td>
                                        <th>Icono</th>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                	<tr>
                                		<th>ID</th>
                                		<th>Código</th>
                                		<th>Título</th>
                                		<th>Icono</th>
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
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->

<%@include file="../includes/footer.jsp"%>