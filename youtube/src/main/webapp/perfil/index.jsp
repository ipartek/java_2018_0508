<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>  

<div class="container">
	
	<div class="row">
		<div class="col-sm-8 col-md-10 col-lg-12 user-details col-centered">
            <div class="user-image mb-3">
                <img src="${ sessionScope.usuario.imagen }" alt="Imagen de perfil" title="${ sessionScope.usuario.alias }" class="img-circle">
            </div>
            <div class="user-info-block">
                <div class="user-heading">
                    <h3>${ sessionScope.usuario.alias }</h3>
                    <span class="help-block">${ sessionScope.usuario.direccion }</span>
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
                            
                            <div class="row-lg-8">
                            	<h2 class="text-center"> ${ sessionScope.usuario.nombre.concat(' ').concat(sessionScope.usuario.apellido1).concat(' ').concat(sessionScope.usuario.apellido2)  }</h2>
                            	<p class="text-center"> ${ sessionScope.usuario.descripcion }</p>
                            </div>
                            
                             <div class="row-lg-8">
								<p class="text-center"><i class="fas fa-envelope"></i> ${ sessionScope.usuario.email }</p>	
                             	<p class="text-center"><i class="fas fa-phone"></i><a href="tel:"> +34 622 123 123</a></p>
                             </div>
                            
                        </div>
                        
                        <div id="settings" class="tab-pane">
                            <h4>Configuración</h4>
                            
                            <form class="form" action="usuario?op=">
							  
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