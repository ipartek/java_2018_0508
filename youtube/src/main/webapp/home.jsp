<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>

<c:set var="idioma" value="${(not empty sessionScope.idioma)?sessionScope.idioma:'es_ES'}" />
<fmt:setLocale value="${idioma}" />
<fmt:setBundle basename="idiomas" /> 



<!DOCTYPE html>
<html lang="${idioma}">

  <head>

	<!-- Comenza todas las URLs desde el href indicado -->
	<base href="<%=request.getContextPath()%>/">
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Youtube Video Play List</title>

	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
	
    <!-- Bootstrap core CSS -->
    <link href="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://blackrockdigital.github.io/startbootstrap-shop-item/css/shop-item.css" rel="stylesheet">
    
    <link rel="stylesheet" href="css/styles.css">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="inicio"><i class="fab fa-youtube youtube-logo"></i> Youtube PlayList</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
            
            <!-- Usuario no logeado -->
            <c:if test="${empty usuario }">
	              <!-- formulario Login -->
	              <form action="login" method="post" class="form-inline mt-2 mt-md-0">
		            <input name="usuario" class="form-control mr-sm-2" type="text" value="${cookie.cNombre.value }" placeholder="Nombre Usuario" required pattern=".{3,30}">
		            <input name="pass" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
		            <input type="checkbox" id="recuerdame" name="recuerdame" class="form-control mr-sm-2" ${not empty (cookie.cNombre.value)?"checked":"" } /><label for="recuerdame" class="text-info">Recuérdame</label>
		            <button class="btn btn-outline-info ml-3 my-2 my-sm-0" type="submit">Entrar</button>
		          </form>            
	        </c:if>                  
	         
	         <!-- Usuario logeado -->
	         <c:if test="${not empty usuario }">
	         
	              <!-- formulario Crear Video -->
	              <form action="inicio" method="post" class="form-inline mt-2 mt-md-0">
		            <input name="id" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
		            <input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
		            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
		          </form>
		          
		          <div class="nav-user logeado">
	             	<i class="fas fa-user"> ${usuario.nombre }</i>
	             	<a href="backoffice/index.jsp">Acceder al backoffice</a>
	             	<a href="logout">Cerrar Sesión</a>
	             </div>		 
	                      
	         </c:if>
	          
            </li>
            <ul class="navbar-nav ml-auto selector-idiomas">
		        <li class="nav-item ml-2 mr-2"><a href="inicio?idioma=eu_ES" class="${(sessionScope.idioma eq 'eu_ES')?'idioma-activo':''}"><img src="https://image.flaticon.com/icons/png/128/555/555559.png" title="Euskera" alt="idioma-euskera" /></a></li>
		        <li class="nav-item mr-2"><a href="inicio?idioma=es_ES" class="${(sessionScope.idioma eq 'es_ES')?'idioma-activo':''}"><img src="https://yeguadalaparrilla.com/Media/yeguadalaparrilla/imagenes/bandera%20Espa%C3%B1a.png" title="Español" alt="idioma-español" /></a></li>
		        <li class="nav-item"><a href="inicio?idioma=en_EN" class="${(sessionScope.idioma eq 'en_EN')?'idioma-activo':''}"><img src="https://yeguadalaparrilla.com/Media/yeguadalaparrilla/imagenes/Bandera%20Inglaterra.png" title="Inglés" alt="idioma-ingles" /></a></li>
            </ul>            
          </ul>
          
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">
    
	  <h1>
	  	<fmt:message key="msg.video.por.visualizar">
	  		<fmt:param value="12"/>
	  	</fmt:message>
	  </h1>
    
      	<c:if test="${empty alert }">
      		${alert = null }
      		
      	</c:if>
      	
      	<c:if test="${not empty alert }">
      	
      		<div class="container">
				<div class="alert ${alert.tipo } alert-dismissible fade show" role="alert">
				  <p>${alert.texto }</p>
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
			</div>
      	</c:if>	
      <div class="row">

        <div class="col-lg-3">        	
          <h4 class="my-4"><fmt:message key="lista.reproduccion"/></h4>
          <ul class="list-group">
          
          	<c:forEach items="${videos }" var="v">
	            <li class="list-group-item d-flex justify-content-between align-items-center">     
	          	  	<a href="inicio?id=${v.id }">${v.nombre }</a>
	          	  	<a href="inicio?id=${v.id }&op=${HomeController.OP_ELIMINAR }"><i style="color:red;" class="float-right fas fa-trash-alt"></i></a>
	            </li>
	        </c:forEach>
	        
            </ul>
            
            <hr>
            
            <h4 class="my-4">Videos Visualizados</h4>
	          <ul class="list-group">
	          		          	
		          	<c:if test="${not empty reproducidos }">
		          	
		          		<c:forEach items="${reproducidos }" var="r">
		          		
			          		<li class="list-group-item d-flex justify-content-between align-items-center">     
				          	  	<a href="inicio?id=${r.id }">${r.nombre }</a>	          	  	
				            </li>
		          		
		          		</c:forEach>
		          	
		          	</c:if>
		          	
		            <c:if test="${empty reproducidos }">
	          			<li class="list-group-item d-flex justify-content-between align-items-center">
	          				<p>*Por favor Inicia Sesión para guardar tus vídeos reproducidos</p>
	          			</li>
	          		</c:if>
	          		
	            </ul>
            
          </div> <!-- /.col-lg-3 -->
          
            <c:if test="${empty videoInicio }">
            
            	<jsp:useBean id="videoInicio" scope="page" class="com.ipartek.formacion.youtube.pojo.Video"></jsp:useBean>
            
            </c:if>

        <div class="col-lg-9">

          <div class="card mt-4">
          
            <iframe id="iframe" width="823" height="415" src="https://www.youtube.com/embed/${videoInicio.id }" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
            
            
            
            <div class="card-body">
              <h3 class="card-title">${videoInicio.nombre }</h3>              
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p>
              <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
              4.0 stars
            </div>
          </div>
          <!-- /.card -->
          
          <c:if test="${empty usuario }">
          	<p class="mt-3 text-danger">*Por favor Inicia Sesión para poder comentar en los vídeos</p>
          </c:if>
          
          <c:if test="${not empty usuario }">
          
            <form action="comentario" method="post" id="form-comentario">
	            <div class="form-group mt-4">
					<textarea name="comentario" class="form-control" id="comentario" rows="3" placeholder="Inserta un comentario"></textarea>
					<button type="submit" class="btn btn-primary">Enviar comentario</button>
				</div>
            </form>
            
          </c:if>
            
          <div class="card card-outline-secondary my-4">
	    	<div class="card-header">
	        	Comentarios
	        </div>
	        <div class="card-body">
	        	        
	        <c:if test="${not empty comentario }">
	        
	        	<c:forEach items="${comentario }" var="c">
	        	
		        	<p>${c.texto }</p>
	              	<small class="text-muted">Posted by ${usuario.nombre } on ${fecha }</small>
	              	<hr>
	        	
	        	</c:forEach>
	        
	        </c:if>
            
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              <hr>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              <hr>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              
              
            </div>
          </div>
          <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

      </div>

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark home-footer">
        <c:set var="anyo" value="<%=new java.util.Date() %>" />
        <span class="text-info">Última visita <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${anyo}" /></span>
        <span class="text-white">Copyright &copy; Your Website <fmt:formatDate type="date" pattern="yyyy" value="${anyo}" /></span>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
