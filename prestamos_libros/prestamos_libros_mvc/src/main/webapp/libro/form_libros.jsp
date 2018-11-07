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
                        <div id="libros" class="tab-pane in active notika-tab-menu-bg animated flipInX">
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
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 fondo_form">
			<div>
				<c:if test="${not empty alerta}">
					<%@ include file="/includes/alerta.jsp"%>
				</c:if>
				<h1 class="titulo_form">${(libro.id == -1)?'Crear':'Editar'} Libro</h1>
				<form action="libros?op=<%=CrudControllable.OP_GUARDAR %>" method="post">
					<div class="form-group">
						<label>Id:</label>
						<div class="nk-int-st">
							<input name="id" type="text" value="${libro.id}" required readonly class="form-control input-sm">
						</div>
					</div>
					<div class="form-group">
						<label>ISBN:</label>
						<div class="nk-int-st">
							<input name="isbn" type="text" value="${libro.isbn}" required autofocus class="form-control input-sm" maxlength="13">
						</div>
					</div>
					<div class="form-group">
						<label>Titulo:</label>
						<div class="nk-int-st">
							<input name="titulo" type="text" value="${libro.titulo}" required class="form-control input-sm">
						</div>
					</div>
					<div class="form-group">
						<label>Editorial:</label>
						<div class="nk-int-st">
							<select name="editorial" class="form-control">
								<option value="-1" selected>Escoge una editorial</option>
								<c:forEach items="${editorial}" var="e">
									<option value="${e.id}" ${(e.id == libro.editorial.id)?'selected':''} >${e.nombre}</option>
								</c:forEach>
							</select>
						</div>

					</div>
					<c:if test="${libro.id == -1}">
						<div class="form-group">
							<label>Número de ejemplares:</label>
							<div class="nk-int-st">
								<input type="number" name="n_libros" class="form-control input-sm" min="1" step="1" max="10" value="1">
							</div>
						</div>
					</c:if>
					<button  class="btn btn-success notika-btn-success waves-effect" type="submit">${(libro.id == -1)?'Crear':'Editar'}</button>
					<c:if test="${libro.id != -1}">
						<a class="btn btn-danger notika-btn-danger waves-effect" href="libros?op=<%=CrudControllable.OP_ELIMINAR %>&id=${libro.id}" onclick="confirmar(event)">Eliminar</a>
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