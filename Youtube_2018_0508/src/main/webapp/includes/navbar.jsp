<%@include file="taglibs.jsp"%>
	<!-- Navigation -->
<%@page import="java.util.Date"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.net.URLDecoder"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top mb-2">
		<div class="container">
			<a class="navbar-brand" href="#">Youtube Playlist</a>
			
			<!--Idiomas -->
			<div class="ml-1 text-light botones-idioma"><% %>
				<span> 
					<a href="inicio?idioma=es_ES" class="badge badge-${(sessionScope.idioma eq 'es_ES')?'warning':'light'}" ${(sessionScope.idioma eq 'es_ES')?'active':''}>
					ES</a>
				</span>
				<span class="ml-0.5">
					<a href="inicio?idioma=eu_ES" class="badge badge-${(sessionScope.idioma eq 'eu_ES')?'warning':'light'}" ${(sessionScope.idioma eq 'eu_ES')?'active':''}>
					EU</a>
				</span>
					<span class="ml-0.5">
					<a href="inicio?idioma=en_EN" class="badge badge-${(sessionScope.idioma eq 'en_EN')?'warning':'light'}" ${(sessionScope.idioma eq 'es_ES')?'active':''}>
					EN</a>
				</span>
			</div>
			
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon">0</span>
			</button>
			
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active">
					
						<!-- Usuario no loggeado -->
						<c:if test="${empty usuario}">
							<!-- Formulario de login -->
							<form class="form-inline navbar-nav ml-auto" action="login"
								method="post">
								<input required type="text" class="form-control mb-1 mr-sm-2" id="inlineFormInputName2" placeholder="Usuario"
									name="user" value="${cookie.cNombre.value}" pattern=".{3,30}">
								<div class="input-group mb-1 mr-sm-2">
									<input required type="password" class="form-control" id="inlineFormInputGroupUsername2"
										placeholder="Contraseña" name="pswd" value="" pattern=".{2,50}">
								</div>
								<button type="submit" class="btn btn-primary mb-1 mr-2"><fmt:message key="boton.login"/></button>
								<input type="checkbox" id="check" value="recordar" name="recordar" ${(not empty cookie.cNombre.value )?"checked":""}> 
								<label for="check" class="text-light"><fmt:message key="check.recordar"/></label> 
							</form>
							<a href="registro.jsp">Registrarse</a>
						</c:if>
					</li>
					
					<li class="nav-item">
						<!-- Usuario Loggeado -->
						<c:if test="${not empty usuario}">
							<div class="row justify-content-around">
								<a class ="text-center" href="backoffice/inicio"><fmt:message key="boton.backoffice"/></a>
								<span class="text-center" style="color:#FFF">
									<i class="fas fa-user mr-1"></i> 
									${usuario.nombre} |
									<a class="ml-1 mr-2" href="logout"><fmt:message key="boton.logout"/></a>
								</span> 
							</div>
							
							<!-- Formulario para crear video -->
							<form class="form-inline navbar-nav ml-auto" action="inicio" method="post">
								<input required type="text" class="form-control mb-1 mr-sm-2"
									id="inlineFormInputName2" placeholder="ID (11 caracteres)"
									name="codigo" pattern=".{11,11}">
								<div class="input-group mb-1 mr-sm-2">
									<input required type="text" class="form-control"
										id="inlineFormInputGroupUsername2"
										placeholder="Título (mínimo 2 letras)" name="titulo">
								</div>
								<button type="submit" class="btn btn-primary mb-1"><fmt:message key="boton.anadir"/></button>
							</form> 
						</c:if>
					</li>
				</ul>
			</div>	
		</div>
	</nav>