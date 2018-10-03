<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

	<%@ include file="../includes/nav.jsp" %>
	<div id="wrapper">

        <%@ include file="../includes/sidebar.jsp" %>

        <div id="page-wrapper">
        	<div class="row">
        		<div class="col-md-12">
        			<h2>${(usuario.id == 0)?'Crear usuario':usuario.nombre}</h2>
        		</div>
        	</div>
        	<div class="row m-auto">
        		<div class="col-md-6">
        			<form action="backoffice/usuario" method="post">        		
	        			<div class="form-group">
	        				<input name="id" type="text" class="form-control" value="${usuario.id}" readonly/>
	        			</div>
	        			<div class="form-group">
	        				<label for="nombre">Nombre:</label>
	        				<input name="nombre" type="text" class="form-control" value="${usuario.nombre}" autofocus/>
	        			</div>
	        			<div class="form-group">
	        				<label for="contrasenya">Contraseña:</label>
	        				<input name="contrasenya" type="text" class="form-control" value="${usuario.contrasenya}"/>
	        			</div>
	        			<div class="form-group">
	        				<label for="rol">Rol:</label>
	        				<select name="rol" class="form-control">
	        					<option value="<%=Usuario.ROL_USER%>">Normal</option>
	        					<option value="<%=Usuario.ROL_ADMIN%>">Administrador</option>
	        				</select>
	        			</div>
	        			<input type="submit" value="${(usuario.id == 0)?'Crear':'Modificar'}" class="btn btn-primary btn-block" />
	        			<c:if test="${usuario.id>0}">
	        				<a href="modal-eliminar" onclick="showModalEliminar(${usuario.id})" class="btn btn-danger btn-block">Eliminar</a>
	        			</c:if>
	        		</form>
        		</div>
        	</div>
        	<!-- /row -->
        </div>
	</div>
	
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
	
<%@ include file="../includes/footer.jsp" %>
