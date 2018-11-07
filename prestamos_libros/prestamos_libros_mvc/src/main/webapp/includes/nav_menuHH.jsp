<%@page import="com.ipartek.formacion.controller.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<div class="container">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<ul class="nav nav-tabs notika-menu-wrap menu-it-icon-pro">
				<!--  <li><a data-toggle="tab" href="#Home">Home</a></li>-->
				<li><a data-toggle="tab" href="#editoriales">Editoriales</a></li>
				<li><a data-toggle="tab" href="#libros">Libros</a></li>
				<li><a data-toggle="tab" href="#alumnos">Alumnos</a></li>
				<li><a data-toggle="tab" href="#prestamos">Prestamos</a></li>
			</ul>
			<div class="tab-content custom-menu-content">
				<!-- Home -->
				<!--  <div id="Home" class="tab-pane in notika-tab-menu-bg animated flipInX">
					<ul class="notika-main-menu-dropdown">
						<li><a href="index.html">Dashboard One</a></li>
					</ul>
				</div>-->
				<!-- Editoriales -->
				<div id="editoriales" class="tab-pane notika-tab-menu-bg animated flipInX">
					<ul class="notika-main-menu-dropdown">
						<li><a href="editoriales?op=<%=CrudControllable.OP_LISTAR %>">
							<i class="notika-icon notika-windows"></i>Listado</a></li>
						<li><a href="editoriales?op=<%=CrudControllable.OP_IR_FORMULARIO %>&id=-1">
							<i class="notika-icon notika-form"></i>Crear la editorial</a></li>
					</ul>
				</div>
				<!-- Libros -->
				<div id="libros" class="tab-pane notika-tab-menu-bg animated flipInX">
					<ul class="notika-main-menu-dropdown">
						<li><a href="libros?op=<%=CrudControllable.OP_LISTAR %>">
							<i class="notika-icon notika-windows"></i>Listado</a></li>
						<li><a href="libros?op=<%=CrudControllable.OP_IR_FORMULARIO %>&id=-1">
							<i class="notika-icon notika-form"></i>Crear libro</a></li>
					</ul>
				</div>
				<!-- Prestamos -->
				<div id="prestamos" class="tab-pane notika-tab-menu-bg animated flipInX">
					<ul class="notika-main-menu-dropdown">
						<li><a href="prestamos?op=<%=CrudControllable.OP_LISTAR %>">
							<i class="notika-icon notika-windows"></i>Listado prestamos</a></li>
							<li><a href="prestamos?op=5">
							<i class="notika-icon notika-windows"></i>Historico prestamos</a></li>
						<li><a href="prestamos?op=<%=CrudControllable.OP_IR_FORMULARIO %>&id=-1">
							<i class="notika-icon notika-form"></i>Crear Prestamo</a></li>
					</ul>
				</div>
				<!-- Alumnos -->
				<div id="alumnos" class="tab-pane notika-tab-menu-bg animated flipInX">
					<ul class="notika-main-menu-dropdown">
						<li><a href="alumnos?op=<%=CrudControllable.OP_LISTAR %>">
							<i class="notika-icon notika-windows"></i>Listado</a></li>
						<li><a href="alumnos?op=<%=CrudControllable.OP_IR_FORMULARIO %>&id=-1">
							<i class="notika-icon notika-form"></i>Crear usuario</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>