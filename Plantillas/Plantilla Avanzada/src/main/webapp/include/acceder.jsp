<nav class="login">
	<ul>
		<li>
			<a id="login" href="#">Acceder</a>
			<div id="login-content">

				<form action="login" method="post">
					<div class="form-group">
						<div class="input-group">
							<label class="input-group-text" for="usuario" title="Usuario">
								<i class="fas fa-user" aria-hidden></i>
							</label> 
							<input type="text" class="form-control" id="usuario" name="usuario" value="${cookie.cNombre.value}" placeholder="Introduce tu usuario" required pattern=".{3,30}">
						</div> <!-- ./ input-group -->	
					</div> <!-- ./ form-group -->	
		
					<div class="form-group">
						<div class="input-group">
							<label class="input-group-text" for="password" title="Contraseña">
								<i class="fas fa-key"></i>
							</label> 
							<input type="password" class="form-control" id="password" name="password" placeholder="Introduce tu contraseña" required pattern=".{4,30}">
						</div> <!-- ./ input-group -->	
					</div> <!-- ./ form-group -->	
		
					<div class="form-check mb-3 ml-2">
						<input type="checkbox" class="form-check-input" id="recordar" name="recordar" ${(not empty cookie.cNombre.value)?"checked":""}>
							<label class="form-check-label" for="recordar">Recordar usuario</label>
					</div>
		
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg btn-block login-btn text-white">Acceder</button>
					</div>
				</form>
			</div> <!-- #/ login-content -->	
		</li>
	</ul>
</nav>