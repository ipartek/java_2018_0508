<%@page import="com.ipartek.formacion.controller.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 fondo_tabla">
			<c:if test="${not empty alerta}">
				<%@ include file="/includes/alerta.jsp"%>
			</c:if>
			<h1 class="titulo_tablas">Historico<span class="badge medallon">${n_prestamos}</span></h1>
			<div class="table-responsive">
	           <table id="data-table-basic" class="table table-sc-ex table-striped">
					<thead>
						<tr>
							<th>Alumno</th>
							<th>Libro</th>
							<th>Fecha Incio</th>
							<th>Fecha Fin</th>
							<th>Devuelto</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${prestamos}" var="p">
							<tr>
								<td><a href="prestamos?op=<%=CrudControllable.OP_IR_FORMULARIO %>&id=${p.id}">${p.alumno.nombre}  ${p.alumno.apellidos}</a></td>
								<td><a href="prestamos?op=<%=CrudControllable.OP_IR_FORMULARIO %>&id=${p.id}">${p.libro.titulo}</a></td>
								<td><a href="prestamos?op=<%=CrudControllable.OP_IR_FORMULARIO %>&id=${p.id}">${p.fecha_inicio}</a></td>
								<td>${p.fecha_fin}</td>
								<td><a href="prestamos?op=<%=CrudControllable.OP_IR_FORMULARIO %>&id=${p.id}">${p.fecha_devuelto}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>


<%@ include file="../includes/footer.jsp"%>