<%@include file="taglibs.jsp"%>




<nav class="navbar navbar-expand-lg navbar-light bg-light">
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
    	<a class="nav-item nav-link" href="inicio">Inicio</a>
     <!-- Usuario no logueado -->
		<c:if test="${empty sessionScope.usuario }">
			<a class="nav-item nav-link" href="login.jsp">Iniciar Sesion</a>
		</c:if>	
		
      <!-- Usuario logueado -->
		<c:if test="${not empty sessionScope.usuario}">	
			<a class="nav-item nav-link" href="backoffice/escribirPagina.jsp">Escribir pagina</a>	
			<a class="nav-item nav-link" href="logout">Cerrar Sesion</a>	
		</c:if>	
    </div>
  </div>
</nav>