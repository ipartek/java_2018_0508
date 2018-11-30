<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main class="container mt-4">

	<h1 class="text-center">Proceso de migración de datos</h1>
	
	<hr>
	
	<div class="row">
		<div class="col">
			<p class="text-center"><b>*El fichero de texto a leer debe estar en la ruta &rArr; <code class="text-dark">C:\ficheros</code></b></p>		
		</div>
	</div>
	
	<div class="row justify-content-center">
		<div class="col col-8">
			<a href="personas?op=5" class="btn btn-block btn-outline-primary">EJECUTAR MIGRACIÓN</a>
		</div>
	</div>

	<c:if test="${not empty leidos}">
		<hr>
		
		<h2 class="mt-4">Resultados de la migración del fichero con personas: </h2>
		<fieldset>
			<p>*Tiempo de carga de datos: ${tiempoEjecucion}.*</p>
			<p><b> Registros leídos: </b><b class="text-info">${leidos}</b></p>
			<p><b>Registros insertados: </b><b class="text-success">${correctos}</b></p>
			<p class="text-danger"><b>Registros erróneos: </b><b class="text-danger">${errores}</b></p>
		</fieldset>
		
		<c:if test="${not empty errores}">
			<hr>
			<span><b>Errores encontrados: </b></span>
			<ul>
				<c:forEach items="${erroresRegistrados}" var="e">
					<li>${e}</li>
				</c:forEach>
			</ul>
		</c:if>
	</c:if>
		
	
	

</main>

<%@include file="includes/footer.jsp"%>