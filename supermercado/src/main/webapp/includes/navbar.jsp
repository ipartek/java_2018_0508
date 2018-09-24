<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	                            <a class="nav-link" href="login.jsp">Login</a>
	                        </li>
						</c:if>
						
						<c:if test="${not empty usuario}">
							<li class="nav-item">
                            <a class="nav-link" href="/privado/alta-producto.jsp">Nuevo producto</a>
	                        </li>
	
	                        <li class="nav-item">
	                            <a class="nav-link" href="/privado/listado.jsp">Listado</a>
	                        </li>
						</c:if>
                    </ul>
                    <c:if test="${not empty usuario}">
                    	<ul class="navbar-nav ml-auto menu">
							<li class="nav-item">
                            	<a class="nav-link" href="">Bienvenido, ${usuario.nombre}<i class="fas fa-user"></i></a>
	                        </li>
	
	                        <li class="nav-item">
	                            <a class="nav-link" href="logout">Cerrar Sesion</a>
	                        </li>
                    	</ul>
                    </c:if>
                </div>

            </nav>
        </header>