<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">Fixed navbar</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          
          <li class="nav-item active">
            <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="grid.jsp">Grid System</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="components.jsp">Components</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="arkanoid.jsp">Arkanoid</a>
          </li>
          
          <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          JEE
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="formulario.jsp">Alta de Productos</a>
	          <a class="dropdown-item" href="fichero.jsp">Subida de Ficheros</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="#">Something else here</a>
	        </div>
      		</li>
      		<!-- END DROPDOWN -->
      		<li class="nav-item">
            <a class="nav-link" href="registro.jsp">Registro</a>
          </li>
        </ul>
      </div>
 </nav>
 
 <%@include file="alert.jsp"%>