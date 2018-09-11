<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<main class="container" role="main">
	
		<h1><i class="fas fa-address-card"></i> Registro</h1>
		
		<form>
		
			<div class="form-row justify-content-center">
			
				<div class="col col-md-6">
		
					<div class="form-group">
						<label for="usuario">Usuario</label>
						<input type="text" class="form-control" id="usuario" autofocus required placeholder="Nick del usuario" />
					</div>
					
					<div class="form-group">
						<label for="pass">Contraseña</label>
						<input type="password" class="form-control" id="pass" required placeholder="Contraseña del usuario" />
					</div>
					
					<div class="form-group">
						<label for="pass_repetida">Repita la contraseña</label>
						<input type="password" class="form-control" id="pass_repetida" required placeholder="Contraseña del usuario" />
					</div>
					
					<div class="form-group">
						<label for="mail">E-mail</label>
						<input type="email" class="form-control" id="mail" required placeholder="ejemplo@gmail.com" />
					</div>
					
					<button type="submit" class="btn btn-outline-primary btn-block">Acceder</button>
					
				</div>
					
			</div>
			
		</form>
	
	</main>


<%@include file="includes/footer.jsp" %>