<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <a class="navbar-brand" href="index.jsp"><img src="img/nidea-logo.png"></a>
    
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
          <a class="nav-link" href="arkanoid.jsp">Arkanoid</a>
        </li>
        <li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" role="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">JEE</a>
			  
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  <a class="dropdown-item" href="formulario">Formularios</a>
			  <a class="dropdown-item" href="fichero.jsp">Ficheros</a>
			</div>
        </li>
        <li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" role="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">Páginas</a>
			  
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  <a class="dropdown-item" href="login.jsp">Login</a>
			  <a class="dropdown-item" href="registro.jsp">Registro</a>
			  <a class="dropdown-item" href="listaProductos.jsp">Lista Productos</a>
			  <a class="dropdown-item" href="listaCards.jsp">Lista Productos Cards</a>
			  <a class="dropdown-item" href="formulario">Formularios</a>
			</div>
        </li>
      </ul>
    </div>
  </nav>
  
  <%@include file="alert.jsp"%>