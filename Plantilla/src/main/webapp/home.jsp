<!-- Cabecera -->
<%@ include file="/include/header.jsp" %>

<!-- Navegador -->
<%@ include file="/include/navbar.jsp" %>

<main class="container mt-5" role="main">
	
	<!-- Gestión de alertas -->
	<c:if test="${alert != null }">
		<div class="row align-center">
	        <div class="col color-primary">
				<%@include file="/include/alert.jsp" %>
			</div>
		</div>
	</c:if>
	
	<!-- Formulario de Acceso -->
	<c:if test="${empty sessionScope.usuario}">
		<div class="row align-center">
	        <div class="col-lg-3 color-primary">
				<%@ include file="/include/modal-login-form.jsp" %>
			</div>
		</div>
	</c:if>
	
	<p>Contenido del main.</p>
</main>

<!-- Pie de Página -->
<div class="row align-center fixed-bottom">
	<div class="col-md-12 color-primary">
		<%@ include file="/include/footer.jsp" %>
	</div>
</div>