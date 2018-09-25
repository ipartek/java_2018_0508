<!-- Menu -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<!-- Logo -->
 <img class="navbar-brand" alt="" src="imagenes/logo.png" width="100px">
<!-- / Logo -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    
      <li class="nav-item active">
        <a class="nav-link" href="home">Principal</a>
      </li>
      
        <c:if test="${empty sessionScope.usuario}">
      <li class="nav-item">
        <a class="nav-link" href="login.jsp">Iniciar Session</a>
      </li>
      </c:if>
          
      <c:if test="${not empty sessionScope.usuario}">
       <li class="nav-item">
        <a class="nav-link" href="alta-producto.jsp">Alta Producto</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="listado-producto.jsp">Listado Productos</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="home">Cerrar Session</a>
      </li>
      </c:if>
    </ul>
    
   
    
  </div>
</nav>