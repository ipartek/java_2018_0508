<!-- //@see -> https://developer.mozilla.org/es/docs/Games/Workflows/Famoso_juego_2D_usando_JavaScript_puro -->
<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>

<style>
	canvas {
	 background: #eee;
	 display: block;
	 margin: 0 auto;
	
	  }
</style>

		<div class="container">
			<div class="row">
				
				<div class="col-12">
					<p><h1 class="text-center text-primary font-weight-light">Arkanoid Canvas Game</h1></p>
					<canvas id="myCanvas" width="500" height="400" style="aling:left"></canvas>
				</div>
				<!-- <div class="col">
					<canvas id="myCanvas2" width="500" height="400" style="aling:right">xd</canvas>
				</div> -->
			</div>
		
			<div class="row justify-content-center">
				<div class="col-12 col-md-6 text-center">
					<p><a href="../index.jsp">Inicio</a></p>
					<!-- REgistramos click mediante escuchador onclick="draw()" -->
					<p><button id="btnPlay"  class="btn btn-outline-primary  ">Jugar</button>
				</div>
					<script type="text/javascript" src="../js/arkanoid.js"></script>
			</div>
		</div>
