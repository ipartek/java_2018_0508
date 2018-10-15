<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Footer -->
<%@page import="java.util.Locale"%>
<%@page import="java.net.URLDecoder"%>

<footer class="py-4">
      <div class="container d-flex justify-content-around">
       	
     	<span class="m-0 text-center">Ultima visita <fmt:formatDate value="${ cookie.cVisita.value }" pattern="dd-MM-yyyy HH:mm:ss" /></span> 
       	
       	<span class="m-0 text-center">Copyright &copy; Your Website 2017</span>
       	
       	<span class="m-0 text-center">
			<a class="${ (sessionScope.idioma eq 'es_ES') ? 'active' : 'text-warning' }" href="inicio?idioma=es_ES">ES</a>
			<label class = "text-warning">|</label>
			<a class="${ (sessionScope.idioma eq 'en_EN') ? 'active' : 'text-warning' }"href="inicio?idioma=en_EN">EN</a>
			<label class = "text-warning">|</label>
			<a class="${ (sessionScope.idioma eq 'eu_ES') ? 'active' : 'text-warning' }" href="inicio?lidioma=eu_ES">EU</a>
		</span>
         
      </div>
      
      <!-- /.container -->
    </footer>
    
    <!-- Include API Youtube-->
    <script src="https://www.youtube.com/iframe_api"></script>
    <script src="js/youtube_iframe_config.js"></script>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap-toggle.min.js"></script>
    
    <!-- JS Propios -->
    <script src="js/listado-videos.js"></script>
    <script src="js/control-panel.js"></script>
    <script src="js/confirm-actions.js"></script>
    
    <c:if test="${ empty sessionScope.usuario }">
    	<script src="js/autofocus.js"></script>
    </c:if>

  </body>
</html>