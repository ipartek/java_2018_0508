<%@ include file="includes/header.jsp"%>
<%@ include file="includes/nav.jsp"%>
<div class="row justify-content-center mb-4">
	<div class="col-10">
		<div class="alert alert-primary" role="alert">Se han procesado ${personasTotales} personas.</div>

		<div class="alert alert-success" role="alert">Se han añadido ${personasCreadas} personas.</div>

		<div class="alert alert-danger" role="alert">Hay ${errores} errores.</div>
	</div>
</div>
<%@ include file="includes/footer.jsp"%>