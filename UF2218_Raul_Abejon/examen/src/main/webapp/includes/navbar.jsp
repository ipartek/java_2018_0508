<div class="contenedor">

        <header id="top">

            <nav class="navbar navbar-expand-md navbar-dark  mb-4 custom-navbar">
                <a class="navbar-brand titulo-pagina badge-info" href="comentariosController">Libro electrónico</a>
                <c:if test="${ empty usuario }">
	                <!-- LOGIN -->
	                <div class="ml-auto">
			             <div>
				              <form action="login" method="post" class="form-inline mt-2 mt-md-0">
					            <input id="usuario" name="nombreUsuario" class="form-control mr-sm-2" type="text" placeholder="Nombre Usuario" value="William" required pattern=".{3,30}"> 
					            <input name="passUsuario" class="form-control mr-sm-2" type="password" placeholder="Contraseña" value="Shakespeare" required pattern=".{2,50}">
					            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
					          </form>   
				         </div>
			    	</div>
		    	</c:if>
		    	
		    	<c:if test="${ not empty usuario }">
	                <div class="ml-auto">	                
			          	<i class="far fa-user">
			          		<p>${usuario }</p>
			          	</i>
			          	<li class="nav-item cerrar-sesion">
                            <a class="nav-link" href="logout">Cerrar Sesion</a>
                        </li>
			          </div>
			    </c:if>
			                
		        </div>
				
            </nav>
            
        </header>
        
        	<%
        		Alerts alerta = (Alerts) request.getAttribute("alerta");
        		if(alerta != null) {
        	%>
        			<div class="<%= alerta.getTipo() %>">
        			
        			<%
        				if(alerta.getTexto() != null){
        						
        			%>
        					<%= alerta.getTexto() %>
        				
        			<%
        				
        				}
        			 %>
        			
        			</div>
        	
        	<%		
        		}
        	%>
       
