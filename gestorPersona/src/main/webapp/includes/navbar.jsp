<nav class="navbar navbar-default navbar-inverse" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">Plantilla Project</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="home?op=1">Listado Personas</a></li>
										
				</ul>				
				<ul class="nav navbar-nav navbar-right">					
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><b>Iniciar sesión</b> <span class="caret"></span></a>
						<ul id="login-dp" class="dropdown-menu">
							<li>
								<div class="row">
									<div class="col-md-12">										
										<form class="form" role="form" method="post" action="plantilla"
											accept-charset="UTF-8" id="login-nav">
											<div class="form-group">												
												<input type="text" class="form-control"
													name="user" placeholder="Nombre de Usuario" required>
											</div>
											<div class="form-group">												
												<input type="password" class="form-control" name="pass" placeholder="Contraseña" required>												
											</div>
											<div class="form-group">
												<input type="submit" class="btn btn-primary btn-block" value="Iniciar">
											</div>											
										</form>
									</div>
									<div class="bottom text-center">
										eres nuevo? <a href="registro.jsp"><b>Registrate</b></a>
									</div>
								</div>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
