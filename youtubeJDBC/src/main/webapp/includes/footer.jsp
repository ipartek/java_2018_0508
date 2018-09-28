<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
    
<!-- Footer -->    
    
<footer class="py-5 bg-dark">
      <div class="container">
      
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
	     <span class="text-warning">Ultima visita <%=fecha%></span>
     	
      
      	
      	<c:set var="anyo" value="<%= new java.util.Date()%>" />      	  
        <p class="m-0 text-center text-white">Copyright &copy; 
           Your Website <fmt:formatDate type="both" pattern="yyyy" value="${anyo}" />
           <!-- @see https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html -->
        </p>
        
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script>
	
		function showModalEliminar( idVideo, operacion ){
			console.log('showModalEliminar id=' + idVideo);
			$('#modalEliminar').modal('show');
			var btn = document.getElementById('btnEliminar');
			btn.href = 'inicio?id='+ idVideo + '&op=' + operacion;			      
		}
		
		function showModalModificar( idVideo, operacion ){
			console.log('showModalModificar id=' + idVideo);
			$('#modalModificar').modal('show');
			var btn = document.getElementById('btnModificar');
			var value = document.getElementById('modifiCacionNombreModal');
			var id = document.getElementById('id');
			var op = document.getElementById('op');
			id.value = idVideo;
			op.value = operacion;
			console.log(id.value);
			console.log(op.value);
			btn.href = 'inicio?id='+ idVideo + '&op=' + operacion;			      
		}
		/*Youtube iframe api*/
		var player;

		function onYouTubeIframeAPIReady() {
		    player = new YT.Player('video-placeholder', {
		        width: 600,
		        height: 400,
		        videoId: '${videoInicio.codigo}',
		        playerVars: {
		            color: 'white',
		            playlist: '${playList}',
		        },
		        events: {
		            onReady: initialize
		        }
		    });
		    
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
}
	
	</script>
	<script src="https://www.youtube.com/iframe_api"></script>
  </body>

</html>