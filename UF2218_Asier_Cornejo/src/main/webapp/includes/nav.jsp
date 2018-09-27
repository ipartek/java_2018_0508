 <div class="contenedor">

        <header id="top">

            <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                

                <div class="navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto menu ">

                        <li class="nav-item">
                            <a class="nav-link" href="home">Principal <span class="sr-only">(current)</span></a>
                        </li>
                        
						<c:if test="${not empty sessionScope.usuario}">
                        <li class="nav-item">
                            <a class="nav-link" href="nuevaPagina.jsp">Escribir Página</a>
                        </li>

                        
                        <li class="nav-item">
                            <span class="nav-link text-warning">Bienvenido ${usuario.nombre }</span>
                        </li>
                        
                        <li>
                       		<button type="button" class="btn btn-outline-secondary botonSesion"> <a href="logOut">Cerrar Sesión</a></button>
                        
                        
                        </li>
						</c:if>
						
						
						<c:if test="${empty sessionScope.usuario}">
                       
                       		<button type="button" class="btn btn-outline-secondary botonSesion"> <a href="login.jsp">Iniciar Sesión</a></button>
                       	
						</c:if>
                    </ul>
                </div>

            </nav>

        </header>