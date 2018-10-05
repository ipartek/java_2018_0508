<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeRolController"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeUsuarioController"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Roles</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
            	<div class="col-md-8">
            		TODO BUSCADOR con su lupita
            	</div>
            	<div class="col-md-4">
            		<a href="roles?id=-1&op=<%=BackofficeUsuarioController.OP_IR_FORMULARIO%>" class="btn btn-success">Crear Nuevo</a>
            	</div>
            </div>
            <!-- /.row -->
            
            <div class="row">
            	<table id="tablaOrdenable" class="display" style="width:100%">
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
					                <td><a href="roles?id=${r.id}&op=<%=BackofficeRolController.OP_IR_FORMULARIO%>">${r.nombre}</a></td>
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
				<!-- table#tablaOrdenable -->
            </div>
            <!-- /.row -->
</div>
<!-- /#page-wrapper -->

<%@include file="../includes/footer.jsp" %>