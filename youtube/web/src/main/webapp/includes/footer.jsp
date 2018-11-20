<!-- Footer -->
<%@page import="java.util.Date"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URLDecoder"%>


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
		<c:set var="anyo" value="<%= new java.util.Date() %>"/>
		<p class="m-0 text-center text-white">Copyright &copy; Your Website 2017<fmt:formatDate type="Both" dateStyle="medium" value="${anyo}"/></p>
	</div><!-- /.container -->
</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<script src="https://www.youtube.com/iframe_api"></script>
	
	<script>
		function checkNombre(){
			
			var nombre = $('#nombre').val();
			var help = $('#nombreHelp');//document.getElemntByID('nombreHelp')
			console.log('checkNombre '+ nombre);
			
			//llamada AJAX es asincrona
			var url = "checknombre";
			$.ajax(url, {
				"type": "post", // usualmente post o get
				"success": function(result) {
					//console.log("Llego el contenido y no hubo error", result);
					//help.html(result.resultado);
						
					if(true === result.resultado){
						help.html('nombre no disponible');//innerHTML
						help.removeClass('text-success');
						help.addClass('text-danger');
					}else{
						help.html('nombre disponible');//innerHTML
						help.removeClass('text-danger');
						help.addClass('text-success');
					}
				},
				"error": function(result) {
					console.error("Este callback maneja los errores", result);
					help.html('ERROR INESPERADO');//innerHTML
					help.removeClass('text-success');
					help.addClass('text-danger');
				},
				"data": {"nombre": nombre}
			});
			
			/*if(nombre != undefined && nombre == "pepe" ){
				help.html('nombre no disponible');//innerHTML
				help.removeClass('text-success');
				help.addClass('text-danger');
			}else{
				
				help.html('nombre disponible');//innerHTML
				help.removeClass('text-danger');
				help.addClass('text-success');
			}*/
		}
	
		function showModalEliminar( idVideo, operacion ){
			console.log('showModalEliminar id=' + idVideo);
			$('#modalEliminar').modal('show');
			var btn = document.getElementById('btnEliminar');
			btn.href = 'inicio?id='+ idVideo + '&op=' + operacion;			
		}
		
		function showModalModificar( idVideo, nombre ){
			
			console.log('showModalModificar id=' + idVideo + ' nombre='+ nombre);
			$('#modalModificar').modal('show');
			document.getElementById('id').value = idVideo;
			document.getElementById('nombre').value = nombre;
			
			
		}
		
		
		/*YOUTUBE IFRAME API*/
		var player;

		function onYouTubeIframeAPIReady() {
		    player = new YT.Player('video-placeholder', {
		        width: 825,
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