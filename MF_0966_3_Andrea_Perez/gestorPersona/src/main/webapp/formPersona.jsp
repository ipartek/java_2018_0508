<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<div class="container">
<h1 class="text-center text-muted">FORMULARIO PERSONA</h1>
	<!-- Tratamiento de alertas -->
	<c:if test="${alert.texto!=null}">
		<div class="alert ${alert.tipo} alert-dismissible show" role="alert">
			<p>${alert.texto}</p>
		 	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		 		<span aria-hidden="true">&times;</span>
		 	</button>
		</div>		
	</c:if>
		
	<form action ="home?op=2" method="post">
		<div class="row justify-content-center align-items-center">
			<div class="form-row">						
					<div class="form-group col-lg-3">
						<div class="input-group">	
							<label for="titulo">Nombre: </label> 
							<input class=" form-control input-sm" type="text" name="nombre" placeholder="min 2 max 50" value="${persona.nombre}" required>
						</div>
					</div>					
					
					<div class="form-group col-lg-3">
						<div class="input-group">	
							<label class="" for="isbnUpdate">Primer Apellido: </label>
							<input class="form-control input-sm" type="text" name="apellido1" placeholder="min 2 max 50 caracteres" value="${persona.apellido1}" maxlength="45" required>
						</div>
					</div>
					
					<div class="form-group col-lg-3">
						<div class="input-group">	
							<label class="" for="isbnUpdate">Segundo Apellido: </label>
							<input class="form-control input-sm" type="text" name="apellido2" placeholder="min 2 max 50 caracteres" value="${persona.apellido2}" maxlength="45" required>
						</div>
					</div>								
				
					<div class="form-group col-lg-3">
						<div class="input-group">
							<input class="form-control input-sm" readonly="readonly" type="hidden" name="id" value="${(persona.id<=0)?'':persona.id}" min-length="2" max-length="45" required>
						</div>
					</div>
				</div>
			
			<div class="form-row">				
				<div class="form-group col-lg-4">
					<div class="input-group">	
						<label class="col-form-label" for="dni">DNI: </label> 
						<input class="form-control" type="text" name="dni" value="${persona.dni}" placeholder="Ejemplo: 12345678A" min-length="9" max-length="9" required>
					</div>
				</div>
				
				<div class="form-group col-lg-4">
					<div class="input-group">	
						<label class="col-form-label" for="email">Correo electrónico: </label> 
						<input class="form-control" type="email" name="email" placeholder="Ejemplo: admin@admin.com" value="${persona.email}" max-length="50">
					</div>
				</div>				
			
			</div>	
								
			<div class="row mt-4 mb-4">				
					<input class=" btn-lg form-control btn btn-primary " type="submit" value="${(persona.id<=0) ? 'Crear':'Actualizar' }">
			</div>
		</div>			
	</form>
</div>
<%@include file="includes/footer.jsp"%>