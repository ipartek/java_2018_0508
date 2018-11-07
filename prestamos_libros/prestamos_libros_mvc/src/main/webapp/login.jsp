<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>
    <!-- Login Register area Start-->
    <div class="login-content">
        <!-- Login -->
        <div class="nk-block toggled" id="l-login">
        	<form action="login" method="post">
            <div class="nk-form">
            	<div class="input-group">
            		<img id="logo_login" alt="Logo de la empresa" src="images/logo_ipartek.png">
            	</div>
                <div class="input-group">
                    <span class="input-group-addon nk-ic-st-pro"><i class="notika-icon notika-support"></i></span>
                    <div class="nk-int-st">
                        <input name="usuario" type="text" class="form-control" placeholder="Usuario" autofocus required value="admin">
                    </div>
                </div>
                <div class="input-group mg-t-15">
                    <span class="input-group-addon nk-ic-st-pro"><i class="notika-icon notika-edit"></i></span>
                    <div class="nk-int-st">
                        <input name="pass" type="password" class="form-control" placeholder="Contraseña" required value="admin">
                    </div>
                </div>
                <button type="submit" class="btn btn-login btn-success btn-float"><i class="notika-icon notika-right-arrow right-arrow-ant"></i></button>
            </div>
            </form>
        </div>
    </div>
<%@ include file="includes/footer.jsp" %>