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
		         <!-- usuario sin pasar por login -->
		         <c:if test="${empty sessionScope.usuario}">
		            <!-- formulario Login -->
		            <form action="login" method="post" class="form-inline mt-2 mt-md-0">
		           		<input name="usuario" value="${cookie.nomUsuario.value}" class="form-control mr-sm-2" type="text" placeholder="Nombre Usuario" required pattern=".{3,30}">
		           		<input name="pass" value="" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
		           		<label class="text-warning" for="recuerdame">¿Recordar?</label>
		           		<input type="checkbox" name="recuerdame" ${(not empty cookie.nomUsuario.value)?"checked":""} >		           		 
		           <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
		         </form>
		       </c:if>         
		        
		         <!-- usuario logeado -->
		         <c:if test="${not empty sessionScope.usuario}">
		           <div class="nav-user">             	
		           	<i class="fas fa-user"> ${usuario.nombre}</i>             	
		           	<a href="logout" class="btn btn-success">Cerrar Session</a>
		           </div>              
		       </c:if>
		        
         </li>  
    </ul>
  </div>
</nav>