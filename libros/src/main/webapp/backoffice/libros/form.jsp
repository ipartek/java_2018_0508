<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file="../include/header.jsp" %>
<%@ include file="../include/nav.jsp" %>
<div class="container">

  <div id="page-wrapper">
  
  	  <%@ include file="../include/alert.jsp" %>
  
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">${ (libro.id == -1) ? 'Crear libro' : libro.titulo }</h1>
          </div>
      </div>
      
      <div class="row">
      		      		
      		<form action="libros" method="post">
      			
      			<div class="form-group">
				  
				   <input type="hidden" class="form-control" name="id" id="id" value="${ libro.id }" readonly>
				</div>
				
				<div class="form-group">
				   <label for="titulo">Titulo</label>
				   <input type="text" class="form-control" name="titulo" id="titulo" value="${ libro.titulo }" autofocus>
				</div>
				<div class="form-group">
				   <label for="isbn">Codigo Isbn</label>
				   <input type="text" class="form-control" name="isbn" id="isbn" value="${ libro.isbn }" >
				</div>
				<div class="form-group">
				   <label for="ejemplares">Cantidad</label>
				   <input type="number" class="form-control" name="ejemplares" id="ejemplares" value="" >
				</div>
<%-- 				<div class="form-group">
				   <label for="editorial">Editorial</label>
				   <input type="text" class="form-control" name="editorial" id="editorial" value="${ libro.editorial }" >
				</div> --%>
				<!-- CARGAR ALUMNOS -->
				<label for="editorial">Editorial</label>
				<select name="editorial" class="form-control">	
			   		<c:forEach items="${ editoriales }" var="editorial">
				   		<option  value="${ editorial.id }" ${ ( editorial.id == prestamo.editorial.id) ? 'selected' : '' }>${ editorial.nombre }</option>
			   		</c:forEach>
				</select>
      		     
      		    <!-- OPERACIÓN = GUARDAR -->	
      			<input type="hidden" name="op" value="<%= ICRUDController.OP_GUARDAR %>">
      			
      			<input type="submit" value="${ (libro.id == -1) ? 'Crear' : 'Modificar' }" class="btn btn-primary btn-block">
      			
      			<!-- BOTÓN ELIMINAR -->
      			<c:if test="${ libro.id > 0 }">
      				<a href="roles?id=${ libro.id }&op=<%= ICRUDController.OP_ELIMINAR %>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
      			</c:if>	
      		
      		</form>
      		
      		<script src="js/confirmar.js"></script>
      		
      </div> <!-- row -->        
  </div> <!-- #page-wrapper -->   
</div>
<%@ include file="../include/footer.jsp" %>

