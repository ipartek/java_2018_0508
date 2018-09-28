<%@include file="includes/header.jsp" %>


	<%@include file="includes/alerts.jsp" %>
	<main role="main" class="container">

            <form id="login-form" action="login" method="post" class="mb-3">
                <div class="form-row justify-content-center">        
                    <div class="col col-md-6">
                        
                        <div class="form-group">
                            <label for="usuario" class="required">Usuario</label>
                            <input type="text" class="form-control" id="usuario" name="usuario" autofocus required placeholder="Introduce tu usuario" />
                        </div>
                                    
                        <div class="form-group">
                            <label for="pass" class="required">Contraseña</label>
                            <input type="password" class="form-control" id="pass" name="pass" required placeholder="Introduce tu contraseña" />
                        </div>
                                    
                        <button type="submit" class="btn btn-outline-primary btn-block">Acceder</button>
                                    
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