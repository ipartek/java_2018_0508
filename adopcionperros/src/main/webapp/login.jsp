<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>
<%@include file="includes/alert.jsp" %>

        <main role="main" class="container">

			<p class="text-danger">${param.msg} ${requestScope.msg}</p>
			


            <div class="row justify-content-center">
                <h1 class="col col-md-6"><i class="fas fa-user"></i> Login</h1>
            </div>
                    
            <div class="row justify-content-center">
                <small id="login-small" class="col col-md-6">Los campos con * son obligatorios</small>
            </div>

            <form id="login-form" action="login" method="post" >
			
                <div class="form-row justify-content-center">
                            
                    <div class="col col-md-6">
                        
                        <div class="form-group">
                            <label for="correo" class="required">Usuario</label>
                            <input type="text" class="form-control" id="usuario" name="usuario" autofocus required placeholder="Nombre usuario (6 caracteres)"/>
                        </div>
                                    
                        <div class="form-group">
                            <label for="pass" class="required">Contraseña</label>
                            <input type="password" class="form-control" id="pass" name="pass"  required placeholder="Contraseña del usuario (8 a 20 caracteres)" />
                        </div>
                                    
                        <button type="submit" class="btn btn-outline-primary btn-block">Acceder</button>
                                    
                    </div>
                                    
                </div>
                            
            </form>

        </main>

        
<%@ include file="includes/footer.jsp" %>