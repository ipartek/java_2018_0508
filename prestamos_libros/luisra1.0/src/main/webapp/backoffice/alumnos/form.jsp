<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file="../include/header.jsp" %>
<%@ include file="../include/nav.jsp" %>
<div class="container">

  <div id="page-wrapper">
  
  	  <%@ include file="../include/alert.jsp" %>
  
      <div class="row ">
          <div class="col-lg-12">
              <h1 class="page-header">${ (alumno.id == -1) ? 'Crear Alumno' : 'Modificar Alumno' }</h1>
          </div>
      </div>
      
      <div class="row justify-content-center">
      		      		
      		<form action="alumnos" method="post">
      			
      			<div class="form-group row">				  
				   <input type="hidden" class="form-control" name="id" id="id" value="${ alumno.id }" readonly>
				</div>
				
				<div class="form-row">
					<div class="col-4">
						<label class="col-2" for="nombre">Nombre</label>
					</div>
				  	<div class="col-8">
				   		<input class="col-10" type="text" class="form-control" name="nombre" id="nombre" value="${ alumno.nombre }" min="2" max="50" autofocus>
				   	</div>
				</div>
      		     
      		    <!-- OPERACIÓN = GUARDAR -->	
      			<input type="hidden" name="op" value="<%= ICRUDController.OP_GUARDAR %>">
      			
      			<input type="submit" value="${ (alumno.id == -1) ? 'Crear' : 'Modificar' }" class="btn btn-primary btn-block">
      			
      		
      		</form>
      		
      		<script src="js/confirmar.js"></script>
      		
      </div> <!-- row -->        
  </div> <!-- #page-wrapper -->   
</div>
<%@ include file="../include/footer.jsp" %>

