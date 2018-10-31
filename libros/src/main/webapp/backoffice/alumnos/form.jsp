<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file="../include/header.jsp" %>
<%@ include file="../include/nav.jsp" %>
<div class="container">

  <div id="page-wrapper">
  
  	  <%@ include file="../include/alert.jsp" %>
  
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">${ (alumno.id == -1) ? 'Crear Alumno' : alumno.nombre }</h1>
          </div>
      </div>
      
      <div class="row">
      		      		
      		<form action="alumnos" method="post">
      			
      			<div class="form-group">				  
				   <input type="hidden" class="form-control" name="id" id="id" value="${ alumno.id }" readonly>
				</div>
				
				<div class="form-group">
				   <label for="nombre">Nombre</label>
				   <input type="text" class="form-control" name="nombre" id="nombre" value="${ alumno.nombre }" autofocus>
				</div>
      		     
      		    <%-- <!-- OPERACIÓN = GUARDAR -->	
      			<input type="hidden" name="op" value="<%= ICRUDController.OP_GUARDAR %>"> --%>
      			
      			<input type="submit" value="${ (alumno.id == -1) ? 'Crear' : 'Modificar' }" class="btn btn-primary btn-block">
      			
      			<!-- BOTÓN ELIMINAR -->
      			<c:if test="${ alumno.id > 0 }">
      				<a href="roles?id=${ alumno.id }&op=<%= ICRUDController.OP_ELIMINAR %>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
      			</c:if>	
      		
      		</form>
      		
      		<script src="js/confirmar.js"></script>
      		
      </div> <!-- row -->        
  </div> <!-- #page-wrapper -->   
</div>
<%@ include file="../include/footer.jsp" %>

