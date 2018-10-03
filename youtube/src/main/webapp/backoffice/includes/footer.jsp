<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
   <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="backoffice/js/sb-admin-2.js"></script>
	<script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready( function () {
		    $('#tablaBackoffice').DataTable();
		} );
		
		function showModalEliminar(id) {
			$('#modal-eliminar').modal('show');
			let btn = document.getElementById('btnEliminar');
			btn.href = 'backoffice/usuario?id='+id+'&op=77';
		}
		
	</script>
  </body>

</html>