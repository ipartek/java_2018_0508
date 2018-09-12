
<!-- Placed at the end of the document so the pages load faster -->
<link rel="stylesheet" href="vendors/datatables/1.10.19/css/jquery.dataTables.min.css">
<style>
	tr:hover td {
		background-color:#DAF7A6 !important;
	}
</style>

<script src="vendors/jquery/jquery-3.3.1.js"></script>
<script src="vendors/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
<link href="vendors/datatables/responsive/2.1.0/css/responsive.dataTables.css" rel="stylesheet" type="text/css" />
<script src="vendors/datatables/responsive/2.1.0/js/dataTables.responsive.js"></script>
<script>
	//Esperamos a que todo el HTML este cargado == body onload
	$(document).ready(function() {
		//$('#example')--> selecciona un objeto por id="example"
		//.DataTable({})--> ejecutar el plugin de DataTable
		$('#tablaordenada').DataTable({
			"language" : {
				"url" : "vendors/plug-ins/9dcbecd42ad/i18n/Spanish.json"
			}

		});
	});
</script>




<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</body>
</html>