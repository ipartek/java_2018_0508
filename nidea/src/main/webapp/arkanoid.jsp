<%@include file="includes/header.jsp" %>

<%@include file="includes/navbar.jsp" %>
	
	<div class="row justify-content-center">
	
		<div class="col">
			<h1 class="text-center text-primary font-weight-light">Arkanoid</h1>
		
			<canvas id="myCanvas" width="480" height="320"></canvas>
			
			<button id="btn-play" type="button" class="btn btn-outline-primary">Jugar</button>
			
		</div>
	
	</div>
	
	
	<script src="js/arkanoid.js"></script>

<%@include file="includes/footer.jsp" %>