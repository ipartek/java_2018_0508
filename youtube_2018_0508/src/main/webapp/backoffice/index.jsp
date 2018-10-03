<%@include file="includes/header.jsp"%>

    <div id="wrapper">
<%@include file="includes/navbar.jsp"%>      

       <div id="page-wrapper">
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">Dashboard</h1>
          </div>
          <!-- /.col-lg-12 -->
      </div>
      <!-- /.row -->
      <div class="row">
          <div class="col-lg-3 col-md-6">
              <div class="panel panel-primary">
                  <div class="panel-heading">
                      <div class="row">
                          <div class="col-xs-3">
                              <i class="fas fa-users fa-5x"></i>
                          </div>
                          <div class="col-xs-9 text-right">
                              <div class="huge">${usuarios}</div>                              
                          </div>
                      </div>
                  </div>
                  <a href="usuarios">
                      <div class="panel-footer">
                          <span class="pull-left">Ver Usuarios</span>
                          <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                          <div class="clearfix"></div>
                      </div>
                  </a>
              </div>
          </div>
          
          <div class="col-lg-3 col-md-6">
              <div class="panel panel-red">
                  <div class="panel-heading">
                      <div class="row">
                          <div class="col-xs-3">
                              <i class="fab fa-youtube fa-5x"></i>
                          </div>
                          <div class="col-xs-9 text-right">
                              <div class="huge">${videos}</div>                              
                          </div>
                      </div>
                  </div>
                  <a href="#">
                      <div class="panel-footer">
                          <span class="pull-left">Ver Videos</span>
                          <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                          <div class="clearfix"></div>
                      </div>
                  </a>
              </div>
          </div>            
      
      </div>
      <!-- /.row -->
  </div>
  <!-- /#page-wrapper -->
    <!-- /#wrapper -->
<%@include file="includes/footer.jsp"%>

