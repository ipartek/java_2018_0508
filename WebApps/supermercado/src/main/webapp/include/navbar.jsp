<!-- Page codification -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<header>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="inicio"><img
			src="images/logo.jpg" alt="logotipo-supermercado-el-fuerte" /></a>

		<div class="navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto menu">

				<li class="nav-item"><a class="nav-link" href="inicio">Principal</a></li>

				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
				
				<!-- Opciones del Backoffice -->
				<c:if test="${not empty sessionScope.usuario}">
				
					<li class="nav-item"><a class="nav-link"href="privado/alta-producto.jsp">Nuevo producto</a></li>
	
					<li class="nav-item"><a class="nav-link" href="listado">Listado</a></li>
				</c:if>

			</ul>
			
			<c:if test="${empty sessionScope.usuario}">
				<a href="login.jsp" class="text-white">Acceder</a>
			</c:if>
			
			<c:if test="${not empty sessionScope.usuario}">
				
				<div class="panel-usuario text-center">
					<span class="text-warning" >${sessionScope.usuario.nombre}</span>
					<a class="ml-2" href="logout">Cerrar sesión</a>
				</div>
			</c:if>
		</div>
		
	</nav>

</header>

	<!--  Gestión de Alertas -->
   <c:if test="${not empty alert}">
	<div class="row justify-content-center">
		<div class="col col-md-6">
	    	<%@ include file ="alert.jsp" %>
	    </div>
	</div>
   </c:if>
