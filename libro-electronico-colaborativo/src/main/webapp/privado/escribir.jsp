<%@include file="../includes/header.jsp" %>

	<main role="main" class="container">
    	<form id="escribir-form" action="escribir" method="post" class="mb-3">
        	<div class="form-row justify-content-center">        
            	<div class="col col-md-6">
            	
                	<div class="form-group">
                    	<label for="pagina" class="required">Escribe tu pagina:</label>
                    	<textarea class="form-control" id="pagina" name="pagina" rows="5" placeholder="Erase una vez..."></textarea>
                    </div>
                                       
                	<button type="submit" class="btn btn-outline-primary btn-block">Escribir</button>            
            	</div>                 
        	</div>      
    	</form>
	</main>

<!-- Footer -->
<%@page import="java.util.Date"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URLDecoder"%>


<!-- Bootstrap core JavaScript -->
<script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
<script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>