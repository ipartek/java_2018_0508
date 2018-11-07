<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file="../include/header.jsp" %>
<%@ include file="../include/nav.jsp" %>
<div class="container">

  <div id="page-wrapper">
  
  	  <%@ include file="../include/alert.jsp" %>
  
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">${ (editorial.id == -1) ? 'Crear Editorial' : editorial.nombre }</h1>
          </div>
      </div>
      
      <div class="row">
      		      		
      		<form action="roles" method="post">
      			
      			<div class="form-group">
				   
				   <input type="hidden" class="form-control" name="id" id="id" value="${ editorial.id }" readonly>
				</div>
				
				<div class="form-group">
				   <label for="nombre">Nombre</label>
				   <input type="text" class="form-control" name="nombre" id="nombre" value="${ editorial.nombre }" autofocus>
				</div>
      		     
      		    <!-- OPERACIÓN = GUARDAR -->	
      			<input type="hidden" name="op" value="<%= ICRUDController.OP_GUARDAR %>">
      			
      			<input type="submit" value="${ (editorial.id == -1) ? 'Crear' : 'Modificar' }" class="btn btn-primary btn-block">
      			
      			<!-- BOTÓN ELIMINAR -->
      			<c:if test="${ editorial.id > 0 }">
      				<a href="roles?id=${ editorial.id }&op=<%= ICRUDController.OP_ELIMINAR %>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
      			</c:if>	
      		
      		</form>
      		
      		<script src="js/confirmar.js"></script>
      		
      </div> <!-- row -->        
  </div> <!-- #page-wrapper -->   
  </div>

<%@ include file="../include/footer.jsp" %>

