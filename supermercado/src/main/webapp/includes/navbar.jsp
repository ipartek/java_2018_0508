<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <header id="top">
            <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                <a class="navbar-brand" href="home"><img src="images/logo.jpg" alt="logotipo-supermercado-el-fuerte" /></a>

                <div class="navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto menu">

                        <li class="nav-item">
                            <a class="nav-link" href="home">Inicio <span class="sr-only">(current)</span></a>
                        </li>
						
						<c:if test="${not empty usuario}">
							<li class="nav-item">
                            <a class="nav-link" href="privado/alta-producto.jsp">Nuevo producto</a>
	                        </li>
	
	                        <li class="nav-item">
	                            <a class="nav-link" href="listado">Listado</a>
	                        </li>
						</c:if>
                    </ul>
                    
                    	<ul class="navbar-nav ml-auto menu">
	                    	<c:if test="${empty sessionScope.usuario}">
		                        <li class="nav-item">
		                            <a class="nav-link" href="login.jsp">Iniciar sesion</a>
		                        </li>
							</c:if>
							<c:if test="${not empty sessionScope.usuario}">
								<li class="nav-item">
	                            	<a class="nav-link" href="">Bienvenido, ${usuario.nombre}<i class="fas fa-user"></i></a>
		                        </li>
		
		                        <li class="nav-item">
		                            <a class="nav-link" href="logout">Cerrar Sesion</a>
		                        </li>
	                        </c:if>
                    	</ul>
                    
                </div>

            </nav>
        </header>