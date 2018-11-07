<%@include file="../includes/taglibs.jsp"%>
<%@include file="../includes/header.jsp"%>

<%@include file="../includes/topbar.jsp"%>

<div class="container mt-2">

	<c:if test="${not empty alert}">
		<%@include file="../includes/alert.jsp"%>
	</c:if>

	<h1>Formulario Modificar Libro Prestado</h1>
	
	<hr>
	
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header">Modificar</h3>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
		<form action="historico?op=2" method="post">				
			<div class="form-row">
			<div class="col">
				<div class="form-group">
					<label class="" for="alumnoUpdate">Alumno: </label>									
					<select class="form-control" required name="alumnoUpdate" id="alumnoUpdate">
						<c:forEach items="${alumnos}" var="a">
							<option value="${a.id}" ${(prestamo.alumno.id==a.id)?'selected':''}>${a.nombre}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<label class="" for="libroUpdate">Libro: </label>									
					<select class="form-control" required name="libroUpdate" id="libroUpdate">
						<c:forEach items="${libros}" var="l">
							<option value="${l.id}" ${(prestamo.libro.id==l.id)?'selected':''}>${l.titulo}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		
		<div class="form-row">
			<div class="col col-6">
				<div class="form-group">
					<label class="" for="fechaInicioUpdate">Fecha de inicio del préstamo: </label>
					
					<input class="form-control" type="date" step="1"name="fechaInicioUpdate" id="fechaInicioUpdate" required value="${prestamo.fecha_prestado}">
				</div>
			</div>
		</div>
		
		<div class="form-row">
			<div class="col col-6">
				<div class="form-group">
					<label class="" for="fechaRetorno">Fecha devolución del préstamo: </label>
					<input class="form-control" type="date" step="1"name="fechaRetorno" id="fechaRetorno" required value="${prestamo.fecha_retorno}">
				</div>
			</div>
			
		</div>
		
		<div class="form-row">
			<div class="col col-6">
				<div class="form-group">
					<label class="" for="fechaInicio">Fecha fin del préstamo: </label>
					
					<input class="form-control" type="date" step="1"name="fechaFin" id="fechaFin" required value="${prestamo.fecha_fin}">
				</div>
			</div>
		</div>
		
	<!-- Parametros ocultos para modificar -->						
		<input class="form-control" type="hidden" name="alumno" id="alumno" value="${prestamo.alumno.id}">
		<input class="form-control" type="hidden" name="libro" id="libro" value="${prestamo.libro.id}">
		<input class="form-control" type="hidden" name="fechaInicio" id="fechaInicio" required value="${prestamo.fecha_prestado}">
		
		<div class="row mt-4 mb-4">
			<div class="col-md-4 offset-md-8">
				<input class="form-control btn btn-outline-primary" type="submit" value="Modificar">
			</div>
		</div>
	</form>						
			
</div>

<%@include file="../includes/scripts.jsp"%>
<%@include file="../includes/footer.jsp"%>