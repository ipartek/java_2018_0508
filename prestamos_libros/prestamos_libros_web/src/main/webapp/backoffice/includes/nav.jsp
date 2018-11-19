 <!--NAVBAR-->
<nav class="navbar navbar-expand-lg main-navbar">
    <ul class="navbar-nav mr-3">
      <li><a href="#" data-toggle="sidebar" class="nav-link nav-link-lg"><i class="ion ion-navicon-round"></i></a></li>
    </ul>
  <ul class="navbar-nav navbar-right">
    <li class="dropdown"><a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle nav-link-lg">
      <i class="ion ion-android-person d-lg-none"></i>
      <div class="d-sm-none d-lg-inline-block">Hola, <c:out value="${sessionScope.usuarioLogin.nombre}" /></div></a>
      <div class="dropdown-menu dropdown-menu-right">
        <a href="#" class="dropdown-item has-icon">
          <i class="ion ion-android-person"></i> <c:out value="${sessionScope.usuarioLogin.nombre}" />
        </a>
        <a href="<%=request.getContextPath()%>/logout" class="dropdown-item has-icon">
          <i class="ion ion-log-out"></i> Cerrar Session
        </a>
      </div>
    </li>
  </ul>
</nav>
      <div class="main-sidebar">
        <aside id="sidebar-wrapper">
        
          <div class="sidebar-brand">
            <img class="mb-4" src="dist/img/logo-ipartek.png" alt="" width="150" height="52">
          </div>
          <div class="sidebar-user">
          <!--LOGO-->
            <div class="sidebar-user-picture">
              <img alt="image" src="dist/img/avatar/avatar-1.jpeg">
            </div>
            <div class="sidebar-user-details">
              <div class="user-name"> <c:out value="${sessionScope.usuarioLogin.nombre}" /></div>
              <div class="user-role">
                Administrator
              </div>
            </div>
          </div>
         	<ul class="sidebar-menu">  
                <li>
              		<a href="prestamo?op=1"><i  class="far fa-address-book"></i><span>Libros Prestados</span></a>
            	</li>
                <li>
                	<a href="prestamo?op=4"><i class="ion ion-clipboard"></i><span>Añadir Prestamo</span></a>
                </li>
                <li>
              		<a href="prestamo?op=2"><i class="fas fa-book-reader"></i><span>Libros Devueltos</span></a>
            	</li>
            	<li>
              		<a href="libro"><i class="fas fa-list-ul"></i><span>Libros</span></a>
            	</li>
            	<li>
                	<a href="usuario"><i class="fas fa-users"></i><span>Usuarios</span></a>
            	</li>
            	<li>
                	<a href="editorial"><i  class="fas fa-book"></i><span>Editoriales</span></a> 
            	</li>
        	</ul>
        </aside>
      </div>
    <!--/ NAVBAR-->