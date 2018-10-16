<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="js/scripts.js"></script>
<script>
	$(document).ready(function() {
		$('#tablaBackoffice').DataTable({
			"order" : [ [ 0, "desc" ] ]
		});
		$('[data-toggle="tooltip"]').tooltip()
		cambiarLogo();
	});

	function showModalEliminar(id) {
		$('#modal-eliminar').modal('show');
		console.log("abro modal");
		let btn = document.getElementById('btnEliminar');
		btn.href = 'backoffice/usuario?id=' + id + '&op=77';
	}

	
</script>
</body>

</html>