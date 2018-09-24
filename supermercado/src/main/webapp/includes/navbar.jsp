<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                <a class="navbar-brand" href="home"><img src="images/logo.jpg" alt="logotipo-supermercado-el-fuerte" /></a>

                <div class="navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto menu">
						
						<!-- Usuario no logueado -->
						<c:if test="${empty usuario }">
							<li class="nav-item">
                            <a class="nav-link" href="home">Inicio <span class="sr-only">(current)</span></a>
                        </li>        
                        <li class="nav-item active">
								<!-- Formulario de login -->
								<form action="login" method="post" class="form-inline mt-2 mt-md-0">									
									<input name="usuario" class="form-control mr-2" type="text" placeholder="Nombre de usuario" required pattern=".{3,30}">
									<input name="pass" class="form-control mr-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
									<button class="btn btn-outline-info btn-outline-pika mr-2" type="submit">Entrar</button>
									
								</form>
								<!-- Fin Formulario de login -->
							</li>						
						</c:if>	
						
						<!-- Usuario logueado -->
						<c:if test="${not empty usuario}">
							<li class="nav-item">
	                            <a class="nav-link" href="home">Inicio <span class="sr-only">(current)</span></a>
	                        	</li>
							
							<li class="nav-item">
	                            <a class="nav-link" href="privado/alta-producto.jsp">Nuevo producto</a>
	                        </li>                        
	
	                        <li class="nav-item">
	                            <a class="nav-link" href="listado.jsp">Listado</a>
	                        </li>
						</c:if>                        	
                    </ul>
                </div>

            </nav>