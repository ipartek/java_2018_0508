<%@ page contentType="text/html; charset=UTF-8" %>

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
     	</div>

        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
            
            <!-- Usuario sin pasar por el login -->
            <c:if test="${empty usuario}">
              <!-- formulario Login -->
              <form action="login" method="post" class="form-inline mt-2 mt-md-0">
	            <input name="usuario" class="form-control mr-sm-2" type="text" placeholder="Nombre Usuario" value="${cookie.cRecuerda.value }" required pattern=".{3,30}">
	            <input name="pass" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
	            <input name="recuerdame" type="checkbox" value="1" ${(not empty cookie.cRecuerda.value)?"checked":""} class="form-check-input" id="exampleCheck1">
    			<label class="form-check-label text-white" for="exampleCheck1">Recuerdame</label>
	            <button class="btn btn-outline-info my-2 my-sm-0 ml-2" type="submit">Entrar</button>
	          </form>                         
            </c:if>
            
            <!-- Usuario logeado -->
            <c:if test="${not empty usuario}">
             <div class="nav-user">             	
             	<i class="fas fa-user">${usuario.nombre}</i>             	
             	<a href="backoffice/index.jsp">Acceder Backoffice</a>
             	<a href="logout">Cerrar Session</a>
             </div>	
             
            
              <!-- formulario Crear Video -->
              <form action="inicio" method="post" class="form-inline mt-2 mt-md-0">
	            <input name="codigo" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
	            <input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
	            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
	          </form>	           
	        </c:if>
	          
            </li>            
          </ul>
          
          
          
        </div>
      </div>
    </nav>