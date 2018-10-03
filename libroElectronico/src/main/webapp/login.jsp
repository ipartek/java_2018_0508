<%@include file="includes/header.jsp"%>

  <div class="container">
  	
  <%@include file="includes/alert.jsp"%>
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">LOGIN</h5>
            <form class="form-signin" action="login" method="post">
              <div class="form-label-group">
                <input type="text" id="usuario" name="usuario" class="form-control" placeholder="nombre de usuario" required autofocus>
              </div>
              <div class="form-label-group">
                <input type="password" id="inputPassword" name="pass" class="form-control" placeholder="Contraseña" required>                
              </div>

              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Entrar</button>
              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>