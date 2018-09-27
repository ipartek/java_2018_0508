<!-- Modal -->
<div id="modal-login-form" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
        <form action="login" method="post" class="form-inline ">
		      <div class="form-group">
			      <input name="usuario" class="form-control mr-sm-2" type="text" placeholder="Usuario" required pattern=".{3,30}" value="${cookie.cNombre.value}">
			      <input name="pass" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
			       <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
		       </div>
		            
		       <div class="form-group ml-3">
		          <input type="checkbox" name="recuerdame" ${(not empty cookie.cNombre.value)?"checked":""}>
		          <label class="text-warning ml-1">Recuérdame</label>
		       </div>
		</form>
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>