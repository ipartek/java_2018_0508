<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>

<%@ include file="includes/header.jsp" %>	
    
    <!-- Page Content -->
    <div class="container">
    	
      <%@ include file="includes/nav.jsp"  %>
      <%@ include file="includes/alert.jsp"  %>	
      	${pa}
      <div class="row">

        <div class="col-lg-3">        	
          <h4 class="my-4"><fmt:message key="lista.reproduccion"/></h4>
          <ul class="list-group">                     
          	  <c:forEach items="${videos}" var="v">          
	            <li class="list-group-item d-flex justify-content-between align-items-center">     
	          	  	<a href="inicio?id=${v.id}">${v.nombre}</a>
	          	  	
	          	  	<c:if test="${not empty sessionScope.usuario}">
	          	  		<i onclick="showModalEliminar(${v.id}, ${HomeController.OP_ELIMINAR} )" style="color:red;" class="float-right fas fa-trash-alt"></i>
	          	  		<i onclick="showModalModificar(${v.id}, '${v.nombre}' )" style="color:grey;" class="float-right fas fa-pencil-alt"></i>
	          	  	</c:if>
	          	  	
	            </li>
	          </c:forEach>
            </ul>
            			
			<!-- Modal Eliminar -->
			<div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Atención!!!</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        ¿ Estas seguro que deseas ELIMINAR el Video?
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
			        <a id="btnEliminar" href="#" class="btn btn-danger">Eliminar</a>			        
			      </div>
			    </div>
			  </div>
			</div>
            
            
            
           <!-- modalModificar -->
			<div class="modal fade" id="modalModificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Modificar Nombre Video</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        
			      </div>
			      <div class="modal-footer">
			      
			      	<form action="inicio" method="post">			      		
			      		<input type="text" id="nombre" name="nombre" required >
			      		<input type="hidden" name="id" id="id" value="-1">
			      		<input type="hidden" name="op" value="${HomeController.OP_MODIFICAR}">
			      		<input type="submit" value="Modificar">
			      	</form>
			      
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
			        			        
			      </div>
			    </div>
			  </div>
			</div>
			
			
			
			
			
			<!-- modalRegistrar -->
			<div class="modal fade" id="modalRegistrar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Registrarse en la aplicacion</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      
			      
			      
			      <div class="modal-body">
				      <form action="registro" method="post">
					        <div class="form-group">
					            <label for="nombre" class="col-form-label"  name="nombre">Nombre:</label>
					            <input type="text" class="form-control" onblur="checkNombre()" id="nombreRegistro" name="nombreRegistro" placeholder="Introduce tu nombre"/>
					       		<small id="nombreHelp" class="form-text">Nombre disponible</small>
					        </div>
					        <div class="form-group">
					            <label for="pass" class="col-form-label">Contraseña</label>
					            <input type="password" class="form-control" id="pass" name="pass" placeholder="Introduce tu contraseña"/>
					        </div>
					        <div class="form-group">
					            <label for="pass2" class="col-form-label"> Repite la Contraseña</label>
					            <input type="password" class="form-control" id="pass2" name="pass2" placeholder="Vuelve a introducir tu contraseña"/>
					        </div>
				      
				      	<button type="submit" class="btn btn-primary" >Registrar </button>
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
				       		       
				      </form> 
			      </div>	
			    </div>
			  </div>
			</div>
			
            
            
            <hr>
            
            <h4 class="my-4">Videos Visualizados</h4>
	          <ul class="list-group">	          	
          		   <c:forEach items="${reproducidos}" var="r">
			            <li class="list-group-item d-flex justify-content-between align-items-center">     
			          	  	<a href="?id=${r.id}">${r.nombre}</a>	          	  	
			            </li>
		           </c:forEach>
		            
		            <c:if test="${empty reproducidos}">
		        		<li class="list-group-item d-flex justify-content-between align-items-center">
	          				<p>*Por favor Inicia Session para guardar tus video reproducidos</p>
	          			</li>
          			</c:if>
	          	
	            </ul>
            
          </div>
         
        
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div class="card mt-4">
          
          	<!--  https://tutorialzine.com/2015/08/how-to-control-youtubes-video-player-with-javascript -->
            <div id="video-placeholder"></div>
			
            
            <div class="card-body">
              <h3 class="card-title"></h3>              
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p>
              <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
              4.0 stars
            </div>
          </div>
         <%@ include file="includes/comentarios.jsp" %> 

      </div>

    </div>
    <!-- /.container -->

 <%@ include file="includes/footer.jsp" %> 
