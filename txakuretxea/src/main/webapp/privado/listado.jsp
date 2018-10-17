
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>    
<%@ include file="../includes/navbar.jsp" %>    


         


        	
			 <div class="row">
			 	
	        	<div class="col-xl-1 col-lg-1 col-md-2  col-sm-2 col-1 columna-menu"  >
		        <%@ include file="../includes/navbar-vertical.jsp" %>
		        </div>
		        <div class="col-xl-11 col-lg-11 col-md-10 col-sm-10 col-11 columna-contenido" >
		        
		        	<c:if test="${vista == 'kanban-perro' }">
		           		vista kanban
		           	</c:if>
		           <c:if test="${vista == 'formulario-perro' }">
		           		<div>
		           			<%@ include file="../includes/formularioPerros.jsp" %>
		           		</div>
		           	</c:if>
		           	<c:if test="${vista == 'lista-perro' }">
		           		<h2>Perros totales : ${perros.size() }</h2>
		           		<%@ include file="../includes/alerta.jsp" %> 
                		<a class="btn btn-success" href="listadoControler?op=2">Nuevo</a>
			            <table id="listado-productos" class="display">
			                <thead>
			                    <tr>
			                        <th>id</th>
			                        <th>nombre</th>
			                        <th>edad</th>
			                        <th>raza</th>
			                        <th>peso</th>
			                        <th>Nº identificacion</th>
			                        
			                    </tr>
			                </thead>
			
			                <tbody>
							<c:forEach items="${perros}" var="p">
			                    <tr>
			                        <td>${p.id}</td>
			                        <td>${p.nombre}</td>
			                        <td>${p.edad}</td>
			                        <td>${p.raza}</td>
			                        <td>${p.peso}</td>			                        
			                        <td>${p.chipPerro.nIdentificacion}</td>			                        
			                    </tr>
							</c:forEach>
			                        
			                </tbody>
			
			            </table>
		           	</c:if>
		        </div>
	        </div>
            
<%@ include file="../includes/footer.jsp" %>
