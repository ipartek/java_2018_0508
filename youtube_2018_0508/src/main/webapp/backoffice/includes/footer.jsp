</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- datatables.net -->
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<script>
	/* custom javascript */

	//Habilitar datatables
	$(document).ready(function() {
		$('#tablaOrdenable').DataTable();
	});

	/*Funcion para ventana emergente del boton eliminar del form Usuario*/
	function confirmar(e) {
		if (confirm('¿Estas seguro que quieres eliminar?')) {
			console.log('confirmado eliminar');
		} else {

			e.preventDefault();
		}
	}
</script>


</body>

</html>