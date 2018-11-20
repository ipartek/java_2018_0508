<div class="card card-outline-secondary my-4">
	
	<div class="card-header"><fmt:message key="titulo.comentarios"/></div>
	
	<div class="card-body">
	
		<!-- Si no hay usuario loggeado -->
		<c:if test="${empty sessionScope.usuario}">
			<p class="font-italic text-danger"><b>*Por favor inicia sesión para comentar en el vídeo*</b></p>
			<hr>
		</c:if>
	
		<c:forEach items="${comentarios}" var="c">
			<p class="textoComentario">${c.texto}</p>
			<small class="text-muted">Publicado por ${c.usuario.nombre} el <fmt:formatDate value="${c.fecha}" pattern="dd/MM/yyyy HH:mm"/> </small>
			<hr>
		</c:forEach>
		
		<!-- Si hay usuario loggeado -->
		<c:if test="${not empty sessionScope.usuario}">
			<div>
				<p>¡<b class="text-warning"> ${usuario.nombre}</b>, danos tu opinión!</p>
				<form action="publicar" method="post">
					<textarea class="form-control mb-2 pb-cmnt-textarea" rows="4" cols="10" name="texto"
						placeholder="Escribe aquí tu comentario..." name="texto"  required></textarea>
					<input type="hidden" name="id_video" value="${videoInicio.id}">
					<input type="submit" class="btn btn-success" value="<fmt:message key="boton.comentar"/>">
				</form>
			</div>
		</c:if>
		
	</div>
</div>
<!-- /.card -->