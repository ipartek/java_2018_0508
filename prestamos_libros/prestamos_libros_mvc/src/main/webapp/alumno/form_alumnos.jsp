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
                        <div id="alumnos" class="tab-pane in active notika-tab-menu-bg animated flipInX">
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
                        <div id="prestamos" class="tab-pane notika-tab-menu-bg animated flipInX">
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
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 fondo_form ">
			<div>
				<c:if test="${not empty alerta}">
					<%@ include file="../includes/alerta.jsp"%>
				</c:if>
				<h1 class="titulo_form">${(alumno.id == -1)?'Crear':'Editar'} Alumno</h1>
				<form action="alumnos?op=2" method="post">
					<div class="form-group">
						<label>Id:</label>
						<div class="nk-int-st">
							<input name="id" type="text" value="${alumno.id}" required readonly class="form-control input-sm">
						</div>
					</div>
					<div class="form-group">
						<label>Nombre:</label>
						<div class="nk-int-st">
							<input name="nombre" type="text" value="${alumno.nombre}" required autofocus class="form-control input-sm">
						</div>
					</div>
					<div class="form-group">
						<label>Apellido:</label>
						<div class="nk-int-st">
							<input name="apellidos" type="text" value="${alumno.apellidos}" required class="form-control input-sm">
						</div>
					</div>
					<button  class="btn btn-success notika-btn-success waves-effect" type="submit">${(alumno.id == -1)?'Crear':'Editar'}</button>
					<c:if test="${alumno.id != -1}">
						<a class="btn btn-danger notika-btn-danger waves-effect" href="alumnos?op=<%=CrudControllable.OP_ELIMINAR %>&id=${alumno.id}" onclick="confirmar(event)">Eliminar</a>
					</c:if>
				</form>
				<script>
			function confirmar(e){
				if(confirm('¿Estas seguro de que deseas ELIMINAR?')){
					console.log('confirmado eliminar');
				}else{
					//prevenir el evento por defecto del enlace
					e.preventDefault();
				}
			}
		</script>
			</div>
		</div>
	</div>
</div>


<%@ include file="../includes/footer.jsp"%>