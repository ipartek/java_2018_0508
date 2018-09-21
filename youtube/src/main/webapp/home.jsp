<!-- Directivas para usar Tags el prefijo es  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%-- <%@page import="com.ipartek.formacion.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.pojo.Comentarios"%>
<%@page import="com.ipartek.formacion.pojo.Alerts"%>
<%@page import="com.ipartek.formacion.pojo.Video"%> --%>
<%@page import="com.ipartek.formacion.youtube.controller.VideoYoutubeController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html lang="en">

  <head>

	<!-- Comenza todas las URLs desde el href indicado -->
	<base href="<%=request.getContextPath()%>/">
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registro de usuarios</title>

	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
	
    <!-- Bootstrap core CSS -->
    <link href="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://blackrockdigital.github.io/startbootstrap-shop-item/css/shop-item.css" rel="stylesheet">
	<!-- Fontawasome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<!-- Estilos propios pero no termina de cogerlos -->
	<link rel="stylesheet" href="css/styles.css" >
	 <!-- Bootstrap core JavaScript -->
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="js/home.js"></script>
	

  </head>

  <body>
	<!-- Ejemplo Etiquetas jsp   -->
	<%-- <%
		Usuario bean = new Usuario();
		bean.setNombre("test");
		out.print("<p>"+ bean.getNombre() +"</p>");
	%>
	
	<jsp:useBean  id="bean2" scope="page" class="com.ipartek.formacion.pojo.Usuario"></jsp:useBean>
	<jsp:setProperty property="nombre" name="bean2" value="Marianiko el short"/>
	<jsp:getProperty property="nombre" name="bean2"/> --%>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Youtube PlayList</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <% 
     	String fecha = "";
        String fecha2 = "";
     	Cookie[] cookies = request.getCookies();
     	for( Cookie c : cookies ){
     		if ( "cVisita".equals(c.getName())){
     			fecha = URLDecoder.decode( c.getValue(), "UTF-8" );
     			break;
     		}	
     	}
     	
     %>
     	<c:if test="${not empty usuario}"> 
        	<span class="text-warning">Ultima visita <%=fecha %></span><!-- cookie.cVisita.value -->
        </c:if>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
            
           
            <c:if test="${empty usuario}"> 
              
	              <form action="login" method="post" class="form-inline mt-2 mt-md-0">
	              	<%
		            	String usuarioRecordar="";
	              		String casillaRecordar="";
		            	for(Cookie c : cookies ){
		            		if("on".equals(c.getValue())){
		            			for( Cookie cNombreUsuario: cookies){
		            				 if("usuarioRecordar".equals(cNombreUsuario.getName())){
		            					 out.print(cNombreUsuario.getValue());
		            					 usuarioRecordar = cNombreUsuario.getValue();
		            					 casillaRecordar = "checked";
		            				 }
		            			}
		            		}
		            		
		            	}
		            %>
		            <input id="usuario" name="usuario" class="form-control mr-sm-2" type="text" placeholder="Nombre Usuario" value="<%=usuarioRecordar %>" required pattern=".{3,30}">
		            
		            
		            <input name="pass" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
		            <span class="text-primary">Recuerdame</span>
		            <input name="recuerdame" type="checkbox" class="form-check-input" id="exampleCheck1"<%= casillaRecordar %>>
		            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
		          </form>   
	          </c:if>            

            <c:if test="${ not empty usuario}">          
              
              
	              <form action="" method="post" class="form-inline mt-2 mt-md-0">
		            <input name="id" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
		            <input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
		            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
		           
		          </form>	  
	            </li>  
	            <li><i class="fas fa-user" style="color:red; margin-left:5px;"> ${usuario.nombre} </i></li>    
	            <li>
	            	 
		            <a href="logout">Cerrar Sesion</a>
		             
	            </li> 
	            <li><a href="backoffice/index.jsp">Backoffice</a></li>
            </c:if>   

          
          
          
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">
    

      	<c:if test="${not empty alert}"> 
      		<div class="container">
				<div class="alert ${alert.tipo} alert-dismissible fade show" role="alert">
				  <p class="TextoAlerta">${alert.texto}</p>
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
			</div>
		</c:if>  

          <div class="row">

        <div class="col-lg-3">        	
          <h1 class="my-4">Lista Reproduccion</h1>
          <ul class="list-group">

          	<c:if test="${empty videos }">
          		
          	
          	</c:if>
          	<c:if test="${empty videoInicio }">
          		
          	
          	</c:if>
	            <c:forEach items="${videos}" var="v">          
	            <li class="list-group-item d-flex justify-content-between align-items-center">     
	          	  	<a href="inicio?id=${v.id}">${v.nombreCancion}</a>
	          	  	<c:if test="${not empty usuario }">
	          	  		<a href="inicio?id=${v.id}&op=${VideoYoutubeController.OP_ELIMINAR}>"><i style="color:red;" class="float-right fas fa-trash-alt"></i></a>
	          	  	</c:if>
	            </li>
	          </c:forEach>

            <c:if test="${not empty usuario}"> 
            	<c:if test="${not empty listaVideos}"> 
            		   
	            	<h2 class="my-4">Historial de Reproduccion</h1>
		          	<ul class="list-group">
      				<c:forEach items="${listaVideos}" var="v"> 
	      				<li class="list-group-item d-flex justify-content-between align-items-center">     
		          	  	<a href="?id=${v.id }">${v.nombreCancion}</a>
		          	  	
		           		 </li>
	           		 </c:forEach>
	           	</c:if>
	        </c:if>
	        <c:if test="${empty usuario}"> 
	        	<p>Por favor identifíquese primero o regístrese en  <a href="registroUsuariosFormulario.jsp">Nuevo usuario</a></p>
	        </c:if>
          </div>
        <div class="col-lg-9">
        	<div class="card mt-4">
          	<!-- Lo saco del iframe width="823" height="415" -->
            <iframe id="iframe" width="823" height="415" src="https://www.youtube.com/embed/${videoInicio.id}?autoplay=1" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
            
            <div class="card-body">
              <h3 class="card-title">${videoInicio.nombreCancion }</h3>              
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p>
              <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
              4.0 stars
            </div>
          </div>

          <c:if test="${not empty usuario}"> 
		<!-- ****** COMENTARIOS ****** -->
          <div class="card card-outline-secondary my-4">
            <div class="card-header">
              <button type="button" class="btn btn-dark" onclick="visibleTextArea()">Comentarios</button>
            </div>
            <div id="comentarios" class="comentarios" style="display:none;">
	            <form action="ComentariosControler" method="post">
	            	<p name="videoId" value="${videoInicio.nombreCancion }">${videoInicio.id }</p>
	            	<textarea name=text rows="" cols="88"></textarea>
	            	<!-- <input id="textArea" name="text" ></input> -->
	            	<!-- <p><a href="ComentariosControler" class="badge badge-dark">Añadir comentario</a></p> -->
	            	<input name="videoId" id="videoId" value="${videoInicio.id }"></input>
	            	<p><button  type="submit" class="btn btn-primary">Date de alta</button></p>
	            </form>
            </div>

     			<div class="card-body">
     				<c:forEach items="${comentarios}" var="c"> 
     					<c:if test="${c.videoId eq videoInicio.id}">
		           		 <p>${ c.comentario}</p>
				              <small class="text-muted">Posted by ${ c.autor} </small>
				              <hr>
				              </c:if>
				    </c:forEach>
	            </div> 
	            

         		 
     				
       		</div>
          <!-- /.card -->
         
        </div>
         </c:if>

      </div>

     
    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white"></p><!-- Copyright &copy; Your Website 2017 -->
      </div>
      <!-- /.container -->
    </footer>

   

  </body>

</html>