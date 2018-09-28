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
	
	</script>

  </body>

</html>