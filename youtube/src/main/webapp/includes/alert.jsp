<c:if test="${not empty alert}">
	<div class="container">
		<div class="alert ${alert.tipo} alert-dismissible fade show"
			role="alert">
			<p>${alert.texto}</p>
			<c:if test="${empty usuario }">
				<p>${msgRegistro }<span onclick="showModalRegistro()" class="enlaceRegistro text-primary">${enlaceRegistro }</span></p>
			</c:if>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</div>
	
	${alert=null}
	
</c:if>
