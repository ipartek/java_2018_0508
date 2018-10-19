<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeVideoController"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeRolController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>
<%@ include file="includes/nav.jsp" %>
<main role="main" class="container">
	<div class="row mt-3">
		<div class="col-3">
			<ul class="list-group">
				<li class="list-group-item">Datos</li>
	  			<li class="list-group-item">Videos</li>
	  			<li class="list-group-item">Amigos</li>
			</ul> 
		</div><!-- Cierre col De la parte izquierda -->
		<div class="col-9">
			<form action="" method="post">
			<h2>Datos de ${usuario.nombre}:</h2>
				<div class="row mt-2 mb-2">
					<div class="col-4">
						Nombre: 
						<input type="text" name="nombre" placeholder="${usuario.nombre}" class="form-control">
					</div>
				</div>
				<div class="row mt-2 mb-2">
					<div class="col">
						Nueva contraseña:
						<input type="password" name="contrasenya" placeholder="ejemplo: P1K4L_sT" class="form-control">
					</div>
					<div class="col">
						Repita la contraseña:
						<input type="password" name="contrasenya" placeholder="ejemplo: P1K4L_sT" class="form-control">
					</div>
				</div><!-- Cierre row contraseñas -->
				<input type="submit" value="Actualizar" class="btn-main btn-outline-pika">
			</form>
		</div><!-- Cierre col De la parte derecha -->
	</div><!-- Cierre del row principal -->
</main>
