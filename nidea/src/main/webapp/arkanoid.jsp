<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

 	    	
    
    
  		
  	<main role="main" class="container">

		<div class="row justify-content-center">  	
			<div class="col-12 mb-3">
		      	<h1 class="text-center text-primary font-weight-light">Arkanoid Canvas Game</h1>		      	      	
		      	<canvas id="myCanvas" width="480" height="320"></canvas>
		    </div>  	
		    <div class="col-12 col-md-6">  	
		      	<!-- registramos clik mediante escuchardor, mirar arkanois.js -->
		      	<button id="btn-play" type="button" class="btn btn-outline-primary btn-lg btn-block">Jugar</button>
	      	</div>
      	</div>
      	
    </main>
    
<script src="js/arkanoid.js"></script>
  		
<%@include file="includes/footer.jsp" %>