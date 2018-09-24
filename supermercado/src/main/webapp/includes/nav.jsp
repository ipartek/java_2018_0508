   <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
       <a class="navbar-brand" href="home"><img src="images/logo.jpg" alt="logotipo-supermercado-el-fuerte" /></a>

       <div class="navbar-collapse" id="navbarCollapse">
           <ul class="navbar-nav mr-auto menu">

               <li class="nav-item">
                   <a class="nav-link" href="home">Inicio <span class="sr-only">(current)</span></a>
               </li>

               <li class="nav-item">
                   <a class="nav-link" href="login">Login</a>
               </li>
               <c:if test = "${not empty usuario}">
	               <li class="nav-item">
	                   <a class="nav-link" href="privado/altaproducto">Nuevo producto</a>
	               </li>
	
	               <li class="nav-item">
	                   <a class="nav-link" href="privado/listado.jsp">Listado</a>
	               </li>
               </c:if>

           </ul>
       </div>

   </nav>