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

    <title>PikaList-Registro</title>

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
		<div class="col-5 m-auto fondo-login-form">
		<h1><i class="fas fa-user-circle"></i>Nuevo Usuario</h1>
			<form action="altaUsuario" method="post">
       	<label for="nombre">Introduzca su nombre:</label>
       	<input  class="form-control" id="nombre" name="nombre" type="text" value="${nombre}" required autofocus maxlength="50" pattern="{3,50}"/>
       	<label for="pass">Introduzca su contraseña:</label>
       	<input class="form-control" id="pass" name="pass" type="password" value="" required maxlength="20" pattern="{8,20}"/>
       	<label for="pass">Repita la contraseña:</label>
       	<input class="form-control" id="pass2" name="pass2" type="password" value="" required maxlength="20" pattern="{8,20}"/>
       		<br>
       		<input class="btn btn-outline-info btn-outline-pika btn-block" type="submit" value="Darse de Alta" />
       </form>
		</div>
	</div>
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="https://www.youtube.com/iframe_api"></script>
	</body>
</html>