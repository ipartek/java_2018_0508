<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<main role="main" class="container">
 
    <h1 class="text-center font-weight-light text-primary">Arkanoid Canvas Game</h1>
    <div class="row justify-content-center">
    	<div class="col-12 mb-3">
    		<canvas id="myCanvas" width="480" height="320"></canvas>

			<script src="js/arkanoid.js"></script>
		</div>
		<div class="col-12 col-md-6">
			<!-- resgitramos click mediante escuchador. Mirar arkanoid.js -->
			<button id="btnPlay" type="button" class="btn btn-outline-primary text-center btn-lg btn-block">Jugar</button>
			
    	</div>
    	
    </div>
    
</main> 
    	
<%@include file="includes/footer.jsp" %>