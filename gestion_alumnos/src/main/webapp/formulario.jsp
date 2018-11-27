
<%@ include file="includes/header.jsp"%>
 <h1>${alumno != null ? 'Editar Alumno' : 'Crear Alumno' }</h1>
<div class="row justify-content-md-center " >
       
        <div class="col-6">
        <a class="badge badge-info" href="alumnos?op=1">Inicio</a>
<form action="alumnos" method="post" class="formulario">
	
			<div class="form-row">

				<div class="form-group col-md-3">
				    <input type="hidden" name="op" value="3">
				    <input type="hidden" name="id" value="${alumno.id != null ? alumno.id : '-1'}">
					<label for="nombre">Nombre</label> <input type="text"
						class="form-control" name="nombre" value="${alumno.nombre }" id="nombre"
						placeholder="Nombre">
				</div>
				<div class="form-group col-md-3">
					<label for="apellido1">Primer Apellido </label> <input type="text"
						class="form-control" name="apellido1" value="${alumno.apellido1 }" id="apellido1"
						placeholder="apellido2">
				</div>
				<div class="form-group col-md-3">
					<label for="apellido1">Segundo Apellido </label> <input type="text"
						class="form-control" name="apellido2" value="${alumno.apellido2 }" id="apellido2"
						placeholder="apellido2">
				</div>
			</div>

			<div class="form-row">

				<div class="form-group col-md-6">
					<label for="apellido1">Dni </label> <input type="text"
						class="form-control" name="dni" id="dni" value="${alumno.dni }" placeholder="dni">
				</div>
				<div class="form-group col-md-3">
					<label for="email">SEmail </label> <input type="email"
						class="form-control" name="email" id="email" value="${alumno.email }" placeholder="email">
				</div>
				</div>
				<div class="form-row">
                    <button class="btn btn-success" type="submit">Guardar</button>
                </div>
        </form>
    </div>
</div>

<%@ include file="includes/footer.jsp"%>