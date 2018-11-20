<!-- FOOTER-->
<footer class="py-5 bg-dark">

	<div class="container">
		<c:set var="anyo" value="<%=new java.util.Date()%>" />
		<p class="m-0 text-center text-white">
			Copyright &copy; Your Website
			<fmt:formatDate type="both" pattern="yyyy" value="${anyo}" />
		</p>
	</div>

</footer>
<!-- /.FOOTER -->

<!-- Bootstrap core JavaScript -->
<script
	src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
<script
	src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
<script src="https://www.youtube.com/iframe_api"></script>
<script>
	function showModalEliminar(idVideo, operacion) {
		console.log('showModalEliminar id=' + idVideo);
		$('#modalEliminar').modal('show');
		var btn = document.getElementById('btnEliminar');
		btn.href = 'inicio?id=' + idVideo + '&op=' + operacion;
	}

	function showModalModificar(idVideo, nombre) {

		console.log('showModalModificar id=' + idVideo + " nombre=" + nombre);
		$('#modalModificar').modal('show');
		document.getElementById('id').value = idVideo;
		document.getElementById('nombre').value = nombre;

	}
	
	//	REPRODUCTOR YOUTUBE
	
	var player;

	function onYouTubeIframeAPIReady() {
	    player = new YT.Player('video-placeholder', {
	        width: 600,
	        height: 400,
	        videoId: '${videoInicio.codigo}',
	        playerVars: {
	            color: 'white',
	            playlist: '${playlist}'
	        },
	        events: {
	            onReady: initialize
	        }
	    });
	}
	function initialize(){

	    // Update the controls on load
	    updateTimerDisplay();
	    updateProgressBar();

	    // Clear any old interval.
	    clearInterval(time_update_interval);

	    // Start interval to update elapsed time display and
	    // the elapsed part of the progress bar every second.
	    time_update_interval = setInterval(function () {
	        updateTimerDisplay();
	        updateProgressBar();
	    }, 1000)

	}
</script>
</body>
</html>
