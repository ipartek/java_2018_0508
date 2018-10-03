<%@include file="../includes/taglibs.jsp"%>

<%@include file="../includes/header.jsp"%>

<!-- Listado de Usuarios -->

 <div id="wrapper">

        <%@include file="../includes/aside.jsp"%>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Usuarios</h1>
                </div>
                <!-- /.col-lg-12 -->
                <div class="col-lg-12">
                    <a href="usuarios?id=-1" class="btn btn-success">Crear Nuevo</a>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Tabla avanzada de los usuarios registrados en la aplicación
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTable-ordenable">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Contraseña</th>
                                        <th>Rol</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${usuarios}" var="u">
                                	 <tr>
                                        <td>${u.id}</td>
                                        <td><a href="usuarios?id=${u.id}">${u.nombre}</a> </td>
                                        <td>${u.contrasena}</td>
                                        <td>${(u.rol==1)?'Usuario Normal':'Administrador'}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                	<tr>
                                		<th>ID</th>
                                		<th>Nombre</th>
                                		<th>Contraseña</th>
                                		<th>Rol</th>
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