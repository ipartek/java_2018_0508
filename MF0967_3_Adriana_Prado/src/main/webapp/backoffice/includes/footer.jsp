	    <!-- Place at the end of the page to load it faster -->
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	   	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
       
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
         
		<script>  
			window.addEventListener("load", function(event) {
		      	$('#lista').DataTable({
		        	"language": {
		        		"url": "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
		       		}                  
		        });
			});
		</script>
    </body>
</html>