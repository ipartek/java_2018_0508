<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    
    <script>
    	/* Custom javascript */
    	
    	//Habilitar datatables    	
	    $(document).ready(function() {
		    $('#tablaOrdenable').DataTable( {
		        "language": {
		            "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
		        }
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
    	
    </script>

</body>

</html>
