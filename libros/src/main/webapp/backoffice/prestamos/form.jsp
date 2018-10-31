<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file="../include/header.jsp" %>
<%@ include file="../include/nav.jsp" %>

  <div class="container">
  
  	  <%@ include file="../include/alert.jsp" %>
  
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">${ not empty prestamo ? 'Crear Prestamo' : prestamo.libro.nombre }</h1>
          </div>
      </div>
      
      <div class="row">
      ${ prestamo }
      		      		
      		<form action="prestamos" method="post">
					
				<div class="form-row">
					<div class="col">
				   		<label for="nuevoLibro">Libro</label>
				   	</div>
				   	<div class="col">
						<!-- CARGAR LIBROS -->
						<select name="nuevoLibro" class="form-control">
							<option value="${ prestamo.libro.id }" selected>${ prestamo.libro.titulo }</option>
					   		<c:forEach items="${ libros }" var="libro">
						   		<option value="${ libro.id }" ${ ( libro.id == prestamo.libro.id) ? 'selected' : '' }>${ libro.titulo }</option>
					   		</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-row">
					<div class="col">
				   		<label for="nuevoAlumno">Alumno</label>
				   	</div>
				   	<div class="col">
						<!-- CARGAR ALUMNOS -->
						<select name="nuevoAlumno" class="form-control">
							<option value="${ prestamo.alumno.id }" selected>${ prestamo.alumno.nombre }</option>	
					   		<c:forEach items="${ alumnos }" var="alumno">
						   		<option value="${ alumno.id }" ${ ( alumno.id == prestamo.alumno.id) ? 'selected' : '' }>${ alumno.nombre }</option>
					   		</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-row">
					<div class="col">
				   		<label for="nuevaFecha">Fecha de Inicio</label>
				   	</div>
				   	<div class="col">
				   		<input type="date" class="form-control" name="nuevaFecha" value="${ prestamo.fechaInicio }">
					</div>
				</div>
				
				<div class="form-row">
					<div class="col">
				   		<label for="fechaFin">Fecha de Fin</label>
				   	</div>
				   	<div class="col">
				   		<input type="date" class="form-control" name="fechaFin" value="${ prestamo.fechaFin }">
					</div>
				</div>
      		    
      		    <input type="hidden" name="alumno" value="${ prestamo.alumno.id }">
      		    <input type="hidden" name="libro" value="${ prestamo.libro.id }">
      		    <input type="hidden" name="fechaInicio" value="${ prestamo.fechaInicio }">
      		    <!-- OPERACIÓN = GUARDAR -->	
      			<input type="hidden" name="op" value="<%= ICRUDController.OP_GUARDAR %>">
      			
      			<input type="submit" value="Modificar" class="btn btn-primary btn-block">
      		
      		</form>  
      		
      </div> <!-- row -->        
  </div> <!-- #page-wrapper -->   

<%@ include file="../include/footer.jsp" %>

