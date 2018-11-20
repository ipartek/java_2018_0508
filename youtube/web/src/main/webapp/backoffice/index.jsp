
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<%@ include file="includes/header.jsp" %>

	<%@ include file="includes/nav.jsp" %>


<%@ include file="includes/sidebar.jsp" %>

        <div id="page-wrapper">
        
        ${sessionScope.alert=null}
 					<c:if test="${not empty alert}">
						<div class="alert ${alert.tipo} alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<strong>${alert.texto}</strong>
						</div>
						${sessionScope.alert=null}
						${alert=null}
					</c:if>
        
        <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">Dashboard</h1>
          </div>
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
                                    <div>Usuarios</div>
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
                                    <i class="fab fa-youtube fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${videos}</div>
                                    <div>Videos</div>
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
                                    <i class="far fa-address-card fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${roles}</div>
                                    <div>Roles</div>
                                </div>
                            </div>
                        </div>
                        <a href="roles">
                            <div class="panel-footer">
                                <span class="pull-left">Administrar roles</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            <!-- /.row -->
        </div>
        
          <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fas fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${comentarios}</div>
                                    <div>Comentarios pendientes</div>
                                </div>
                            </div>
                        </div>
                        <a href="comentarios/aprobar">
                            <div class="panel-footer">
                                <span class="pull-left">Aprobar comentarios</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

   
<%@ include file="includes/footer.jsp" %>