<%@page import="com.ipartek.formacion.youtube.controller.back.ICRUDController"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
  
  	  <%@ include file="../includes/alert.jsp" %>
  
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">${ (rol.id == -1) ? 'Crear Rol' : rol.nombre }</h1>
          </div>
      </div>
      
      <div class="row">
      		      		
      		<form action="roles" method="post">
      			
      			<div class="form-group">
				   <label for="id">ID</label>
				   <input type="text" class="form-control" name="id" id="id" value="${ rol.id }" readonly>
				</div>
				
				<div class="form-group">
				   <label for="nombre">Nombre</label>
				   <input type="text" class="form-control" name="nombre" id="nombre" value="${ rol.nombre }" autofocus>
				</div>
      		     
      		    <!-- OPERACIÓN = GUARDAR -->	
      			<input type="hidden" name="op" value="<%= ICRUDController.OP_GUARDAR %>">
      			
      			<input type="submit" value="${ (rol.id == -1) ? 'Crear' : 'Modificar' }" class="btn btn-primary btn-block">
      			
      			<!-- BOTÓN ELIMINAR -->
      			<c:if test="${ rol.id > 0 }">
      				<a href="roles?id=${ rol.id }&op=<%= ICRUDController.OP_ELIMINAR %>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
      			</c:if>	
      		
      		</form>
      		
      		<script src="js/confirmar.js"></script>
      		
      </div> <!-- row -->        
  </div> <!-- #page-wrapper -->   

<%@ include file="../includes/footer.jsp" %>

