
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Youtube PlayList</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
 <% 
     	String fecha = "";
     	Cookie[] cookies = request.getCookies();
     	for( Cookie c : cookies ){
     		if ( "cVisita".equals(c.getName())){
     			fecha = URLDecoder.decode( c.getValue(), "UTF-8" );
     			break;
     		}	
     	}

		%>
		%>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
            
           
            <c:if test="${empty usuario}"> 
              
	              <form action="login" method="post" class="form-inline mt-2 mt-md-0">
		            <input id="usuario" name="usuario" class="form-control mr-sm-2" type="text" placeholder="Nombre Usuario" required pattern=".{3,30}"> 
		            <input name="pass" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
		            <span class="text-primary">Recuerdame</span>
		            <input name="recuerdame" type="checkbox" class="form-check-input" id="exampleCheck1">
		            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
		          </form>   
	          </c:if>            

            <c:if test="${ not empty usuario}">          
              
              	<li><i class="fas fa-user" style="color:red; margin-left:5px;"> ${usuario.nombre} </i></li> 
	              <form action="" method="post" class="form-inline mt-2 mt-md-0">
		            <input name="id" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
		            <input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
		            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
		           
		          </form>	  
	            </li>  
	            
	            <li>   
		            <ul>
		            	<!-- inicio?id=${v.id}&op=${VideoYoutubeController.OP_ELIMINAR} -->
		            	<li><a name="idioma" href="inicio?idioma=eu_ES">EUS</a></li>
	            		<li><a name="idioma" href="inicio?idioma=en_EN">ENG</a></li>
	            		<li><a name="idioma" href="inicio?idioma=es_ES">ESP</a></li>
		            </ul>
		        </li>
	            <li>
	            	 
		            <a href="logout">Cerrar Sesion</a>
		             
	            </li> 
	            <li><a href="backoffice/index.jsp">Backoffice</a></li>
            </c:if>   

          
          
          
        </div>
      </div>
    </nav>