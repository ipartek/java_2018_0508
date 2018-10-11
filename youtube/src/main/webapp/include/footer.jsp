<!-- Footer -->
<%@page import="java.util.Locale"%>
<%@page import="java.net.URLDecoder"%>

<footer class="py-4 bg-dark">
      <div class="container d-flex justify-content-around">
       	<% 
	     	String fecha = "";
	     	Cookie[] cookies = request.getCookies();
	     	for( Cookie c : cookies ){
	     		if ( "cVisita".equals(c.getName())){
	     			fecha = URLDecoder.decode( c.getValue(), "UTF-8" );
	     			break;
	     		}	
	     	}
     	
     		%>
     	<span class="m-0 text-center text-white">Ultima visita <%=fecha%></span> 
       	
       	<span class="m-0 text-center text-white">Copyright &copy; Your Website 2017</span>
       	
       	<span class="m-0 text-center text-white">
			<a class="${ (sessionScope.idioma eq 'es_ES') ? 'active text-white' : 'text-warning' }" href="inicio?idioma=es_ES">ES</a>
			<label class = "text-warning">|</label>
			<a class="${ (sessionScope.idioma eq 'en_EN') ? 'active text-white' : 'text-warning' }"href="inicio?idioma=en_EN">EN</a>
			<label class = "text-warning">|</label>
			<a class="${ (sessionScope.idioma eq 'eu_ES') ? 'active text-white' : 'text-warning' }" href="inicio?lidioma=eu_ES">EU</a>
		</span>
         
      </div>
      <!-- /.container -->
    </footer>
    
    <!-- JQUERY core JS -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>
</html>