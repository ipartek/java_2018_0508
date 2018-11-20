<%@ include file="includes/header.jsp" %>	
<%@ include file="includes/nav.jsp"  %>
        <div id="page-wrapper">
        <%@ include file="includes/alert.jsp"  %>
        	
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Panel de control</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <c:if test=""></c:if>
            <div class="row">
            	<h2>Modifica tus datos</h2>
            	<form>
					  <div class="form-row">
					    <div class="form-group col-md-12">
					      <label for="nombre">Nombre</label>
					      <input type="text" name="nombre" value="${ sessionScope.usuario.nombre}" class="form-control" id="nombre" placeholder="Nuevo nombre de usuario">
					    </div>
					    
					  </div>
					  <div class="form-group col-md-6">
					    <label for="newPass">Contraseña</label>
					    <input type="text" name="newPass" class="form-control" id="newPass" placeholder="Nueva contraseña">
					  </div>
					  <div class="form-group col-md-6">
					    <label for="newPass2"> Repita contraseña</label>
					    <input type="text" name="newPass2" class="form-control" id="newPass2" placeholder="Introduzca nuevamente la contreñar">
					  </div>
					  
					  <button type="submit" class="btn btn-primary btn-lg btn-block">Guardar</button>
				</form>
            </div>
            <hr>
            <!-- /.row -->
            <div class="row justify-content-around">
                
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">                                   
                                    <i class="fab fa-youtube fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${videos.size()}</div>
                                    <div>Videos</div>
                                </div>
                            </div>
                        </div>
                        <a href="perfil/video/index.jsp">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
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
                                    <i class="far fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${comentarios.size() }</div>
                                    <div>Comentarios Pendientes</div>
                                </div>
                            </div>
                        </div>
                        <a href="perfil/comentarios/index.jsp">
                            <div class="panel-footer">
                                <span class="pull-left">ver detalle</span>
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

<%@ include file="includes/footer.jsp"  %>