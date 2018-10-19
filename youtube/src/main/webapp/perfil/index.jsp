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
                            	
                            	<div class="row">
                            		
                            		<c:forEach items="${ videos }" var="video" varStatus="loop">
			
									<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mt-3">
									    <div class="hovereffect">
									        <img class="img-responsive" src="https://img.youtube.com/vi/${ video.cod }/0.jpg" alt="${ video.nombre }">
									        <div class="overlay">
									           <h2>${ video.nombre }</h2>
									           <a class="info" href="inicio?id=${ video.id }"><i class="fa fa-play" title="Reproducir Video"></i></a>
									           
									           <!-- DELETE/UPDATE VIDEO OPTIONS -->
										    	<c:if test="${ not empty sessionScope.usuario }">   	
										          		<a class="info">
										          			<i class="text-danger fas fa-trash-alt mr-2" title="Eliminar Video" 
										          			onclick="showModalForm(${ video.id },${ HomeController.OP_ELIMINAR });"></i>
										          		</a>
										          		<a class="info">
										          			<i class="text-primary fas fa-edit" title="Editar Video" 
										          			onclick="showModalForm(${ video.id }, ${ HomeController.OP_MODIFICAR });"></i>
										          		</a>
									          	</c:if>
									        </div>
									    </div>
									</div>
								
								    </c:forEach>
                            	</div>

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