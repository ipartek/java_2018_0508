<!-- Navigation -->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
   <div class="container">
     <a class="navbar-brand" href="#">Youtube PlayList</a>
     <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
       <span class="navbar-toggler-icon"></span>
     </button>
     
    
     
     <div class="collapse navbar-collapse" id="navbarResponsive">
     	
     	
     	<ul class="navbar-nav ml-auto idioma">
     		<li class="nav-item ${(sessionScope.idioma eq 'es_ES')?'active':''}"><a href="inicio?idioma=es_ES">es</a></li>
     		<li class="nav-item ${(sessionScope.idioma eq 'eu_ES')?'active':''}"><a href="inicio?idioma=eu_ES">eu</a></li>
     		<li class="nav-item ${(sessionScope.idioma eq 'en_EN')?'active':''}"><a href="inicio?idioma=en_EN">en</a></li>
     	</ul>
     
       <ul class="navbar-nav ml-auto">
         <li class="nav-item active">
              	
         
		         <!-- usuario sin pasar por login -->
	         <c:if test="${empty sessionScope.usuario}">

		          	<form action="login" method="post" class="form-inline mt-2 mt-md-0">
		            <input id="usuario" name="usuario" class="form-control mr-sm-2" type="text" placeholder="Nombre Usuario" value="admin" required pattern=".{3,30}"> 
		            <input name="pass" class="form-control mr-sm-2" type="password" placeholder="Contraseña" value="admin" required pattern=".{2,50}">
		            <span class="text-primary">Recuerdame</span>
		            <input name="recuerdame" type="checkbox" class="form-check-input" id="exampleCheck1">
		            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
		         
		         </form> 
		          <a href="registroUsuariosFormulario.jsp">Registrate</a>
		       </c:if>         
		        
		         <!-- usuario logeado -->
		         <c:if test="${not empty sessionScope.usuario}">
		           <div class="nav-user">             	
		           	<i class="fas fa-user">${usuario.nombre}</i> 
		           	     <c:if test="${ sessionScope.usuario.nombre == 'admin'}">       	
		           			<a href="backoffice/inicio">Acceder Backoffice</a>
	           			</c:if>
		                     	
		           			<a href="perfil/inicio">Panel de control</a>
		           
		           	<a href="logout">Cerrar Session</a>
		           </div>            
		         
		            <!-- formulario Crear Video -->
		            <form id="agregarCancionNavbar" action="inicio" method="post" class="form-inline mt-2 mt-md-0">
		            <input type="hidden" name="usuarioId" value="${usuario.id}">
		           <input name="codigo" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
		           <input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
		           <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
		         </form>
		         <!-- formulario editar Video -->
	            <!-- <form id="editarCancionNavbar" action="inicio" method="post" class="form-inline mt-2 mt-md-0">
            		<input name="editarVideoId" class="form-control mr-sm-2" type="number" min="1" placeholder="ID del video" title="ID del video" required >
		           <input name="editarCodigo" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
		           <input name="editarNombre" class="form-control mr-sm-2" type="text" placeholder="Nuevo nombre del video 2 letras" required pattern=".{2,125}">
		           <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Editar</button>
		         </form>	 -->	               	          
		       </c:if>   
         </li>            
       </ul> 
     </div>
   </div>
 </nav>
<%@ include file="alert.jsp" %>