<%@page
	import="com.ipartek.formacion.prestamolibros.controller.CrudControllable"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/nav.jsp"%>

<div id="page-wrapper">

	<%@include file="../includes/alert.jsp"%>

	<div class="row">
		<form action="prestamos" method="post">
			
			<div class="form-group">
				<label for="libro">Libro:</label>
				<select id="libro" name="libro" class="form-control">
				<option>Selecciona el libro</option>
					<c:forEach items = "${libros}" var = "l">
						<option value="${l.id }">${l.id} - ${l.titulo} (${l.editorial.editorial})</option>
					</c:forEach>
				</select>			
			</div>
			
			<div class="form-group">
				<label for="alumno">Alumno:</label>
				<div class="input-group">
					<select id="alumno" name="alumno" class="form-control">
						<option>Selecciona el alumno</option>
						<c:forEach items = "${alumnos}" var = "a">
							<option value="${a.id }">${a.nombre} ${a.apellidos}</option>
						</c:forEach>
					</select>
				    <span class="input-group-btn">
				    	<button class="btn btn-default" type="button" onclick="showModalNuevoAlumno()"><i class="fas fa-plus" ></i></button>
				    </span>		
				</div>
			</div>
			
			<div class="form-group">
			<label for="fechaInicio">Fecha inicio:</label>
			<input type="date" class="form-control" id="fechaInicio" name="fechaInicio" value="${fechaInicio}"/>
			
			</div>
			
			<input type="hidden" name="op"
				value="<%=CrudControllable.OP_GUARDAR%>" /> <input type="submit"
				value="Prestar"
				class="btn btnCrear btn-block" />
		

		</form>

	</div>
	
	
	<!-- Modal Nuevo Alumno -->
			<div class="modal fade" id="modalNuevoAlumno" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h4 class="modal-title" id="exampleModalLabel">Nuevo Alumno</h4>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			      	<form action="alumnos" method="post">
			      	
			      		<div class="form-group">
				      		<label for="nombre">Nombre</label>
				        	<input type="text" class="form-control" id="nombreAlumno" name="nombre" autofocus/>
			        	</div><div class="form-group">
				      		<label for="apellidos">Apellidos</label>
				        	<input type="text" class="form-control"id="apellidosAlumno" name="apellidos"/>
			        	</div>
			        	<div class="modal-footer">
			        		<button type="submit" id="btnAnadirAlumno" class="btn btn-modificar">Crear</button>	
			        		<button type="button" class="btn btn-finalizar" data-dismiss="modal">Cerrar</button>			        
			      </div>
			        	
			        	<input type="hidden" name="id" id="id" value="-1"/>
			        	<input type="hidden" name="op" value=<%=CrudControllable.OP_GUARDAR %> />
			        	
			        </form>
			      </div>
			    </div>
			  </div>
			</div>

</div>
<%@include file="../includes/footer.jsp"%>