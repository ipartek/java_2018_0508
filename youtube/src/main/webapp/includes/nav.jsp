<!-- Navigation -->
 <%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
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
     <span class="text-warning">Ultima visita <%=fecha%></span>
     	
     
     <div class="collapse navbar-collapse" id="navbarResponsive">
       <ul class="navbar-nav ml-auto">
         <li class="nav-item active">
              	
         
		         <!-- usuario sin pasar por login -->
		         <c:if test="${empty sessionScope.usuario}">
		            <!-- formulario Login -->
		            <form action="login" method="post" class="form-inline mt-2 mt-md-0">
		           <input name="usuario" class="form-control mr-sm-2" type="text" placeholder="Nombre Usuario" required pattern=".{3,30}">
		           <input name="pass" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
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