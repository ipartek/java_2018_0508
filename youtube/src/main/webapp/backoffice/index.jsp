<!-- Include the header -->
<%@ include file="../include/header.jsp"%>

<style>
	html {
		background-image: ../img/fondo-backoffice.jpg";
	}
	
</style>

<main class="container" role="main">
	
	<div class="row">
		<h1>Estamos en el Backoffice</h1>
		<p>*	Sólo pueden entrar usuarios logueados. </p>
	</div>
	
</main>

<h2>Usuarios conectados: </h2>
<%
	
	int num = (Integer) application.getAttribute("numusuariosEnLinea");

%>
<p><%= num %></p>

<!-- Include the footer -->
<%@ include file="../include/footer.jsp"%>