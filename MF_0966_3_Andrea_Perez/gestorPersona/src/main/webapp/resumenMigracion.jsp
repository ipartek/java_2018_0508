<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<div class="container">
		
	<h1 class="mt-4 text-center">Resultados de la migración de datos </h1>
	
	<p>Total de registros leídos: <b class="text-info">${leidos}</b></p>
	<p>Total de registros insertados: <b class="text-success">${correctos}</b></p>
	<p>Total de registros erróneos: <b class="text-danger">${errores}</b></p>

</div>



















<%@include file="includes/footer.jsp"%>