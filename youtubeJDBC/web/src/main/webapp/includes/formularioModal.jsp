<!-- Modal REGISTRO DE USUARIOS-->
						<div class="modal fade" id="formularioModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel">Atención!!!</h5>
						        <form action="inicio" >
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="form-row">
										  <div class="form-group col-md-6">
										      <label for="nombreUsuario">Usuario</label>
										      <input type="text" class="form-control" name="nombreUsuario" autofocus required="required" placeholder="5 caracteres minimo" pattern="[A-Za-z]{5,45}">
										    </div>
										    <div class="form-group col-md-6">
										      <label for="emailUsuario">Email</label>
										      <input type="email" class="form-control" name="emailUsuario" required="required" placeholder="ejemplo@correo.com" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,45}">
										    </div>
										    <div class="form-group col-md-6">
										      <label for="passUsuario">Password</label>
										      <input type="password" class="form-control" required="required" name="passUsuario" placeholder="*******">
										    </div>
										    <div class="form-group col-md-6">
										      <label for="replyPassUsuario">Repita el password</label>
										      <input type="password" class="form-control" required="required" name="replyPassUsuario" placeholder="*******">
										    </div>
										  </div>
										  <div class="center-button">

										  </div>
							      <div class="modal-body">

							      </div>
							      <div class="modal-footer">
							        <button type="button"  class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
							         
							        <button  type="submit" class="btn btn-primary">Date de alta</button>       
							      </div>
						      </form>
						    </div>
						  </div>