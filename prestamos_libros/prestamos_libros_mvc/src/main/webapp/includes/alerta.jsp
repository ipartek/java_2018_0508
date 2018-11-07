<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="alert alert-${alerta.tipo} alert-dismissible" role="alert">
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true"><i class="notika-icon notika-close"></i></span>
	</button>
	${alerta.texto}
</div>