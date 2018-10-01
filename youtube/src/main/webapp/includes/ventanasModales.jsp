<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!-- Modal Eliminar-->
<div class="modal fade" id="modal-eliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header bg-danger">
        <h5 class="modal-title" id="exampleModalLabel">Cuidadin</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       ¿Estas seguro de querer eliminar este video?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <a id="btnEliminar" href="" class="btn btn-danger">Eliminar <i class="fas fa-trash-alt"></i></a>
      </div>
    </div>
  </div>
</div>


<!-- Modal Editar-->
<div class="modal fade" id="modal-modificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header bg-warning">
        <h5 class="modal-title" id="exampleModalLabel">Cuidadin</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <form action="inicio" method="post">
       	<input id="id" name="id" type="hidden" value="">
       	<input id="op" name="op" type="hidden" value="">
       	<input id="cajaNombre" name="cajaNombre" type="text" value=""/>
       	<input class="btn btn-warning" type="submit" value="Editar" />
       </form>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>


<!-- Modal Alta-->
<div class="modal fade" id="modal-alta" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header bg-info">
        <h5 class="modal-title" id="exampleModalLabel">Registro</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body m-2">
       <form action="altaUsuario" method="post">
       	<label for="nombre">Introduzca su nombre:</label>
       	<input  class="form-control" id="nombre" name="nombre" type="text" value="" required autofocu/>
       	<label for="pass">Introduzca su contraseña:</label>
       	<input class="form-control" id="pass" name="pass" type="password" value="" required/>
       	<label for="pass">Repita la contraseña:</label>
       	<input class="form-control" id="pass2" name="pass2" type="password" value="" required/>
       	<div class="m-2">
       		<input class="btn btn-success" type="submit" value="Darse de Alta" />
       		<button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
       	</div>
       </form>
      </div>
    </div>
  </div>
</div>