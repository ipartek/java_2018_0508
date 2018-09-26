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
    <title>Página de Login</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link rel="stylesheet" href="css/styles.css">

</head>
<body>
	<form method="post" action="loginController">
		<label for="nombre">Nombre:</label>
		<input type="text" name="nombre" placeholder="Ej: Luisito" value="pablo" autofocus required />
		<label for="pass">Contraseña:</label>
		<input type="password" name="pass" value="neruda" required />
		<input type="submit" value="Acceder"/>
	</form>
</body>
</html>