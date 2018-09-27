<%@ include file="includes/header.jsp" %>
<%@ include file="includes/nav.jsp" %>		



		
        <main role="main" class="container">
        <c:if test="${not empty alert}">
			<div class="container">
				<div class="alert ${alert.tipo} alert-dismissible fade show"
					role="alert">
					<p>${alert.texto}</p>
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
	
				${alert=null}
	
		</c:if>
        
        
        
			<p class="text-danger">${param.msg} ${requestScope.msg}</p>
            <div class="row justify-content-center">
                <h1 class="col col-md-6"><i class="fas fa-user"></i> Login</h1>
            </div>
                    
            <div class="row justify-content-center">
                <small id="login-small" class="col col-md-6">Los campos con * son obligatorios</small>
            </div>

            <form id="login-form" action="login" method="post">
			
                <div class="form-row justify-content-center">
                            
                    <div class="col col-md-6">
                        
                        <div class="form-group">
                            <label for="nombre" class="required">Introduce tu nombre</label>
                            <input  name="nombre"type="text" class="form-control" id="nombre" autofocus required placeholder="Ej: Asier" />
                        </div>
                                    
                        <div class="form-group">
                            <label for="pass" class="required">Contraseña</label>
                            <input  name="pass" type="password" class="form-control" id="pass" minlength="4" maxlength="20" required placeholder="ContraseÃ±a del usuario (8 a 20 caracteres)" />
                        </div>
                                    
                        <button type="submit" class="btn btn-outline-primary btn-block">Acceder</button>
                                    
                    </div>
                                    
                </div>
                            
            </form>

        </main>

        
    </div> <!-- /.contenedor -->

<%@ include file="includes/footer.jsp" %> 