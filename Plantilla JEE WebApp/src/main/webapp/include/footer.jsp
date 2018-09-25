	<footer class="footer">
      <div class="container text-muted d-flex justify-content-between">
      
      	<span class="text-center">
			Usuarios conectados: ${empty applicationScope.uConectados ? 0 : applicationScope.uConectados.size()}
		</span> 
      
      	<span class="text-muted">Contenido del footer aquí</span>
      
      	<span class="social">
      		<a href="https://es-es.facebook.com/" target="_blank"><i class="fab fa-facebook fa-3x"></i></a>
      		<a href="https://twitter.com/?lang=es" target="_blank"><i class="fab fa-twitter-square fa-3x"></i></a>
      	</span>
      	<!-- <span class="text-center">  -->
		<!-- Ultima visita: <fmt:formatDate value="${sessionScope.ultimaConexion}" pattern="dd-MM-yyyy HH:mm:ss" /> -->
		<!-- </span> -->
        
      </div>
    </footer>
	
 	<!-- JQUERY core JS -->
	<script src="js/jquery-3.3.1.min.js"></script>
	
	<!-- BOOTSTRAP core JS -->
	<script src="js/bootstrap.min.js"></script>	
	
	<!-- PERSONAL JS -->
	<script src="js/autofocus.js"></script>
</body>
</html>