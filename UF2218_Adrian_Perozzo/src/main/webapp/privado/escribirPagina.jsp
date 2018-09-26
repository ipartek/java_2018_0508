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
	<div class="form-pagina">
			<form method="post" action="escribir">
				<input type="hidden" name="nPagina" value="${param.pActual}" />
				<label for="texto">Escribe aqui:</label>
				<textarea name="texto" rows="" cols="">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam non laoreet magna. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec neque dui, volutpat sit. </textarea>
				<input type="submit" value="Escribir"/>
			</form>
		</div>
</body>
</html>