<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeComentarioController"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.ICRUDController"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
  
  	  <%@ include file="../includes/alert.jsp" %>
  		
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">Aprobar Comentarios</h1>
          </div> 
      </div> 
      
      <div class="row">
      
      		<!--  DATATBLES -->
      		<table id="tablaOrdenable" class="display" style="width:100%">
		        <thead>
		            <tr>
		                <th>ID</th>
		                <th>Texto</th>	
		                <th>Video</th>
		                <th>Usuario</th>
		                <th>Aprobar</th>                
		            </tr>
		        </thead>
		        
		        <tbody>
		        	<form action="comentarios" method="post">
		        	<c:forEach items="${ comentariosPendientes }" var="comentario">
			            <tr>
			                <td>${ comentario.id }</td>
			                <td><a href="roles?id=${ comentario.id }&op=<%= ICRUDController.OP_IR_FORMULARIO %>">${ comentario.texto }</a></td>	
			                <td>${ comentario.video.nombre }</td>
			                <td>${ comentario.usuario.nombre }</td>
			                <th><input type="checkbox" name="aprobados" value="${ comentario.id }"><th>                
			            </tr>
		            </c:forEach>
		            <input type="hidden" name="op" value="${ BackofficeComentarioController.OP_APROBAR  }">
		            <input type="submit" class="btn btn-primary" value="Aprobar Comentarios">
		            </form>
		        </tbody>
		       
		        <tfoot>
		            <tr>
		                <th>ID</th>
		                <th>Texto</th>
		                <th>Video</th>	
		                <th>Usuario</th>
		                <th>Aprobar</th>	  
		            </tr>
		        </tfoot>
    	</table> 	<!-- table#tablaOrdenable -->		
      </div> <!-- ./ row -->
      
  </div> <!-- #page-wrapper -->  
   

<%@ include file="../includes/footer.jsp" %>

