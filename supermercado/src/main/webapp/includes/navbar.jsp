<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                <a class="navbar-brand" href="home"><img src="images/logo.jpg" alt="logotipo-supermercado-el-fuerte" /></a>

                <div class="navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto menu">
						
						<!-- Usuario no logueado -->
						<c:if test="${empty sessionScope.usuario }">
							<li class="nav-item">  
								<a class="nav-link" href="home">Inicio <span class="sr-only">(current)</span></a>                          
	                            <a class="nav-link" href="login.jsp">Iniciar sesion <span class="sr-only">(current)</span></a>
                        	</li> 			
						</c:if>	
						
						<!-- Usuario logueado -->
						<c:if test="${not empty sessionScope.usuario}">
							<li class="nav-item">
	                            <a class="nav-link" href="home">Inicio <span class="sr-only">(current)</span></a>
	                        	</li>
							
							<li class="nav-item">
	                            <a class="nav-link" href="privado/alta-producto.jsp">Nuevo producto</a>
	                        </li>                        
	
	                        <li class="nav-item">
	                            <a class="nav-link" href="listado">Listado</a>	                            
	                        </li>
	                         <li class="nav-item">	                            
	                            <a class="nav-link" href="logout">cerrar sesion</a>
	                        </li>
						</c:if>                        	
                    </ul>
                </div>

            </nav>