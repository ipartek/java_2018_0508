<%@include file="taglibs.jsp" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light bg-nav-custom">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
      </li>
      <!-- usuario logueado -->
      <c:if test="${not empty sessionScope.usuario}">
	      <li class="nav-item">
	        <a class="nav-link " href="home?op=alta">Registrar perro</a>
	    	</li>
	  </c:if>
     
      <!-- Usuario no loggeado -->
	  <c:if test="${empty sessionScope.usuario}">
      	
      	<form class="form-inline my-2 my-lg-0" action="login" method="post">
    	<input class="form-control mr-sm-2" type="text" placeholder="nombre usuario" name="nombreLogin" required value="scobby">
      	<input class="form-control mr-sm-2" type="password" placeholder="contraseña usuario" name="passUsuario" required value="galletas">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Entrar</button>
    </form>
      </c:if>
    </ul>
    <c:if test="${not empty sessionScope.usuario}">
    
    <ul class="nav navbar-top-links navbar-right">
    
		<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i> Cerrar Sesión</a>
	</ul>
    </c:if>
    
    
  </div>
</nav>