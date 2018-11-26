<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<div class="container">

	<c:if test="${not empty alert}">
		<%@include file="includes/alert.jsp"%>
	</c:if>
	
	<hr>

	<h1 class="text-center">Formulario Persona</h1>
	
	<hr>
	
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header">${(persona.id==-1)?'Crear nueva persona:':persona.nombre}</h3>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	
	<hr>
	
	<form action ="personas?op=2" method="post">
		<div class="form-row">
			<div class="col col-lg-2">
				<div class="form-group">
					<label class="" for="id">Id: </label> 
					<input class="form-control" readonly="readonly" type="text" name="id" value="${(persona.id==-1)?'':persona.id}" required>
				</div>
			</div>
			<div class="col">
				<label class="" for="nombre">Nombre: </label> 
					<input class="form-control" autofocus type="text" name="nombre" placeholder="Min. 2 y máx. 50 caracteres" value="${persona.nombre}" min-length="2" max-length="50" >
			</div>
		</div>
		<div class="form-row">
			<div class="col">
				<div class="form-group">
					<label class="" for="apellido1">Primer apellido: </label> 
					<input class="form-control" type="text" name="apellido1" value="${persona.apellido1}" placeholder="Min. 2 y máx. 50 caracteres" min-length="2" max-length="50" required>
				</div>
			</div>
			<div class="col">
				<label class="" for="apellido2">Segundo apellido: </label> 
					<input class="form-control" type="text" name="apellido2" placeholder="Min. 2 y máx. 50 caracteres" value="${persona.apellido2}" min-length="2" max-length="50">
			</div>
		</div>
		
		<div class="form-row">
			<div class="col">
				<div class="form-group">
					<label class="" for="dni">DNI: </label> 
					<input class="form-control" type="text" name="dni" value="${persona.dni}" placeholder="Ejemplo: 12345678A" min-length="8" max-length="9" required>
				</div>
			</div>
			<div class="col">
				<label class="" for="email">Correo electrónico: </label> 
					<input class="form-control" type="email" name="email" placeholder="Ejemplo: admin@admin.com" value="${persona.email}" max-length="50">
			</div>
		</div>
		
		<div class="row mt-4 mb-4">
			<div class="col-md-4 offset-md-8">
				<input class="form-control btn btn-outline-primary" type="submit" value="${(persona.id==-1) ? 'Crear':'Actualizar' }">
			</div>
		</div>
	</form>  	
	<hr>
		
</div>

<%@include file="includes/footer.jsp"%>