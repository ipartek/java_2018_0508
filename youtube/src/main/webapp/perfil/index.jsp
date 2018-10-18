<%@page import="com.ipartek.formacion.youtube.controller.frontoffice.FrontofficeController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp" %>
<div id="wrapper">

		<%@include file="includes/nav.jsp" %>

        <div id="page-wrapper" class="contenedor">
        <%@include file="includes/alert.jsp" %>
            <div class="cabeceraPerfil row">
                <div class="col-lg-6">
                    <h1>${sessionScope.usuario.nombre}</h1>
                </div>
                <div class="col-lg-6 divImagenPerfil">
                	<img src="${sessionScope.usuario.imagen}" class="imagenPerfil" alt="imagen-de-perfil" title="imagen-de-perfil" />
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
            
            	<form action="" method="post">
            		
            		<div class="form-row">
            			<div class="form-group col-lg-6">
            				<label for="nombre">Nombre:</label>
            				<input type="text" class="form-control" id="nombre" name="nombre" value="${sessionScope.usuario.nombre}" />
            			</div>
            			<div class="form-group col-lg-6">
							<label for="imagen">Imagen de perfil(URL)</label>
            				<input type="text" id="imagen" name="imagen" class="form-control" placeholder="https:/imagen-de-ejemplo.com" />
            			</div>
            		</div>
            		
            		<div class="form-row">
            			<div class="col-lg-12">
            				<fieldset class="scheduler-border">
            					<legend class="scheduler-border">Cambiar contraseña</legend>
            					<div class="form-group col-lg-6">
            						<label for="nuevaPass">Nueva contraseña:</label>
            						<input type="text" class="form-control" id="nuevaPass" name="nuevaPass" />
            					</div>
            					<div class="form-group col-lg-6">
            						<label for="repitePass">Repita la contraseña:</label>
            						<input type="text" class="form-control" id="repitePass" name="repitePass" />
            					</div>
            				</fieldset>
            			</div>
	            	</div>
	            	
	            	<input type="hidden" name="op" value="<%=FrontofficeController.OP_MODIFICAR_PERFIL %>" />
	            	
	            	<input type="submit" class="btn btn-primary btn-block" value="Guardar cambios" />
            		
            	</form>
              
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
<%@include file="includes/footer.jsp" %>

