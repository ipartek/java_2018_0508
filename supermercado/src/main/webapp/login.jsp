<%@ include file="includes/head.jsp" %>
<body>

    <div class="contenedor">

        <header id="login-header">

            <%@ include file="includes/navbar.jsp" %>
        
        </header>

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
                            <label for="correo" class="required">Email</label>
                            <input type="email" class="form-control" id="correo" name="correo" autofocus required placeholder="Ej: paco@gmail.com" />
                        </div>
                                    
                        <div class="form-group">
                            <label for="pass" class="required">Contrase�a</label>
                            <input type="password" class="form-control" id="pass" name="pass" minlength="8" maxlength="20" required placeholder="Contraseña del usuario (8 a 20 caracteres)" />
                        </div>
                                    
                        <button type="submit" class="btn btn-outline-primary btn-block">Acceder</button>
                                    
                    </div>
                                    
                </div>
                            
            </form>

        </main>

        <footer id="login-footer">

            <div>
                <p>&copy; 2018</p>
            </div>
    
            <nav>
                <a href="#">Politica de privacidad</a>
                <a href="#">Contacto</a>
                <a href="#">Localización</a>
            </nav>
    
            <div class="social">
                <a href="https://es-es.facebook.com/" id="facebook" target="_blank"><i class="fab fa-facebook-square fa-3x"></i></a>
                <a href="https://twitter.com/?lang=es" id="twitter" target="_blank"><i class="fab fa-twitter-square fa-3x"></i></a>
            </div>
    
        </footer>

    </div> <!-- /.contenedor -->

    
</body>
</html>