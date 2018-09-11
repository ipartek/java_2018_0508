<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<img src="images/nidea.png" alt="Smiley face" height="42">

	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
	  <span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link" href="index.jsp">Home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="grid.jsp">Grid System</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="components.jsp">Components</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="formulario">Formulario</a>
			</li>
			<li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          JEE
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="formulario">Formulario</a>
		          <a class="dropdown-item" href="fichero.jsp">Fichero</a>
		        </div>
		    </li>
		    <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Pantallas
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="login.jsp">Login</a>
		          <a class="dropdown-item" href="formulario">Formulario</a>
		          <a class="dropdown-item" href="registro.jsp">Registro de usuarios</a>
		          <a class="dropdown-item" href="mostrar.jsp">Listado productos (publico)</a>
		          <a class="dropdown-item" href="dashboard.jsp">Listado productos (privado)</a>
		        </div>
		    </li>
		</ul>
	</div>
</nav>

<%@ include file="alert.jsp" %>