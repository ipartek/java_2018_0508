<!-- Navigation -->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
   <div class="container">
   	<img class="logo"alt="logo youtube" src="http://www.stickpng.com/assets/images/580b57fcd9996e24bc43c545.png">
     <a class="navbar-brand" href="#">Youtube PlayList</a>
     <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
       <span class="navbar-toggler-icon"></span>
     </button>
     
    
     
     <div class="collapse navbar-collapse" id="navbarResponsive">
     
     	<ul id="idioma" class="navbar-nav ml-auto">
     		<li class="nav-item"><a href="inicio?idioma=es_ES">es</a></li>
     		<li class="nav-item"><a href="inicio?idioma=eu_ES">eu</a></li>
     		<li class="nav-item"><a href="inicio?idioma=en_EN">en</a></li>
     	</ul>
     
       <ul class="navbar-nav ml-auto">
         <li class="nav-item active">
              	
         
		         <!-- usuario sin pasar por login -->
		         <c:if test="${empty sessionScope.usuario}">
		            <!-- formulario Login -->
		            <form action="login" method="post" class="form-inline mt-2 mt-md-0">
		           		<input name="usuario" value="${cookie.cNombre.value}" class="form-control mr-sm-2" type="text" placeholder="Nombre Usuario" required pattern=".{3,30}">
		           		<input name="pass" value="" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
		           		<label class="text-warning" for="recuerdame">¿Recordar?</label>
		           		<input class="recuerdame" type="checkbox" name="recuerdame" ${(not empty cookie.cNombre.value)?"checked":""} >		           		 
		           <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
		         </form>
		       </c:if>         
		        
		         <!-- usuario logeado -->
		         <c:if test="${not empty sessionScope.usuario}">
		           <div class="nav-user">             	
		           	<i class="fas fa-user">${usuario.nombre}</i>             	
		           	<a href="backoffice/index.jsp">Acceder Backoffice</a>
		           	<a href="logout">Cerrar Session</a>
		           </div>            
		         
		            <!-- formulario Crear Video -->
		            <form action="inicio" method="post" class="form-inline mt-2 mt-md-0">
		           <input name="id" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
		           <input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
		           <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
		         </form>	          
		       </c:if>
		        
         </li>            
       </ul>
       
       
       
     </div>
   </div>
 </nav>