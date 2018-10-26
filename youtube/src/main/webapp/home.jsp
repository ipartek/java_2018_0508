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
		
		<div class="col  mr-2 text-center">
			
			<h2 class="mb-0">${ videoInicio.nombre }</h2>
		
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
	<!-- 16:9 ASPECT RATIO -->
	<div class="embed-responsive embed-responsive-16by9">
	  <div class="embed-responsive-item" id="video-placeholder"></div>
     
     <!-- PLAYER CONTROLS -->
  		
  		<!-- VIDEO BUTTONS -->
		<div class="col  d-flex justify-content-between">
			
				<a href="inicio?op=${ HomeController.OP_PREV }&id=${ videoInicio.id }" id="button_prev" class="btn btn-light">
					<i class="fa fa-fast-backward"></i>
				</a>
					    
				<button type="button" id="button_play" class="btn btn-light" onclick='buttonPlayPress()'>
					<i class="fa fa-play" id="label_play"></i>
				</button>
					    
				<a href="inicio?op=${ HomeController.OP_NEXT }&id=${ videoInicio.id }" id="button_next" class="btn btn-light">
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
	
	</div>	<!-- /.embed-responsive -->
     
</div> <!-- /.container -->

<!--  LISTA DE REPRODUCCIÓN --> 

<div class="container mt-5 mb-5">
	<div class="row">
			<c:forEach items="${ videos }" var="video" varStatus="loop">
			
			<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mt-3">
			    <div class="hovereffect">
			        <img class="img-responsive" src="https://img.youtube.com/vi/${ video.cod }/0.jpg" alt="${ video.nombre }">
			        <div class="overlay">
			           <h2>${ video.nombre }</h2>
			           <a class="info" href="inicio?id=${ video.id }"><i class="fa fa-play" title="Reproducir Video"></i></a>
			           
			           <!-- DELETE/UPDATE VIDEO OPTIONS -->
				    	<c:if test="${ not empty sessionScope.usuario }">   	
				          		<a class="info">
				          			<i class="text-danger fas fa-trash-alt mr-2" title="Eliminar Video" 
				          			onclick="showModalForm(${ video.id },${ HomeController.OP_ELIMINAR });"></i>
				          		</a>
				          		<a class="info">
				          			<i class="text-primary fas fa-edit" title="Editar Video" 
				          			onclick="showModalForm(${ video.id }, ${ HomeController.OP_MODIFICAR });"></i>
				          		</a>
			          	</c:if>
			        </div>
			    </div>
			</div>
		
		    </c:forEach>
	</div>
</div>

<%@ include file="include/comentarios.jsp" %>
    
    
    <script>
    	
    	var player;

    	/*	YOUTUBE API*/
    	function onYouTubeIframeAPIReady() {
    	    player = new YT.Player('video-placeholder', {
    	        videoId: '${ videoInicio.cod }',
    	        host: 'https://www.youtube.com',
    	        playerVars: {
    	            'enablejsapi': 1,
    	            'origin': 'http://localhost:8080',
    	            'autoplay': 1,
    	            'rel': 0, 
    	            'controls': 0
    	        },
    	        events: {
    	            onReady: initialize
    	        }
    	    });
    	}
    	
    </script>
    
    <!-- Include the footer -->
    <%@ include file="include/footer.jsp"%>
    
   
