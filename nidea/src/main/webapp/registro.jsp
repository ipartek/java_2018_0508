<%@page import="com.ipartek.formacion.nidea.pojo.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<main id="registro-page" class="container">
    <div class="row justify-content-center">
        <div class="col-6 mb-3">
            <h1 class="text-center text-primary font-weight-light">Formulario Alta Usuario</h1>
            <p>Los campos con * son obligatorios</p>
             <form>
              <div class="form-group">
			    <label class="requiered" for="nombre">Nombre</label>
                        <input name="nombre" type="text" class="form-control" requiered placeholder="nombre de usuario" autofocus>
			  </div>
			  <div class="form-group">
			     <label class="requiered" for="apellidos">Apellidos</label>
                 <input name="apellidos" type="number" class="form-control" requiered placeholder="apellidos del usuario">
			  </div>
			  <div class="form-group">
			    <label class="requiered" for=mail>Email</label>
			    <input type="email" class="form-control" name="mail" aria-describedby="emailHelp" placeholder="ejemplo@dominio.com">
			  </div>
			  <div class="form-group">
			    <label class="requiered" for="password">Contraseña</label>
			    <input type="password" class="form-control" name="password" placeholder="Mínimo 6 caracteres" onkeyup="validate()" minlength=6 >
			  </div>
			  <div class="form-group">
			    <label class="requiered" for="passwordrep">Repetir contraseña</label>
			    <input type="password" class="form-control" name="passwordrep" placeholder="Repetir la contraseña anterior" onkeyup="validate()">
			  </div>
			 
			  <button type="submit" class="btn btn-primary btn-lg btn-block">Enviar</button>
			</form>
        </div>

    </div>
</main>


<%@ include file="includes/footer.jsp" %>
