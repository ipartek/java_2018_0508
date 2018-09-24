<%@include file="taglibs.jsp"%>

<header id="top">

            <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                <a class="navbar-brand" href="home"><img src="images/logo.jpg" alt="logotipo-supermercado-el-fuerte" /></a>

                <div class="navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto menu">

                        <li class="nav-item">
                            <a class="nav-link" href="home">Inicio <span class="sr-only">(current)</span></a>
                        </li>
                        
						<c:if test="${empty usuario}">
	                        <li class="nav-item">
	                            <a class="nav-link" href="login">Iniciar Sesión</a>
	                        </li>
						</c:if>
						
						<c:if test="${not empty usuario}">
							 <li class="nav-item">
	                            <a class="nav-link" href="privado/alta-producto.jsp">Nuevo producto</a>
	                        </li>

	                        <li class="nav-item">	
	                            <a class="nav-link" href="privado/listado.jsp">Listado</a>
	                        </li>
	                        
							<li class="nav-item" style="color:#FFF">
								<i class="fas fa-user mr-1 ml-2"></i> 
								${usuario.nombre} |
								<a class="ml-1 mr-2" href="logout">Cerrar Sesión</a>
							</li>
						</c:if>

                    </ul>
                </div>

            </nav>

        </header>