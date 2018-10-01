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
