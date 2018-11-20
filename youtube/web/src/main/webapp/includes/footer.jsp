<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <!-- <script src="vendor/jquery/jquery.min.js"></script> -->
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
	<script src="https://www.youtube.com/iframe_api"></script>
	
	<script>
	
		function showModalEliminar(idVideo, operacion){
			console.log("showModalEliminar id = " + idVideo);
			$('#modalEliminar').modal('show');
			var btn = document.getElementById('btnEliminar');
			btn.href = 'inicio?id=' + idVideo + '&op=' + operacion;
		}
		
		function showModalModificar(idVideo, nombre){
			console.log("showModalModificar id = " + idVideo + " nombre = " + nombre);
			$('#modalModificar').modal('show');
			document.getElementById('id').value = idVideo;
			document.getElementById('nombre').value = nombre;
			
		}
		
		function showModalRegistro(){
			$('#modalRegistro').modal('show');
		}
		
		function checkNombre(){
			var nombre = $('#nombreRegistro').val();
			var help = $('#nombreHelp');		//document.getElementById;

			console.log('check nombre ' + nombre);
			
			//Llamada Ajax es ASÍNCRONA => "/checknombre"
			
			var url = "checknombre";
			
			$.ajax(url, {
			"type": "post", // usualmente post o get
			"success": function(data) {
				console.log("Llegó el contenido y no hubo error", data);
				help.html(data.resultado);
				
				if(nombre != undefined && nombre == 'pepi'){
					help.removeClass('text-success');
					help.addClass('text-danger');				
				
				}else{
					help.removeClass('text-danger');
					help.addClass('text-success');					
				}
				
			},
			"error": function(result) {
				console.error("Este callback maneja los errores", result);
				help.html('ERROR INESPERADO');
				help.removeClass('text-success');
				help.addClass('text-danger');				
			},
			"data": {"nombreRegistro" : nombre}
			});
			
		}
		
		/* YOUTUBE IFRAME API */
	
		var player;
	
		function onYouTubeIframeAPIReady() {
		    player = new YT.Player('video-placeholder', {
		        width: 600,
		        height: 400,
		        videoId: '${videoInicio.codigo}',
		        playerVars: {
		        	autoplay: 1,
		            color: 'white',
		            playlist: '${playlist}'
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