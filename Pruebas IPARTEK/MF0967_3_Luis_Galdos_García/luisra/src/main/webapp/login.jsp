<%@ include file = "includes/header.jsp" %>
	<div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-2"></div>
            <div class="col-lg-6 col-md-8 login-box">
                <div class="col-lg-12 login-key">
                    <i class="fa fa-key" aria-hidden="true"></i>
                </div>
                <div class="col-lg-12 login-title">
                    ADMIN PANEL
                </div>

                <div class="col-lg-12 login-form">
                    <div class="col-lg-12 login-form">
                        <form action="login" method="post">
                            <div class="form-group">
                                <label class="form-control-label" for="usuario">USUARIO</label>
                                <input type="text" class="form-control" name="nombreUsuario" value="admin" id="usuario">
                            </div>
                            <div class="form-group">
                                <label class="form-control-label" for="password">CONTRASEÑA</label>
                                <input type="password" class="form-control" name="password" autofocus id="password">
                            </div>

                            <div class="col-lg-12 loginbttm">
                                <div class="col-lg-6 login-btm login-text">
                                    <!-- Error Message -->
                                </div>
                                <div class="col-lg-6 login-btm login-button">
                                    <button type="submit" class="btn btn-outline-primary">ACCEDER</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-3 col-md-2"></div>
            </div>
        </div>
       </div>
<%@ include file = "includes/footer.jsp" %>