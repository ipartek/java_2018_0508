<nav class="navbar navbar-expand-lg navbar-dark bg-dark rounded shadow-sm">
	<!-- Navbar content -->
	<a class="navbar-brand" href="index.jsp">Web Repaso</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarText">
	    <ul class="navbar-nav mr-auto">
	    	<li class="nav-item">
				<a class="nav-link" href="login.jsp">Login</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="privado/privado.jsp">Privado</a>
			</li>
	    </ul>
  	</div>
  	<c:if test="${not empty usuario}">
		<div class="collapse navbar-collapse justify-content-end" id="navbarNav">
			<ul class="nav navbar-nav navbar-right">
				<li class="nav-item"><a class="nav-link" href="logout">Cerrar Sesión <i class="fas fa-sign-out-alt"></i></a>
			</ul>
		</div>
	</c:if>
	
</nav>