<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main role="main" class="container">

	<%@include file="includes/alert.jsp"%>
	

    <div class="row justify-content-center mt-4">
        <h1 class="col col-md-6 text-center">Login</h1>
    </div>

    <form id="login-form" action="login" method="post">

        <div class="form-row justify-content-center">
                    
            <div class="col col-md-6">
                
                <div class="form-group">
                    <label for="user" class="required">Nombre</label>
                    <input type="text" name="user" class="form-control" autofocus required placeholder="Ej: Admin123" />
                </div>
                            
                <div class="form-group">
                    <label for="pass" class="required">Contraseña</label>
                    <input type="password" name="pswd" class="form-control" required placeholder="Contraseña del usuario" />
                </div>
                            
                <button type="submit" class="btn btn-outline-primary btn-block">Acceder</button>
            </div>
                            
        </div>
                    
    </form>

</main>

<%@include file="includes/footer.jsp"%>