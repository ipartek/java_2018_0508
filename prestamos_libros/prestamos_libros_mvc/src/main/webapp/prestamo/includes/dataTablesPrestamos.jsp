		
		<!-- Page-Level Demo Scripts - Tables - Use for reference -->
		<script>
			$(document).ready(function() {
				$('#dataTable').DataTable({
					responsive: true,
			    	"language": {
					"url": "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
					},
					"order": [[ 4, "asc" ]],
					columnDefs: [
					    {
					        targets: '_all',
					        className: 'dt-center'
					    }
					  ]
				});
			});
		</script>