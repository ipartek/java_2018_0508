<%@include file="taglibs.jsp"%>

<!-- Menu -->
<nav class="navbar navbar-expand-md navbar navbar-dark bg-dark mb-2">
    <a class="navbar-brand" href="../home"><img class="logo" src="../images/dogs-icon.png" width="40" height="40" alt="perro-logo"></a>
    
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
	        <li class="nav-item">
	            <a class="nav-link" href="home">Home</a>
	        </li>
	        
			<!-- Usuario Loggeado -->
			<c:if test="${not empty usuario}">
				<li class="nav-item">
	            	<a class="nav-link" href="altaPerros.jsp">Registrar Perro</a>
	        	</li>
	        	<li class="nav-item">
	            	<a class="nav-link" href="../logout">Cerrar sesión</a>
	        	</li>
			</c:if>
        </ul>
    </div>
</nav>
<!-- /menu -->