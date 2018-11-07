<div class="row mt-2">
	
	<c:if test="${ not empty alert }">
		<div class="alert ${ alert.tipo } alert-dismissible fade show mt-0" role="alert">
			<p>${ alert.texto }</p>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
</div>
${alert = null}