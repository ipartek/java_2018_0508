<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<div class=" container">

 	<div class="row justify-content-center">
	 	<div class="col -12 mb-3">
		 	<h1 class="text-primary font-weight-light">Arkanoid Canvas Game</h1>
		 	
		 	<canvas id="myCanvas" width="480" height="320"></canvas>	
		</div> 
		
			<div class="col -12 col-md-6">				
				<!-- Registramos click mediante escuchador,mirar arkanoid.js -->
				<button  id="btn_play" type="button" class="btn btn-outline-primary" >jugar</button>
			</div> 			
 	</div>	
	
</div>
<script src="js/arkanoid.js"></script>
<%@ include file="includes/footer.jsp" %>