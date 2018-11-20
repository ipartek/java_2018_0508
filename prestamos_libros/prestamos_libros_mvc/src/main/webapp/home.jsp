<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" name="viewport">
  <title>Login &mdash; Gestion prestamo de Libros</title>
  
  <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.png"/>

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/ionicons.min.css">
  <link rel="stylesheet" href="css/fontawesome-all.min.css">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <div id="app">
    <section class="section">
      <div class="container mt-3">
        <div class="row">
          
          <div class="col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4">
          	
          	<%@include file="/includes/alert.jsp" %>
          	
            <div class="login-brand">
              <img src="img/logo-ipartek.png" alt="" width="250" height="82">
            </div>

            <div class="card card-primary">
              <div class="card-header"><h4>Acceso Administrador</h4></div>

              <div class="card-body">
                <form method="POST" action="<%=request.getContextPath()%>/login" class="needs-validation">
                  <div class="form-group">
                    <label for="usuario">Usuario</label>
                    <input id="usuario" type="text" class="form-control" name="usuario" value="${cookie.cNombre.value}" tabindex="1" required autofocus>
                  </div>

                  <div class="form-group">
                    <label for="pass" class="d-block">Contraseña</label>
                    <input id="pass" type="password" class="form-control" name="pass" tabindex="2" value="admin" required>
                  </div>

                  <div class="form-group">
                    <div class="custom-control custom-checkbox">
                      <input type="checkbox" name="recuerdame" class="custom-control-input" tabindex="3" id="recuerdame" ${(not empty cookie.cNombre.value)?"checked":""}>
                      <label class="custom-control-label" for="recuerdame" >Recordar</label>
                    </div>
                  </div>

                  <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block boton-login" tabindex="4">
                      Acceder
                    </button>
                  </div>
                </form>
              </div>
            </div>
            <div class="simple-footer">
              Copyright &copy; Ipartek 2018
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</body>
</html> 