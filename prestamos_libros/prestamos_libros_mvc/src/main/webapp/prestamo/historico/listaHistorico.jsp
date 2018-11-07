<%@include file="../includes/header.jsp"%>

<%@include file="../includes/topbar.jsp"%>

<%@include file="../includes/taglibs.jsp"%>

<div class="container mt-2">

	<c:if test="${not empty alert}">
		<%@include file="../includes/alert.jsp"%>
	</c:if>
	
	<hr>

	<h1 class="text-center">Histórico de préstamos</h1>
	
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
						<th scope="col">Fecha de devolución</th>
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
							<td>${p.fecha_retorno}</td>
							<td><a class="btn btn-success btn-block" href="historico?op=4&alumno=${p.alumno.id}&libro=${p.libro.id}&fechaInicio=${p.fecha_prestado}">Modificar</a></td>
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
	           		</tr>
               </tfoot>
			</table>	
		</div>
	</div>
	
	<hr>	
</div>

<%@include file="../includes/scripts.jsp"%>

<%@include file="../includes/dataTablesHistorico.jsp"%>

<%@include file="../includes/footer.jsp"%>