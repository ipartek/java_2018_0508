<%@include file="includes/header.jsp" %>

<%@include file="includes/navbar.jsp" %>

 <main role="main" class="container">
 
 	<div class="row justify-content-center">
 	
 		<div class="col-12 mb-3">
 
		 	<h1 class="text-primary text-center font-weight-light">Arkanoid Canvas Game</h1>
		 
		 	<canvas id="myCanvas" width="480" height="320"></canvas>
		 	
		 </div>
		 	
		 <div class="col-12 col-md-6">
		 	
		 	<!-- Registramos click mediante esuchador, mirar arkanoid.js -->
		 	<button type="button" id="btn-play" class="btn btn-outline-primary btn-block">Jugar</button>
		 	
		 </div>
 	
 	</div>
 
 </main>
 	
<script src="js/arkanoid.js"></script>

 <%@include file="includes/footer.jsp" %>