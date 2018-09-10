 <%@include file="includes/header.jsp" %>
  <%@include file="includes/navbar.jsp" %>
	
	<main role="main" class="container">
		<div class="row justify-content-center" >
			<div class="col-12 mb-3">
				<h1 class="text-center text-prymary font-weight-light" >Arkanoid Canvas Game</h1>
				<canvas id="myCanvas" width="480" height="320"></canvas>
			</div>
			
			<div class="col-12 col-md-6">
				<!-- registramos click mediante escuchador, mirar arkanoid.js -->
				<button id="btn_play" type="button" class="btn btn-outline btn-primary  btn-lg btn-block">Jugar</button>
			</div>
		</div>
		
		<script src="js/arkanoid.js"></script>
		
	</main>		
  <%@ include file="includes/footer.jsp" %>