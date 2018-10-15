
<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

<div id="page-wrapper">

<%@ include file="../includes/alert.jsp" %>

	<div class="row">
		<div class="col-lg-12">
			
	
		</div>
		<!-- /.col-lg-12 -->
	</div> 
	<div class="row">
		<div class="col">
			<input type="submit" value="aprobar" class="btn btn-success">
		</div>
	</div>

	<div class="row">
	<form action="comentarios" method="post">
	<table id="tablaOrdenable" class="display" style="width: 100%">
			<thead>
				<tr>
					<th>Aprobar</th>
					<th>Texto</th>
					<!--<th>Nombre Video</th>-->
					<th>Usuario</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${comentarios}" var="c">
					<tr>
						<td><input type="checkbox" name="aprobado" value="${c.id }"></td>
						<td>${c.texto}</td>
						<!-- <td>${v.nombre}</td>-->
		                 <td>${c.usuario.nombre}</td>
						
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>Aprobar</th>
					<th>Texto</th>
					<!--<th>Nombre Video</th>-->
					<th>Usuario</th>
				</tr>
			</tfoot>
		</table>
	 </form>
	</div>

		
	</div>
	
<!-- Modal Eliminar-->
		<div class="modal fade" id="modalComentario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  			<div class="modal-dialog" role="document">
   			 <div class="modal-content">
     	 <div class="modal-header">
       		 <h5 class="modal-title" id="exampleModalLabel">Leer Texto Completo</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>

<%@ include file="../includes/footer.jsp" %>  