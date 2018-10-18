<!-- Cabecera -->
<%@ include file="include/header.jsp" %>

<!-- Navbar -->
<%@ include file="include/navbar.jsp" %>

<main class="container" role="main">
	
	<div class="row align-center">
        <div class="col color-primary">
			<!-- Gestión de alertas -->
			<%@include file="include/alert.jsp" %>
		</div>
	</div>
	
	<div class="row align-center">
        <div class="col color-primary">
			<!-- Formulario de Acceso -->
			<%@ include file="include/modal-login-form.jsp" %>
		</div>
	</div>
	
	<div class="row align-center">
        <div class="col-md-12 color-primary">
            <div class="error-template">
                <h1>404 No Encontrado</h1>
                <h2>Ooops!</h2>
                
                <div class="error-details">
                   <p>Lo sentimos, ha ocurrido un error inesperado. 
                   La página ${requestScope["javax.servlet.forward.request_uri"]} no está disponible.</p>
                </div>
                
                <div class="error-actions">
                    <a href="inicio" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>Inicio </a>
                    <a href="mailto:example@email.com" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-envelope"></span> Contáctanos </a>
                </div>
            </div>
        </div>
    </div>
</main>

<!-- Pie de Página -->
<div class="row align-center fixed-bottom">
	<div class="col-md-12 color-primary">
		<%@ include file="include/footer.jsp" %>
	</div>
</div>