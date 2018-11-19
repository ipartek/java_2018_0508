<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file="../include/header.jsp" %>
<%@ include file="../include/nav.jsp" %>
<div class="container">

  <div id="page-wrapper">
  
  	  <%@ include file="../include/alert.jsp" %>
  
      <div class="row" >
          <div class="col-lg-12">
              <h1 class="page-header">${ (editorial.id == -1) ? 'Crear Editorial' : 'Modificar Editorial' }</h1>
          </div>
      </div>
      
      <div class="row justify-content-center">
      		      		
      		<form action="editoriales" method="post">
      			
      			<div class="form-group">
				   
				   <input type="hidden" class="form-control" name="id" id="id" value="${ editorial.id }" readonly>
				</div>
				
				<div class="form-row">
					<div class="col-4">
					   <label for="nombre">Nombre</label>
					</div>
					<div class="col-8">
					   <input type="text" class="form-control" name="nombre" id="nombre" value="${ editorial.nombre }" autofocus>
					</div>
					
				</div>
      		     
      		    <!-- OPERACIÓN = GUARDAR -->	
      			<input type="hidden" name="op" value="<%= ICRUDController.OP_GUARDAR %>">
      			
      			<input type="submit" value="${ (editorial.id == -1) ? 'Crear' : 'Modificar' }" class="btn btn-primary btn-block">
      			
      		
      		</form>
      		
      		<script src="js/confirmar.js"></script>
      		
      </div> <!-- row -->        
  </div> <!-- #page-wrapper -->   
  </div>

<%@ include file="../include/footer.jsp" %>

