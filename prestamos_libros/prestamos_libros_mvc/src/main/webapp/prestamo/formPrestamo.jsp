<%@include file="includes/taglibs.jsp"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/topbar.jsp"%>

<div class="container mt-2">

	<c:if test="${not empty alert}">
		<%@include file="includes/alert.jsp"%>
	</c:if>

	<h1>Formulario préstamo</h1>
	
	<hr>
	
	<div class="row">
		<div class="col-lg-12">
<%-- 			<h3 class="page-header">${(libro.id==-1)?'Crear nuevo libro':libro.titulo}</h3> --%>
			<c:if test="${ empty prestamo.fecha_fin }">
				<h3 class="page-header">Prestar</h3>
			</c:if>
			<c:if test="${not empty prestamo.fecha_fin }">
				<h3 class="page-header">Modificar</h3>
			</c:if>
			
			
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	
<%-- 	<c:if test="${not empty prestamo}"> --%>
		<form action ="home?op=2" method="post">				
				
				<div class="form-row">
					<div class="col">
						<div class="form-group">
							<label class="" for="alumnoUpdate">Alumno: </label>
							<select class="form-control" required name="alumnoUpdate" id="alumnoUpdate">
								<option value="-1">Seleccione un alumno</option>
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
								<option value="-1">Seleccione un libro</option>
								<c:forEach items="${libros}" var="l">
									<option value="${l.id}" ${(prestamo.libro.id==l.id)?'selected':''}>${l.id} - ${l.titulo}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				
				<div class="form-row">
					<div class="col col-6">
						<div class="form-group">
							<label class="" for="fechaInicioUpdate">Fecha de inicio del préstamo: </label>
							<input class="form-control" type="date" step="1"name="fechaInicioUpdate" required value="${(prestamo.fecha_prestado==null)?fechaActual:prestamo.fecha_prestado}">
						</div>
					</div>
					<c:if test="${not empty prestamo.fecha_fin}">
						<div class="col col-6">
							<div class="form-group">
								<label class="" for="fechaInicio">Fecha de fin del préstamo: </label>
								<input class="form-control" type="date" step="1"name="fechaFin" required value="${prestamo.fecha_fin}">
							</div>
						</div>
						<!-- Parametros ocultos para modificar -->						
						<input class="form-control" type="hidden" name="alumno" id="alumno" value="${prestamo.alumno.id}">
						<input class="form-control" type="hidden" name="libro" id="libro" value="${prestamo.libro.id}">
						<input class="form-control" type="hidden" name="fechaInicio" id="fechaInicio" required value="${prestamo.fecha_prestado}">
					</c:if>
				</div>
				
				
				
				<div class="row mt-4 mb-4">
					<div class="col-md-4 offset-md-8">
						<input class="form-control btn btn-outline-primary" type="submit" value="${(prestamo.fecha_fin==null)?'Crear':'Modificar'}">
					</div>
				</div>
			</form>
		<hr>
<%--    	</c:if> --%>
	
	<hr>
		
</div>

<%@include file="includes/scripts.jsp"%>

<%@include file="includes/footer.jsp"%>