<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>

<div id="page-wrapper">
<%@ include file="../includes/alert.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				<i class="fas fa-comments"></i>Comentarios <span class="badge badge-secondary">${fn:length(comentarios)}</span>
			</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-md-4">
			<form action="comentarios" method="post">
				<div class="input-group">
  					<input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
  					<span class="input-group-addon"><i class="fas fa-search"></i></span>
				</div>
			</form>
		</div>
	</div>

	<div class="row">
		<main class="container" role="main">

		<table id="listado" class="display">
			<thead>
				<tr>
					<th>Id</th>
					<th>Comentario</th>
					<th>Fecha</th>
					<th>Usuario</th>
					<th>Video</th>
					<th>Aprobado</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${comentarios}" var="c">
					<tr>
						<td>${c.id}</td>
			            <td><a href="comentarios?id=${c.id}&op=<%=CrudControllable.OP_IR_FORMULARIO%>">${c.texto}</a></td>	
			            <td>${c.fecha}</td> 		                
						<td>${c.usuario.nombre}</td>
						<td>${videos.nombre}</td>
						<td>${(c.aprobado)?1: 0 }</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

		</main>


<%@ include file="../includes/footer.jsp"%>