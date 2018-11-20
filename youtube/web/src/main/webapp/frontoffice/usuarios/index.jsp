<%@page import="com.ipartek.formacion.youtube.controller.CrudControllable"%>
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
						${sessionScope.alert=null}
						${alert=null}
					</c:if>
 
 
 	<div class="col-md-4 botonCrear">
      			<a href="usuarios?id=-1&op=<%=CrudControllable.OP_IR_FORMULARIO%>" class="btn btn-primary crear">Crear Nuevo</a>
      		</div>	
  <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">Usuarios<span class="badge badge-info numUsuarios">${fn:length(usuarios)}</span></h1>
          </div>
            <div class="row">
                <div class="col-lg-12">
                
                	<table id="tablaOrdenable" class="display">
					    <thead>
					        <tr>
					            <th>id</th>
					            <th>Nombre</th>	            
					            <th>Rol</th>
					            
					        </tr>
					    </thead>
					    <tbody>
					    
					    	<c:forEach items="${usuarios}" var="u">
					        <tr>
					            <td>${u.id}</td>
					            <td><a name="nombre" href="usuarios?id=${u.id}&op=<%=CrudControllable.OP_IR_FORMULARIO%>">${u.nombre}</a></td>	            
					            <td>${u.rol.nombre}</td>
					        </tr>
					        
					        </c:forEach>
					        
					    </tbody>
					    
					    <tfoot>
					    	<tr>
					            <th>id</th>
					            <th>Nombre</th>
					            <th>Rol</th>
					        </tr>
					    
					    </tfoot>
					</table>
                    
                </div>
            </div><!-- /.row -->
            <div class="row">
      		
      		
      </div>
                
 </div><!-- /#page-wrapper -->
            

<%@ include file="../includes/footer.jsp" %>