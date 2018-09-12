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
                    </br>
                </div>
                <form action="formulario" method="post"id="Login">
                            
                    <div class="form-group">
                    
                    
                        <input type="email" class="form-control" id="inputEmail" placeholder="Email" autofocus tabindex="1">
                    
                    </div>
                    
                    <div class="form-group">
                    
                        <input type="password" class="form-control" id="inputPassword" placeholder="********" tabindex="2">
                    
                    </div>
                    <div class="forgot">
                        <a href="#">¿No recuerdas el password?</a>
                    </div>
                    
              
                    <input type="submit" value="login" class="btn btn-primary btn-block" tabindex="3">
                    
                </form>                                
             </div>
        </div> 
     </main>        
<%@include file="includes/footer.jsp" %>

