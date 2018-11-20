<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalTitle"></h4>
      </div>
      <div class="modal-body" id="myModalBody">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>
<!-- Modal:end -->
 
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
		    $('[data-toggle="tooltip"]').tooltip();
		});
   		
   		function showModal(texto, titulo){
   			document.getElementById('myModalTitle').innerHTML = titulo;
   			document.getElementById('myModalBody').innerHTML = texto;
   			
   			$('#myModal').modal('show');
   		}
   		
   	</script>
   	
   
</body>

</html>
