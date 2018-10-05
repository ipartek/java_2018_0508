<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="es">

<head>

<base href="<%=request.getContextPath()%>/">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>PikaList</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- FontAwesome CSS -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
<!-- Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="css/style.css" rel="stylesheet" type="text/css" />

</head>

<body class="body-backoffice">
	<!-- Cabecera -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-pika-purple">
			<div class="container">
				<a class="navbar-brand" href="backoffice/inicio">PikaList BackOffice<img
					id="logo" src="images/logo_backoffice.png" alt="Logo de la APP"></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse justify-content-between"
					id="navbarResponsive">

					<c:if test="${empty usuario}">
						<!-- Usuario Logueado en session -->
						<ul class="navbar-nav align-items-center">
							<li class="nav-item active"><a class="text-pika"
								href="login.jsp">Acceder/Login</a></li>
							<li class="nav-item"><a class="text-pika"
								href="registroUsuario.jsp">Date de Alta</a></li>
						</ul>
					</c:if>
					<c:if test="${not empty usuario}">
						<!-- Usuario No Logueado -->
						<ul class="navbar-nav align-items-center">
							<li class="nav-item">
								<div class="text-light text-right m-1">
									Bienvenido <i class="fas fa-user-circle"></i>${usuario.nombre}
									<a class="text-pika-yellow" href="inicio">Ir al Inicio</a> <a
										class="text-pika-yellow" href="logout">Cerrar Sesion</a>
								</div>
							</li>
						</ul>
					</c:if>

					<ul class="navbar-nav">
						<li class="nav-item"><a href="inicio?idioma=es_Es"><img
								src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Flag_of_Spain.svg/20px-Flag_of_Spain.svg.png"></a></li>
						<li class="nav-item"><a href="inicio?idioma=eu_Es"><img
								src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Flag_of_the_Basque_Country.svg/20px-Flag_of_the_Basque_Country.svg.png"></a></li>
						<li class="nav-item"><a href="inicio?idioma=en_En"><img
								src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Flag_of_the_United_Kingdom.svg/20px-Flag_of_the_United_Kingdom.svg.png"></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<div class="row mt-5">
		<div class="col-3">
			<h2 class="m-4 text-pika-blue">Panel de Acceso</h2>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">Cras justo odio</li>
				<li class="list-group-item">Dapibus ac facilisis in</li>
				<li class="list-group-item">Vestibulum at eros</li>
				<li class="list-group-item"><a href="#" class="btn-block">hsfhsafhalihfd</a></li>
			</ul>
		</div>
		<div class="col-9">
			<div class="row">
				<!-- <%@ include file="includes/alertas.jsp"%> -->
			</div>
			<div class="row">
				<div class="col-4 mt-1">
					<div class="card">
						<div class="card-body bg-pika-blue">
							<i class="fas fa-users fa-5x text-pika-yellow"></i>
						</div>
						<div class="card-footer bg-pika-purple">
							<a href="#" class="btn-block text-pika-yellow">Usuarios</a>
						</div>
					</div>
				</div>
				<div class="col-4 mt-1">
					<div class="card">
						<div class="card-body bg-pika-red">
							<i class="fab fa-youtube fa-5x text-pika"></i>
						</div>
						<div class="card-footer bg-pika-purple">
							<a href="#" class="btn-block text-pika-yellow">Videos</a>
						</div>
					</div>
				</div>
				<div class="col-4 mt-1">
					<div class="card">
						<div class="card-body bg-pika-yellow">
							<i class="fab fa-youtube fa-5x text-pika-blue"></i>
						</div>
						<div class="card-footer">
							<a href="#" class="btn-block">Videos</a>
						</div>
					</div>
				</div>
				<div class="col-4 mt-1">
					<div class="card">
						<div class="card-body bg-pika">
							<i class="fab fa-youtube fa-5x text-pika-red"></i>
						</div>
						<div class="card-footer">
							<a href="#" class="btn-block">Videos</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Cierre row principal -->
	<%@ include file="includes/footer.jsp"%>