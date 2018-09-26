<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="home">Inicio</a>
		
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon">0</span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav mr-auto">
				<!-- Usuario Loggeado -->
				<c:if test="${not empty usuario}">
					<li class="nav-item">	
	                	<a class="nav-link" href="edicion/crearPagina.jsp">Nueva página</a>
	                </li>
				</c:if>	
			</ul>
			
			<ul class="navbar-nav">
				<!-- Usuario no loggeado -->
				<c:if test="${empty usuario}">
					<li class="nav-item">
						<a class="nav-link ml-1 mr-2" href="login.jsp">Iniciar Sesión</a>
					</li>
				</c:if>
				
				<c:if test="${not empty usuario}">
					<li class="nav-item mt-2">
						<span class="icono"><i class="fas fa-user"></i> ${usuario.nombre} |</span>
					</li>
					<li class="nav-item">
						<a class="nav-link ml-1 mr-2" href="logout">Cerrar Sesión</a>						
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>