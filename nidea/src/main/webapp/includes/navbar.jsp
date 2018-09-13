
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#"><img class="logo" src="images/nidea.png"></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="index.jsp">Inicio <span class="sr-only">(current)</span></a>
          </li>
          
          
          <li class="nav-item">
            <a class="nav-link " href="components.jsp">Componentes</a>
          </li>
           <li class="nav-item">
            <a class="nav-link " href="flex_examples.jsp">FlexBox</a>
          </li>
          
          <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          JEE
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="formulario">Formulario</a>
	          <a class="dropdown-item" href="fichero.jsp">Fichero</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="#">Something else here</a>
	        </div>
      	</li>
      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Pantallas
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="registroUsuarios.jsp">Registro</a>
	          <a class="dropdown-item" href="login.jsp">Login</a>
	          <a class="dropdown-item" href="listarUsuariosControler">Listado de usuarios</a>
	          <a class="dropdown-item" href="listarUsuariosAdmin">Listado de usuarios(Administracion)</a>
	          
      </li>
      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Productos
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="formulario">Añadir productos</a>
	          <a class="dropdown-item" href="listarControler">Listar productos(User zone)</a>
	          <a class="dropdown-item" href="listarProductosAdmin">Listar productos(Administracion)</a>
			
	          
      </li>
        </ul>
        <!-- <form class="form-inline mt-2 mt-md-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form> -->
      </div>
    </nav>
<%@include file="alert.jsp" %>
