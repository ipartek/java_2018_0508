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
    <title>Página principal</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link rel="stylesheet" href="css/styles.css">

</head>
<body>
	<header>
		<c:if test="${not empty usuario}">
			<nav>
				<ul>
					<li><a href="privado/escribirPagina.jsp?pActual=${pActual+2}">Escribir Pagina</a></li>
					<li>Bienvenido ${usuario.nombre}<a href="logout">Cerrar Sesion</a></li>
				</ul>
			</nav>
		</c:if>
		<c:if test="${empty usuario}">
			<nav>
				<ul>
					<li><a href="login.jsp">Iniciar Sesion</a></li>
				</ul>
			</nav>
		</c:if>
	</header>
	<h2>${alert}</h2>
	<div>
	<p>Ir a pagina: </p>
		<form method="post" action="home">
			<input type="number" name="nPaginas" />
			<input type="submit" value="IR"/>
		</form>
	</div>
	
	<h2>PAGINA <span>${pActual+1}</span>/<span>${pTotal}</span></h2>
	<p>
		<span>${pActual+1}</span>
		${pagina.texto}
		<span>${pagina.autor}</span>
	</p>
	<a href="home?nPagina=${pActual-1}">Anterior</a>
	<a href="home?nPagina=${pActual+1}">Siguiente</a>
</body>
</html>