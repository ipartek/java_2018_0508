<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp"%>

<%@ include file="includes/navbar.jsp"%>
<!-- Formulario de login -->
	<div class="row fondo-login">
		<div class="col-3 m-5">
		<h1 class="text-pika">Login</h1>
			<form id="login" action="login" method="post" class="">
				<div class="form-group">
					<input autofocus name="usuario" class="form-control mr-2" type="text"
						placeholder="Nombre de usuario" required pattern=".{3,30}"
						value="${cookie.nombreRecordado.value}"> <br> <input
						type="checkbox" name="recordar" checked><small>Recuerdame</small>
				</div>
				<div class="form-group">
					<input name="pass" class="form-control mr-2" type="password"
						placeholder="Contraseña" required pattern=".{2,50}">
				</div>
				<button class="btn btn-outline-info btn-outline-pika btn-block mr-2"
					type="submit">Entrar</button>
			</form>
		</div>
	</div>

<%@ include file="includes/footer.jsp"%>