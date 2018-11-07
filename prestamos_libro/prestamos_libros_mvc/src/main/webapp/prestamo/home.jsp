<%@include file="includes/header.jsp"%>

<%@include file="includes/topbar.jsp"%>

<%@include file="includes/taglibs.jsp"%>

<%@page import="com.ipartek.formacion.controller.HomeController"%>

<div class="container mt-2">

	<c:if test="${not empty alert}">
		<%@include file="includes/alert.jsp"%>
	</c:if>
	
	<hr>

	<h1 class="text-center">Listado de préstamos pendientes</h1>
	
	<hr>
	
	<div class="row justify-content-end mt-2 mb-2">
		<div class="col col-2">
			<a href="home?op=4" class="btn btn-success">Nuevo préstamo</a>
		</div>
	</div>
	
	<hr>
	
	<div class="row">
		<div class="col-lg-12">
			<table width="100%" class="table table-striped table-bordered table-hover" id="dataTable">
				<thead class="bg-info">
					<tr>
						
						<th scope="col">Libro</th>
						<th scope="col">Alumno</th>
						<th scope="col">Fecha prestado</th>
						<th scope="col">Fecha límite</th>
						<th scope="col">Días restantes</th>	
						<th scope="col"></th>
						<th scope="col"></th>					
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${prestamos}" var="p">
						<tr>							
							<td>${p.libro.titulo}</td>
							<td>${p.alumno.nombre}</td>
							<td>${p.fecha_prestado}</td>
							<td>${p.fecha_fin}</td>
							<td class="${HomeController.diasRestantes(p.fecha_fin)>0?'':'moroso'}"><strong>${HomeController.diasRestantes(p.fecha_fin)}</strong></td>
					  		<td><button onclick="showModalEditar(${p.libro.id}, ${p.alumno.id}, '${p.fecha_prestado}')" class="btn btn-success btn-block">Devolver</button>
					  		<td><a class="btn btn-success btn-block" href="home?op=4&alumno=${p.alumno.id}&libro=${p.libro.id}&fechaInicio=${p.fecha_prestado}&fechaFin=${p.fecha_fin}">Modificar</a></td></td>
					   </tr>
				   </c:forEach>
				</tbody>
				<tfoot class="bg-info">
	               	<tr>	               		
						<th scope="col">Libro</th>
						<th scope="col">Alumno</th>
						<th scope="col">Fecha prestado</th>
						<th scope="col">Fecha límite</th>
						<th scope="col">Días restantes</th>	
						<th scope="col"></th>
						<th scope="col"></th>					
	           		</tr>
               </tfoot>
			</table>	
		</div>
	</div>
	
	<hr>
	
	<!-- Modal Devolver Libro-->
	<div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="modalEditar" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalCenterTitle">Devolver libro</h4>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- Formulario para devolver libro -->
					<form id="formEditar" class="form-inline navbar-nav ml-auto" action="home?op=6" method="post">
						<input type="hidden" class="form-control" id="libro" name="libro" value="-1">
						<input type="hidden" class="form-control" id="alumno" name="alumno" value="-1">
						<input type="hidden" class="form-control" id="fechaInicio" name="fechaInicio" value="-1">
						<div class="form-row justify-content-center">
							<div class="col col-6">
								<div class="form-group">
									<label class="mr-2" for="fechaRetorno">Fecha de devolución del libro: </label>
									<input class="form-control" type="date" step="1" name="fechaRetorno" id="fechaRetorno" required>
								</div>
							</div>
						</div>
						<div class="form-row mt-4 mb-2">
							<div class="col">
								<div class="form-group">
									<input class="form-control btn btn-primary btn-block" type="submit" value="Devolver">
								</div>
							</div>
						</div>
					</form> 	
				</div>
			</div>
		</div>
	</div>
		
</div>

<%@include file="includes/scripts.jsp"%>

<%@include file="includes/dataTablesPrestamos.jsp"%>

<%@include file="includes/footer.jsp"%>