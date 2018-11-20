<%@include file="taglibs.jsp"%>

<div class="col-lg-3">
				<h1 class="my-4"><fmt:message key="lista.reproduccion"/></h1>
				<ul class="list-group">
				
					<c:forEach items="${videos }" var="v">
						<li class="list-group-item d-flex justify-content-between align-items-center">
							<a href="inicio?id=${v.id }">${v.titulo }</a>
							<c:if test="${not empty usuario}">
								<i onclick="showModalEditar(${v.id}, ${HomeController.OP_MODIFICAR}, '${v.titulo}')" style="color:green;" class="float-right fas fa-pencil-alt"></i>
			          	  		<i onclick="showModalEliminar(${v.id}, ${HomeController.OP_ELIMINAR})" style="color:red;" class="float-right fas fa-trash-alt"></i>
							</c:if>	           			
	           			</li>
					</c:forEach>

				</ul>
				
				<!-- Modal Eliminar -->
				<div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLabel">ATENCIÓN</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				        ¿Estás seguro de que deseas eliminar el vídeo?
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
				        <a id="btnEliminar" type="button" class="btn btn-danger" href="#">Eliminar</a>
				      </div>
				    </div>
				  </div>
				</div>
				
				<!-- Modal Editar -->
				<div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLabel">EDITAR</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
						<div class="modal-body">
			      	 		<p class="text-center">¿Quieres cambiar el nombre del vídeo?</p>
			      	 		<!-- Formulario para crear video -->
							<form id="formEditar" class="form-inline navbar-nav ml-auto" action="inicio" method="post">
								<div class="input-group mb-1 mr-sm-2">
								<input type="hidden" class="form-control" id="id2" name="id2" value="-1">
								<input required type="text" class="form-control"
									placeholder="Título (mínimo 2 letras)" id ="titulo2" name="titulo2" value="">
								</div>
								<button id="btnEditar" type="submit" form="formEditar" class="btn btn-primary">Actualizar</button>	
							</form> 					
				      	</div>
			      		<div class="modal-footer">
			        		<a type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</a>
			        		
			      		</div>
				    </div>
				  </div>
				</div>
				
				
				
				
				<c:if test="${not empty usuario}">
				
					<h1 class="my-4"><fmt:message key="lista.visualizados"/></h1>
					<ul class="list-group">
						<c:if test="${not empty videosVistos}">
						
							<c:forEach items="${videosVistos }" var="vv">
							
								<li class="list-group-item d-flex justify-content-between align-items-center">     
					          	  	<a href="?id=${vv.id }">${vv.titulo }</a>	          	  	
					            </li>
					            
							</c:forEach>
						
						</c:if>
						
						<c:if test="${empty videosVistos}">
						
							<li class="list-group-item d-flex justify-content-between align-items-center">
		          				<p>*Por favor Inicia Sesión para guardar tus video reproducidos</p>
		          			</li>
		          			
						</c:if>
					</ul>
				</c:if>
			</div>
			<!-- /col-lg-3 -->