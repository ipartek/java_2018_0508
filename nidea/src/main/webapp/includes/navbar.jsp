<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
      <a class="navbar-brand" href="index.jsp"><img src="imagen/nidea-logo.png" alt="foto logo"></a>
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
	            <a class="nav-link" href="components.jsp">componets</a>
	          </li>
	          <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		         J2EE
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="formulario">Formulario</a>
		          <a class="dropdown-item" href="fichero.jsp">Ficheros</a>	          
		        </div>
	      	</li>
	      	
	      	<li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	         Pantalla
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="formulario">Formulario</a>
	          <a class="dropdown-item" href="login.jsp">Login</a>	 
	          <a class="dropdown-item" href="registroUsuario.jsp">Registro</a>
	          <a class="dropdown-item" href="listadoUsuario.jsp">Listado usuario</a> 
	          <a class="dropdown-item" href="listadoEmpleado.jsp">Listado empleado</a>        
	        </div>
      	</li>    
        </ul>
       
      </div>
    </nav>
    
    <%@ include file="alert.jsp" %>