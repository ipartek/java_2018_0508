<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/taglibs.jsp"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<!-- Main -->
<div class="container" role="main" >

<%@include file="includes/alert.jsp"%>

	<div class="row justify-content-center align-items-end">
		<h1 class="text-center">Iniciar sesión</h1>
	</div>
	       	
	<div class="row justify-content-center align-items-center">
		<div class="col">
			<form action="login" method="post">
	            <div class="form-row justify-content-center">
		            <div class="col col-md-6">
		            	 <div class="form-row">
		                    <div class="col">
		                        <div class="form-group">
		                            <label class="required" for="nombre">Nombre: </label>
		                            <input class="form-control" type="text" name="nombre" step="0.1" placeholder="Introduzca el nombre de usuario" autofocus required>
		                        </div>
		                    </div>
		                </div>
		                
		                <div class="form-row">
		                    <div class="col">
		                        <div class="form-group">
		                            <label for="pswd">Contraseña: </label>
		                            <input class="form-control" type="password" name="pswd" placeholder="Introduzca su contraseña" required>
		                        </div>
		                    </div>	
		                </div>
		                 <input class="form-control btn btn-outline-primary" type="submit" value="Entrar">
		            </div>
	            </div>
			</form>
	        <c:if test="${not empty param.msg}">
				<p class="message text-center">${param.msg}</p>
			</c:if>
		</div>
	</div>
	
</div>

<%@include file="includes/footer.jsp"%>