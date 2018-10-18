<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>  

<div class="container">
	
	<div class="row">
		<div class="col-sm-8 col-md-10 col-lg-12 user-details col-centered">
            <div class="user-image mb-3">
                <img src="https://st.depositphotos.com/1734074/4662/v/950/depositphotos_46622619-stock-illustration-user-man-with-glasses-icon.jpg" alt="Imagen de perfil" title="${ sessionScope.usuario.nombre }" class="img-circle">
            </div>
            <div class="user-info-block">
                <div class="user-heading">
                    <h3>${ sessionScope.usuario.nombre }</h3>
                    <span class="help-block">Dirección</span>
                </div>
                <ul class="navigation nav-center">
                    <li class="active">
                        <a data-toggle="tab" href="#information">
                            <span><i class="fas fa-user"></i></span>
                        </a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#settings">
                            <span><i class="fas fa-cog"></i></span>
                        </a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#videos">
                            <span><i class="fas fa-video"></i></span>
                        </a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#comments">
                            <span><i class="fas fa-comments"></i></span>
                        </a>
                    </li>
                </ul>
                <div class="user-body">
                    <div class="tab-content">
                        
                        <div id="information" class="tab-pane active">
                            <h4>Información General</h4>
                        </div>
                        
                        <div id="settings" class="tab-pane">
                            <h4>Configuración</h4>
                            
                            <form class="form" action="/action_page.php">
							  
							  <div class="form-group row">
							    <div class="col">
							      <input type="text" class="form-control" placeholder="Contraseña actual">
							    </div>
							  </div>
							  
							   <div class="form-group row">
							    <div class="col">
							      <input type="text" class="form-control" placeholder="Nueva contraseña">
							    </div>
							    <div class="col">
							      <input type="text" class="form-control" placeholder="Confirmar nueva contraseña">
							    </div>
							  </div>
								
							</form>
                        </div>
                        
                        <div id="videos" class="tab-pane">
                            <h4>Videos</h4>
                        </div>
                        
                        <div id="comments" class="tab-pane">
                            <h4>Comentarios</h4>
                            
                            <c:forEach items="${ comentarios }" var="comentario">
                            	
                            	<div class="row">
                            		<div class="col">
                            		<p> ${ comentario.texto } </p>
                            		</div>
                            	</div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</div>
</div>
<%@ include file="includes/footer.jsp" %>                  