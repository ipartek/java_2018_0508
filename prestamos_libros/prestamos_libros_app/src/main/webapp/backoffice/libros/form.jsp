<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file="../include/header.jsp" %>
<%@ include file="../include/nav.jsp" %>
<div class="container ">

  <div id="page-wrapper ">
  
  	  <%@ include file="../include/alert.jsp" %>
  	  
  	  
      <div class="row ">
          <div class="col-lg-12">
          
              <h1 class="page-header">${ (libro.id == -1) ? 'Crear libro' : 'Modificar Libro' }</h1>
          </div>
      </div>
      
      <!-- MODALES -->
    <%@ include file = "../include/modal.jsp" %>
      <div class="row justify-content-center">
      		
      		<form action="libros" method="post">
      			 
      			<div class="form-group">
				 
				   <input type="hidden" class="form-control" name="id" id="id" value="${ libro.id }" readonly>
				</div>
				
				<div class="form-row">
					<div class="col-4">
				   		<label for="titulo">Título</label>
				   	</div>
				   	<div class="col-4">
				   		<input type="text" class="form-control" name="titulo" id="titulo" value="${ libro.titulo }" autofocus>
				   	</div>
				</div>
				<div class="form-row">
					<div class="col-4">
				   		<label for="isbn">Código Isbn</label>
				   	</div>
				   	<div class="col-8">
				   		<input type="text" class="form-control" name="isbn" id="isbn" value="${ libro.isbn }" >
				   	</div>
				</div>
				<c:if test="${ (libro.id == -1) }">
					<div class="form-row">
						<div class="col-4">					
					  		 <label for="ejemplares">Cantidad</label>
					   </div>
					   <div class="col-4">	
					   		<input type="number" class="form-control" name="ejemplares" id="ejemplares" value="" >
					   	</div>
					</div>
				</c:if>
				
				<!-- CARGAR EDITORIALES -->
				<div class="form-row">
					<div class="col-4">		
						<label for="editorial">Editorial</label>
					</div>
					<div class="col-4">
						<select name="editorial" id="editorial" class="form-control">	
					   		<c:forEach items="${ editoriales }" var="editorial">
						   		<option  value="${ editorial.id }" ${ ( editorial.id == libro.editorial.id) ? 'selected' : '' }>${ editorial.nombre }</option>
					   		</c:forEach>
						</select>
					</div>		
				</div>
      		     
      		    <!-- OPERACIÓN = GUARDAR -->	
      			<input type="hidden" name="op" value="<%= ICRUDController.OP_GUARDAR %>">
      			
      			<input type="submit" value="${ (libro.id == -1) ? 'Crear' : 'Modificar' }" class="btn btn-primary btn-block mt-3">
      		
      		</form>
      		
      </div> <!-- row -->        
  </div> <!-- #page-wrapper -->   
</div>
<%@ include file="../include/footer.jsp" %>

