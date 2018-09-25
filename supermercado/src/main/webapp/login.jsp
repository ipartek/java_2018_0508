<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
	<base href="<%=request.getContextPath()%>/">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">

</head>
<body class="fondo-login">

    <div class="contenedor">

        <main role="main" class="row m-5 justify-content-center">
			<div class="fondo-login-form">
				<div class="fondo-login-form-real">
					<c:if test="${not empty param.msg}">
					<p class="text-danger">${param.msg}</p>
				</c:if>

	            <form id="login-form" action="login" method="post">
	            	<h1 class=""><i class="fas fa-user"></i> Login</h1>
	                <small id="login-small">Los campos con * son obligatorios</small>
	                <br>
	                <div class="form-group">
	                	<label for="correo" class="required">Email: *</label>
	                    <input name="correo" type="text" class="form-control" id="correo" autofocus required placeholder="Ej: paco@gmail.com" />
	                </div>
	                <div class="form-group">
	                	<label for="pass" class="required">Contraseña: *</label>
	                	<input name="pass" type="password" class="form-control" id="pass" minlength="8" maxlength="20" required placeholder="Contraseña del usuario (8 a 20 caracteres)" />
	                </div>
	                <button type="submit" class="btn btn-outline-success btn-block">Acceder</button>
	            </form>
				</div>
				
			</div>
        </main>
    </div> <!-- /.contenedor -->
</body>
</html>