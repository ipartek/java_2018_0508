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

    <title>PikaList</title>

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
	<!-- Formulario de login -->
	<div class="row">
		<div class="col-3 m-auto fondo-login-form">
		<h1><i class="fas fa-user-circle"></i>Nuevo Usuario</h1>
			<form action="altaUsuario" method="post">
       	<label for="nombre">Introduzca su nombre:</label>
       	<input  class="form-control" id="nombre" name="nombre" type="text" value="" required autofocu/>
       	<label for="pass">Introduzca su contraseña:</label>
       	<input class="form-control" id="pass" name="pass" type="password" value="" required/>
       	<label for="pass">Repita la contraseña:</label>
       	<input class="form-control" id="pass2" name="pass2" type="password" value="" required/>
       	<div class="m-2">
       		<input class="btn btn-success" type="submit" value="Darse de Alta" />
       		<button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
       	</div>
       </form>
		</div>
	</div>
	</body>
</html>