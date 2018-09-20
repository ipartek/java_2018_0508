<%@ include file="includes/header.jsp"%>

<%@ include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col">
				<h1 class="text-center text-primary font-weight-light">Arkanoid</h1>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<canvas id="myCanvas" height="320" width=480 onLoad="inicializar()"></canvas>
			</div>
		</div>
		
		<div class="row text-center mt-3">
			<div class="col">
				<button id="btn-play" type="button" class="btn btn-primary">Jugar</button>
				<button id="btn-reset" type="button" class="btn btn-primary">Reiniciar</button>
			</div>
		</div>
	
	</div>
	

	
	
	

<script src="js/arkanoid.js"></script>

<%@ include file="includes/footer.jsp"%>