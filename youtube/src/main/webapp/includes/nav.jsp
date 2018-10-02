<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="inicio"><i class="fab fa-youtube youtube-logo"></i> Youtube PlayList</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
            
           <!-- usuario sin pasar por login -->
		         <c:if test="${empty sessionScope.usuario}">
		            <!-- formulario Login -->
		            <form action="login" method="post" class="form-inline mt-2 mt-md-0">
		           		<input name="usuario" value="${cookie.cNombre.value}" class="form-control mr-sm-2" type="text" placeholder="Nombre Usuario" required pattern=".{3,30}">
		           		<input name="pass" value="" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
		           		<label class="text-warning" for="recuerdame">¿Recordar?</label>
		           		<input type="checkbox" name="recuerdame" ${(not empty cookie.cNombre.value)?"checked":""} >		           		 
		           <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
		         </form>
		         <p onclick="showModalRegistro()" class="enlaceRegistro text-primary">Darme de alta en la plataforma</p>
		       </c:if>         
		        
		         <!-- usuario logeado -->
		         <c:if test="${not empty sessionScope.usuario}">
		           <div class="nav-user">             	
		           	<i class="fas fa-user logeado"> ${usuario.nombre}</i>             	
		           	<a href="backoffice/index.jsp">Acceder Backoffice</a>
		           	<a href="logout">Cerrar sesión</a>
		           </div>            
		         
		            <!-- formulario Crear Video -->
		            <form action="inicio" method="post" class="form-inline mt-2 mt-md-0">
		           <input name="codigo" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
		           <input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
		           <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
		         </form>	          
		       </c:if>
	          
            </li>
            <ul class="navbar-nav ml-auto selector-idiomas">
		        <li class="nav-item ml-2 mr-2"><a href="inicio?idioma=eu_ES" class="${(sessionScope.idioma eq 'eu_ES')?'idioma-activo':''}"><img src="https://image.flaticon.com/icons/png/128/555/555559.png" title="Euskera" alt="idioma-euskera" /></a></li>
		        <li class="nav-item mr-2"><a href="inicio?idioma=es_ES" class="${(sessionScope.idioma eq 'es_ES')?'idioma-activo':''}"><img src="https://yeguadalaparrilla.com/Media/yeguadalaparrilla/imagenes/bandera%20Espa%C3%B1a.png" title="Espa�ol" alt="idioma-espa�ol" /></a></li>
		        <li class="nav-item"><a href="inicio?idioma=en_EN" class="${(sessionScope.idioma eq 'en_EN')?'idioma-activo':''}"><img src="https://yeguadalaparrilla.com/Media/yeguadalaparrilla/imagenes/Bandera%20Inglaterra.png" title="Ingl�s" alt="idioma-ingles" /></a></li>
            </ul>            
          </ul>
          
        </div>
      </div>
    </nav>