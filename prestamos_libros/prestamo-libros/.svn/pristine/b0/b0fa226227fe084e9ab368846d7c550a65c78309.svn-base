<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<footer class="footer">
	
		<p>&copy; Adrian Garcia & Asier Cornejo</p>
	
	</footer>

	<!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
   
   	<!-- datatables.net -->
   	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    
	<script>
	
	$(document).ready(function() {
	    $('#tablaOrdenable').DataTable( {
	        "language": {
	            "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
	        },
	        "order": [[ 0, "desc" ]]
	    } );
	} );
	
	function confirmar(e){
		
		if(confirm('¿Estás seguro de que quieres eliminar?')){
			console.log('Confirmado eliminar');
		}else{
			//Prevenir el evento por defecto del enlace <a href="">
			e.preventDefault();
		}
		
	}
	
	function showModalDevolucion(idLibro, idAlumno, titulo, nombre, fechaInicio){
		
		$('#modalDevolucion').modal('show');
		document.getElementById('titulo').value = titulo;
		document.getElementById('nombre').value = nombre;
		document.getElementById('libro').value = idLibro;
		document.getElementById('alumno').value = idAlumno;
		document.getElementById('fechaInicio').value = fechaInicio;
	}
	
	function showModalNuevoAlumno(){
			
			$('#modalNuevoAlumno').modal('show');
			console.log('Confirmado nuevo alumno');
			
			
		}
	
	function showModalNuevaEditorial(){
		
		$('#modalNuevaEditorial').modal('show');
		console.log('Confirmado nueva editorial');
		
	}
	
	</script>
	
</body>
</html>