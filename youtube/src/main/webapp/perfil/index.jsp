<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeVideoController"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeRolController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>
<%@ include file="includes/nav.jsp" %>
<main role="main" class="container">
	<div class="row mt-3">
		<div class="col-3">
			<ul class="list-group">
	  			<li class="list-group-item">Mostrar imagen subida con etiqueta IMG </li>
	  			<li class="list-group-item">Mostrar Tamaño bytes imagen subida</li>
	  			<li class="list-group-item">Permitir solo extensiones .PNG, .JPG y JPEG</li>
	  			<li class="list-group-item">¿ Que pasa si pesa mas de 2MB?</li>
			</ul> 
		</div><!-- Cierre col De la parte izquierda -->
		<div class="col-9">
			<form>
				<div class="row">
					<div class="col-4">
						Nombre: ${usuario.nombre}
					</div>
				</div>
				<div class="row">
					<div class="col">
						
					</div>
				</div><!-- Cierre row contraseñas -->
			</form>
		</div><!-- Cierre col De la parte derecha -->
	</div><!-- Cierre del row principal -->
</main>
