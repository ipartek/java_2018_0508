<%@include file="../includes/taglibs.jsp"%>
<%@include file="../includes/header.jsp"%>

<%@include file="../includes/topbar.jsp"%>

<div class="container mt-2">

	<c:if test="${not empty alert}">
		<%@include file="../includes/alert.jsp"%>
	</c:if>
	
	<hr>

	<h1 class="text-center">Formulario libro</h1>
	
	<hr>
	
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header">${(libro.id==-1)?'Crear nuevo libro:':libro.titulo}</h3>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	
	<hr>
	
	<c:if test="${not empty libro}">
		<form action ="altalibro?op=2" method="post">
				<div class="form-row">
					<div class="col col-lg-2">
						<div class="form-group">
							<label class="" for="id">Id: </label>
							<input class="form-control" readonly="readonly" type="text" name="id" value="${(libro.id==-1)?'':libro.id}" min-length="2" max-length="50" required>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label class="" for="titulo">Título: </label> 
							<input class="form-control" type="text" name="titulo" placeholder="Inserte el título" value="${libro.titulo}" required>
						</div>
					</div>
				</div>
				
				<div class="form-row">
					<div class="col">
						<div class="form-group">
							<label class="" for="isbnUpdate">ISBN: </label>
							<input class="form-control" type="text" name="isbn" placeholder="Inserte el isbn" value="${libro.isbn}" maxlength="13" required>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label class="" for="editorial">Editorial: </label>
							<select class="form-control" required name="editorial" id="editorialUpdate">
								<option value="-1">Seleccione una editorial</option>
								<c:forEach items="${editoriales}" var="e">
									<option value="${e.id}" ${(libro.editorial.id==e.id)?'selected':''}>${e.nombre}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<c:if test="${libro.id==-1}">
						<div class="col">
							<div class="form-group">
								<label class="" for="cant">Libros a ingresar: </label>
								<input class="form-control" type="text" name="cant" placeholder="Max. unidades: 20" value="${libro.cant}" maxlength="2" required>
							</div>
						</div>
					</c:if>	
				</div>
				
				<div class="row mt-4 mb-4">
					<div class="col-md-4 offset-md-8">
						<input class="form-control btn btn-outline-primary" type="submit" value="${(libro.id==-1) ? 'Crear':'Actualizar' }">
					</div>
				</div>
			</form>
		<hr>
   	</c:if>
	
	<hr>
		
</div>

<%@include file="../includes/scripts.jsp"%>

<%@include file="../includes/footer.jsp"%>