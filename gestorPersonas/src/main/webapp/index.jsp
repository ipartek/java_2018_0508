<%@ include file="includes/header.jsp"%>
<%@ include file="includes/nav.jsp"%>

<div class="main-content">
	<section class="section">
		<div class="section-body">
			<div class="row justify-content-center mb-4">
				<div class="col-10">
					<div>
			
		<%@include file="includes/alert.jsp"%>

						<form action="persona" class="form-inline my-2 my-lg-0" method="GET">
							<input type="hidden" name="op" value="2">
							<select name="filtro" class="form-control" >
								<option value="0">Seleccionar...</option>
								<option value="1">DNI</option>
								<option value="2">Email</option>
								<option value="3">Nombre apellidos</option>
							</select>
      						<input name="palabra" class="form-control mr-sm-2" type="search" placeholder="Inserte las palabras" aria-label="Search">
      						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
    					</form>
   					</div>
   					<br/>
					<div class="card">
						<div class="card-header">
							<%@ include file="../includes/alert.jsp"%>
							<h4>Listado Personas</h4>
						</div>
						<div class="card-body">
							<c:if test="${empty personas}">
								<div>Aún no hay personas</div>
							</c:if>
							<c:if test="${not empty personas}">
								<!--  datatables -->
								<table id="tablaOrdenable" class="display" style="width: 100%">
									<thead>
										<tr>
											<th>Nombre</th>
											<th>Apellido1</th>
											<th>Apellido2</th>
											<th>Email</th>
											<th>DNI</th>
											<th>Editar</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${personas}" var="p">
											<tr>
												<td>${p.nombre}</td>
												<td>${p.apellido1}</td>
												<td>${p.apellido2}</td>
												<td>${p.email}</td>
												<td>${p.dni}</td>
												<td><a class="btn btn-secondary"
													href="persona?op=1&id=${p.id}" role="button">Editar</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

<%@ include file="includes/footer.jsp"%>
