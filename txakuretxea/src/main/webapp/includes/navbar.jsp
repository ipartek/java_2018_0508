

        <header id="top">
			<c:if test="${ empty sessionScope.usuario}">
            <nav class="navbar navbar-expand-md  mb-4 custom-navbar">
                
                <span class=" navbar-brand nav-link badge badge-success">TXAKURETXEA</span>

                <div class="navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto menu">
                        <li class="nav-item">
                            <a class=" nav-link badge badge-success" href="home">Inicio</a>
	                    </li>
	                    <li class="nav-item">
                            <a class="nav-link nav-link badge badge-success" href="usuarioLogin.jsp">Identificate <span class="sr-only"></span></a>         
	                    </li>
	                    
		                

                    </ul>
                </div>
                </c:if>
               <c:if test="${ not empty sessionScope.usuario}">
            <nav class="navbar navbar-expand-md  mb-4 custom-navbar">
                
                <span class=" navbar-brand nav-link badge badge-success">TXAKURETXEA</span>

                <div class="navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto menu">
                        
	                    <c:if test="${ sessionScope.usuario == 'scobby'}">
		                    <li class="nav-item">
	                           <a class="nav-link badge badge-danger" href="listadoControler?vista=lista-perro&op=1">Administracionn</a>
		                    </li>
		                    
		                </c:if>
		                

                    </ul>
                </div>
                <c:if test="${not empty sessionScope.usuario}">
		                <div class="nav-complemento">           
			                <div>
			                	<i class="fas fa-user">${sessionScope.usuario}</i>   
			                </div>
			                <c:if test="${ sessionScope.usuario == 'scobby'}">
				                <div class="pantallas-pequeñas">
					                <ul class="nav flex-column active">
										<li class="nav-item">
									    <a class="nav-link badge badge-pill badge-info " href="home">Inicio</a>
									  </li>
									  <li class="nav-item">
									    <a class="nav-link badge badge-pill badge-info " href="listadoControler?vista=lista-usuario&op=1">Perros</a>
									  </li>
									  
									</ul>
								</div>
							</c:if>
			                <div class="">
			                	<a class="nav-link badge badge-danger" href="logout">Cerrar Session</a>
			                </div>
			            </div> 
	                </c:if>
                
                </c:if>
                
                
      

            </nav>
</header>