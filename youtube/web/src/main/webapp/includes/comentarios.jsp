<div class="card card-outline-secondary my-4">
	<div class="card-header">
		Comentarios
	</div>
	<div class="card-body">
		<c:if test="${not empty sessionScope.usuario}">
			<p><b class="text-warning">${usuario.nombre}</b> queremos saber que opinas de este video:</p>
		</c:if>
		
		<c:if test="${empty sessionScope.usuario}">
		<p><i class="text-danger">*Para poder escribir tu opinión, por favor inicia sesión.</i></p>
		</c:if>
		
		<div class="form-comentario">
			<form action="publicar" method="post" class="form-inline d-flex align-items-stretch">
				<textarea name="texto" rows="5" placeholder="Dejanos tu comentario..." class="form-control" required ${(empty sessionScope.usuario)?'disabled':'' }></textarea>
				<input type="hidden" name="id_video" value="${videoInicio.id}">
				<input type="submit" value="Comentar" class="btn btn-outline-info ml-auto" ${(empty sessionScope.usuario)?'disabled':'' }>
			</form>
		</div>
		
		<hr>
		
		<c:forEach items="${comentarios}" var="c">
     		<p class="comentario-publico">${c.texto}</p>
     		<small class="text-muted"><b>${c.usuario.nombre}</b>  <fmt:formatDate value="${c.fecha}" pattern="dd/MM/yyyy HH:mm"/></small>
     		<hr>
     	</c:forEach>
     
	</div>
</div>
<!-- /.card -->