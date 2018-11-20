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
      
      <div class="row justify-content-center">
      		      		
      		<form action="prestamos" method="post">
      		
      		
					
				<div class="form-row" id="rowLibro">
					<div class="col-4">
				   		<label for="libros">Libro</label>
				   	</div>
				   	<div class="col-4">
						<!-- CARGAR LIBROS -->
						<select name="libros" class="form-control" id="libros">
							<option value="${ prestamo.libro.id }" selected>${ prestamo.libro.titulo }</option>
					   		<c:forEach items="${ libros }" var="libro">
						   		<option value="${ libro.id }" ${ ( libro.id == prestamo.libro.id) ? 'selected' : '' }>${ libro.titulo }</option>
					   		</c:forEach>
						</select>
						<div class="row">
						  <div class="form-row" id="rowTitulo" style="display:none;">
			                    <div class="col">
			                        <label for="nuevoTitulo">Título</label> 
			                    </div>
			                    <div class="col">
			                        <input type="text" name="nuevoTitulo" >
			                    </div>
			            </div>
            
			            <div class="form-row" id="rowIsbn" style="display:none;">
			                    <div class="col">
			                        <label for="nuevoIsbn">ISBN</label>   
			                    </div>
			                    <div class="col">
			                        <input type="text" name="nuevoIsbn" >
			                    </div>
			            </div>
                
			            <div class="form-row" id="rowNumLibros" style="display:none;">
			                    <div class="col">
			                        <label for="ejemplares">Num Ejemplares</label> 
			                    </div>
			                    <div class="col">
			                        <input type="number" name="ejemplares" >
			                    </div>
			            </div>
            
			            <div class="form-row" id="rowEditorial" style="display:none; ">
			                <div class="col-4">     
			                    <label for="editorial">Editorial</label> 
			                </div>
			                <div class="col-4">
			                    <select name="editorial" id="editorial" class="form-control"  >   
			                        <c:forEach items="${ editoriales }" var="editorial">
			                            <option  value="${ editorial.id }" ${ ( editorial.id == libro.editorial.id) ? 'selected' : '' } >${ editorial.nombre }</option>
			                        </c:forEach>
			                    </select>
			                    <input type="hidden" class="form-control"  name="nuevaEditorial" id="nuevaEditorial" placeholder="nombre de la nueva editorial" required="required">
			                </div>
			                <div class="col-2">
	                            <button id="botonNuevadit" type="button" onclick="ocultarEditoriales()" class="btn btn-lg btn-primary">Nueva editorial</button>
	                             <button id="botonListado" style="display:none;" type="button" onclick="mostrarEditoriales()" class="btn  btn-lg btn-primary">Lista editoriales</button>
                            </div>  
			            </div>
		             </div>
						
					</div>
					<div class="col-4">
					   <button id="btnNuevoLibro" type="button" onclick="ocultarLibros()" class="btn btn-primary">Nuevo Libro</button>
                        <button id="btnListaLibro" style="display:none;" type="button" onclick="mostrarLibros()" class="btn btn-primary">Mostrar Libros</button>
					</div>
					
				</div>
				
				
				
				<div class="form-row" id="rowAlumno">
					<div class="col-4">
				   		<label for="nuevoAlumno">Alumno</label>
				   	</div>
				   	<div class="col-4">
						<!-- CARGAR ALUMNOS -->
						<select name="alumnos" class="form-control" id="alumnos">
							<option value="${ prestamo.alumno.id }" selected>${ prestamo.alumno.nombre }</option>	
					   		<c:forEach items="${ alumnos }" var="alumno">
						   		<option value="${ alumno.id }" ${ ( alumno.id == prestamo.alumno.id) ? 'selected' : '' }>${ alumno.nombre }</option>
					   		</c:forEach>
						</select>
						<input type="hidden" class="form-control"  name="nuevoAlumno" id="nuevoAlumno" placeholder="nombre del nuevo alumno" >
					</div>
					<div class="col-4">
					   <button id="btnNuevoAlumno" type="button" onclick="ocultarAlumnos()" class="btn btn-primary">Nuevo Alumno</button>
                        <button id="btnListaAlumno" style="display:none;" type="button" onclick="mostrarAlumnos()" class="btn btn-primary">Mostrar Alumnos</button>
					</div>
				</div>
				
				
				<div class="form-row" id="rowInicio">
					<div class="col-4">
				   		<label for="fechaInicio">Fecha de Inicio</label>
				   	</div>
				   	<div class="col-4">
				   		<input type="date" class="form-control" name="fechaInicio" value="${ prestamo.fechaInicio }" >
					</div>
				</div>
				
				<div class="form-row" id="rowFin">
					<div class="col-4">
				   		<label for="fechaFin">Fecha de Fin</label>
				   	</div>
				   	<div class="col-4">
				   		<input type="date" class="form-control" name="fechaFin" value="${ prestamo.fechaFin }">
					</div>
				</div>
      		    
      		    <input type="hidden" name="alumnoOrig" value="${ prestamo.alumno.id }">
      		    <input type="hidden" name="libroOrig" value="${ prestamo.libro.id }">
      		    <input type="hidden" name="fechaIOrig" value="${ prestamo.fechaInicio }">
      		    <input type="hidden" name="fechaFinOrig" value="${ prestamo.fechaFin }">
      		     <input type="hidden" name="fechaRetornoOrig" value="${ prestamo.fechaRetorno }">
      		    <!-- OPERACIÓN = GUARDAR -->
      		    <input type="hidden" name="id" value="${ prestamo.alumno.id == -1 ? '-1' : '${ prestamo.alumno.id }' }">	
      			<input type="hidden" name="op" value="<%= ICRUDController.OP_GUARDAR %>">
      			<input type="submit" value="${ prestamo.alumno.id == -1 ? 'Crear' : 'Modificar' }" class="btn btn-primary btn-block">
      		
      		</form>  
      		
      </div> <!-- row -->        
  </div> <!-- #page-wrapper -->   

<%@ include file="../include/footer.jsp" %>

