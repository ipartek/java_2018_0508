<!-- Include the header -->
<%@ include file="include/header.jsp"%>
    
<!-- Page Content -->
<div class="container">
    
    <!-- Include the navbar -->
	<%@ include file="include/navbar.jsp"%>
	
	<!-- Include the alert -->
	<%@ include file="include/alert.jsp"%>
	
    <div class="row">

        <div class="col-lg-3">        	
        	<h4 class="my-4"><fmt:message key="lista.repr"/></h4>
          	<ul class="list-group">
          		<!--  Cargar lista de videos -->
	          	<c:forEach items="${videos}" var="video">
	          		<li class="list-group-item d-flex justify-content-between align-items-center">     
		          		<a href="inicio?id=${video.id}">${video.nombre}</a>
		          		<a href="inicio?id=${video.id}>&op=${HomeController.OP_ELIMINAR}"><i style="color:red;" class="float-right fas fa-trash-alt"></i></a>
		            </li>
	          	</c:forEach>
            </ul>     
            <hr>              
            <h4 class="my-4">Videos Reproducidos</h4>
	        	<ul class="list-group">
	        	
	        		<c:if test="${not empty sessionScope.usuario}}">
		        		<!--  Cargar historial de  reproducidos -->
			          	<c:forEach items="${reproducidos}" var="video">
			          		<li class="list-group-item d-flex justify-content-between align-items-center">     
				          		<a href="inicio?id=${video.id}">${video.nombre}</a>
				          		<a href="inicio?id=${video.id}>&op=${HomeController.OP_ELIMINAR}"><i style="color:red;" class="float-right fas fa-trash-alt"></i></a>
				            </li>
			          	</c:forEach>
	        		</c:if>
	        	
		        	<c:if test="${empty sessionScope.usuario}}">
		        		<li class="list-group-item d-flex justify-content-between align-items-center">
		          			<p>Por favor, accede para guardar tus reproducciones.</p>
		          		</li>
		        	</c:if>	
	            </ul>     
        	</div>        
        	<!-- /.col-lg-3 -->

        <div class="col-lg-9">
          <div class="card mt-4">
            <iframe id="iframe" width="820" height="415" src="https://www.youtube.com/embed/${videoInicio.id}?autoplay=1" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
  
            <div class="card-body">
              <h3 class="card-title">${videoInicio.nombre}</h3>              
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p>
              <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
              4.0 stars
            </div>
          </div>
          <!-- /.card -->
          
          <div class="card card-info">
                <div class="card-block">
                    <textarea placeholder="Escribe aquí tu comentario..." class="pb-cmnt-textarea"></textarea>
                    <form class="form-inline"> 
                        <button class="btn" type="button"><span class="fas fa-file-upload"></span></button>
                        <button class="btn btn-primary ml-auto" type="button">Comparte!</button>
                    </form>
                </div>
            </div>
        </div>
        <!-- /.col-lg-9 -->

      </div>

    </div>
    <!-- /.container -->
    
    <!-- Include the footer -->
    <%@ include file="include/footer.jsp"%>
    
   
