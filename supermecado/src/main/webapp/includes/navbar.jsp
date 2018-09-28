<div class="contenedor">
 
	 <header id="top">

            <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                <a class="navbar-brand" href="home"><img src="images/logo.jpg" alt="logotipo-supermercado-el-fuerte" /></a>

                <div class="navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto menu">

                        <li class="nav-item">
                            <a class="nav-link" href="home">Principal <span class="sr-only">(current)</span></a>
                        </li>
                        
						<c:if test="${not empty sessionScope.usuario}">
	                        <li class="nav-item">
	                            <a class="nav-link" href="privado/alta-producto.jsp">Nuevo producto</a>
	                        </li>
	
	                        <li class="nav-item">
	                            <a class="nav-link" href="listado.html">Listado</a>
	                        </li>
	                        <li class="nav-item">
	                            <a class="nav-link text-warning" href="logout">Cerrar Sesión</a>
	                        </li>
	                        
                        </c:if>
                        
                        <c:if test="${empty sessionScope.usuario}">
                        	<li class="nav-item">
	                            <a class="nav-link text-warning" href="login.jsp">Iniciar Sesión</a>
	                        </li>
                        </c:if>

                    </ul>
                </div>

            </nav>

        </header>