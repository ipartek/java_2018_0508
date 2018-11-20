<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/nav.jsp" %>

<main role="main" class="container container-login">

<%@include file="includes/alert.jsp" %>
	<div class="card card-container">
        
        <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
        
        <p id="profile-name" class="profile-name-card"></p>
       
        <form action="login" method="post" class="form-login">
            
            <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Nombre" required autofocus value="admin">
            <input type="password" id="pass" name="pass" class="form-control" placeholder="Contraseña" required value="admin">
               
            <button class="btn btn-block" type="submit">Acceder</button>
            
        </form><!-- /form -->
        
    </div><!-- /card-container -->

</main>

<%@include file="includes/footer.jsp" %>