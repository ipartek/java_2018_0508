<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-lg-4">
	<section>
	  	<h1 class="text-pika"><fmt:message key="lista.reproduccion"/></h1>
		<ul class="list-group">
			<c:if test="${not empty videos}">
				<c:forEach items="${videos}" var="v">
					<li class="list-group-item d-flex justify-content-between align-items-center">
						<a href="inicio?id=${v.id}">${v.nombre}</a>
						<c:if test="${sessionScope.usuario.rol eq 0}">
							<!-- Opcion Editar -->
							<i onclick="showModalModificar(${v.id},${HomeController.OP_MODIFICAR},'${v.nombre}')" class="fas fa-pencil-alt text-pika-purple"></i>
							<!-- Opcion Eliminar -->
							<i onclick="showModalEliminar(${v.id},${HomeController.OP_ELIMINAR})" class="fas fa-trash-alt text-pika-red"></i>
						</c:if>
					</li>
				</c:forEach>
			</c:if>
		</ul>


	</section>
	<section>
		<h2 class="text-secondary">Lista del Usuario</h2>
			<c:if test="${not empty usuario}">
				<ul class="list-group">
					<c:if test="${not empty videosUsuario}">
						<c:forEach items="${videosUsuario}" var="vu">
							<li class="list-group-item d-flex justify-content-between align-items-center">
								<a href="inicio?id=${vu.id}">${vu.nombre}</a>
							</li>
						</c:forEach>
					</c:if>
				</ul>
			</c:if>
			<c:if test="${empty usuario}">
				<a href="login.jsp">Accede con tu usuario</a>
			</c:if>
	</section>
</div>