<c:if test="${not empty alert}">
	<div class="container media-left">
		<div class="alert ${alert.tipo} alert-dismissible" role="alert">
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		  <p>${alert.texto}</p>
		</div>
	</div>
	
	${alert=null}
	
</c:if>