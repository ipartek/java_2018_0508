<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>

<!-- Include the header -->
<%@ include file="include/header.jsp"%>
    
<!-- Page Content -->
<div class="container">
    
    <!-- Include the navbar -->
	<%@ include file="include/navbar.jsp"%>
	
	<!-- Include the alert -->
	<%@ include file="include/alert.jsp"%>
	
	<!-- Include the modals -->
	<%@ include file="include/modal-alerts.jsp"%>
	
    <div class="row">

        <div class="col-lg-3">        	
        	<h4 class="my-4"><fmt:message key="lista.repr"/></h4>
          	<ul class="list-group">
          		<!--  Cargar lista de videos -->
	          	<c:forEach items="${videos}" var="video">
	          		<li class="list-group-item d-flex justify-content-between align-items-center"> 
	          			
	          			<a href="inicio?id=${video.id}">${video.nombre}</a>
	          			
	          			<c:if test="${not empty sessionScope.usuario}">    
			          		<a>
			          			<i style="color:red;" class="float-right fas fa-trash-alt mr-2" title="Eliminar Video" onClick="showModalForm(${video.id},${HomeController.OP_ELIMINAR});"></i>
			          		</a>
			          		<a>
			          			<i style="color:green;" class="float-right fas fa-edit" title="Editar Video" onClick="showModalForm(${video.id}, ${HomeController.OP_MODIFICAR});"></i>
			          		</a>
		          		</c:if>
		          		
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
				          		<a href="inicio?id=${video.cod}">${video.nombre}</a>
				          		<a href="inicio?id=${video.cod}>&op=${HomeController.OP_ELIMINAR}"><i style="color:red;" class="float-right fas fa-trash-alt mr-2" title="Eliminar Video"></i></a>
				          		<a href="inicio?id=${video.cod}>&op=${HomeController.OP_MODIFICAR}"><i style="color:green;" class="float-right fas fa-edit" title="Editar Video"></i></a>
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
          
          <div id="video-placeholder">
<%--           	<iframe id="iframe" width="820" height="415" src="https://www.youtube.com/embed/${videoInicio.cod}?autoplay=1" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe> --%>
          </div>     
  
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
    
    <script>
    
    	/*	FORMULARIOS MODALES*/
    	function showModalForm(idVideo, codOp) {
    		var modalForm;
    		var btnGo;
    		
    		if (codOp == 1) {
    			modalForm = $('#modalEliminar');
    			btnGo = $('#btnEliminarVideo');
    		
    		} else {
    			modalForm = $('#modalModificar');
    			btnGo = $('#btnModificarVideo');
    		}
    			modalForm.modal('show');	
    			btnGo.attr("href", "inicio?id="+ idVideo + "&op=" + codOp);	
    			$('#idModificar').val(idVideo);
    			console.log(idVideo);
    	}
    	
    	var player;

    	/*	YOUTUBE API*/
    	function onYouTubeIframeAPIReady() {
    	    player = new YT.Player('video-placeholder', {
    	        width: 600,
    	        height: 400,
    	        videoId: '${videoInicio.cod}',
    	        playerVars: {
    	            color: 'white',
    	            playlist: '${playlist}'
    	        },
    	        events: {
    	            onReady: initialize
    	        }
    	    });
    	}
    	
    	function initialize(){

    	   /*  // Update the controls on load
    	    updateTimerDisplay();
    	    updateProgressBar(); */

    	    // Clear any old interval.
    	    //clearInterval(time_update_interval);

    	    // Start interval to update elapsed time display and
    	    // the elapsed part of the progress bar every second.
    	    time_update_interval = setInterval(function () {
    	        updateTimerDisplay();
    	        updateProgressBar();
    	    }, 1000)

    	}
    	
    	
    </script>
    
    <!-- Include API Youtube-->
    <script src="https://www.youtube.com/iframe_api"></script>
    
    <!-- Include the footer -->
    <%@ include file="include/footer.jsp"%>
    
   
