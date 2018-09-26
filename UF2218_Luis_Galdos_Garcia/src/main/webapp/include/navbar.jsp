<!-- Page codification -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<header class="mb-3">
	<!-- HEADER NAVBAR -->
	<nav class="navbar navbar-expand-md navbar-dark bg-primary fixed-top">
		<a class="navbar-brand" href="inicio"><img class="logo" src="https://banner2.kisspng.com/20180329/bpe/kisspng-book-silhouette-royalty-free-clip-art-open-book-5abd87d0674563.116058771522370512423.jpg" alt = "Soy una tetera"></a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Menú de navegación">
	    	<span class="navbar-toggler-icon"></span>
	    </button>
	
	   	<div class="collapse navbar-collapse" id="navbar">
	    	<ul class="navbar-nav mr-auto">
	          <li class="nav-item">
	            <a class="nav-link text-white" href="inicio"><i class="fas fa-home"></i>Inicio </a>
	          </li>
	          	<!-- Usuario logueado (panel de backoffice) -->
		      	<c:if test="${not empty sessionScope.usuario}"> 
		           	<li class="nav-item">
	            		<a class="nav-link text-white" href="backoffice/escribir-pag.jsp"><i class="fas fa-pencil-alt"></i>Escribir entrada </a>
	          		</li>
		        </c:if>
		        
		        <!-- Usuario no logueado (link de acceso) -->
	            <c:if test="${empty sessionScope.usuario}"> 
	            	<li class="nav-item">
		        		<a class="nav-link text-white" href="login.jsp"><i class ="fas fa-sign-in-alt "></i>Acceder</a>
		        	</li>
		        </c:if>
	        </ul>
	        
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