<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-lg-4">
	<section>
	  	<h1 class="text-pika"><fmt:message key="lista.reproduccion"/></h1>
		<ul class="list-group">
			<c:if test="${not empty videos}">
				<c:forEach items="${videos}" var="v">
					<li class="list-group-item d-flex justify-content-between align-items-center">
						<a href="inicio?id=${v.id}">${v.nombre}</a>
						<a href="inicio?id=${v.id}&op=${HomeController.OP_ELIMINAR}"><i class="fas fa-trash-alt text-danger"></i></a>
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
				<a href="#">Accede con tu usuario</a>
			</c:if>
	</section>
</div>