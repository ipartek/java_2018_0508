<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<body id="LoginForm">
    <main class="container">
        <div class="login-form">
            <div class="main-div">
                <div class="panel">
                    <h2>Login</h2>
                    <br>
                </div>
                <form action="formulario" method="post"id="Login">
                            
                    <div class="form-group">
                    
                    
                        <input type="email" required class="form-control" id="inputEmail" placeholder="Email" autofocus >
                    
                    </div>
                    
                    <div class="form-group">
                    
                        <input type="password"  required class="form-control" minlength=8 maxlength=8 class="inputPassword" placeholder="Contraseña" >
                    
                    </div>
                    <div class="forgot">
                        <a href="#">¿No recuerdas la contraseña?</a>
                    </div>
                    
              
                    <input type="submit" value="Entrar" class="btn btn-primary btn-block" >
                    
                </form>                                
             </div>
        </div> 
     </main>        
<%@include file="includes/footer.jsp" %>

