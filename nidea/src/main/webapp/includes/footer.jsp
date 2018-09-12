
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
			     
			     
			     

	
	<script>
	window.addEventListener("load", function(event) {
		$(document).ready(function() {
	           // $('#example')==> selecciona un objeto por id="example"
	           //.DataTable() ==> ejecuta el pluging de datatable
	            $('#example').DataTable({
	             "language": {
	            	 "url": "vendors/datatable/i18n/Spanish.json"
	             }
	            });
	        } );

		
	});
		
	</script>
	
	
	
	
</body>
</html>