<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<!-- Tratamiento de las alertas get POST-->
	    <c:if test="${empty alerta}">
	    	${alerta=null}
	    </c:if>
	    
		<c:if test="${not empty alerta}">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
  				<span >${alerta}</span>
  				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    				<span aria-hidden="true">&times;</span>
  				</button>
			</div>
		</c:if>	

<form action ="home?op=2" method="post">
				<div class="form-row">
					<div class="col col-lg-2">
						<div class="form-group">
							<label class="" for="id">Id: </label>
							<input class="form-control" readonly="readonly" type="text" name="id" value="${(persona.id==-1)?'':persona.id}" min-length="2" max-length="50" required>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label class="" for="titulo">Nombre: </label> 
							<input class="form-control" type="text" name="nombre" placeholder="min 2 max 50" value="${persona.nombre}" required>
						</div>
					</div>
				</div>
				
				<div class="form-row">
					<div class="col">
						<div class="form-group">
							<label class="" for="isbnUpdate">Primer Apellido: </label>
							<input class="form-control" type="text" name="apellido1" placeholder="min 2 max 50 caracteres" value="${persona.apellido1}" maxlength="50" required>
						</div>
						<div class="form-group">
							<label class="" for="isbnUpdate">Segundo Apellido: </label>
							<input class="form-control" type="text" name="apellido2" placeholder="min 2 max 50 caracteres" value="${persona.apellido2}" maxlength="50" required>
						</div>
						<div class="form-group">
							<label class="" for="isbnUpdate">Email: </label>
							<input class="form-control" type="email" name="email" placeholder="pepe@gmail.com" value="${persona.email}"  required>
						</div>
						<div class="form-group">
							<label class="" for="isbnUpdate">DNI: </label>
							<input class="form-control" type="text" name="dni" placeholder="99999999B" value="${persona.dni}" required>
						</div>
					</div>					
					
				</div>
				
				<div class="row mt-4 mb-4">
			<div class="col-md-4 offset-md-8">
				<input class="form-control btn btn-primary" type="submit" value="${(persona.id==-1) ? 'Crear':'Actualizar' }">
			</div>
		</div>
</form>

<%@include file="includes/footer.jsp"%>