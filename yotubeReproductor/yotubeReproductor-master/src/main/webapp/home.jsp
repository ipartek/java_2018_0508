 <%@ include file="includes/header.jsp"  %>
 <%@ include file="includes/navbar.jsp"  %>

	<!-- .CONTAINER -->
	<div class="container">
	
		<!-- ALERT -->
		<c:if test="${empty alert}">
    		${alert = null };
    	
    	 </c:if>

		<c:if test="${not empty alert}">
			<div class="container">
				<div class="alert ${alert.tipo} alert-dismissible fade show mt-4" role="alert">
					<p>${alert.texto}</p>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
		</c:if>
		<!-- / ALERT -->

		<div class="row">

			<div class="col-lg-3">
				<h4 class="my-4"><fmt:message key="lista.reproduccion"/></h4>
				<ul class="list-group">
					<c:forEach items="${videos}" var="v">

						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							<a href="inicio?id=${v.id}">${v.nombre}</a> 
							
							<c:if test="${not empty sessionScope.usuario}">
							<i onclick="showModalEliminar(${v.id}, ${HomeController.OP_ELIMINAR} )" style="color: red;" class="float-right fas fa-trash-alt"></i>
						<i onclick="showModalModificar(${v.id}, '${v.nombre}' )" style="color: red;" class="float-right fas fa-pencil-alt"></i>
							</c:if>
							</li>
					</c:forEach>

				</ul>
				
				


		<!-- Modal Eliminar-->
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
        ¿Estas seguro que quieres eliminar el video?
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
            
            
				<hr>

				<h4 class="my-4">Videos Visualizados</h4>
				<ul class="list-group">


					<c:forEach items="${reproducidos}" var="r">
						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							<a href="?id=${r.id}">${r.nombre}</a>
						</li>

					</c:forEach>


					<c:if test="${not empty reproducidos}">
						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							<p>*Por favor Inicia Session para guardar tus video
								reproducidos</p>
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
						<h3 class="card-title">${videoInicio.nombre}</h3>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque
							facere, soluta. Totam id dolores, sint aperiam sequi pariatur
							praesentium animi perspiciatis molestias iure, ducimus!</p>
						<span class="text-warning">&#9733; &#9733; &#9733; &#9733;
							&#9734;</span> 4.0 stars
					</div>
				</div>
				<!-- /.card -->
	
				<!-- /.card -->

			</div>
			<!-- /.col-lg-9 -->

		</div>

	</div>

 <%@ include file="includes/footer.jsp"  %>	