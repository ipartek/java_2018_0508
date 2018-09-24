<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

    <div class="contenedor">

        <header id="login-header">

            <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                <a class="navbar-brand" href="index.html"><img src="images/logo.jpg" alt="logotipo-supermercado-el-fuerte" /></a>
        
                <div class="navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto menu">
        
                        <li class="nav-item">
                            <a class="nav-link" href="index.html">Principal <span class="sr-only">(current)</span></a>
                        </li>
        
                        <li class="nav-item">
                            <a class="nav-link" href="login.html">Login</a>
                        </li>
        
                        <li class="nav-item">
                            <a class="nav-link" href="alta-producto.html">Nuevo producto</a>
                        </li>
        
                        <li class="nav-item">
                            <a class="nav-link" href="listado.html">Listado</a>
                        </li>
        
                    </ul>
                </div>
        
            </nav>
        
        </header>

        <main role="main" class="container">

			<p class="text-danger">${param.msg}</p>


            <div class="row justify-content-center">
                <h1 class="col col-md-6"><i class="fas fa-user"></i> Login</h1>
            </div>
                    
            <div class="row justify-content-center">
                <small id="login-small" class="col col-md-6">Los campos con * son obligatorios</small>
            </div>

            <form id="login-form">
			
                <div class="form-row justify-content-center">
                            
                    <div class="col col-md-6">
                        
                        <div class="form-group">
                            <label for="correo" class="required">Email</label>
                            <input type="email" class="form-control" id="correo" autofocus required placeholder="Ej: paco@gmail.com" />
                        </div>
                                    
                        <div class="form-group">
                            <label for="pass" class="required">Contrase�a</label>
                            <input type="password" class="form-control" id="pass" minlength="8" maxlength="20" required placeholder="Contrase�a del usuario (8 a 20 caracteres)" />
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
                <a href="#">Localizaci�n</a>
            </nav>
    
            <div class="social">
                <a href="https://es-es.facebook.com/" id="facebook" target="_blank"><i class="fab fa-facebook-square fa-3x"></i></a>
                <a href="https://twitter.com/?lang=es" id="twitter" target="_blank"><i class="fab fa-twitter-square fa-3x"></i></a>
            </div>
    
        </footer>

    </div> <!-- /.contenedor -->

    
</body>
</html>