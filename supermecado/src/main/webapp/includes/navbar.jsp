<div class="contenedor">

        <header id="top">

            <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                <a class="navbar-brand" href="home"><img src="images/logo.jpg" alt="logotipo-supermercado-el-fuerte" /></a>

                <div class="navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto menu">

                        <li class="nav-item">
                            <a class="nav-link" href="home">Inicio <span class="sr-only">(current)</span></a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Login</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="privado/alta.jsp">Nuevo producto</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="privado/listado.jsp">Listado</a>
                        </li>

                    </ul>
                </div>
                 <form action="login" method="post" class="form-inline mt-2 mt-md-0">
	              	
		            <input id="usuario" name="usuario" class="form-control mr-sm-2" type="text" placeholder="Nombre Usuario" value="" required pattern=".{3,30}">
		            
		            
		            <input name="pass" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
		           <!--  <span class="text-primary">Recuerdame</span>
		            <input name="recuerdame" type="checkbox" class="form-check-input" id="exampleCheck1"> -->
		            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
		          </form>   

            </nav>
           

        </header>
