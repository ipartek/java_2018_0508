<!-- SET JAVA LANGUAGE AND UTF-8 CODIFICATION -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- IMPORTS OF JAVA CLASSES -->
<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>

<!-- INCLUDE HEADER -->
<%@ include file="include/header.jsp"%>
    
<!-- HOME CONTENT -->
<div class="container mb-2">
    
    <!-- INCLUDE HEADER-NAV -->
	<%@ include file="include/header-nav.jsp"%>
	
	<!-- INCLUDE ALERTS -->
	<%@ include file="include/alert.jsp"%>
	
	<!-- INCLUDE CONFIRMATION ALERTS -->
	<%@ include file="include/modal-alerts.jsp"%>
	
	<div class="row d-flex justify-content-center">
		
		<div class="col  mr-2">
			
			<h2>${ videoInicio.nombre }</h2>
		
		</div>	<!-- /.col -->
		
	</div> <!-- /.row -->
	
	<!-- THEME AND PLAYLIST CONTROLS -->
	<div class="row d-flex justify-content-center">
		
		<div class="col  mr-2">
			<form class="form-inline">
				
				<label class="checkbox-inline" id="lblLights">
				  <input type="checkbox" data-toggle="toggle" data-size="mini" data-onstyle="default"
				  	data-on="<i class='far fa-lightbulb fa-lg'></i>" data-off="<i class='fas fa-lightbulb fa-lg'>"
				   	onchange='checkLightsChanged()' id="chckLights"> 
				</label>
				
				<label class="checkbox-inline ml-5" id="lblRepeat">
				  <input type="checkbox" data-toggle="toggle" data-size="mini" data-onstyle="default"
				  	data-on="Repetir" data-off="No Repetir"
				  onchange='checkRepeatChanged()' id="chckRepeat"> 
				</label>
				
				<label class="checkbox-inline ml-5" id="lblRandom">
				  <input type="checkbox" data-toggle="toggle" data-size="mini" data-onstyle="default"
				  	data-on="<i class='fas fa-random fa-lg'></i>" data-off="<b>123</b>"
				  onchange='checkRandomChanged()' id="chckRandom" ${ (cookie.cRandom.value == true) ? 'checked' : '' }>
				</label>
			
			</form>
				
		</div> <!-- /.col -->
		
	</div> <!--  /.row -->
	
	<!-- REPRODUCTOR -->
	<div class="row">	
		
		<div class="col">
          
          <div class="card">   
	         
	          <div id="video-placeholder"></div> <!-- IFRAME --> 
          
          </div> <!-- /.card -->  		
       
        </div> <!-- /.col -->
     
     </div> <!-- /.row -->
     
     <!-- PLAYER CONTROLS -->
     <div class="row">
  		
  		<!-- VIDEO BUTTONS -->
		<div class="col  d-flex justify-content-between">
			
				<a href="inicio?op=${ HomeController.OP_PREV }" id="button_prev" class="btn btn-light">
					<i class="fa fa-fast-backward"></i>
				</a>
					    
				<button type="button" id="button_play" class="btn btn-light" onclick='buttonPlayPress()'>
					<i class="fa fa-play" id="label_play"></i>
				</button>
					    
				<a href="inicio?op=${ HomeController.OP_NEXT }" id="button_next" class="btn btn-light">
					<i class="fa fa-fast-forward"></i>
				</a> 
				
				<button type="button" id="button_mute" class="btn btn-light" onclick='buttonMutePress()'>
					<i class="fas fa-volume-up" id="label_mute"></i>
				</button>	
				
				<span id="current-time" class="my-auto">0:00</span>
				  
				<input type="range" id="progress-bar" value="0" min="0" max="100">
				  
				<span id="duration" class="my-auto">0:00</span>
				
				<button type="button" id="button_fullScreen" class="btn btn-light" onclick="buttonFullScreenPress()">
					<i class="fas fa-desktop" id="label_fullScreen"></i>
				</button>
			
		</div> 	<!-- /.col -->
	
	</div>	<!-- /.row -->
     
</div> <!-- /.container -->

<!--  LISTA DE REPRODUCCIÓN --> 
<div class="container-fluid mt-5 mb-5">
    <div id="carouselExample" class="carousel slide" data-ride="carousel" data-interval="9000">
        <div class="carousel-inner row w-100 mx-auto" role="listbox">
        
        	<c:forEach items="${ videos }" var="video" varStatus="loop">
            <div class="carousel-item col-md-3 ${ (videoInicio.id == video.id) ? 'active' : '' }">
                
                <!-- CAROUSEL IMAGE -->
                <a href="inicio?id=${ video.id }">
                	<img class="img-fluid mx-auto d-block" src="https://img.youtube.com/vi/${ video.cod }/0.jpg?text=${ loop.index }" alt="slide ${ loop.index }">
                </a>
                
                <!-- CAROUSEL TEXT -->
                <div class="carousel-caption d-none d-md-block">
			    	<h5><a href="inicio?id=${ video.id }">${ video.nombre }</a></h5>
			    	
			    	<!-- DELETE/UPDATE VIDEO OPTIONS -->
			    	<c:if test="${ not empty sessionScope.usuario }">    
			         	<p>		
			          		<a>
			          			<i class="text-danger fas fa-trash-alt mr-2" title="Eliminar Video" 
			          			onClick="showModalForm(${ video.id },${ HomeController.OP_ELIMINAR });"></i>
			          		</a>
			          		<a>
			          			<i class="text-primary fas fa-edit" title="Editar Video" 
			          			onClick="showModalForm(${ video.id }, ${ HomeController.OP_MODIFICAR });"></i>
			          		</a>
			          	</p>
		          	</c:if>
			    	
			  	</div>
            </div>
            </c:forEach>
            
        </div>
        
        <a class="carousel-control-prev" href="#carouselExample" role="button" data-slide="prev">
            <i class="fa fa-chevron-left fa-2x text-white"></i>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExample" role="button" data-slide="next">
            <i class="fa fa-chevron-right fa-2x text-warning"></i>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<%@ include file="include/comentarios.jsp" %>
    
    
    <script>
    	
    	var player;

    	/*	YOUTUBE API*/
    	function onYouTubeIframeAPIReady() {
    	    player = new YT.Player('video-placeholder', {
    	        videoId: '${ videoInicio.cod }',
    	        playerVars: {
    	            enablejsapi: 1,
    	            origin: 'http://localhost:8080',
    	            autoplay: 1,
    	            rel: 0, 
    	            controls: 0
    	        },
    	        events: {
    	            onReady: initialize
    	        }
    	    });
    	}
    	
    </script>
    
    <!-- Include the footer -->
    <%@ include file="include/footer.jsp"%>
    
   
