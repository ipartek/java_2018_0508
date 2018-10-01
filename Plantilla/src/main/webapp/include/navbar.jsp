<header class="mb-3">
	<!-- HEADER NAVBAR -->
	<nav class="navbar navbar-expand-md navbar-dark bg-primary fixed-top">
		<a class="navbar-brand" href="inicio"><img class="logo" src="http://cdn.onlinewebfonts.com/svg/img_477677.png" alt = "Soy una tetera"></a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Menú de navegación">
	    	<span class="navbar-toggler-icon"></span>
	    </button>
	
	   	<div class="collapse navbar-collapse" id="navbar">
	    	<ul class="navbar-nav mr-auto">
	          <li class="nav-item">
	            <a class="nav-link text-white" href="inicio">Inicio </a>
	          </li>
	          	<!-- Usuario logueado (panel de backoffice) -->
		      	<c:if test="${not empty sessionScope.usuario}"> 
		          <li class="nav-item dropdown">
		            <a class="nav-link dropdown-toggle text-white" href="https://example.com" id="backofficeMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Backoffice</a>
		            <div class="dropdown-menu" aria-labelledby="backofficeMenu">
		              <a class="dropdown-item" href="#">Añadir Productos</a>
		              <a class="dropdown-item" href="backoffice/panel.jsp">Ver Productos</a>
		            </div>
		          </li>
		        </c:if>
	        </ul>
	        
	        <!-- Usuario no logueado (link de acceso) -->
            <c:if test="${empty sessionScope.usuario}"> 
	        	<a class="text-white"data-toggle="modal" data-target="#modal-login-form" href="#">Acceder</a>
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