<%@page import="com.ipartek.formacion.controller.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>

<%@ include file="../includes/nav_header.jsp"%>

<div class="main-menu-area mg-tb-40">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <ul class="nav nav-tabs notika-menu-wrap menu-it-icon-pro">
                       
                        <li><a data-toggle="tab" href="#editoriales"> Editoriales</a>
                        </li>
                        <li><a data-toggle="tab" href="#alumnos"> Alumnos</a>
                        </li>
                        <li><a data-toggle="tab" href="#libros"> Libros</a>
                        </li>
                        <li><a data-toggle="tab" href="#prestamos"> Prestamos</a>
                        </li>
                    </ul>
                    <div class="tab-content custom-menu-content">
                        <div id="editoriales" class="tab-pane notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="editoriales?op=<%=CrudControllable.OP_LISTAR %>">Listar Editorial</a>
                                </li>
                                <li><a href="editoriales?op=<%=CrudControllable.OP_IR_FORMULARIO %>&id=-1">Crear Editorial</a>
                                </li>
                            </ul>
                        </div>
                        <div id="alumnos" class="tab-pane notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="alumnos?op=<%=CrudControllable.OP_LISTAR %>">Listar alumno</a>
                                </li>
                                <li><a href="alumnos?op=<%=CrudControllable.OP_IR_FORMULARIO %>&id=-1">Crear alumno</a>
                                </li>
                            </ul>
                        </div>
                        <div id="libros" class="tab-pane notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="libros?op=<%=CrudControllable.OP_LISTAR %>">Listar libros</a>
                                </li>
                                <li><a href="libros?op=<%=CrudControllable.OP_IR_FORMULARIO %>&id=-1">Crear libros</a>
                                </li>
                            </ul>
                        </div>
                        <div id="prestamos" class="tab-pane in active notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="prestamos?op=<%=CrudControllable.OP_LISTAR %>">Listar prestamo</a>
                                </li>
                                <li><a href="prestamos?op=<%=CrudControllable.OP_HISTORICO %>&id=-1">Historico</a>
                                </li>
                                <li><a href="prestamos?op=<%=CrudControllable.OP_IR_FORMULARIO %>&id=-1">Crear prestamo</a>
                                </li>
                            </ul>
                        </div>
              
                    </div>
                </div>
            </div>
        </div>
    </div>

<div class="container">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 fondo_form">
			<div>
				<c:if test="${not empty alerta}">
					<%@ include file="/includes/alerta.jsp"%>
				</c:if>
				<h1 class="titulo_form">${(prestamo.id == -1)?'Crear':'Editar'} Prestamo</h1>
				<form action="prestamos?op=<%=CrudControllable.OP_GUARDAR%>" method="post">
					<div class="form-group">
						<label>Id:</label>
						<div class="nk-int-st">
							<input name="id" type="text" value="${prestamo.id}" required readonly class="form-control input-sm">
						</div>
					</div>
						<div class="form-group">
								<label>Alumno:</label>
								<div class="nk-int-st">
									<!-- <input name="id_alumno" type="text" value="${prestamo.alumno.id} - ${prestamo.alumno.nombre} ${prestamo.alumno.apellidos} " required class="form-control input-sm"> -->
								<select name="id_alumno" class="form-control">
									<option value="${prestamo.alumno.id}" selected>${prestamo.alumno.nombre}</option>
									<c:forEach items="${alumnos}" var="a">
										<option value="${a.id}">${a.id} - ${a.nombre} - ${a.apellidos}</option>
									</c:forEach>
								</select>
								</div>
						</div>
						<div class="form-group">
								<label>Libro:</label>
								<div class="nk-int-st">
									<!--  <input name="id_libro" type="text" value="${prestamo.libro.id} - ${prestamo.libro.titulo}" required class="form-control input-sm">-->
									<div class="nk-int-st">
								<select name="id_libro" class="form-control">
									<option value="${prestamo.libro.id}" selected>${prestamo.libro.titulo}</option>
									<c:forEach items="${libros}" var="l">
										<option value="${l.id}">${l.id} - ${l.isbn} - ${l.titulo} </option>
									</c:forEach>
								</select>
							</div>
								</div>
						</div>
						<div class="form-group">
							<label>Fecha inicio:</label>
							<div class="nk-int-st">
								<input name="fecha_inicio" type="date" value="${prestamo.fecha_inicio }" required class="form-control input-sm">
							</div>
						</div>
						<c:if test="${prestamo.id != -1}">
						<div class="form-group">
							<label>Fecha fin:</label>
							<div class="nk-int-st">
								<input name="fecha_fin" type="date" value="${prestamo.fecha_fin}" class="form-control input-sm">
							</div>
						</div>

						</c:if>
						<c:if test="${not empty prestamo.fecha_devuelto}">
						<label>Fecha devuelto:</label>
							<div class="nk-int-st">
								<input name="fecha_devolucion" type="date" value="${prestamo.fecha_devuelto}" class="form-control input-sm">
							</div>
						</c:if>
						<button  class="btn btn-success notika-btn-success waves-effect" type="submit">${(prestamo.id == -1)?'Crear':'Editar'}</button>
				</form>
			</div>
		</div>
	</div>
</div>