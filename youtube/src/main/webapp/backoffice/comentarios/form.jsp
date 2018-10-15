<%@page import="com.ipartek.formacion.youtube.controller.back.ICRUDController"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
  
  	  <%@ include file="../includes/alert.jsp" %>
  
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">${ (comentario.id == -1) ? 'Crear Comentario' : 'Comentario ID' comentario.id }</h1>
          </div>
      </div>
      
      <div class="row">
      		      		
      		<form action="comentarios" method="post">
      			
      			<div class="form-group">
				   <label for="id">ID</label>
				   <input type="text" class="form-control" name="id" id="id" value="${ comentario.id }" readonly>
				</div>
				
				<div class="form-group">
				   <label for="texto">Texto</label>
				   <input type="text" class="form-control" name="nombre" id="nombre" value="${ comentario.nombre }" autofocus>
				</div>
      		     
      		    <!-- OPERACIÓN = GUARDAR -->	
      			<input type="hidden" name="op" value="<%= ICRUDController.OP_GUARDAR %>">
      			
      			<input type="submit" value="${ (comentario.id == -1) ? 'Crear' : 'Modificar' }" class="btn btn-primary btn-block">
      			
      			<!-- BOTÓN ELIMINAR -->
      			<c:if test="${ comentario.id > 0 }">
      				<a href="roles?id=${ comentario.id }&op=<%= ICRUDController.OP_ELIMINAR %>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
      			</c:if>	
      		
      		</form>
      		
      		<script src="js/confirmar.js"></script>
      		
      </div> <!-- row -->        
  </div> <!-- #page-wrapper -->   

<%@ include file="../includes/footer.jsp" %>

