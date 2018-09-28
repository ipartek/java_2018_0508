<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

    <!-- Page Content -->
    <div class="container">
    <%@include file="includes/alerts.jsp" %>
    <h1 class="mt-4">
	<fmt:message key="msj.video.por.visualizar">
		<fmt:param value="785"/>
	</fmt:message>
	</h1>
      <div class="row">

        <div class="col-lg-3">        	
          <h4 class="my-4"><fmt:message key="lista.reproduccion"/></h4>
          <ul class="list-group">
          		<c:forEach items="${videos}" var="v">
	            <li class="list-group-item d-flex justify-content-between align-items-center">     
	          	  	<a href="inicio?id=${v.id}">${v.nombre}</a>
	          	  	<c:if test="${not empty sessionScope.usuario}">
	          	  		<i onclick="showModalEliminar(${v.id}, ${HomeController.OP_ELIMINAR} )" style="color:red;" class="float-right fas fa-trash-alt"></i>
	          	  		<i onclick="showModalModificar(${v.id},'${v.nombre}' )" style="color:grey;" class="float-right fas fa-pencil-alt"></i>
	          	  	</c:if>
	            </li>
            	</c:forEach>
            </ul>
            
			<!-- Modal Eliminar -->
			<div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title text-danger" id="exampleModalLabel">Atencion!</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			      Estas seguro que quieres ELIMINAR el video?
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
			        <a id="btnEliminar" href="#" class="btn btn-danger">Eliminar</a>			        
			      </div>
			    </div>
			  </div>
			</div>
			
			<!-- Modal Modificar -->
			<div class="modal fade" id="modalModificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Modificando titulo</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			      	<p>Introduce el nuevo nombre para el video '<span id="nombre" name="nombre"></span>' :</p>
			      	<form action="inicio" method="get" class="form-inline mt-2 mt-md-0">
			      	 	<input name="id" id="id" class="form-control mr-sm-2" type="hidden" title="id del video" value="">
			      	 	<input name="op" id="op" class="form-control mr-sm-2" type="hidden" title="operacion" value="2">
	            		<input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
	            		<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Modificar</button>
			        </form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>		        
			      </div>
			    </div>
			  </div>
			</div>
            
            <hr>
            
            <h4 class="my-4">Videos Visualizados</h4>
	          <ul class="list-group">
	          	<c:if test="${not empty usuario}">
	          			<c:forEach items="${reproducidos}" var="r">
			            	<li class="list-group-item d-flex justify-content-between align-items-center">     
			          	  		<a href="?id=${r.id}">${r.nombre}</a>	          	  	
			            	</li>
			            </c:forEach>
		        </c:if>
		        <c:if test="${empty usuario}">
	          			<li class="list-group-item d-flex justify-content-between align-items-center">
	          				<p>*Por favor Inicia Session para guardar tus video reproducidos</p>
	          			</li>
	          	</c:if>
	            </ul>
            
          </div>

        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div class="card mt-4">
          
            <iframe id="iframe" width="823" height="415" src="https://www.youtube.com/embed/${videoInicio.codigo}?autoplay=1" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
            
            <div class="card-body">
              <h3 class="card-title">${v.nombre}</h3>              
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p>
              <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
              4.0 stars
            </div>
          </div>
          <!-- /.card -->
          
		 <%@include file="includes/comments.jsp" %>

        </div>
        <!-- /.col-lg-9 -->

      </div>

    </div>
    <!-- /.container -->

    <%@include file="includes/footer.jsp" %>
