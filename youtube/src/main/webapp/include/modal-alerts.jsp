
<!-- MODAL ELIMINAR VIDEO -->
<div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     
     <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Aviso</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
       <p>Vas a eliminar un video. Los cambios serán irreversibles. No obstante, siempre puedes volver
        a introducirlo en la lista. ¿Desear continuar?</p>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <a id="btnEliminarVideo" type="button" class="btn btn-danger">Eliminar Video</a>
      </div>
    </div>
  </div>
</div>

<!-- MODAL MODIFICAR VIDEO -->
<div class="modal fade" id="modalModificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     
     <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Aviso</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
       <form action="inicio" id="updateForm" method="post">
		  <div class="form-group">
		  	<label for="nuevoCod">Nuevo Código</label>
		    <input type="text" name="nuevoCod" class="form-control" id="nuevoCod" placeholder="Debe tener 11 caracteres.">
		    
		    <label for="nuevoTit">Nuevo título</label>
		    <input type="text" name="nuevoTitulo" class="form-control" id="nuevoTit" placeholder="Mínimo 2 caracteres.">
		  	
		  	<input type="hidden" id="idModificar" name="id">
		  	<input type="hidden" name="op" value="${HomeController.OP_MODIFICAR}">
		  
		  </div>
		  <input type="submit" value="Modificar" class="btn btn-danger">
		</form>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>

<!-- MODAL REGISTRO -->
<div class="modal fade" id="modalRegistrar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     
     <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Regístrate!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
      
	      <form action="registro" method="post">
			  
			  <div class="form-group">
			    <label for="registerUsuario">Usuario</label>
			    <input type="text" class="form-control" id="registerUsuario" name="registerUsuario" placeholder="Mínimo 5 caracteres" required autofocus pattern="{3,50}">
			  </div>
			  
			   <div class="form-row">
				    <div class="col-6">
				     	<label for="registerPassword">Contraseña</label>
			    		<input type="password" class="form-control" id="registerPassword" name="registerPassword" placeholder="Mínimo 5 caracteres" required pattern="{8,20}">
				    </div>
				    <div class="col-6">
				     	<label for="repitePassword">Repite Contraseña</label>
			    		<input type="password" class="form-control" id="repitePassword" name="repitePassword" placeholder="Mínimo 5 caracteres" required pattern="{8,20}">
				    </div>
			    </div>
			  <div class="form-group">
			    
			  </div>
			  <button type="submit" class="btn btn-primary">Registrarme!</button>
			</form>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>