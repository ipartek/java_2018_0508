<%@include file="taglibs.jsp"%>
		<!-- Footer -->
		<footer class="py-3 bg-light mt-2">
			<div class="row justify-content-center">
				<div class="col col-lg-10">
					<nav id="footer" class="navbar navbar-expand-lg navbar-light bg-light">
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarNav">
							<ul class="navbar-nav  justify-content-center">
								<li class="nav-item">
									<a class="nav-link" href="#"><span class="sr-only"></span><strong> © IPARTEK Servicios Informáticos</strong></a>
								</li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
			<!-- /.container -->
		</footer>
		
		<!-- DataTables JavaScript -->
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
		<!-- <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/datatables-responsive/dataTables.responsive.js"></script> -->
		
		
		<!-- Bootstrap CDN -->
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		
		
		
		<!-- Page-Level Demo Scripts - Tables - Use for reference -->
		<script>
			$(document).ready(function() {
				$('#dataTable').DataTable({
					responsive: true,
			    	"language": {
					"url": "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
					}		            
				});
			});
		</script>
		
		<script>
        	function confirmar(e){
        		if(confirm('¿Estás seguro de que quieres eliminar?')){
        			console.log('Pulsado eliminar');
        		}else{
        			//Prevenir el evento por defecto del enlace
        			e.preventDefault();
        		}
        	}
        </script>
	
	</body>

</html>