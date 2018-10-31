<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MODAL ELIMINAR-->
<div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      
      <div class="modal-header">
        <h5 class="modal-title text-center" id="exampleModalLabel">Aviso: Cambios irreversibles</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
       
       <p>Vas a eliminar un registro. Los cambios serán irreversibles. No obstante, siempre puedes volver
        a introducirlo en la lista. ¿Desear continuar?</p>
        
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">No eliminar</button>
        <a id="btnEliminar" type="button" class="btn btn-danger">Eliminar</a>
      </div>
    </div>
  </div>
</div>

<!-- MODAL ELIMINAR-->
<div class="modal fade" id="modalModificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Formulario de Alta o Modificación Editorial</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
       
       <form id="updateForm" method="post">

		  <input type="submit" value="Guardar" class="btn btn-danger">
		</form>
        
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Cancelar</button>
      </div>
    </div>
  </div>
</div>