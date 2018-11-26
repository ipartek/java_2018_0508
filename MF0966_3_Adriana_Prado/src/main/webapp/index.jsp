<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main class="container">
	<c:if test="${not empty alert}">
		<%@include file="includes/alert.jsp"%>
	</c:if>
	
	<c:if test="${personas.size() < 1}">
		<div class="alert alert-info alert-dismissible fade show text-center" role="alert">
			<span>No se han encontrado registros en la base de datos. Pulsa en <strong>Migrar datos</strong>
				para insertar los registros del fichero <i class="fas fa-long-arrow-alt-right"></i>
				<a href="personas?op=5" class="btn btn-dark btn-sm">Migrar datos</a>
			</span> 
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	
	<hr>
	
	<h1 class="text-center">Personas</h1>
	
	<hr>
	
	<div class="row justify-content-end mt-2 mb-2">
		<div class="col col-2">
			<a href="personas?id=-1&op=3" class="btn btn-success">Crear Nuevo</a>
		</div>
	</div>
	
	<hr>
	
	<div class="row">
		<div class="col">
			<form action="personas?op=4" method="post">
				<div class="input-group mb-3">
					<input type="text" name="palabra" class="form-control" placeholder="Buscar... (nombre, email, dni)" aria-label="Buscar... (nombre, email, dni)" aria-describedby="button-addon2">
					<div class="input-group-append">
						<select class="btn btn-outline-secondary dropdown-toggle" name="opcionBuscar">
					        <option selected value="-1">Selecciona una opción</option>
					        <option value="nombreBuscar">Nombre y/o apellidos</option>
					        <option value="dniBuscar">DNI</option>
					        <option value="emailBuscar">Correo electrónico</option>
						</select>
						<input class="btn btn-outline-secondary" type="submit" id="button-addon2" value="Buscar">
					</div>
				</div>
			</form>
		</div>
	</div>
	
	
	<hr>
	
		<div class="col col-lg-12">
			
			<table width="100%" class="table table-striped table-bordered table-hover" id="dataTable">
				<thead class="bg-dark text-white">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido 1</th>
						<th scope="col">Apellido 2</th>
						<th scope="col">DNI</th>
						<th scope="col">Email</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${personas}" var="p">
					   <tr>
					       <td>${p.id}</td>
					       <td><a href="personas?id=${p.id}&op=3">${p.nombre}</a></td>
					       <td>${p.apellido1}</td>
					       <td>${p.apellido2}</td>
					       <td>${p.dni}</td>
					       <td>${p.email}</td>
					   </tr>
				   </c:forEach>
				</tbody>
				<tfoot class="bg-dark text-white">
	               	<tr>
	               		<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido 1</th>
						<th scope="col">Apellido 2</th>
						<th scope="col">DNI</th>
						<th scope="col">Email</th>
	           		</tr>
               </tfoot>
			</table>
	</div>
</main>

<%@include file="includes/footer.jsp"%>