<%@include file="../includes/taglibs.jsp"%>

<%@page import="com.ipartek.formacion.controller.back.BackofficeUsuarioController"%>
<%@page import="com.ipartek.formacion.controller.back.BackofficeVideoController"%>

<%@include file="../includes/header.jsp"%>

<!-- Listado de Usuarios -->

 <div id="wrapper">

        <%@include file="../includes/aside.jsp"%>

        <div id="page-wrapper">
        
        	<%@include file="../includes/alerts.jsp"%>
        	
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Vídeos</h1>
                </div>
                <!-- /.col-lg-12 -->
                <div class="col-lg-12">
                    <a href="videos?id=-1&op=${BackofficeVideoController.OP_IR_FORMULARIO}" class="btn btn-success">Crear Nuevo</a>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default panel-tabla">
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
                                        <th>Creado por usuario</th>
                                    </tr>
                                </thead>
                                <tbody>
	                                <c:forEach items="${videos}" var="v">
	                                	 <tr>
	                                        <td>${v.id}</td>
	                                        <td><a href="videos?id=${v.id}&op=${BackofficeVideoController.OP_IR_FORMULARIO}">${v.codigo}</a> </td>
	                                        <td>${v.titulo}</td>
	                                        <td><img width="200px" height="150px" src="https://img.youtube.com/vi/${v.codigo}/0.jpg"></img></td>
	                                        <td><a href="usuarios?id=${v.usuario.id}&op=${BackofficeUsuarioController.OP_IR_FORMULARIO}">${v.usuario.nombre}</a> </td>
	                                    </tr>
	                                </c:forEach>
                                </tbody>
                                <tfoot>
                                	<tr>
                                		<th>ID</th>
                                		<th>Código</th>
                                		<th>Título</th>
                                		<th>Icono</th>
                                		<th>Creado por usuario</th>
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