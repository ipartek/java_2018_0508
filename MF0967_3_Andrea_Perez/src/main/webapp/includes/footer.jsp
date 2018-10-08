<footer>
	<div class="container-fluid bg-primary py-3">
		<div class="container">
			<div class="row">
				<div class="col-md-7">
					<div class="row py-0">
						<div class="col-sm-1 hidden-md-down">
							<a class="bg-circle bg-info" href="#"> <i
								class="fa fa-2x fa-fw fa-address-card" aria-hidden="true "></i>
							</a>
						</div>
						<div class="col-sm-11 text-white">
							<div>
								<h4>  Contact</h4>
								<p>
									   <span class="header-font">M</span>y<span class="header-font">w</span>website.com
								</p>
								<p class="text-center">Copyright ©  Andrea Perez 2018.</p>
							</div>
						</div>
					</div>
				</div>

				<!-- icon-social -->
				<div class="col-md-5 icon-social">
					<div class="d-inline-block">
						<div class="bg-circle-outline d-inline-block"
							style="background-color: #3b5998">
							<a href="https://www.facebook.com/"><i
								class="fa fa-2x fa-fw fa-facebook text-white"></i> </a>
						</div>
						<div class="bg-circle-outline d-inline-block"
							style="background-color: #4099FF">
							<a href="https://twitter.com/"> <i
								class="fa fa-2x fa-fw fa-twitter text-white"></i></a>
						</div>

						<div class="bg-circle-outline d-inline-block"
							style="background-color: #0077B5">
							<a href="https://www.linkedin.com/company/"> <i
								class="fa fa-2x fa-fw fa-linkedin text-white"></i></a>
						</div>
						<div class="bg-circle-outline d-inline-block"
							style="background-color: #d34836">
							<a href="https://www.google.com/"> <i
								class="fa fa-2x fa-fw fa-google text-white"></i></a>
						</div>
					</div>
				</div>
				<!-- /icon-social -->

			</div>
		</div>
	</div>

	<!-- Boostrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
	<!-- DataTable -->
	
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js" ></script>
	
	<script type="text/javascript">
	
	<!-- Funcion para DataTable-->
	$(document).ready(function() {
        $('#dataTable-ordenable').DataTable({
        	responsive: true,
        	"language": {
        		"url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
       		}		            
        });
    });
	
	
	
	<!-- funcion para el confirm de eliminar-->
    function confirmar(e){
		if(confirm('¿Estás seguro de que quieres eliminar?')){
			console.log('Pulsado eliminar');
		}else{
			//Prevenir el evento por defecto del enlace
			e.preventDefault();
		}
	}
	
	</script>
	
	
	<!-- /DatTable -->
</footer>

</body>

</html>