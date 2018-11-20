<c:if test="${not empty alert}">
	<div class="container">
		<div class="alert ${alert.tipo} alert-dismissible fade show"
			role="alert">
			
			<c:if test="${empty sessionScope.usuario}">
			<p>${alert.texto},si no está registrado por favor pulsa <span onclick="showModalRegistrar()">aqui</span></p>
			</c:if>
			<c:if test="${not empty sessionScope.usuario}">
			<p>${alert.texto}</p>
			</c:if>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</div>
	
	${sessionScope.alert=null}
	
</c:if>
