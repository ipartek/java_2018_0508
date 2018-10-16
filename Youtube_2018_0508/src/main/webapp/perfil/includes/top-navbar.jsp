<header class="header">
    <nav class="navbar">
    
      <!-- Search Box-->
      <div class="search-box">
        <button class="dismiss"><i class="icon-close"></i></button>
        <form id="searchForm" action="#" role="search">
          <input type="search" placeholder="Buscar en esta página..." class="form-control">
        </form>
      </div>
      
      <div class="container-fluid">
        <div class="navbar-holder d-flex align-items-center justify-content-between">
          <!-- Navbar Header-->
          <div class="navbar-header">
            <!-- Navbar Brand -->
            <a href="index.html" class="navbar-brand d-none d-sm-inline-block">
            <div class="brand-text d-none d-lg-inline-block"><span><i class="far fa-smile-beam mr-2"></i> ${usuario.nombre}</div>
            <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div></a>
            <!-- Toggle Button-->
            <a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
          </div>
          
          <!-- Navbar Menu -->
          <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
            <!-- Search-->
            <li class="nav-item d-flex align-items-center"><a id="search" href="#"><i class="icon-search"></i></a></li>
            <!-- Logout    -->
            <li class="nav-item"><a href="../logout" class="nav-link logout"> <span class="d-none d-sm-inline">Cerrar sesión</span><i class="fa fa-sign-out"></i></a></li>
          </ul>
          
        </div>
      </div>
    </nav>
  </header>