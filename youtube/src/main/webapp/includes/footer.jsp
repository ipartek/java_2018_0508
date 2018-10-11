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
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="https://www.youtube.com/iframe_api"></script>

	<script>
	
		function showModalEliminar( idVideo, operacion ){
			console.log('showModalEliminar id=' + idVideo);
			$('#modalEliminar').modal('show');
			var btn = document.getElementById('btnEliminar');
			btn.href = 'inicio?id='+ idVideo + '&op=' + operacion;			
		}
		
		function showModalModificar( idVideo, nombre ){
			
			console.log('showModalModificar id=' + idVideo +  " nombre=" + nombre);
			$('#modalModificar').modal('show');
			document.getElementById('id').value = idVideo;
			document.getElementById('nombre').value = nombre;
						
		}
		
		/* YOTUBE IFRAME API */
		/** https://tutorialzine.com/2015/08/how-to-control-youtubes-video-player-with-javascript */
		var player;

		function onYouTubeIframeAPIReady() {
		    player = new YT.Player('video-placeholder', {
		        width: 823,
		        height: 400,
		        videoId: '${videoInicio.codigo}',
		        playerVars: {		        	
		            color: 'white',
		            playlist: '${playlist}',
		            autoplay: 1
		        },
		        events: {
		            onReady: initialize
		        }
		    });
		}
	</script>
	<script src="js/youtube_iframe_config.js"></script>

  </body>

</html>