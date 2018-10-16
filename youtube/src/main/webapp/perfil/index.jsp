<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp" %>
<div id="wrapper">

		<%@include file="includes/nav.jsp" %>

        <div id="page-wrapper" class="contenedor">
        <%@include file="includes/alert.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header titulo">${sessionScope.usuario.nombre}</h1>
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
            				<img src="" alt="Imagen-de-perfil" title="Imagen-de-perfil" />
            				<input type="file" class="btn btn-primary" value="Cambiar imagen de perfil" />
            			</div>
            		</div>
            		
            		<div class="form-row">
            			<div class="col-lg-12">
            				<fieldset>
            					<legend>Cambiar contraseña</legend>
            					<div class="form-group col-lg-6">
            						<label for="nuevaPass">Nueva contraseña:</label>
            						<input type="text" class="form-control" id="nuevaPass" name="nuevaPass" />
            					</div>
            					<div class="form-group col-lg-6">
            						<label for="repitePass">Repite la contraseña:</label>
            						<input type="text" class="form-control" id="repitePass" name="repitePass" />
            					</div>
            				</fieldset>
            			</div>
	            	</div>
            		
            	</form>
              
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
<%@include file="includes/footer.jsp" %>

