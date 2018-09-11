<%@page import="com.ipartek.formacion.nidea.pojo.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<main id="login-page" class="container">
    <div class="row justify-content-center">
        <div class="col-6 mb-3">
            <h1 class="text-center text-primary font-weight-light">Login</h1>
            <form>
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