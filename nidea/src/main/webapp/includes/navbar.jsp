 <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
 	<img  class="navbar-brand" alt="" src="images/Logo.png" width="70" height="70">
      <a class="navbar-brand" href="#">Menú</a>
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
            <a class="nav-link" href="components.jsp">Componentes</a>
          </li>
           <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          JEE
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	          <a class="dropdown-item" href="formulario">Formulario</a>
	          <a class="dropdown-item" href="subida-fichero">File</a>
	        </div>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Pantallas
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	          <a class="dropdown-item" href="listadoBackend.jsp">Listado de productos Backend</a>
	          <a class="dropdown-item" href="listadoFrontend.jsp">Listado de productos Frontend</a>
	          <a class="dropdown-item" href="login.jsp">Login</a>
	          <a class="dropdown-item" href="registro.jsp">Registro</a>
	          
	        </div>
	      </li>
        </ul>
      </div>
    </nav>
    <%@include file="alert.jsp" %>