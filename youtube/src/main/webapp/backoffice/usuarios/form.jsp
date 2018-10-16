<%@page import="com.ipartek.formacion.youtube.controller.back.ICRUDController"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
  
  	  <%@ include file="../includes/alert.jsp" %>
  
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">${ (usuario.id == -1) ? 'Crear Usuario' : usuario.nombre }</h1>
          </div>
      </div>

      <div class="row">
      		      		
      		<form action="usuarios" method="post">
      			
      			<div class="form-group">
				   <label for="id">Id</label>
				   <input type="text" class="form-control" name="id" id="id" value="${ usuario.id }" readonly>
				</div>
				
				<div class="form-group">
				   <label for="nombre">Nombre</label>
				   <input type="text" class="form-control" name="nombre" id="nombre" value="${ usuario.nombre }" autofocus>
				</div>
				
				<!-- PASSWORD -->
				<div class="form-group">
					<label for="password">Contraseña</label>
					<div class="input-group mb-3">
					 
					  <input type="password" class="form-control" name="password" id="password" value="${ usuario.password }">
					  <span class="input-group-addon" onclick="showPassword('password', event)"><i class="fas fa-eye-slash"></i></span>
					</div>
				</div> <!-- ./ form-group -->
				
				<div class="form-group">
				   <label for="rol">Rol</label>
				   
				   <!-- CARGAR ROLES -->
				   <select name="rol" class="form-control">	
				   		<c:forEach items="${ roles }" var="rol">
					   		<option value="${ rol.id }" ${ ( rol.id == usuario.rol.id) ? 'selected' : '' }>${ rol.nombre }</option>
				   		</c:forEach>
				   </select>
				</div>
      		    
      		    <!-- OPERACIÓN == GUARDAR -->	
      			<input type="hidden" name="op" value="<%= ICRUDController.OP_GUARDAR %>">
      			
      			<input type="submit" value="${ (usuario.id == -1) ? 'Crear' : 'Modificar' }" class="btn btn-primary btn-block p-3">
      			
      			<c:if test="${ usuario.id > 0 }">
      				<a href="usuarios?id=${ usuario.id }&op=<%= ICRUDController.OP_ELIMINAR %>" onclick="confirmar(event)" class="btn btn-danger btn-block p-3">Eliminar(Modal)</a>
      			</c:if>	
      		</form>
      		
      		<script src="js/confirmar.js"></script>
      		
      </div>      
     
  </div>
  <!-- #page-wrapper -->   

<%@ include file="../includes/footer.jsp" %>

