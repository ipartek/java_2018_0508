<%@include file="taglibs.jsp"%>
	<!-- Footer -->
<%@page import="java.util.Date"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.net.URLDecoder"%>

<footer class="py-5 bg-dark">
		<div class="container">
		<%
				String user ="";
				String fecha = "";
				Cookie[] cookies = request.getCookies();
				for(Cookie c: cookies){
					if(c.getName().equals("cVisita")){
						fecha = URLDecoder.decode(c.getValue(), "UTF-8");
						
						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						Cookie cVisita = new Cookie("cVisita", URLEncoder.encode(dateFormat.format(new Date()), "UTF-8"));
					}
				}
				%>
<%-- 			<span class="text-warning mr-5"> Última visita <%=fecha %></span> --%>
			<!-- https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html -->
			<c:set var="now" value="<%= new java.util.Date() %>"/>
			<span class="text-warning">Última visita el </span>
			<span class="text-warning"> <fmt:formatDate type="both" pattern="dd MM yyyy HH:mm" timeStyle="medium" value="${now }"/></span>
			<p class="m-0 text-center text-white">Copyright &copy; Youtube 2018</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="https://www.youtube.com/iframe_api"></script>
	
	<script>
		function showModalEliminar(idVideo, operacion){
			console.log('showModalEliminar id=' + idVideo);
			$('#modalEliminar').modal('show');
			var btn = document.getElementById('btnEliminar');
			btn.href = 'inicio?id='+idVideo+'&op='+operacion;
		}
		
		function showModalEditar(idVideo, operacion, titulo2){
			console.log('showModalEditar id=' + idVideo);
			$('#modalEditar').modal('show');
			var btn = document.getElementById('id2');
			btn.value = idVideo;
			var btn2 = document.getElementById('titulo2');
			btn2.value = titulo2;
		}
	</script>
	
	<!-- Youtube IFRAME API -->
	<script>
		var player;
	
		function onYouTubeIframeAPIReady() {
		    player = new YT.Player('video-placeholder', {
		        width: 600,
		        height: 400,
		        videoId: '${videoInicio.codigo}',
		        playerVars: {
		            color: 'white',
		            playlist: '${playlist}',
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
		
		// This function is called by initialize()
		function updateTimerDisplay(){
		    // Update current time text display.
		    $('#current-time').text(formatTime( player.getCurrentTime() ));
		    $('#duration').text(formatTime( player.getDuration() ));
		}

		function formatTime(time){
		    time = Math.round(time);

		    var minutes = Math.floor(time / 60),
		    seconds = time - minutes * 60;

		    seconds = seconds < 10 ? '0' + seconds : seconds;

		    return minutes + ":" + seconds;
		}
		
		$('#progress-bar').on('mouseup touchend', function (e) {

		    // Calculate the new time for the video.
		    // new time in seconds = total duration in seconds * ( value of range input / 100 )
		    var newTime = player.getDuration() * (e.target.value / 100);

		    // Skip video to new time.
		    player.seekTo(newTime);

		});
		
		// This function is called by initialize()
		function updateProgressBar(){
		    // Update the value of our progress bar accordingly.
		    $('#progress-bar').val((player.getCurrentTime() / player.getDuration()) * 100);
		}
		
		$('#play').on('click', function () {
		    player.playVideo();
		});

		$('#pause').on('click', function () {
		    player.pauseVideo();
		});
		
		$('#mute-toggle').on('click', function() {
		    var mute_toggle = $(this);

		    if(player.isMuted()){
		        player.unMute();
		        mute_toggle.text('volume_up');
		    }
		    else{
		        player.mute();
		        mute_toggle.text('volume_off');
		    }
		});
		
		$('#volume-input').on('change', function () {
		    player.setVolume($(this).val());
		});
	</script>

</body>

</html>