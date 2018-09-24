  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ include file="includes/header.jsp" %>
  <%@ include file="includes/navbar.jsp" %>


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
	<h1>
		<!-- Mensaje de ejemplo -->
<%-- 		<fmt:message key="msj.video.por.visualizar">
			<fmt:param value="785"/>
		</fmt:message> --%>
	</h1>
          <div class="row">
				
        <div class="col-lg-3"> 
        <!-- Lista de reproduccion -->       	
          <h1 class="my-4">
          
          		<fmt:message key="msj.lista.reproduccion">
					
				</fmt:message>
          </h1>
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
	        	<p>
	        	<fmt:message key="msj.loguea.o.regritro">
					
				</fmt:message>
	        	<a href="registroUsuariosFormulario.jsp">Nuevo usuario</a></p>
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

<%@ include file="includes/footer.jsp" %>    