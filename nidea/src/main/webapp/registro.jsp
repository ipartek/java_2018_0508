<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<main class="container" role="main">
	
		<div class="row justify-content-center">
			<h1 id="login-h1" class="col col-md-6"><i class="fas fa-address-card"></i> Registro</h1>
		</div>
		
		<div class="row justify-content-center">
			<small id="login-small" class="col col-md-6">Los campos con * son obligatorios</small>
		</div>
		
		<form>
		
			<div class="form-row justify-content-center">
			
				<div class="col col-md-6">
		
					<div class="form-group">
						<label for="usuario" class="required">Usuario</label>
						<input type="text" class="form-control" id="usuario" minlength="5" maxlength="15" autofocus required placeholder="Nick del usuario (5 a 15 caracteres)" />
					</div>
					
					<div class="form-row">
					
						<div class="form-group col">
							<label for="pass" class="required">Contraseña</label>
							<input type="password" class="form-control" id="pass" minlength="8" maxlength="20" required placeholder="(8 a 20 caracteres)" />
						</div>
						
						<div class="form-group col">
							<label for="pass_repetida" class="required">Repita la contraseña</label>
							<input type="password" class="form-control" id="pass_repetida" minlength="8" maxlength="20" required placeholder="(8 a 20 caracteres)" />
						</div>
					
					</div>
					
					<div class="form-group">
						<label for="mail" class="required">E-mail</label>
						<input type="email" class="form-control" id="mail" required placeholder="ejemplo@gmail.com" />
					</div>
					
					<button type="submit" class="btn btn-outline-primary btn-block">Acceder</button>
					
				</div>
					
			</div>
			
		</form>
	
	</main>


<%@include file="includes/footer.jsp" %>