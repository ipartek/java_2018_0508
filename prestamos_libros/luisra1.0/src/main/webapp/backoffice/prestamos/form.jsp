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
      		      		
      		<form action="prestamos" method="post">
      		
      		<div class="form-row" id="rowTitulo" style="display:none;">
      				<div class="col">
      					<label for="nuevoTitulo">Título</label>	
      				</div>
      				<div class="col">
      					<input type="text" name="titulo">
      				</div>
      		</div>
      		
      		<div class="form-row" id="rowIsbn" style="display:none;">
      				<div class="col">
      					<label for="nuevoTitulo">ISBN</label>	
      				</div>
      				<div class="col">
      					<input type="text" name="isbn">
      				</div>
      		</div>
      			
      		<div class="form-row" id="rowNumLibros" style="display:none;">
      				<div class="col">
      					<label for="nuevoTitulo">Num Ejemplares</label>	
      				</div>
      				<div class="col">
      					<input type="number" name="ejemplares">
      				</div>
      		</div>
      		
      		<div class="form-row" id="rowEditorial" style="display:none;">
	      		<div class="col-4">		
					<label for="editorial">Editorial</label> 
				</div>
				<div class="col-4">
					<select name="editorial" id="editorial" class="form-control">	
				   		<c:forEach items="${ editoriales }" var="editorial">
					   		<option  value="${ editorial.id }" ${ ( editorial.id == libro.editorial.id) ? 'selected' : '' }>${ editorial.nombre }</option>
				   		</c:forEach>
					</select>
					<input type="hidden" class="form-control"  name="nuevaEditorial" id="nuevaEditorial" placeholder="nombre de la nueva editorial" >
				</div>
			</div>
					
				<div class="form-row" id="rowLibro">
					<div class="col">
				   		<label for="nuevoLibro">Libro</label>
				   	</div>
				   	<div class="col">
						<!-- CARGAR LIBROS -->
						<select name="nuevoLibro" class="form-control" id="nuevoLibro">
							<option value="${ prestamo.libro.id }" selected>${ prestamo.libro.titulo }</option>
					   		<c:forEach items="${ libros }" var="libro">
						   		<option value="${ libro.id }" ${ ( libro.id == prestamo.libro.id) ? 'selected' : '' }>${ libro.titulo }</option>
					   		</c:forEach>
						</select>
					</div>
					
				</div>
				
				<div class="form-row" >
					<div class="col">
						<button id="btnNuevoLibro" type="button" onclick="ocultarLibros()" class="btn btn-block btn-primary">Nuevo Libro</button>
						<button id="btnListaLibro" style="display:none;" type="button" onclick="mostrarLibros()" class="btn btn-block btn-primary">Mostrar Libros</button>
					</div>
				</div>
				
				<div class="form-row" id="rowAlumno">
					<div class="col">
				   		<label for="nuevoAlumno">Alumno</label>
				   	</div>
				   	<div class="col">
						<!-- CARGAR ALUMNOS -->
						<select name="nuevoAlumno" class="form-control" id="nuevoAlumno">
							<option value="${ prestamo.alumno.id }" selected>${ prestamo.alumno.nombre }</option>	
					   		<c:forEach items="${ alumnos }" var="alumno">
						   		<option value="${ alumno.id }" ${ ( alumno.id == prestamo.alumno.id) ? 'selected' : '' }>${ alumno.nombre }</option>
					   		</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="col">
						<button id="btnNuevoAlumno" type="button" onclick="ocultarAlumnos()" class="btn btn-block btn-primary">Nuevo Alumno</button>
						<button id="btnListaAlumno" style="display:none;" type="button" onclick="mostrarAlumnos()" class="btn btn-block btn-primary">Mostrar Alumnos</button>
					</div>
				</div>
				
				<div class="form-row" id="rowInicio">
					<div class="col">
				   		<label for="nuevaFecha">Fecha de Inicio</label>
				   	</div>
				   	<div class="col">
				   		<input type="date" class="form-control" name="nuevaFecha" value="${ prestamo.fechaInicio }">
					</div>
				</div>
				
				<div class="form-row" id="rowFin">
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

