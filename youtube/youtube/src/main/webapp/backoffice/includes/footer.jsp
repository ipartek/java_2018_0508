<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		});	  	
   		
   		
   		function confirmar (e){
   			if (confirm('¿Estas seguro de que quieres ELIMINAR?')) {
				console.log('confirmado eliminar')
			} else {
				//prevenir el evento por defecto de <a href=''>S
				e.preventDefault();
			}
   			
   			
   		}
   		
   		function showPass(event , elementId){
   			console.log('click en '+elementId)
   			var el = document.getElementById(elementId)
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
   		function showComentario(elementId){
   			var el = document.getElementById(elementId)
   		}
   		
   		function showModal(texto, titulo){
 			console.log('click showModal texto=' + texto);
 			
 			document.getElementById('myModalBody').innerHTML = texto;
 			document.getElementById('myModalTitle').innerHTML = titulo;
 			
 			$('#myModal').modal('show');  
 		}
   		
   	</script>
   	<!-- Modal del comentario  -->
   	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalTitle">Modal title</h4>
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
	
  </body>

</html>