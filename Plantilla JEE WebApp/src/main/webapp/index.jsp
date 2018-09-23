<!-- Cabecera con navegador -->
<%@ include file="vendor/include/header.jsp" %>

<main class="container mt-5" role="main">
	
	<!-- Gestión de alertas -->
	<div class="row align-center">
        <div class="col color-primary">
			<%@include file="../../vendor/include/alert.jsp" %>
		</div>
	</div>
	
	<!-- Formulario de Acceso -->
	<div class="row align-center">
        <div class="col-lg-3 color-primary">
			<%@ include file="vendor/include/modal-login-form.jsp" %>
		</div>
	</div>
	
	<p>Contenido del main.</p>
</main>

<!-- Pie de Página -->
<div class="row align-center fixed-bottom">
	<div class="col-md-12 color-primary">
		<%@ include file="vendor/include/footer.jsp" %>
	</div>
</div>