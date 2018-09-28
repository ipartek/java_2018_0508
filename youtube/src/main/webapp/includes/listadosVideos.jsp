<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-lg-4">
	<section>
	  	<h1 class="text-pika"><fmt:message key="lista.reproduccion"/></h1>
		<ul class="list-group">
			<c:if test="${not empty videos}">
				<c:forEach items="${videos}" var="v">
					<li class="list-group-item d-flex justify-content-between align-items-center">
						<a href="inicio?id=${v.id}">${v.nombre}</a>
						<c:if test="${not empty sessionScope.usuario}">
							<!-- Opcion Editar -->
							<i onclick="showModalModificar(${v.id},${HomeController.OP_MODIFICAR},'${v.nombre}')" class="fas fa-pencil-alt text-warning"></i>
							<!-- Opcion Eliminar -->
							<i onclick="showModalEliminar(${v.id},${HomeController.OP_ELIMINAR})" class="fas fa-trash-alt text-danger"></i>
						</c:if>
					</li>
				</c:forEach>
			</c:if>
		</ul>

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
	</section>
	<section>
		<h2 class="text-secondary">Lista del Usuario</h2>
			<c:if test="${not empty usuario}">
				<ul class="list-group">
					<c:if test="${not empty videosUsuario}">
						<c:forEach items="${videosUsuario}" var="vu">
							<li class="list-group-item d-flex justify-content-between align-items-center">
								<a href="inicio?id=${vu.id}">${vu.nombre}</a>
							</li>
						</c:forEach>
					</c:if>
				</ul>
			</c:if>
			<c:if test="${empty usuario}">
				<a href="#">Accede con tu usuario</a>
			</c:if>
	</section>
</div>