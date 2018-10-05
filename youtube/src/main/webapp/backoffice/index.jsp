<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

    <div id="wrapper">

		<%@include file="includes/nav.jsp" %>

        <div id="page-wrapper" class="contenedor">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header titulo">Dashboard</h1>
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
                                    <i class="fas fa-users fa-4x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${usuarios}</div>
                                    <div>Usuarios registrados</div>
                                </div>
                            </div>
                        </div>
                        <a href="usuarios">
                            <div class="panel-footer">
                                <span class="pull-left">Ver usuarios</span>
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
                                    <i class="fab fa-youtube fa-4x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${videos}</div>
                                    <div>Videos almacenados</div>
                                </div>
                            </div>
                        </div>
                        <a href="videos">
                            <div class="panel-footer">
                                <span class="pull-left">Ver videos</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fas fa-address-card fa-4x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${roles}</div>
                                    <div>Roles almacenados</div>
                                </div>
                            </div>
                        </div>
                        <a href="roles">
                            <div class="panel-footer">
                                <span class="pull-left">Ver roles</span>
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

    </div>
    <!-- /#wrapper -->

 <%@ include file="includes/footer.jsp" %> 