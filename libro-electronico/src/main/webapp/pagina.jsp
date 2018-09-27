<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main class="container" role="main">

	<%@include file="includes/alert.jsp"%>

	<%@include file="includes/buscarPagina.jsp"%>

 	<h1 class="mt-2">${pagina.titulo}</h1>
 	
 	<c:if test="${pagina.id > 0}">
 	
	 	<p>
	 		${pagina.contenido}
	 	</p>
 	
 	</c:if>
	
</main>

<%@include file="includes/navPaginas.jsp"%>

<%@include file="includes/footer.jsp"%>