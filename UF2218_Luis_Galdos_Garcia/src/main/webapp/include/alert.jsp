<!-- Page codification -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${not empty sessionScope.alert}">
	<div class="alert ${alert.tipo} alert-dismissible fade show mt-0" role="alert">
		<p>${alert.texto}</p>
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		${alert = null}
	</div>
</c:if>
