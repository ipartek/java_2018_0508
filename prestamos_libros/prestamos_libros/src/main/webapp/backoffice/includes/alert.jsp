<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<c:if test="${not empty sessionScope.alert}">
	<div class="alert ${sessionScope.alert.tipo} alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<p>${sessionScope.alert.texto}</p>
	</div>
</c:if>

${sessionScope.alert = null}