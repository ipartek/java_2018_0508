	    <!-- jQuery -->
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/jquery/jquery.min.js"></script>
		
		 <!-- Bootstrap Core JavaScript -->
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<!-- DataTables JavaScript -->
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/datatables/js/jquery.dataTables.min.js"></script>
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/datatables-responsive/dataTables.responsive.js"></script>
	
	    <!-- Custom Theme JavaScript -->
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/dist/js/sb-admin-2.js"></script>

		<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	    <script>
		    $(document).ready(function() {
		        $('#dataTable-ordenable').DataTable({
		        	responsive: true,
		        	"language": {
		        		"url": "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
		       		}		            
		        });
		    });
	    </script>
		
	<script>
		
		function showModalComentario(idComentario, texto){
			$('#modalVerComentario').modal('show');
			var comentario = document.getElementById('comentarioCompleto');
			comentario.innerHTML = texto;
		}
		
		$(document.getElementsByClassName('popoverOption')).popover({ trigger: "hover" });
	</script>
		
	</body>
</html>