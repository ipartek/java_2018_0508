<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Usuarios</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
            	<div class="col-md-8">
            		TODO BUSCADOR con su lupita
            	</div>
            	<div class="col-md-4">
            		<a href="usuarios?id=-1" class="btn btn-success">Crear Nuevo</a>
            	</div>
            </div>
            <!-- /.row -->
            
            <div class="row">
            	<table id="tablaOrdenable" class="display" style="width:100%">
				        <thead>
				            <tr>
				                <th>ID</th>
				                <th>Nombre</th>
				                <th>Password</th>
				                <th>Rol</th>
				            </tr>
				        </thead>
				        <tbody>
				        	<c:forEach items="${usuarios}" var="u">
					            <tr>
					                <td>${u.id}</td>
					                <td><a href="usuarios?id=${u.id}">${u.nombre}</a></td>
					                <td>${u.password}</td>
					                <td>${(u.rol==1)?'Normal':'Administrador'}</td>
					            </tr>
				            </c:forEach>
				       </tbody>
				       <tfoot>
				            <tr>
				                <th>ID</th>
				                <th>Nombre</th>
				                <th>Password</th>
				                <th>Rol</th>
				            </tr>
				        </tfoot>
				</table>
				<!-- table#tablaOrdenable -->
            </div>
            <!-- /.row -->
</div>
<!-- /#page-wrapper -->

<%@include file="../includes/footer.jsp" %>