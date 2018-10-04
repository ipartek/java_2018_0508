<%@include file="../includes/taglibs.jsp"%>

<c:if test="${empty alert }">
	${alert = null }
</c:if>
		
<c:if test="${not empty alert }">
	<div class="alert ${alert.tipo } alert-dismissible fade show mt-4" role="alert">
		<p>${alert.texto }</p>
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
</c:if>