 <%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Properties"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        
        <a class="navbar-brand" href="#">Youtube PlayList</a>
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
 
 			<!-- Usuario logueado (formulario búsqueda de videos) -->
            <c:if test="${not empty usuario}">
	            
	            <div class="nav-user"><i class="fas fa-user mr-2"></i><span>${usuario.nombre}</span>
	             	<a href="backoffice/">Backoffice</a>
	             	<a href="logout"><i class="fas fa-power-off"></i></a>
	            </div>	
	             
	              <!-- formulario Crear Video -->
	             <form action="inicio" method="post" class="form-inline ">        
		           <input name="id" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
		           <input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
		           <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>     
		         </form>	  
            </c:if>
            
            <!-- Usuario no logueado (formulario login) -->
            <c:if test="${empty usuario}"> 
        
	              <form action="login" method="post" class="form-inline ">
		            <div class="form-group">
			            <input name="usuario" class="form-control mr-sm-2" type="text" placeholder="Nombre Usuario" required pattern=".{3,30}" value="${cookie.cUsuario.value}">
			            <input name="pass" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
			            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
		            </div>
		            
		            <div class="form-group">
		            	<input type="checkbox" name="recordar">Recordar
		            </div>
		          </form>
	         	</c:if>     
              
           </li>            
          </ul>     
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
     	<span class="text-warning ml-3">Ultima visita <%=fecha%></span> 
        
        <%
        
	      Locale locale = request.getLocale();
	      String lang = locale.getLanguage();
	      String country = locale.getCountry();
	      
	      out.print("<span class='text-primary ml-3'>" + lang + " | " + country + "</span");
	  	%>
        </div>
        <!-- ./collapse-navbar -->
      </div>
    
      <!-- ./container -->
    </nav>
