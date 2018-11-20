<!-- Navigation -->
        <%@page import="com.ipartek.formacion.youtube.controller.perfil.PerfilController"%>
<nav class="navbar navbar-default nav-top navbar-static-top navbar-dark bg-dark" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand " href="inicio">Perfil</a>
                <a class="navbar-brand " href="<%=request.getContextPath()%>/inicio">Inicio</a>
            </div>
            <!-- /.navbar-header -->
           

            <ul class="nav navbar-top-links navbar-right">
            	<li>
                	<p style="color:white;">${ sessionScope.usuario.nombre}</p>
                </li>	
            	<li>
                	<a href="<%=request.getContextPath()%>/logout">Cerrar Session</a>
                </li>	
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                       
                        <li>
                            <a href="<%=request.getContextPath()%>/perfil/inicio?op=<%=PerfilController.OP_PRINCIPAL%>"><i class="fa fa-dashboard fa-fw"></i> Tu perfil</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/perfil/inicio?op=<%=PerfilController.OP_VIDEO%>"><i class="fab fa-youtube"></i> Videos</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/perfil/inicio?op=<%=PerfilController.OP_COMENTARIO%>"><i class="far fa-comments"></i> Comentários</a>
                        </li>
                       
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
<!-- /Navigation -->
