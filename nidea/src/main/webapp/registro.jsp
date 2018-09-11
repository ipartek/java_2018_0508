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
                        <input name="nombre" type="text" class="form-control" requiered tabindex="3" placeholder="nombre">
			  </div>
			  <div class="form-group">
			     <label class="requiered" for="apellidos">Apellidos</label>
                 <input name="apellidos" type="number" class="form-control" requiered tabindex="4" placeholder="apellidos">
			  </div>
			  <div class="form-group">
			    <label class="requiered" for="username">Nombre de usuario</label>
                <input name="username" type="text" class="form-control" requiered tabindex="3" placeholder="nombre usuario">
			  </div>
			  <div class="form-group">
			    <label for=mail>Email address</label>
			    <input type="email" class="form-control" name="mail" aria-describedby="emailHelp" placeholder="Enter email">
			  </div>
			  <div class="form-group">
			    <label for="password">Password</label>
			    <input type="password" class="form-control" name="password" placeholder="Password">
			  </div>
			 
			  <button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
			</form>
        </div>

    </div>
</main>

<%@ include file="includes/footer.jsp" %>