<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="includes/header.jsp"%>

<main class="container">
	<hr>
	
	<c:if test="${not empty juego}">
		<%@include file="includes/alert.jsp"%>
		<h2>Detalle juego creado</h2>
		<span><b>Id:</b> ${juego.id}</span>
		<br>
		<span><b>Título: </b>${juego.titulo}</span>
		<br>
		<span><b>Fecha de lanzamiento: </b>${juego.fecha_lanzamiento}</span>
	</c:if>

	<hr>

	<c:if test="${empty juegos}">
		<%@include file="includes/alert.jsp"%>
	</c:if>

	<h2>Lista de juegos</h2>
	
	<c:forEach items="${juegos}" var="j">
		
		<span><b>Id:</b> ${juego.id}</span>
		<br>
		<span><b>Título: </b>${juego.titulo}</span>
		<br>
		<span><b>Fecha de lanzamiento: </b>${juego.fecha_lanzamiento}</span>
		
		<hr>
	</c:forEach>
	
</main>



<%@include file="includes/footer.jsp"%>