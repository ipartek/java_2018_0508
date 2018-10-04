<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

	<%@ include file="../includes/nav.jsp" %>
	<div id="wrapper">

        <%@ include file="../includes/sidebar.jsp" %>

        <div id="page-wrapper">
        	<div class="row">
        		<h2>Usuarios <span class="label label-primary">${nUsuario}</span></h2>
        	</div>
        	<div class="row">
        		<div class="col-md-8">
        			<form action="" method="post">
					    <div class="input-group">
					      <input type="text" class="form-control" placeholder="Buscar..." name="buscar">
					      <div class="input-group-btn">
					        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
					      </div>
					    </div>
					  </form>
        		</div>
        		<div class="col-md-4">
        			<a href="backoffice/usuario?id=-1&op=<%= BackofficeUsuarioController.OP_IR_FORMULARIO%>" class="btn btn-info">Crear Nuevo</a>
        		</div>
        	</div>
        	<table id="tablaBackoffice" class="display" style="width:100%">
		        <thead>
		            <tr>
		                <th>ID</th>
		                <th>Nombre</th>
		                <th>Password</th>
		                <th>Rol</th>
		            </tr>
		        </thead>
		        <tbody>
		        	<c:forEach items="${usuarios}" var="u">
		        		<tr>
			                <td>${u.id}</td>
			                <td><a href="backoffice/usuario?id=${u.id}&op=<%= BackofficeUsuarioController.OP_IR_FORMULARIO%>">${u.nombre}</a></td>
			                <td>${u.contrasenya}</td>
			                <td>${(u.rol==1)?'usuario':'admin'}</td>
		            	</tr>
		        	</c:forEach>
		        </tbody>
		        <tfoot>
		            <tr>
		                <th>ID</th>
		                <th>Nombre</th>
		                <th>Password</th>
		                <th>Rol</th>
		            </tr>
		        </tfoot>
	        </table>
        </div>
	</div>
<%@ include file="../includes/footer.jsp" %>
