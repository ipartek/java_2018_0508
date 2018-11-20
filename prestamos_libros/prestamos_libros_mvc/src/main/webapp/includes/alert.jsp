<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${not empty alert}">
	<div class="container">
		<div class="alert ${alert.tipo} alert-dismissible fade show" role="alert">
			<p>${alert.texto}</p>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</div>
	
	${sessionScope.alert=null}
	
</c:if>