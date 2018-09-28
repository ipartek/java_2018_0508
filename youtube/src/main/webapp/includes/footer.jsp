<!-- Footer -->
<%@page import="java.util.Date"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URLDecoder"%>
<footer class="py-5 bg-dark">
    	<%
        String fecha = "";
     	Cookie[] cookies = request.getCookies();
     	for( Cookie c : cookies ){
     		if ( "cVisita".equals(c.getName())){
     			//ultima visita
     			fecha = URLDecoder.decode( c.getValue(), "UTF-8" );
     			
     			//guardar visita actual
     			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");		
     			Cookie cVisita = new Cookie("cVisita", URLEncoder.encode( dateFormat.format(new Date()),"UTF-8") );
     			cVisita.setMaxAge(60*60*24*365); //1año
     			response.addCookie(cVisita);
     			
     			break;
     		}	
     	}
        %>
        
      <span class="text-warning ml-4">Ultima visita <%=fecha%></span>
      
      <div class="container">
        <c:set var="anyo" value="<%= new java.util.Date()%>" />
        <p class="m-0 text-center text-white">Copyright &copy; Your Website <fmt:formatDate type="both" pattern="yyyy" value="${anyo}"/></p>
      	<!-- @see https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html -->
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="https://www.youtube.com/iframe_api"></script>

	<script>
	
		function showModalEliminar( idVideo, operacion ){
			console.log('showModalEliminar id=' + idVideo);
			$('#modalEliminar').modal('show');
			var btn = document.getElementById('btnEliminar');
			btn.href = 'inicio?id='+ idVideo + '&op=' + operacion;			
		}
		
		function showModalModificar( idVideo, nombre){
			console.log('showModalModificar id=' + idVideo + ' nombre=' + nombre);
			$('#modalModificar').modal('show');
			document.getElementById('id').value = idVideo;
			document.getElementById('nombre').innerHTML = nombre;
		}
		
		/* YOUTUBE IFRAME API */
		
		var player;

		function onYouTubeIframeAPIReady() {
		    player = new YT.Player('video-placeholder', {
		        width: 823,
		        height: 415,
		        videoId: '${videoInicio.codigo}',
		        playerVars: {
		        	autoplay: 1,
		            color: 'red',
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
		
		$('#speed').on('change', function () {
		    player.setPlaybackRate($(this).val());
		});
		
		$('#quality').on('change', function () {
		    player.setPlaybackQuality($(this).val());
		});
		
		$('#next').on('click', function () {
		    player.nextVideo()
		});

		$('#prev').on('click', function () {
		    player.previousVideo()
		});
		
		$('.thumbnail').on('click', function () {

		    var url = $(this).attr('data-video-id');

		    player.cueVideoById(url);

		});
	
	</script>

  </body>

</html>