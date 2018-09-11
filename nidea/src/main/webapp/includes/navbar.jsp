    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
      <a class="navbar-brand" href="#"><img src="images/imagen01.svg" alt="logo de la empresa" width="100" height="100">Nidea</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="grid.jsp">Grid System<i class="fas fa-cookie-bite nope"></i></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="componentes.jsp">Componentes<i class="fas fa-cookie-bite nope"></i></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="arkanoid.jsp">Arkanoid<i class="fas fa-cookie-bite nope"></i></a>
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
	          <a class="dropdown-item" href="registro.jsp">Registro</a>
	          <a class="dropdown-item" href="listado.jsp">Listado Bonito</a>
	          <a class="dropdown-item" href="listado-tabla.jsp">Listado DataTable</a>
	        </div>
	      </li>
        </ul>
      </div>
    </nav>
    
<%@ include file="alert.jsp"%>