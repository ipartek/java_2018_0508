<!-- Page codification -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Java Standard Tag Libraries -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>

	<!-- Comienza todas las URLs desde el href indicado -->
	<!-- <base href="${pageContext.request.contextPath}"> -->
	
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Plantilla JEE WebApp</title>

	<!-- BOOTSTRAP core CSS -->
    <link href="vendor/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- FONTAWSOME core CSS -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
	
	<!-- GOOGLE Font 'Varela Round'-->
	<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
	
    <!-- Personal CSS Stylesheet -->
    <link href="vendor/css/styles.css" rel="stylesheet"></link>
    <link href="vendor/css/404-styles.css" rel="stylesheet"></link>
      
</head>
<body>


	<header class="mb-3">
		<!-- HEADER NAVBAR -->
		<nav class="navbar navbar-expand-md navbar-dark bg-primary fixed-top">
	      <a class="navbar-brand" href="#">Navbar</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="navbar-toggler-icon"></span>
	      </button>
	
	      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
	        <ul class="navbar-nav mr-auto">
	          <li class="nav-item active">
	            <a class="nav-link" href="#">Inicio <span class="sr-only">(current)</span></a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="#">Item 1</a>
	          </li>
	           <li class="nav-item">
	            <a class="nav-link" href="#">Item 2</a>
	          </li>
	          <li class="nav-item dropdown">
	            <a class="nav-link dropdown-toggle" href="https://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
	            <div class="dropdown-menu" aria-labelledby="dropdown01">
	              <a class="dropdown-item" href="#">Action</a>
	              <a class="dropdown-item" href="#">Another action</a>
	              <a class="dropdown-item" href="#">Something else here</a>
	            </div>
	          </li>
	        </ul>
	        
	        <!-- Usuario no logueado (link de acceso) -->
            <c:if test="${empty sessionScope.usuario}"> 
	        	<a class="text-white" href="#" data-toggle="modal" data-target="#modal-login-form">Acceder</a>
	        </c:if>
	        
	        <!-- Usuario logueado (panel de usuario) -->
            <c:if test="${not empty sessionScope.usuario}"> 
	        	<div class="nav-user text-white">
		     		<i class="fas fa-user mr-2"></i><span>${sessionScope.usuario.nombre}</span>
			  		<a href="logout" title="Cerrar sesión"><i class="fas fa-power-off ml-2 text-white"></i></a>
		    	</div>
            </c:if>
            
	      </div>
	    </nav>
	    
	</header>