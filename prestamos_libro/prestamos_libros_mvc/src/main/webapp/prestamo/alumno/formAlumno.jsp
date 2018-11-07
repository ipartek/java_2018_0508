<%@include file="../includes/taglibs.jsp"%>
<%@include file="../includes/header.jsp"%>

<%@include file="../includes/topbar.jsp"%>

<div class="container">

	<c:if test="${not empty alert}">
		<%@include file="../includes/alert.jsp"%>
	</c:if>
	
	<hr>

	<h1 class="text-center">Formulario Alumno</h1>
	
	<hr>
	
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header">${(alumno.id==-1)?'Crear nuevo alumno:':alumno.nombre}</h3>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	
	<hr>
	
	<form action ="alumno?op=2" method="post">
		<div class="form-row">
			<div class="col col-lg-2">
				<div class="form-group">
					<label class="" for="id">Id: </label> 
					<input class="form-control" readonly="readonly" type="text" name="id" value="${(alumno.id==-1)?'':alumno.id}" min-length="2" max-length="50" required>
				</div>
			</div>
			<div class="col">
				<label class="" for="nombreUpdate">Nombre: </label> 
					<input class="form-control" type="text" name="nombre" placeholder="Inserte el nuevo nombre" value="${alumno.nombre}">
			</div>
		</div>
		
		<div class="row mt-4 mb-4">
			<div class="col-md-4 offset-md-8">
				<input class="form-control btn btn-outline-primary" type="submit" value="${(alumno.id==-1) ? 'Crear':'Actualizar' }">
			</div>
		</div>
	</form>  	
	<hr>
		
</div>

<%@include file="../includes/scripts.jsp"%>

<%@include file="../includes/footer.jsp"%>