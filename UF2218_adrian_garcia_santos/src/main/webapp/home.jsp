<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="es">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Libro</title>
    <link rel="stylesheet" href="css/styles.css">
    
    <!-- Comienza todas las URLs desde el href indicado -->
    <base href="${pageContext.request.contextPath }/">
</head>
<body>

	<header>

		<div class="login">
		
			<c:if test="${empty usuario }">
				<a href="login.jsp">Iniciar sesión</a>
			</c:if> 
			
			<c:if test="${not empty usuario }">
				<p>${usuario.nombre }</p>
				<a href="logout">Cerrar sesión</a>
			
			</c:if>
			
		</div>
		
		<div>
		
			<c:if test="${not empty usuario }">
			
				<a href="privado/escribir.jsp">Escribir página</a><br><br>
			
			</c:if>
		
			<form action="paginaIndicada" method="post">
			
				<button>Ir a página</button>
				<input type="number" class="irAPagina" name="paginaIndicada" min="0" max="${nPaginas }" />
			</form>
			
		</div>
	
	</header>
	
	<div class="contenido">
	
		<a href="paginaAnterior?id=${pagina.id -1}">Anterior</a>
		
		<a href="paginaSiguiente?id=${pagina.id +1 }" class="siguiente">Siguiente</a>
		
		<div class="libro">
			
			
			<c:if test="${not empty paginaInicio }">
			
				<h2>Página ${paginaInicio.id } / ${paginaInicio.id }</h2>
				<p>${paginaInicio.texto }</p>
					
				<div class="piePagina">
					
					<p>Autor: ${paginaInicio.autor } </p>
					
				</div>
			
			</c:if>
			
			<c:if test="${empty paginaInicio }">
			
				<h2>Página ${pagina.id } / ${nPaginas }</h2>
				<p>${pagina.texto }</p>
					
				<div class="piePagina">
					
					<p>Autor: ${pagina.autor } </p>
					
				</div>
			
			</c:if>
			
			
			
		</div>
		
		<a href="paginaAnterior?id=${pagina.id -1}">Anterior</a>
		
		<a href="paginaSiguiente?id=${pagina.id +1 }" class="siguiente">Siguiente</a>
	
	</div>
	
	<footer>
	
		<form>
			<button>Buscar palabra</button>
			<input type="search" />
		</form>
	
	</footer>
	
</body>
</html>