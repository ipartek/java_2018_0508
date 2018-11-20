<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<%@include file="includes/taglibs.jsp"%>

<%@include file="includes/header.jsp"%>

    <div class="contenedor">
    
		<%@include file="includes/topbar.jsp"%>
		
        <main role="main" class="container">
        
        <%@include file="includes/alert.jsp"%>
        
        <div class="row justify-content-center">
        	<div class="login-body col col-5 mt-2 mb-2">
        
				<div class="titulo-login row justify-content-center align-items-center mt-2">
                	<h1 class="col text-center"><i class="fas fa-user"></i> Login</h1>
            	</div>
                    
	            <div class="row justify-content-center">
	                <small id="login-small" class="col col-md-6">Los campos con <strong class="required"></strong> son obligatorios</small>
	            </div>
            
				<div class="row justify-content-center mb-2">
					<div class="col col-10">
						<form id="login-form" action="login" method="post" >
				
			                <div class="form-row justify-content-center">
			                            
			                    <div class="col col-10">
			                        
			                        <div class="form-group">
			                            <label for="nombre_usuario" class="required">Nombre:</label>
			                            <input type="text" class="form-control" id="user" name="user" autofocus required placeholder="Ej. admin" value="ander"/>
			                        </div>
			                                    
			                        <div class="form-group">
			                            <label for="pass" class="required">Contraseña</label>
			                            <input type="password" class="form-control" id="pass" name="pass" minlength="5" maxlength="10" required placeholder="Contraseña (5 a 10 caracteres)" value="12345"/>
			                        </div>
			                                    
			                        <button type="submit" class="btn btn-outline-primary btn-block">Acceder</button>
			                                    
			                    </div>
			                                    
			                </div>
	                            
	            		</form>
					</div>
				</div>
				
        	</div>
        </div>
        
			
			


            

        </main>
    </div> <!-- /.contenedor -->

<%@include file="includes/footer.jsp"%>