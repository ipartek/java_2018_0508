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
        	<h4 class="text-white"> <fmt:message key="lista.repr"/> </h4>
          	<ul class="list-group">
          		
          		<!--  CARGAR LISTA DE VIDEOS -->
	          	<c:forEach items="${ videos }" var="video">
	          		<li class="list-group-item d-flex justify-content-between align-items-center"> 
	          			
	          			<a href="inicio?id=${ video.id }">${ video.nombre }</a>
	          			
	          			<c:if test="${ not empty sessionScope.usuario }">    
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
	        	
	        		<c:if test="${ not empty sessionScope.usuario }}">
		        		<!--  Cargar historial de  reproducidos -->
			          	<c:forEach items="${ reproducidos }" var="video">
			          		<li class="list-group-item d-flex justify-content-between align-items-center">     
				          		<a href="inicio?id=${ video.cod }">${ video.nombre }</a>
				          		<a href="inicio?id=${ video.cod }>&op=${ HomeController.OP_ELIMINAR }"><i style="color:red;" class="float-right fas fa-trash-alt mr-2" title="Eliminar Video"></i></a>
				          		<a href="inicio?id=${ video.cod }>&op=${ HomeController.OP_MODIFICAR }"><i style="color:green;" class="float-right fas fa-edit" title="Editar Video"></i></a>
				            </li>
			          	</c:forEach>
	        		</c:if>
	        	
		        	<c:if test="${ empty sessionScope.usuario }}">
		        		<li class="list-group-item d-flex justify-content-between align-items-center">
		          			<p>Por favor, accede para guardar tus reproducciones.</p>
		          		</li>
		        	</c:if>	
	            </ul>     
        	</div>        
        	<!-- /.col-lg-3 -->

        <div class="col-lg-9">
          <div class="card mt-4">
          
	          <div id="video-placeholder"> </div> <!-- REPRODUCTOR -->
	          
	          <%@ include file="include/comentarios.jsp"%>  <!-- GESTIÓN DE COMENTARIOS -->
          
          </div> <!-- /.col-lg-9 -->  
  			
        </div> <!-- /.card -->

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
    	        width: 820,
    	        height: 415,
    	        videoId: '${videoInicio.cod}',
    	        playerVars: {
    	            color: 'white',
    	            playlist: '${playlist}',
    	            autoplay: 1
    	        },
    	        events: {
    	            onReady: initialize
    	        }
    	    });
    	}
    	
    </script>
    
    <!-- Include API Youtube-->
    <script src="https://www.youtube.com/iframe_api"></script>
    
    <script src="js/youtube_iframe_config.js"></script>
    
    <!-- Include the footer -->
    <%@ include file="include/footer.jsp"%>
    
   
