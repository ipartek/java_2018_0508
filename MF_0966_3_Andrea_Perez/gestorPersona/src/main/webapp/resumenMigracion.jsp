<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<div class="container">
		
	<h1 class="mt-4 text-center">Resultados de la migración de datos </h1>
	<p>El fichero de texto debe estar en <b>c:/datosMigrar/personas.txt</b> </p>
	
	
	<a href="home?op=5" class="btn btn-success">EJECUTAR</a>
	
	<c:if test="${leidos!=null && correctos!=null && errores!=null}">
		<p>Total de registros leídos: <b class="text-info">${leidos}</b></p>
		<p>Total de registros insertados: <b class="text-success">${correctos}</b></p>
		<p>Total de registros erróneos: <b class="text-danger">${errores}</b></p>
		<p>Tiempo de ejecucion:<b>${tiempo} segundos</b></p>
		
		<div class="row border">
			<div class="col">
				<ul>
					<p>Lineas errorneas</p>
					<c:forEach items="${cantLineaError}" var="cl">
						<li>${cl}</li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="col">
				<ul>
					<p>Mensaje Error:</p>
					<c:forEach items="${msg}" var="m">
						<li>${m}</li>
					</c:forEach>
				</ul>
			
			</div>
		</div>
		
	</c:if>
	

</div>



















<%@include file="includes/footer.jsp"%>