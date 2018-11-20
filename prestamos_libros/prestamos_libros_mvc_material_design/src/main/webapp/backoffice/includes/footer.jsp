<!--footer-->
<footer class="main-footer">
	<div class="footer-left">
		Copyright &copy; 2018
		<div class="bullet"></div>
		Design By <a href="http://www.formacion.ipartek.com/">Ipartek</a>
	</div>
	<div class="footer-right"></div>
	<!-- Modal -->
	<div class="modal fade" id="modalDevolucion" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			
			<form action="prestamo" method="post">
				<input type="hidden" id="op" name="op" value="5">
				<input type="hidden" id="libro" name="libro">
				<input type="hidden" id="usuario" name="usuario">
				<input type="hidden" id="fechaInicio" name="fechaInicio">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Fecha Devolución</h5>
											<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="cerrarModal()">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="form-group col">
								<label for="last_name">FECHA DEVOLUCION</label> 
								<input name="datedevolucion" id="datepicker" width="276" />
							</div>
						</div>
					</div>
					<div class="modal-footer">
<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="cerrarModal()">Cerrar</button>
						<button type="submit" class="btn btn-primary">Devolver</button>
					</div>
				</div>
			</form>
			
		</div>
	</div>
</footer>
<!-- /footer-->
</div>
</div>

<script src="dist/modules/jquery.min.js"></script>
<script src="dist/modules/popper.js"></script>
<script src="dist/modules/tooltip.js"></script>
<script src="dist/modules/bootstrap/js/bootstrap.min.js"></script>
<script src="dist/modules/nicescroll/jquery.nicescroll.min.js"></script>
<script src="dist/modules/scroll-up-bar/dist/scroll-up-bar.min.js"></script>
<script src="dist/js/sa-functions.js"></script>
<script src="dist/modules/chart.min.js"></script>
<script src="dist/modules/summernote/summernote-lite.js"></script>
<script src="dist/js/scripts.js"></script>
<script src="dist/js/custom.js"></script>
<script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/js/gijgo.min.js" type="text/javascript"></script>

<!-- datatables.net -->
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<script>
	//Habilitar datatables
	$(document)
			.ready(
					function() {
						$('#tablaOrdenable')
								.DataTable(
										{
											"language" : {
												"url" : "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
											}
										});
					});

	$('#datepicker').datepicker({
		uiLibrary : 'bootstrap4'
	});

	$('#datedevolucion').datepicker({
		uiLibrary : 'bootstrap4'
	});
	
	$('#fechaFinDatepicker').datepicker({
		uiLibrary : 'bootstrap4'
	});

	function showModalDevolucion(idLibro, idUsuario, fechaInicio) {
		document.getElementById('libro').value = idLibro;
		document.getElementById('usuario').value = idUsuario;
		document.getElementById('fechaInicio').value = fechaInicio;
		
		console.log('id_libro= ' + idLibro + ' id_usuario= ' + idUsuario + ' fecha_inicio= ' + fechaInicio);
		
		$('#modalDevolucion').modal('show');
	}
	
	function cerrarModal(){
		$('#modalDevolucion').modal('hide');
	}
</script>


</body>
</html>