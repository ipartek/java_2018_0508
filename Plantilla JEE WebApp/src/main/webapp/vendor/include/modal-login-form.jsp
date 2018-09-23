<!-- MODAL LOGIN FORM -->

<div id="modal-login-form" class="modal fade align-center" tabindex="-1" aria-hidden="true" aria-labelledby="Acceso para miembros" aria-describedby="Acceso para miembros" role="dialog">
		<div class="modal-dialog modal-login">
			<div class="modal-content">
				
				<div class="modal-header">
					<div class="avatar">
						<img src="https://www.omdream.com/wp-content/uploads/Experiencia-Usuario.png" alt="Imagen de login">
					</div>				
					<h4 class="modal-title">Acceso para miembros</h4>	
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				</div>
				
				<div class="modal-body">
					<form action="login" method="post">
						
						<div class="form-group">
							<div class="input-group">
								<label class="input-group-text" for="usuario"><i class="fas fa-user"></i></label>
							    <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Usuario" required pattern=".{3,30}"
							    value="${cookie.cNombre.value}">
							</div>		
						</div>
						
						<div class="form-group">
							<div class="input-group">
								<label class="input-group-text" for="password"><i class="fas fa-key"></i></label>
							    <input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" required pattern=".{4,30}">
							</div>		
						</div>   
						
						<div class="form-check mb-3 ml-2">
						    <input type="checkbox" class="form-check-input" id="recordar" name="recordar" ${(not empty cookie.cNombre.value)?"checked":""}>
						    <label class="form-check-label" for="recordar">Recordar usuario</label>
						</div>     
						
						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-lg btn-block login-btn text-white">Acceder</button>
						</div>
						
					</form>
				</div>
				
				<div class="modal-footer text-primary">
					<a class="text-primary" href="#">Registrarme</a>
					<span> - </span>
					<a class="text-primary" href="#">Olvidé mi contraseña</a>
				</div>
			</div>
		</div>

</div>       