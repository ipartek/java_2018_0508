<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>

<div id="page-wrapper">
<%@ include file="../includes/alert.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				<i class="fas fa-wrench list"></i>Videos <span class="badge badge-secondary">${fn:length(videos)}</span></h1>
			</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-md-4">
			<form action="videos" method="get" class="form-inline mt-2 mt-md-0">
				<input name="busqueda" class="form-control mr-sm-2" type="text" placeholder="Busca un video">	           		 
				<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Buscar</button>
			</form>
		</div>
		<div class="col-md-4">
			<a href="videos?id=-1&op=<%=CrudControllable.OP_IR_FORMULARIO %>" class="btn btn-success">Crear Nuevo</a>
		</div>
	</div>

	<div class="row">
		<main class="container" role="main">

		<table id="listado" class="display">
			<thead>
				<tr>
					<th>Id</th>
					<th>Codigo</th>
					<th>Imagen</th>
					<th>Nombre</th>
					<th>Usuario</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${videos}" var="v">
					<tr>
						<td>${v.id}</td>
						<td>${v.codigo}</td>
						<td><img src="http://img.youtube.com/vi/${v.codigo}/0.jpg" alt="imagen por defecto del video" class="thumbnail"/></td>
			            <td><a href="videos?id=${v.id}&op=<%=CrudControllable.OP_IR_FORMULARIO%>">${v.nombre}</a></td>			                
						<td><a href="usuarios?id=${v.usuario.id}&op=<%=CrudControllable.OP_IR_FORMULARIO%>">${v.usuario.nombre}</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

		</main>


<%@ include file="../includes/footer.jsp"%>