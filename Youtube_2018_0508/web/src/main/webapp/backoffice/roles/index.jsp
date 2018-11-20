<%@include file="../includes/taglibs.jsp"%>

<%@page import="com.ipartek.formacion.controller.back.BackofficeRolController"%>

<%@include file="../includes/header.jsp"%>

<!-- Listado de Roles -->

 <div id="wrapper">

        <%@include file="../includes/aside.jsp"%>

        <div id="page-wrapper">
        
        	<%@include file="../includes/alerts.jsp"%>
        
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Roles <span class="badge">${roles.size()}</span></h1>
                </div>
                <!-- /.col-lg-12 -->
                <div class="col-lg-12">
                    <a href="roles?id=-1&op=${BackofficeRolController.OP_IR_FORMULARIO}" class="btn btn-success">Crear Nuevo</a>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default panel-tabla">
                        <div class="panel-heading">
                            Tabla avanzada de los roles actuales en la aplicación
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTable-ordenable">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${roles}" var="r">
                                	 <tr>
                                        <td>${r.id}</td>
                                        <td><a href="roles?id=${r.id}&op=${BackofficeRolController.OP_IR_FORMULARIO}">${r.nombre}</a> </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                	<tr>
                                		<th>ID</th>
                                		<th>Nombre</th>
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