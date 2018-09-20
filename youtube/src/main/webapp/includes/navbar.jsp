<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Alert"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Video"%>

<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>

<%@page import="java.util.ArrayList"%>

<!-- Cabecera -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container">
				<a class="navbar-brand" href="#">Youtube PlayList</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive"
				 aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<c:if test="${empty usuario}">
						<!-- Usuario Logueado en session -->
						<ul class="navbar-nav ml-auto  align-items-center">
							<li class="nav-item active">
								<!-- Formulario de login -->
								<form action="login" method="post" class="form-inline mt-2 mt-md-0">
									<input name="usuario" class="form-control mr-sm-2" type="text" placeholder="Nombre de usuario" required pattern=".{3,30}">
									<input name="pass" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
									<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
								</form>
							</li>
						</ul>
					</c:if>
					<c:if test="${not empty usuario}">
						<!-- Usuario No Logueado -->
						<ul class="navbar-nav ml-auto  align-items-center">
							<li class="nav-item">
								<div class="text-light text-right m-1">
									Bienvenido <i class="fas fa-user-circle"></i>${usuario.nombre}
									<a href="backoffice/index.jsp">Acceder BackOffice</a>
									<a href="logout">Cerrar Sesion</a>
								</div>
							</li>
						</ul>
					</c:if>
				</div>
			</div>
		</nav>
	</header>
	