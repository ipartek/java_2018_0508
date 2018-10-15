<!-- jQuery -->
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/jquery/jquery.min.js"></script>
		
		 <!-- Bootstrap Core JavaScript -->
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<!-- DataTables JavaScript -->
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/datatables/js/jquery.dataTables.min.js"></script>
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/datatables-responsive/dataTables.responsive.js"></script>
	
	    <!-- Custom Theme JavaScript -->
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/dist/js/sb-admin-2.js"></script>

		<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	    <script>
		    $(document).ready(function() {
		        $('#dataTable-ordenable').DataTable({
		        	responsive: true,
		        	"language": {
		        		"url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
		       		}		            
		        });
		    });
		    
		    //funcion para el confirm de eliminar 
		    function confirmar(e){
        		if(confirm('¿Estás seguro de que quieres eliminar?')){
        			console.log('Pulsado eliminar');
        		}else{
        			//Prevenir el evento por defecto del enlace
        			e.preventDefault();
        		}
        	}
		    
		    //funcion para leer comentario completo
		    function showModalComentario(idComentario, texto){
				$('#modalVerComentario').modal('show');
				var comentario = document.getElementById('comentarioCompleto');
				comentario.innerHTML = texto;
			}
		    
		  //Ocultar y mostrar password
		  function showpass(event,contrasenna){
			  
			  var el=document.getElementById(contrasenna);
			  
			  if(el.type=="password"){				  
				  el.type="text";
				 
			  }else{
				  el.type="password";
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