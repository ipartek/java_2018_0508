<%@ include file="../includes/header.jsp"  %>
  <div id="app">
    <section class="section">
      <div class="container mt-5">
        <div class="row">
          <div class="col-12 col-sm-10 offset-sm-1 col-md-8 offset-md-2 col-lg-8 offset-lg-2 col-xl-8 offset-xl-2">
            <div class="login-brand">
        <img class="mb-4" src="dist/img/logo-ipartek.png" alt="" width="150" height="52">
            </div>

            <div class="card card-primary">
              <div class="card-header">
              	<h4>
              		<c:if test="${empty usuario.id}">
              			Añadir Usuario
              		</c:if>
              		<c:if test="${not empty usuario.id}">
              			Editar Usuario
              		</c:if>
              	</h4>
              </div>
              <div class="card-body">
                <form action="usuario?op=2" method="POST">
                <input type="hidden" name="id" value="${usuario.id}">
                  <div class="row">
                    <div class="form-group col-6">
                      <label for="frist_name">Nombre y Apellidos</label>
                      <input id="frist_name" type="text" class="form-control" name="nombreApellidos" value="${usuario.nombreApellidos}"  required autofocus>
                    </div>
                  </div>
                  <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">
                    	<c:if test="${empty usuario.id}">
                    		Añadir
                    	</c:if>
                    	<c:if test="${not empty usuario.id}">
                    		Editar
                    	</c:if>
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

  <script src="../dist/modules/jquery.min.js"></script>
  <script src="../dist/modules/popper.js"></script>
  <script src="../dist/modules/tooltip.js"></script>
  <script src="../dist/modules/bootstrap/js/bootstrap.min.js"></script>
  <script src="../dist/modules/nicescroll/jquery.nicescroll.min.js"></script>
  <script src="../dist/modules/moment.min.js"></script>
  <script src="../dist/modules/scroll-up-bar/dist/scroll-up-bar.min.js"></script>
  <script src="../dist/js/sa-functions.js"></script>
  
  <script src="../dist/js/scripts.js"></script>
  <script src="../dist/js/custom.js"></script>
  <script src="../dist/js/demo.js"></script>
</body>
</html>