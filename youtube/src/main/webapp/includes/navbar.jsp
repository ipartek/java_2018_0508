<%@page import="java.net.URLDecoder"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Cabecera -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-pika">
			<div class="container">
				<a class="navbar-brand" href="#">Youtube PikaList<img id="logo" src="images/logo.png" alt="Logo de la APP"></a>
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
								<form id="login" action="login" method="post" class="form-inline mt-2 mt-md-0">
									<div class="form-group">
										<c:if test="${not empty cookie.nombreRecordado}">
											<input autofocus name="usuario" class="form-control mr-2" type="text" placeholder="Nombre de usuario" required pattern=".{3,30}" value="${cookie.nombreRecordado.value}">
										</c:if>
										<c:if test="${empty cookie.nombreRecordado}">
											<input autofocus name="usuario" class="form-control mr-2" type="text" placeholder="Nombre de usuario" required pattern=".{3,30}">
										</c:if>
										<br>
										<input type="checkbox" name="recordar" checked><small>Recuerdame</small>
									</div>
									<div class="form-group">
										<input name="pass" class="form-control mr-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
									</div>
									<button class="btn btn-outline-info btn-outline-pika mr-2" type="submit">Entrar</button>
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
				
								
					<ul class="navbar-nav">
						<li class="nav-item"><a class="text-pika" href="inicio?idioma=es_Es">es</a></li>
						<li class="nav-item"><a class="text-pika"  href="inicio?idioma=eu_Es">eu</a></li>
						<li class="nav-item"><a class="text-pika"  href="inicio?idioma=en_En">en</a></li>
					</ul>
				
				
				</div>
			</div>
		</nav>
	</header>
	