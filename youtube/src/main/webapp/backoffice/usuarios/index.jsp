<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

<%@ include file="../includes/nav.jsp" %>

<%@ include file="../includes/sidebar.jsp" %>


 <div id="page-wrapper">
 	<c:if test="${not empty alert}">
						<div class="alert ${alert.tipo} alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<strong>${alert.texto}</strong>
						</div>
					</c:if>
 
            <div class="row">
                <div class="col-lg-12">
                
                	<table id="tablaOrdenable" class="display">
					    <thead>
					        <tr>
					            <th>id</th>
					            <th>Nombre</th>
					            <th>Password</th>
					            <th>Rol</th>
					        </tr>
					    </thead>
					    <tbody>
					    
					    	<c:forEach items="${usuarios}" var="u">
					        <tr>
					            <td>${u.id}</td>
					            <td><a href="usuarios?id=${u.id}">${u.nombre}</a></td>
					            <td>${u.pass}</td>
					            <td>${u.rol}</td>
					        </tr>
					        
					        </c:forEach>
					        
					    </tbody>
					    
					    <tfoot>
					    	<tr>
					            <th>id</th>
					            <th>Nombre</th>
					            <th>Password</th>
					            <th>Rol</th>
					        </tr>
					    
					    </tfoot>
					</table>
                    
                </div>
            </div><!-- /.row -->
            <div class="row">
      		
      		<div class="col-md-4">
      			<a href="usuarios?id=-1" class="btn btn-success">Crear Nuevo</a>
      		</div>	
      </div>
                
 </div><!-- /#page-wrapper -->
            
      
        




























<%@ include file="../includes/footer.jsp" %>