<%@page
	import="com.ipartek.formacion.prestamolibros.controller.CrudControllable"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/nav.jsp"%>

<div id="page-wrapper">

	<%@include file="../includes/alert.jsp"%>

	<div class="row">
		<form action="prestamos" method="post">
			
			<c:if test="${empty fechaDevuelto}">
			
				<div class="form-group">
					<label for="libro">Libro:</label>
					<select id="libro" name="libro" class="form-control">
						<option value="${libro.id}">${libro.id} - ${libro.titulo} (${libro.editorial.editorial})</option>
						<c:forEach items = "${libros}" var = "l">
							<option value="${l.id }">${l.id} - ${l.titulo} (${l.editorial.editorial})</option>
						</c:forEach>
					</select>			
				</div>
				
				<div class="form-group">
					<label for="alumno">Alumno:</label>
					<select id="alumno" name="alumno" class="form-control">
						<option value="${alumno.id}">${alumno.nombre} ${alumno.apellidos}</option>
						<c:forEach items = "${alumnos}" var = "a">
							<option value="${a.id }">${a.nombre} ${a.apellidos}</option>
						</c:forEach>
					</select>	
				</div>
				
			</c:if>
			
			<c:if test="${not empty fechaDevuelto}">
			
				<div class="form-group">
					<label for="libro">Libro:</label>
					<select id="libro" name="libro" class="form-control">
						<c:forEach items = "${todosLibros}" var = "l">
							<option value="${l.id }">${l.id} - ${l.titulo} (${l.editorial.editorial})</option>
						</c:forEach>
					</select>			
				</div>
				
				<div class="form-group">
					<label for="alumno">Alumno:</label>
					<select id="alumno" name="alumno" class="form-control">
						<c:forEach items = "${todosAlumnos}" var = "a">
							<option value="${a.id }">${a.nombre} ${a.apellidos}</option>
						</c:forEach>
					</select>	
				</div>
				
			</c:if>
			
			<div class="form-group">
				<label for="fechaInicio">Fecha de inicio</label>
				<input type="date" class="form-control" id="fechaInicio" name="fechaInicio" value="${fechaInicio}" required />
			</div>
			
			<div class="form-group">
				<label for="fechaFin">Fecha final</label>
				<input type="date" class="form-control" id="fechaFin" name="fechaFin" value="${fechaFin}" required />
			</div>
			
			<c:if test="${not empty fechaDevuelto}">
				<div class="form-group">
					<label for="fechaDevuelto">Fecha de devolución</label>
					<input type="date" class="form-control" id="fechaDevuelto" name="fechaDevuelto" value="${fechaDevuelto}" required />
				</div>
			</c:if>
			
			<input type="hidden" name="oldLibro" value="${libro.id}" />
			<input type="hidden" name="oldAlumno" value="${alumno.id}" />
			<input type="hidden" name="oldFechaInicio" value="${fechaInicio}" />
			
			<input type="hidden" name="op"
				value="7" /> <input type="submit"
				value="Modificar préstamo"
				class="btn btn-modificar btn-block" />
		

		</form>

	</div>

</div>
<%@include file="../includes/footer.jsp"%>