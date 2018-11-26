<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main class="container">
		
	<h1 class="mt-4">Resultados de la búsqueda de <strong>"${palabra}"</strong>: </h1>
	<h2>${personasEncontradas.size()} resultado(s) en total.</h2>
	
	<c:forEach items="${personasEncontradas}" var="p">
			<span><strong>Id: </strong> ${p.id}</span>
			<span><strong>Nombre: </strong>${p.nombre}</span><br>
			<span><strong>Primer apellido: </strong>${p.apellido1}</span>
			<span><strong>Segundo apellido: </strong>${p.apellido2}</span><br>
			<span><strong>DNI: </strong>${p.dni}</span><br>
			<span><strong>Correo electrónico: </strong>${p.email}</span>	
		<hr>
	</c:forEach>

</main>

<%@include file="includes/footer.jsp"%>