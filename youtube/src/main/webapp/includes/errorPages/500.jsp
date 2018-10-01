<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

	<main class="m-5 p-5 jumbotron bg-info text-light text-center" role="main">
		<h1><i class="fas fa-exclamation-triangle"></i> Error 500 <i class="fas fa-exclamation-triangle"></i></h1>
		<h2>Disculpe hemos tenido un problema tecnico en breves lo solucionaremos.</h2>
		<h3 class="text-justify">Vuelva a nuestra <a class="text-dark" href="inicio">Pagina principal</a> <i class="fas fa-home"></i> o pongase en contacto con nuestro <a class="text-dark" href="mailto:serviciotecnico@itlogistic.eus" >servicio tecnico</a> <i class="fas fa-envelope"></i></h3>
	</main>
	<%= exception.printStackTrace() %>

	<!-- Footer -->
	<footer class="bg-dark p-3 fixed-bottom">
		<p class="text-center text-white">Copyright &copy; Adrian Perozzo</p>
	</footer>
<%@ include file="../footer.jsp" %>