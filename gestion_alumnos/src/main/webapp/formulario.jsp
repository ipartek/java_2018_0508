
<%@ include file="includes/header.jsp"%>

        <div class="main">
        <h1><a class="badge badge-info boton-resumen-inicio" href="alumnos?op=1">Inicio</a><span>${alumno != null ? 'Editar Alumno' : 'Crear Alumno' }</span></h1>
    </div>
    <div class="row justify-content-md-center formulario-alumno align-items-center" >
       
        <div class="col-6">
        <form action="alumnos" method="post" class="formulario" novalidate="novalidate">
	           <p class="${ alerta.tipo }"> ${ alerta.texto}</p>
			<div class="form-row">

				<div class="form-group col-md-4">
				    <input type="hidden" name="op" value="3">
				    <input type="hidden" name="id" value="${alumno.id != null ? alumno.id : '-1'}">
					<label for="nombre">Nombre</label> <input type="text"
						class="form-control" name="nombre" value="${alumno.nombre }" id="nombre"
						pattern=".{1,150}" title="entre 1 y 150 caracteres" required="required" pattern=".{1,150}"
						title="Entre 1 y 150 caracteres" placeholder="(Entre 1 y 150 caracteres)">
				</div>
				<div class="form-group col-md-4">
					<label for="apellido1">Primer Apellido </label> <input type="text"
						class="form-control" name="apellido1" value="${alumno.apellido1 }" id="apellido1"
						pattern=".{1,150}" required="required" title="Entre 1 y 150 caracteres" placeholder="(Entre 1 y 150 caracteres)">
				</div>
				<div class="form-group col-md-4">
					<label for="apellido1">Segundo Apellido </label> <input type="text"
						class="form-control" name="apellido2" value="${alumno.apellido2 }" id="apellido2"
						pattern=".{1,150}" required="required" title="Entre 1 y 150 caracteres" placeholder="(Entre 1 y 150 caracteres)">
				</div>
			</div>

			<div class="form-row">

				<div class="form-group col-md-6">
					<label for="apellido1">Dni </label> <input type="text"
						pattern=".{9}" title="9 Caracteres" required="required" class="form-control" name="dni"  id="dni" value="${alumno.dni }" placeholder="Nº dni - (9 Caracteres 12345678x)">
				</div>
				<div class="form-group col-md-6">
					<label for="email">Email </label> <input type="email"
						class="form-control" title="Correo electronico del alumno" name="email" required="required" id="email" value="${alumno.email }" placeholder="Email - (alumno@dominio.com)">
				</div>
				</div>
				<div class="row ">
				    <div class="col-3"></div>
				    <div class="col-6">
					    
	                        <button class="btn btn-secondary btn-lg btn-block" type="submit">Guardar</button>
	                    
				    </div> 
				    <div class="col-3"></div>
				</div>
				
        </form>
    </div>
</div>

<%@ include file="includes/footer.jsp"%>