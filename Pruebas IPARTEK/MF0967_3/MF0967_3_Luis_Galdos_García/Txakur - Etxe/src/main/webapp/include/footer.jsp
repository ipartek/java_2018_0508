	<footer class="footer text-white">
      <div class="container text-muted d-flex justify-content-between">
      
      	<span class="text-center text-white">
			Usuarios conectados: ${empty applicationScope.uConectados ? 0 : applicationScope.uConectados.size()}
		</span> 
      
      	<div>
      	
      	<form class="form-inline mt-2" action="buscar" method="post">
      		<div class="form-group">
			     <input type="text" class="form-control" id="search" name="txtBuscar" placeholder="Buscar aquí">
			     <button type="submit" class="btn btn-danger ml-2"><i class="fas fa-search text-white mr-2"></i></button>
		 	</div>
		  	 
      	</form>
      	
      	</div>
      	<span class="social">
      		<a href="https://es-es.facebook.com/" target="_blank"><i class="fab fa-facebook fa-3x text-white"></i></a>
      		<a href="https://twitter.com/?lang=es" target="_blank"><i class="fab fa-twitter-square fa-3x text-white"></i></a>
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