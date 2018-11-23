<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="includes/header.jsp"%>
	
<%@include file="includes/navbar.jsp"%>

<main class="container">

	<%@include file="includes/alert.jsp"%>

	<div class="row mt-4 justify-content-center">
		<div class="col col-6 text-center">
			<a class="btn btn-block btn-outline-${(not empty usuario)?'success':'danger'}" href="/privado/privado.jsp">Acceder Privado</a>
		</div>
	</div>
	<h1 class="text-center mt-2">Iniciar sesión</h1>
	<div class="row justify-content-center">
		<div class="col col-6">
			<form action="login" method="post">
				<div class="form-group">
					<label for="usuario">Nombre de usuario: </label>
					<input type="text" class="form-control" name="usuario" placeholder="Usuario">
				</div>
				<div class="form-group">
					<label for="pass">Contraseña:</label>
					<input type="password" class="form-control" name="pass" placeholder="Password">
				</div>
				<input type="submit" class="btn btn-block btn-outline-primary" value="Entrar">
			</form>
		</div>
	</div>
</main>

<%@include file="includes/footer.jsp"%>