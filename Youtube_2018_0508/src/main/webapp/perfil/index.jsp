<%@include file="includes/header.jsp"%>

<div class="page">
  <!-- Main Navbar-->
  <%@include file="includes/top-navbar.jsp"%>
  
  <div class="page-content d-flex align-items-stretch"> 
    
    <!-- Side Navbar -->
    <%@include file="includes/side-navbar.jsp"%>
    
    <div class="content-inner">
      <!-- Page Header-->
      <header class="page-header">
        <div class="container-fluid">
          <h2 class="no-margin-bottom">Página principal</h2>
        </div>
      </header>
      
      <!-- Dashboard Counts Section-->
      <section class="dashboard-counts no-padding-bottom">
        <div class="container-fluid">
          <div class="row bg-white has-shadow">
            <!-- VIDEOS -->
            <div class="col-xl-4 col-sm-6">
              <div class="item d-flex align-items-center">
                <div class="icon bg-violet"><i class="icon-user"></i></div>
                <div class="title"><span>Mis Vídeos</span>
                  <div class="progress">
                    <div role="progressbar" style="width: 25%; height: 4px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-violet"></div>
                  </div>
                </div>
                <div class="number"><strong>25</strong></div>
              </div>
            </div>
            <!-- COMENTARIOS -->
            <div class="col-xl-4 col-sm-6">
              <div class="item d-flex align-items-center">
                <div class="icon bg-red"><i class="icon-padnote"></i></div>
                <div class="title"><span>Mis Comentarios</span>
                  <div class="progress">
                    <div role="progressbar" style="width: 70%; height: 4px;" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-red"></div>
                  </div>
                </div>
                <div class="number"><strong>70</strong></div>
              </div>
            </div>
            <!-- AJUSTES -->
            <div class="col-xl-4 col-sm-6">
              <div class="item d-flex align-items-center">
                <div class="icon bg-green"><i class="icon-bill"></i></div>
                <div class="title"><span>Ajustes de privacidad</span>
                  <div class="progress">
                    <div role="progressbar" style="width: 40%; height: 4px;" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-green"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      
      <!-- Dashboard Header Section    -->
      <section class="dashboard-header">
        
      </section>	
      
      <!-- Page Footer-->
      <footer class="main-footer">
        <div class="container-fluid">
          <div class="row">
            <div class="col-sm-6">
              <p>Youtube &copy; 2018-2019</p>
            </div>
            <div class="col-sm-6 text-right">
              <p>Diseño por <a href="https://bootstrapious.com/admin-templates" class="external">Bootstrapious</a></p>
              <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
            </div>
          </div>
        </div>
      </footer>
    </div>
  </div>
</div>

<%@include file="includes/footer.jsp"%>