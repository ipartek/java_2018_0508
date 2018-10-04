<!-- Navigation -->
        <nav class="navbar navbar-default nav-top navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand " href="inicio">Backoffice</a>
                <a class="navbar-brand " href="<%=request.getContextPath()%>/inicio">Inicio</a>
            </div>
            <!-- /.navbar-header -->
           

            <ul class="nav navbar-top-links navbar-right">
            	<li>
                	<a href="<%=request.getContextPath()%>/logout">Cerrar Session</a>
                </li>	
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                       
                        <li>
                            <a href="inicio"><i class="fa fa-dashboard fa-fw"></i> Panel de control</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/backoffice/usuario"><i class="fas fa-users"></i> Usuarios</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/backoffice/video"><i class="fab fa-youtube"></i> Videos</a>
                        </li>
                       
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
<!-- /Navigation -->