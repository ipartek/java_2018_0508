<%@include file="includes/taglibs.jsp"%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="com.adriana.prado.pojo.Usuario"%>
<%@page import="com.adriana.prado.pojo.Alert"%>
<%@page import="com.adriana.prado.controller.HomeController"%>
<%@page import="com.adriana.prado.pojo.Video"%>
<%@page import="java.util.ArrayList"%>


<%@include file="includes/header.jsp"%>

<div class="container mt-4 mb-4">

	<%@include file="includes/navbar.jsp"%>

	<%@include file="includes/alert.jsp"%>
	
	<div class="row justify-content-center">
	
		<div class="col-6">
			
			<h1 class="text-center">Registro nuevos usuarios</h1>
			
			<form action="registro" method="post" class="formularioregistro" >
				<div class="form-row">
					<div class="col">
						<div class="form-group">
						   <label class="required" for="usuario">Usuario: </label>
						   <input class="form-control" type="text" name="usuario" placeholder="Mínimo 3 caracteres y máximo 10" minlength="4" maxlength="10" autofocus tabindex="1" required>
					   </div>
					</div>
				</div>
				
				<div class="form-row">
					<div class="col">
						<div class="form-group">
						    <label class="required" for="pswd">Contraseña: </label>
						    <input class="form-control" type="password" name="pswd" placeholder="Mínimo 4 caracteres" minlength="4" tabindex="2" required>
						</div>
					</div>	
					<div class="col">
						<div class="form-group">
						    <label class="required" for="pswd">Repite la contraseña: </label>
						    <input class="form-control" type="password" name="pswdRepe" placeholder="Repite la contraseña anterior" minlength="4" tabindex="3" required>
						</div>
					</div>
				</div>
				
				<input class="form-control btn btn-outline-primary" type="submit" value="Dar de Alta">
			</form>
			<!-- /.registro -->
		</div>
		<!-- .col -->
	</div>
	<!-- .row -->
</div>
<!-- /.container -->

<%@include file="includes/footer.jsp"%>