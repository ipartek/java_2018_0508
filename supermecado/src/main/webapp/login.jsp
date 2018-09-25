<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>
    
<div class="contenido">
        
        <main role="main" class="container">
		
		<p class="text-danger">${param.msg }</p>
            <div class="row justify-content-center">
                <h1 class="col col-md-6"><i class="fas fa-user"></i> Login</h1>
            </div>
                    
            <div class="row justify-content-center">
                <small id="login-small" class="col col-md-6">Los campos con * son obligatorios</small>
            </div>

            <form id="login-form" action="login" method="post">
			
                <div class="form-row justify-content-center">
                            
                    <div class="col col-md-6">
                        
                        <div class="form-group">
                            <label for="emailUsuario" class="required">Email</label>
                            <input type="email" name="emailUsuario" class="form-control" id="correo" autofocus required placeholder="Ej: paco@gmail.com" />
                        </div>
                                    
                        <div class="form-group">
                            <label for="passUsuario" class="required">Contraseña</label>
                            <input type="password" name="passUsuario" class="form-control" id="pass" minlength="4" maxlength="20" required placeholder="Contraseña del usuario (8 a 20 caracteres)" />
                        </div>             
                        <button type="submit" class="btn btn-outline-primary btn-block">Acceder</button>
                                   
                    </div>
                                    
                </div>
           </form> 
                            
            

        </main>
     </div>
   </div>   

<%@ include file="includes/footer.jsp" %>