<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!-- Modal Eliminar-->
<div class="modal fade" id="modal-eliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header bg-pika-red">
        <h5 class="modal-title text-pika-blue" id="exampleModalLabel">Cuidadin</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <p>¿Estas seguro de querer eliminar este video?</p>
       <a id="btnEliminar" href="" class="btn btn-outline-info btn-outline-pika-red">Eliminar <i class="fas fa-trash-alt"></i></a>
       <button type="button" class="btn btn-outline-info btn-outline-pika-red" data-dismiss="modal">Cerrar</button>
        
      </div>
      <div class="modal-footer bg-pika-red">
        
      </div>
    </div>
  </div>
</div>


<!-- Modal Editar-->
<div class="modal fade" id="modal-modificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header bg-pika-purple">
        <h5 class="modal-title text-pika" id="exampleModalLabel">A Editar</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <form action="inicio" method="post">
       	<input id="id" name="id" type="hidden" value="">
       	<input id="op" name="op" type="hidden" value="">
       	<input id="cajaNombre" name="cajaNombre" type="text" value="" autofocus maxlength="125" class="form-control"/>
       	<br>
       	<input class="btn btn-outline-info btn-outline-pika-purple" type="submit" value="Editar" />
       	<button type="button" class="btn btn-outline-info btn-outline-pika-red" data-dismiss="modal">Cerrar</button>
       </form>
       
      </div>
      <div class="modal-footer bg-pika-purple">
        
      </div>
    </div>
  </div>
</div>
