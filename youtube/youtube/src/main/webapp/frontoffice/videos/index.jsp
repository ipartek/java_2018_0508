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
      			<a href="videos?id=-1&op=<%=CrudControllable.OP_IR_FORMULARIO%>" class="btn btn-primary crear">Crear Nuevo</a>
      		</div>	
  <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">Videos<span class="badge badge-info numUsuarios">${fn:length(videos)}</span></h1>
          </div>
            <div class="row">
                <div class="col-lg-12">
                
                	<table id="tablaOrdenable" class="display">
					    <thead>
					        <tr>
					            <th>Id</th>
					            <th>Imagen</th>
					            <th>Nombre</th>	            
					            <th>Usuario</th>
					            
					        </tr>
					    </thead>
					    <tbody>
					    
					    	<c:forEach items="${videos}" var="v">
					        <tr>
					            <td>${v.id}</td>
					            <td class="imagen"><img class="miniatura" alt="Miniatura del video " src="http://img.youtube.com/vi/${v.codigo}/0.jpg"> </td>
					            <td><a name="nombre" href="videos?id=${v.id}&op=<%=CrudControllable.OP_IR_FORMULARIO%>">${v.nombre}</a></td>	            
					            <td><a name="nombre_usuario" href="usuarios?id=${v.usuario.id}&op=<%=CrudControllable.OP_IR_FORMULARIO%>">${v.usuario.nombre}</td>
					        </tr>
					        
					        </c:forEach>
					        
					    </tbody>
					    
					    <tfoot>
					    	<tr>
					            <th>Id</th>
					            <th>Imagen</th>
					            <th>Nombre</th>	            
					            <th>Usuario</th>
					        </tr>
					    
					    </tfoot>
					</table>
                    
                </div>
            </div><!-- /.row -->
            <div class="row">
      		
      		
      </div>
                
 </div><!-- /#page-wrapper -->
            

<%@ include file="../includes/footer.jsp" %>