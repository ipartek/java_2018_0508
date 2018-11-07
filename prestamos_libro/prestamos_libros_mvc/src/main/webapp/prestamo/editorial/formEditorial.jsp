<%@include file="../includes/taglibs.jsp"%>
<%@include file="../includes/header.jsp"%>

<%@include file="../includes/topbar.jsp"%>

<div class="container">

	<c:if test="${not empty alert}">
		<%@include file="../includes/alert.jsp"%>
	</c:if>
	
	<hr>

	<h1 class="text-center">Formulario de editoriales</h1>
	
	<hr>
	
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header">${(editorial.id==-1)?'Crear nueva editorial:':editorial.nombre}</h3>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	
	<hr>
	
	<c:if test="${not empty editorial}">
		<form action ="editorial?op=2" method="post">
			<div class="form-row">
				<div class="col col-lg-2">
					<div class="form-group">
						<label class="" for="id">Id: </label> 
						<input class="form-control" readonly="readonly" type="text" name="id" value="${(editorial.id==-1)?'':editorial.id}" min-length="2" max-length="50" >
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label class="" for="nombre">Nombre: </label> 
						<input class="form-control" type="text" name="nombre" placeholder="Inserte el nuevo nombre" value="${editorial.nombre}" required>
					</div>
				</div>
			</div>
			<div class="row mt-4 mb-4">
				<div class="col-md-4 offset-md-8">
					<input class="form-control btn btn-outline-primary" type="submit" value="${(editorial.id==-1) ? 'Crear':'Actualizar' }">
				</div>
			</div>
		</form>
		<hr>
   	</c:if>
	
	<hr>
		
</div>

<%@include file="../includes/scripts.jsp"%>

<%@include file="../includes/footer.jsp"%>