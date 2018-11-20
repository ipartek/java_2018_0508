<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeComentarioController"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Comentarios</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
            	<div class="col-md-8">
            		TODO BUSCADOR con su lupita
            	</div>
            	<div class="col-md-4">
            		<a href="comentarios?id=-1&op=<%=BackofficeComentarioController.OP_IR_FORMULARIO%>" class="btn btn-success">Crear Nuevo</a>
            	</div>
            </div>
            <!-- /.row -->
            
            <div class="row">
            	<table id="tablaOrdenable" class="display" style="width:100%">
				        <thead>
				            <tr>
				                <th>id</th>
				                <th>fecha</th>
				                <th>texto</th>
				                <th>aprobado</th>
				                <th>video</th>
				                <th>usuario</th>
				            </tr>
				        </thead>
				        <tbody>
				        	<c:forEach items="${comentarios}" var="c">
				        		<tr>			            
					                <td><a href="comentarios?id=${c.id}&op=<%=BackofficeComentarioController.OP_IR_FORMULARIO%>">${c.id}</a></td>
					                <td>${c.fecha}</td>
					                <td onclick="showModal('${c.texto}', 'Detalle Comentario');" class="hover-hand">${fn:substring(c.texto, 0, 100)}...</td>
					                <td>${(not c.aprobado)?'Pendiente de moderación':'Aprobado'}</td>
					                <td title="${c.video.nombre}" data-toggle="tooltip" data-placement="right" class="hover-hand">${fn:substring(c.video.nombre, 0, 25)}...</td>
					                <td>${c.usuario.nombre}</td>
					            </tr>
				            </c:forEach>
				       </tbody>
				       <tfoot>
				            <tr>
				                <th>id</th>
				                <th>fecha</th>
				                <th>texto</th>
				                <th>aprobado</th>
				                <th>video</th>
				                <th>usuario</th>
				            </tr>
				        </tfoot>
				</table>
				<!-- table#tablaOrdenable -->
            </div>
            <!-- /.row -->
</div>
<!-- /#page-wrapper -->

<%@include file="../includes/footer.jsp" %>