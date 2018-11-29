<%@ include file="includes/header.jsp"%>
<%@ include file="includes/nav.jsp"%>

<div class="main-content">
	<div class="container justify-content-center col-4 mb-2 ">
	
	<h1>
		<i class="fas fa-archive"></i> Alta de Persona
	</h1>
	<small>Los campos con * son obligatorios</small>

	<form action="persona" method="post">
		<input type="hidden" name="id" value="${persona.id}">
		<div class="form-row">
			<div class="form-group col">
				<label for="nombre" class="required">Nombre:</label> <input
					type="text" class="form-control" id="nombre" name="nombre"
					value="${persona.nombre}" required autofocus />
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col">
				<label for="apellido1" class="required"> Apellido 1 </label> <input
					type="text" class="form-control" id="apellido1" name="apellido1"
					value="${persona.apellido1}" required autofocus />
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col">
				<label for="apellido2" class="required"> Apellido 2 </label> <input
					type="text" class="form-control" id="apellido2" name="apellido2"
					value="${persona.apellido2}" required autofocus />
			</div>
		</div>

		<div class="form-row">
			<div class="form-group col">
				<label for="email" class="required"> Email </label> <input
					type="text" class="form-control" id="email" name="email"
					value="${persona.email}" required autofocus />
			</div>
		</div>
		<div class="form-row">
			<div class="form-group  col">
				<label for="dni" class="required"> DNI </label> <input type="text"
					class="form-control" id="dni" name="dni" value="${persona.dni}"
					required autofocus />
			</div>
		</div>

		<div class="form-row">
			<div class="form-group  col">
				<button type="submit" class="btn btn-outline-primary btn-block">
					Guardar</button>
			</div>
		</div>

	</form>
</div>
</div>

<%@ include file="includes/footer.jsp"%>