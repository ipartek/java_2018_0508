 </div>
    <!-- /#wrapper -->

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
   		
   		
   		function showpass( event, elementId ){
   			console.log('click showpass ' + elementId);
   			var el = document.getElementById(elementId);
   			if ( el.type === "password"){
   				el.type = "text";
   			}else{
   				el.type = "password";
   			}   			
   			
   			if ( event.target.classList.contains("fa-eye")){
   				event.target.classList.remove("fa-eye");
   				event.target.classList.add("fa-eye-slash");
   			}else{
   				event.target.classList.add("fa-eye");
   				event.target.classList.remove("fa-eye-slash");
   			}
   			
   		}
   		
   	</script>
   	
   
</body>

</html>
