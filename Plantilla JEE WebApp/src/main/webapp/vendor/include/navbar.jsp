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