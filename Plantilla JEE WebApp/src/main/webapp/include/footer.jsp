	<footer class="footer">
      <div class="container text-muted d-flex justify-content-around">
      
      	<span class="text-center">
			Usuarios conectados: ${empty applicationScope.uConectados ? 0 : applicationScope.uConectados.size()}
		</span> 
      
      	<span class="text-muted">Contenido del footer aquí</span>
      
      	<span class="text-center">
			Ultima visita: <fmt:formatDate value="${sessionScope.ultimaConexion}" pattern="dd-MM-yyyy HH:mm:ss" />
		</span> 
        
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