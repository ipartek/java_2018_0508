<div class="contenedor">

        <header id="top">

            <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                <a class="navbar-brand" href="home"><img src="images/logo.jpg" alt="logotipo-supermercado-el-fuerte" /></a>

                <div class="navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto menu">
						<c:if test="${not empty sessionScope.usuario }">
                        <li class="nav-item">
                            <a class="nav-link" href="home">Inicio <span class="sr-only">(current)</span></a>
                        </li>

                       <!--  <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Login</a>
                        </li>
 -->				
                        <li class="nav-item">
                            <a class="nav-link" href="privado/alta-producto.jsp">Nuevo producto</a>
                        </li>
						
	                        <li class="nav-item">
	                            <a class="nav-link" href="listado">Listado</a>
	                        </li>
	                    </c:if>

                    </ul>
                </div>
                 <div>
	                <c:if test="${not empty sessionScope.usuario }">
			          	<i class="far fa-user">
			          		<p>${usuario.nombre }</p>
			          	</i>
			          	<li class="nav-item">
	                            <a class="nav-link" href="logout">Cerrar Sesion</a>
	                        </li>
			          </div>
			        </c:if>
			        <c:if test="${ empty sessionScope.usuario }">
			          	<li class="nav-item">
	                            <a class="nav-link" href="login.jsp">Login</a>
	                        </li>
			        </c:if>
		        </div>

            </nav>
        </header>
