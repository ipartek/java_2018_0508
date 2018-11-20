<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Moderación de comentarios</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row mb-3">
            	<form action="comentarios/aprobar" method="post">
            	<table id="tablaOrdenable" class="display" style="width:100%">
				        <thead>
				            <tr>
				                <th>id</th>
				                <th>usuario</th>
				                <th>video</th>
				                <th>fecha</th>
				                <th>comentario</th>
				            </tr>
				        </thead>
				        <tbody>
				        	<c:forEach items="${comentarios}" var="c">
					            <tr>
					                <td>${c.id} <input type="checkbox" name="ids" value="${c.id}"> </td>
					                <td>${c.usuario.nombre}</td>
					                <th title="${c.video.nombre}" data-toggle="tooltip" data-placement="right" class="hover-hand">${fn:substring(c.video.nombre, 0, 25)}...</th>
					                <td>${c.fecha}</td>
					                <td onclick="showModal('${c.texto}', 'Detalle Comentario');" class="hover-hand">${fn:substring(c.texto, 0, 100)}...</td>
					            </tr>
				            </c:forEach>
				       </tbody>
				</table>
				<!-- table#tablaOrdenable -->
				<input type="submit" value="Aprobar comentarios" class="btn btn-info btn-block">
				</form>
				<!-- /form -->
				
				
				
            </div>
</div>
<!-- /#page-wrapper -->

<%@include file="../includes/footer.jsp" %>