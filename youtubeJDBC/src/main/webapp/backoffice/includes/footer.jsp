 </div>
    <!-- /#wrapper -->

      <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- Datatable js -->
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
	<script type="text/javascript">
		$(document).ready( function () {
		    $('#userDataTable').DataTable();
		    /* "order": [[ 3, "desc" ]] */
		} );
		
		function showPass(event,elementId){
			console.log("nos llega :"+ elementId);
			 var el = document.getElementById(elementId);
			if(el.type == 'password'){
				console.log('password');
				el.type ="text";
			}else{
				console.log('texto');
				el.type ="password";
			}
			if(event.target.classList.contains("fa-eye")){
				event.target.classList.remove("fa-eye");
				event.target.classList.add("fa-eye-slash");
			}else{
				event.target.classList.remove("fa-eye-slash");
				event.target.classList.add("fa-eye");
				
				
			}
		}
	</script>
	
</body>

</html>