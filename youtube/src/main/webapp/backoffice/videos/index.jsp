<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeVideoController"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Videos</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
            	<div class="col-md-8">
            		TODO BUSCADOR con su lupita
            	</div>
            	<div class="col-md-4">
            		<a href="videos?id=-1&op=<%=BackofficeVideoController.OP_IR_FORMULARIO%>" class="btn btn-success">Crear Nuevo</a>
            	</div>
            </div>
            <!-- /.row -->
            
            <div class="row">
            	<table id="tablaOrdenable" class="display" style="width:100%">
				        <thead>
				            <tr>
				                <th>ID</th>
				                <th>Codigo</th>
				                <th>Nombre</th>
				            </tr>
				        </thead>
				        <tbody>
				        	<c:forEach items="${videos}" var="v">
					            <tr>
					                <td>${v.id}</td>
					                <td>${v.codigo}</td>
					                <td><a href="videos?id=${v.id}&op=<%=BackofficeVideoController.OP_IR_FORMULARIO%>">${v.nombre}</a></td>
					            </tr>
				            </c:forEach>
				       </tbody>
				       <tfoot>
				            <tr>
				                <th>ID</th>
				                <th>Codigo</th>
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