<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>

<div id="page-wrapper">
	<%@ include file="includes/alert.jsp"%>
	<div class="row">
	    <div class="col-lg-3 col-md-6">
	        <div class="panel panel-color">
	    		<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<img src="../images/user.png" class="perfil">
						</div>
					</div>
				</div>
				
				<a href="">
	                <div class="panel-footer">
	                    <span class="pull-left">Cambiar foto</span>
	                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                	<div class="clearfix"></div>
	                </div>
				</a>
			</div>
	    </div>
	    <div class="col-lg-3 col-md-6">
        <form action="perfil" method="post"  class="form-inline mt-2 mt-md-0">
		    <div class="form-group">
				<label for="nombre" class="required">Nombre</label>
				<input type="text" class="form-control" name="nombre" id="nombre" value="${usuario.nombre}"/>
				<label for="password" class="required">Contraseña</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fas fa-eye" onclick="showpass(event, 'password')"></i>
					</div>
				    <input type="password" class="form-control" name="password" id="password" value="${usuario.password}" />
				</div>
			</div>
			<div class="form-group">
				<button class="btn mt-2 mt-md-0" type="submit">Cambiar</button>
			</div>
		</form>
    </div>
	</div>

</div>
	<!-- /#page-wrapper -->

	<%@ include file="includes/footer.jsp"%>