
<header>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="home"><img
			src="images/logo.jpg" alt="logotipo-supermercado-el-fuerte" /></a>

		<div class="navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto menu">

				<li class="nav-item"><a class="nav-link" href="inicio">Principal</a></li>

				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
				
				<!-- Opciones del Backoffice -->
				<c:if test="${sesionScope.usuario != null}">
				
					<li class="nav-item"><a class="nav-link"href="/privado/alta-producto.jsp">Nuevo producto</a></li>
	
					<li class="nav-item"><a class="nav-link" href="/privado/listado.jsp">Listado</a></li>
				</c:if>

			</ul>
			<c:if test="${sesionScope.usuario == null}">
				<a href="login.jsp" class="text-white">Acceder</a>
			</c:if>
		</div>
		
	</nav>

</header>
