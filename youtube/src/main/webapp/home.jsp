<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>
<%@ include file="includes/header.jsp" %>	
    
    <!-- Page Content -->
    <div class="container">
    	
      <%@ include file="includes/nav.jsp"  %>
      <%@ include file="includes/alert.jsp"  %>	
      	
      <div class="row">

        <div class="col-lg-3">        	
          <h4 class="my-4"><fmt:message key="lista.reproduccion"/></h4>
          <ul class="list-group">                     
          	  <c:forEach items="${videos}" var="v">          
	            <li class="list-group-item d-flex justify-content-between align-items-center">     
	          	  	<a href="inicio?id=${v.id}">${v.nombre}</a>
	          	  	
	          	  	<c:if test="${not empty sessionScope.usuario}">
	          	  		<i onclick="showModalEliminar(${v.id}, ${HomeController.OP_ELIMINAR })" style="color:red;" class="float-right fas fa-trash-alt mr-1"></i>
	          	  		<i onclick="showModalModificar(${v.id}, '${v.nombre }')" style="color:orange;" class="fas fa-pencil-alt ml-1"></i>
	            	</c:if>
	            
	            </li>
	          </c:forEach>
            </ul>
			
			<!-- Modal eliminar -->
			<div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Atención</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        ¿Estás seguro de que deseas eliminar el video?
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
			        <a id="btnEliminar" href="#" class="btn btn-danger">Eliminar</a>
			      </div>
			    </div>
			  </div>
			</div>
			
			<!-- Modal modificar -->
			<div class="modal fade" id="modalModificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Modificar nombre del video</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        
			      </div>
			      <div class="modal-footer">
			      	<form action="inicio" method="post">
			        	<div class="form-group">
				        	<label for="nombreVideo">Nombre</label>
				        	<input type="text" id="nombre" name="nombre" class="form-control" required  autofocus />
				        	<input type="hidden" name="id" id="id" value="-1"/>
				        	<input type="hidden" name="op" value="${HomeController.OP_MODIFICAR }"/>
				        	<button type="submit" class="btn btn-primary">Cambiar nombre</button>
				        </div>
			        </form>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
			      </div>
			    </div>
			  </div>
			</div>
			
			<!-- Modal registro -->
			<div class="modal fade" id="modalRegistro" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Registro</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        <form action="registro" method="post">
			        	<div class="form-group">
			        	
				        	<label for="nombreRegistro">Nombre</label>
				        	<input type="text" id="nombreRegistro" name="nombreRegistro" class="form-control" autofocus required placeholder="Mínimo 3 y máximo 50 caracteres" pattern="{3, 50}" />
				        	
				        	<label for="passRegistro">Contraseña</label>
				        	<input type="password" id="passRegistro" name="passRegistro" class="form-control" required placeholder="Mínimo 8 y máximo 20 caracteres" pattern="{8, 20}"  />
				        	
				        	<label for="passRegistroRep">Repita la contraseña</label>
				        	<input type="password" id="passRegistroRep" name="passRegistroRep" class="form-control mb-3" required placeholder="Mínimo 8 y máximo 20 caracteres" pattern="{8, 20}"  />
				        	
				        	<button type="submit" class="btn btn-primary">Darme de alta</button>
				       
				        </div>
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
          
          	<!-- https://tutorialzine.com/2015/08/how-to-control-youtubes-video-player-with-javascript -->
            <div id="video-placeholder"></div>
            
            <div class="card-body">
              <h3 class="card-title"></h3>              
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p>
              <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
              4.0 stars
            </div>
          </div>
          <!-- /.card -->

          <div class="card card-outline-secondary my-4">
            <div class="card-header">
              Comentarios
            </div>
            <div class="card-body">
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

 <%@ include file="includes/footer.jsp" %> 
