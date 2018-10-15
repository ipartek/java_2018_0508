<%@page import="com.ipartek.formacion.youtube.controller.back.ICRUDController"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
  
  	  <%@ include file="../includes/alert.jsp" %>
  
      <div class="row">
          <div class="col-lg-12 ">
              <h1 class="page-header">${ (video.id == -1) ? 'Crear Video' : video.nombre }</h1>
          </div>
      </div>
      
      <div class="row">
      		      		
      		<form action="videos" method="post">
      			
      			<!-- CAMPOS DE FORMULARIO -->
      			<div class="form-group">
				   <label for="id">ID</label>
				   <input type="text" class="form-control" name="id" id="id" value="${ video.id }" readonly>
				</div>
				
				<div class="form-group">
				   <label for="codigo">Código</label>
				   <input type="text" class="form-control" name="codigo" id="codigo" value="${ video.cod }" autofocus maxlength="11" minlength="11">
				</div>
				
				<div class="form-group">
				   <label for="nombre">Nombre</label>
				   <input type="text" class="form-control" name="nombre" id="nombre" value="${ video.nombre }">
				</div>
				
				<div class="form-group">
				   	<label for="usuario">Pertenece a:</label>
			 	
				 	<!-- CARGAR USUARIOS -->
					<select name="idUsuario" class="form-control">	
					   	<c:forEach items="${ usuarios }" var="usuario">
							<option value="${ usuario.id }" ${ ( usuario.id == video.usuario.id) ? 'selected' : '' }>${ usuario.nombre }</option>
						</c:forEach>
					</select>
				</div>
      		     
      		    <!-- OPERACIÓN = GUARDAR -->	
      			<input type="hidden" name="op" value="<%= ICRUDController.OP_GUARDAR %>">
      			
      			<input type="submit" value="${ (video.id == -1) ? 'Crear' : 'Modificar' }" class="btn btn-primary btn-block">
      			
      			<!-- BOTÓN ELIMINAR -->
      			<c:if test="${ video.id > 0 }">
      				<a href="videos?id=${ video.id }&op=<%= ICRUDController.OP_ELIMINAR %>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar (Modal)</a>
      			</c:if>	
      		
      		</form>
      		
      		<script src="js/confirmar.js"></script>
      		
      </div> <!-- row -->        
  </div> <!-- #page-wrapper -->   

<%@ include file="../includes/footer.jsp" %>

