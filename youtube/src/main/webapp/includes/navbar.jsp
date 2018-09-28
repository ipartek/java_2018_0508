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
				
				<div class="collapse navbar-collapse justify-content-between" id="navbarResponsive">

					<c:if test="${empty usuario}">
						<!-- Usuario Logueado en session -->
						<ul class="navbar-nav align-items-center">
							<li class="nav-item active">
								<a class="text-pika" href="login.jsp">Acceder/Login</a>
							</li>
						</ul>
					</c:if>
					<c:if test="${not empty usuario}">
						<!-- Usuario No Logueado -->
						<ul class="navbar-nav align-items-center">
							<li class="nav-item">
								<div class="text-light text-right m-1">
									Bienvenido <i class="fas fa-user-circle"></i>${usuario.nombre}
									<a class="text-pika-red" href="backoffice/index.jsp">Acceder BackOffice</a>
									<a class="text-pika-red" href="logout">Cerrar Sesion</a>
								</div>
							</li>
						</ul>
					</c:if>
				
								
					<ul class="navbar-nav">
						<li class="nav-item"><a class="text-pika" href="inicio?idioma=es_Es"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Flag_of_Spain.svg/20px-Flag_of_Spain.svg.png"></a></li>
						<li class="nav-item"><a class="text-pika"  href="inicio?idioma=eu_Es"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Flag_of_the_Basque_Country.svg/20px-Flag_of_the_Basque_Country.svg.png"></a></li>
						<li class="nav-item"><a class="text-pika"  href="inicio?idioma=en_En"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Flag_of_the_United_Kingdom.svg/20px-Flag_of_the_United_Kingdom.svg.png"></a></li>
					</ul>
				
				
				</div>
			</div>
		</nav>
	</header>
	