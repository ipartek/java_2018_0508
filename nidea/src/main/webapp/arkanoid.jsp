<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

 	    	
    
    
  		
  	<main role="main" class="container">
  	
      	<h1>Arkanoid</h1>
      	
      	
      	<canvas id="myCanvas" width="480" height="320"></canvas>

		<script>
			// JavaScript code goes here
			
			var canvas = document.getElementById("myCanvas");
			var ctx = canvas.getContext("2d");
			
			//dibujar rectangulo verde
			ctx.beginPath();
			ctx.rect(20, 40, 50, 50);
			ctx.fillStyle = "#00FF00";
			ctx.fill();
			ctx.closePath();
			
			//circulo verde
			ctx.beginPath();
			ctx.arc(240, 160, 20, 0, Math.PI*2, false);
			ctx.fillStyle = "green";
			ctx.fill();
			ctx.closePath();
			
			//rectangulo stroke == border
			ctx.beginPath();
			ctx.rect(160, 10, 100, 40);
			ctx.strokeStyle = "rgba(0, 0, 255, 0.5)";
			ctx.stroke();
			ctx.closePath();
			
			
		</script>
      	
    </main>
  		
<%@include file="includes/footer.jsp" %>