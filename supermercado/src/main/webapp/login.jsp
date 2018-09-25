<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

        <main role="main" class="container">
        
        	<!-- <p class="text-danger">${param.msg }${requestScope.msg }</p> Param para pintar parámetros recibidos en la url -->
			<c:if test="${empty alert }">
      		${alert = null }
      		
	      	</c:if>
	      	
	      	<c:if test="${not empty alert }">
	      	
	      		<div class="alert ${alert.tipo } alert-dismissible fade show" role="alert">
				  <p>${alert.texto }</p>
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
	      	</c:if>	
            <div class="row justify-content-center">
                <h1 class="col col-md-6"><i class="fas fa-user"></i> Iniciar sesión</h1>
            </div>
                    
            <div class="row justify-content-center">
                <small id="login-small" class="col col-md-6">Los campos con * son obligatorios</small>
            </div>

            <form action="login" method="post" id="login-form">
			
                <div class="form-row justify-content-center">
                            
                    <div class="col col-md-6">
                        
                        <div class="form-group">
                            <label for="correo" class="required">Usuario</label>
                            <input type="text" name="nombre" class="form-control" id="correo" value="admin" autofocus required placeholder="Ej: paco@gmail.com" />
                        </div>
                                    
                        <div class="form-group">
                            <label for="pass" class="required">Contraseña</label>
                            <input type="password" name="pass" class="form-control" id="pass" value="admin" required placeholder="Contraseña del usuario (8 a 20 caracteres)" />
                        </div>
                                    
                        <button type="submit" class="btn btn-outline-primary btn-block">Acceder</button>
                                    
                    </div>
                                    
                </div>
                            
            </form>

        </main>

<%@ include file="includes/footer.jsp" %>