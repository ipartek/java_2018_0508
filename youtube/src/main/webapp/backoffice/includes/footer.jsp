<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
   
   	<!-- datatables.net -->
   	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
   
   	<script>
   		/* custom javascript */
   	
   		//Habilitar datatables
 		$(document).ready(function() {
		    $('#tablaOrdenable').DataTable();
		});	  	
   		
   		
   		function confirmar (e){
   			if (confirm('¿Estas seguro de que quieres ELIMINAR?')) {
				console.log('confirmado eliminar')
			} else {
				//prevenir el evento por defecto de <a href=''>S
				e.preventDefault();
			}
   			
   			
   		}
   		
   	</script>
	
  </body>

</html>