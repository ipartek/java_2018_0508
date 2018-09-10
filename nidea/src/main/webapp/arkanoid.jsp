<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>
	<div class="container text-primary">
		<div class="row justify-content-center">
			<div class="col-12 mb-3">
				<h1 class="text-center text-primary font-weight-light">ARKANOID</h1>
				<canvas id="myCanvas" width="480" height="320"></canvas>
			</div>
			<div class="col-12 col-md-6">
				<button id="btnPlay" type="button" class="btn btn-outline-primary btn-lg btn-block">Play</button>
			</div>
		</div>
		

		
		
		
	</div>

<script src="vendors/jquery.js"></script>
<script src="js/arkanoid.js"></script>
	
<%@ include file="includes/footer.jsp" %>