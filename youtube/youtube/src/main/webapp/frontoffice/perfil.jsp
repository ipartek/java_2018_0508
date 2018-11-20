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
              <h1 class="page-header">Perfil de ${usuario.nombre}</h1>
          </div>
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fab fa-youtube fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${numVideos}</div>
                                    <div>Videos subidos</div>
                                </div>
                            </div>
                        </div>
                        <a href="videos">
                            <div class="panel-footer">
                                <span class="pull-left">Ver videos subidos</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
        
         
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fas fa-users fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${numComentarios}</div>
                                    <div>Comentarios realizados</div>
                                </div>
                            </div>
                        </div>
                        <a href="comentarios">
                            <div class="panel-footer">
                                <span class="pull-left">Ver tus comentarios</span>
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