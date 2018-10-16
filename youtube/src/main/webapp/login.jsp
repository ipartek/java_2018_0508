<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="idioma" value="${(not empty sessionScope.idioma)?sessionScope.idioma:'es_ES'}" />
<fmt:setLocale value="${idioma}" />
<fmt:setBundle basename="idiomas" /> 

<!DOCTYPE html>
<html lang="${idioma}">

  <head>

	<!-- Etiqueta HTML para comenzar las urls desde href indicado. -->
	<base href="<%=request.getContextPath()%>/">
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">

    <title>PikaList-Login</title>

	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <!-- FontAwesome CSS -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <!-- Custom CSS -->
	 <link href="css/style.css" rel="stylesheet" type="text/css"/>

  </head>

  <body class="fondo-login">
  <c:if test="${not empty sessionScope.alert}">
		<div class="container">
			<div class="alert alert-${alert.tipo} alert-dismissible fade show" role="alert">
				<strong>${alert.texto}</strong>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>
	<!-- Formulario de login -->
	<div class="row">
		<div class="col-3 m-auto fondo-login-form">
		<h1><i class="fas fa-user-circle"></i>Login</h1>
			<form id="login" action="login" method="post" class="">
				<div class="form-group">
					<input autofocus name="usuario" class="form-control mr-2" type="text" placeholder="Nombre de usuario" required pattern=".{3,30}" value="${cookie.nombreRecordado.value}">
					 <br> <input type="checkbox" name="recordar" checked><small>Recuerdame</small>
				</div>
				<div class="form-group">
					<input name="pass" class="form-control mr-2" type="password" placeholder="Contraseña" required pattern=".{2,50}" value="manoli">
				</div>
				<button class="btn btn-outline-info btn-outline-pika btn-block mr-2"
					type="submit">Entrar</button>
			</form>
		</div>
	</div>
	</body>
</html>