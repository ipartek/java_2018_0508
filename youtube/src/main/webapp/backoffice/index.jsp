<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ipartek.formacion.pojo.Usuario"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tablas</title>

    <link rel="stylesheet" href="css/tabla.css"/> 
    <!-- ***** -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css">    
    <!-- Bootstrap core CSS -->
    <link href="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--Datatable css-->
    <link rel="stylesheet" href="vendors/datatables/1.10.19/css/jquery.dataTables.min.css">    
    <link href="vendors/datatables/2.1.0/css/responsive.dataTables.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="css/tabla.css"/>  
    <!--Plugin para el funcionamiento del datatable, deberia ponerse en la ultima parte del body
    pero al colocarlo en la parte inferior me sigue dando problemas -->  
    <!-- <script src="Youtube/src/main/webapp/vendor/jquery/jquery-3.3.1.js"></script>
    <script src="Youtube/src/main/webapp/vendor/jquery/1.10.19/js/jquery.dataTables.min.js"></script>    
    <script src=".Youtube/src/main/webapp/vendor/datatables/2.1.0/js/dataTables.responsive.js"></script> -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>


    
    

</head>

<body>

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
            
            <% 
            	//Gestion Usuario Logeado   
            	Usuario usuario = (Usuario)session.getAttribute("usuario");
            	if ( usuario == null ){            
            %>	            
              <!-- formulario Login -->
              <form action="login" method="post" class="form-inline mt-2 mt-md-0">
	            <input id="usuario" name="usuario" class="form-control mr-sm-2" type="text" placeholder="Nombre Usuario" required pattern=".{3,30}">
	            <input name="pass" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
	            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
	          </form>            
            <%
            	} else {
            %>              
              <!-- formulario Crear Video -->
              
              <form action="" method="post" class="form-inline mt-2 mt-md-0">
	            <input name="id" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
	            <input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
	            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
	           
	          </form>	  
				     
	          
	          
            </li>      
            <li>
            	 <i class="fas fa-user" style="color:red; margin-left:5px;"> <%=usuario.getNombre() %> </i>
	            <a href="logout">Cerrar Sesion</a>
	             <a href="backoffice/index.jsp">Backoffice</a>
            </li> 
            <%
            	} 
              %>       
          </ul>
          
          
          
        </div>
      </div>
    </nav>
<h1>ESTAMOS EN EL BACKOFFICE </h1>
*Solo pueden entrar usuarios logeados <br>
 <% 
	Usuario u = (Usuario)session.getAttribute("usuario");
	if ( u == null ){		
		out.print("<p style=\"color:red\">Usuario nulo, se ha saltado el login!!!</p>");		
	}else{		
		out.print("Usuario: " + u.getNombre() + "<br>");
	}
%>

<h2>Usuarios Conectados</h2>
	

	    	<%-- <li><%=uConectado.getValue().getNombre()%></li> --%>
	   

	
<table id="tabla" class="display responsive nowrap" width="100%">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Correo</th>
                        <th>Contraseña</th>
                        
                    </tr>
                </thead>
                <%
	
    HashMap<String, Usuario> usuariosConectados = (HashMap<String, Usuario>)application.getAttribute("uConectados");
	
	for( HashMap.Entry<String,Usuario> uConectado : usuariosConectados.entrySet() ){
		
	    %>
                <tbody>
                    <tr>
                        <td><%=uConectado.getValue().getNombre()%></td>
                        <td><%=uConectado.getValue().getEmail()%></td>
                        <td><%=uConectado.getValue().getPassword()%></td>
                    </tr>
                  <%
	
	}
%>   
                </tbody>
                <tfoot>
                    <tr>
                        <th>Nombre</th>
                        <th>Correo</th>
                        <th>Contraseña</th>
                    </tr>
                </tfoot>
            </table>
  
</body>
</html>	

