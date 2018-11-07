<%@include file="../includes/taglibs.jsp"%>
<%@include file="../includes/header.jsp"%>

<%@include file="../includes/topbar.jsp"%>

<div class="container">

	<c:if test="${not empty alert}">
		<%@include file="../includes/alert.jsp"%>
	</c:if>
	
	<hr>
	
	<h1 class="text-center">Alumnos</h1>
	
	<hr>
	
	<div class="row justify-content-end mt-2 mb-2">
		<div class="col col-2">
			<a href="alumno?id=-1&op=4" class="btn btn-success">Crear Nuevo</a>
		</div>
	</div>
	
	<hr>
	
		<div class="col col-lg-12">
			
			<table width="100%" class="table table-striped table-bordered table-hover" id="dataTable">
				<thead class="bg-info">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${alumnos}" var="a">
					   <tr>
					       <td>${a.id}</td>
					       <td><a href="alumno?id=${a.id}&op=4">${a.nombre}</a></td>
					       <td>
							<c:if test="${a.id > 0 }">
                           		<a href="alumno?id=${a.id}&op=3" onclick="confirmar(event)" class="btn btn-outline-danger btn-block">Eliminar</a>
                           	</c:if>
                            </td>
					   </tr>
				   </c:forEach>
				</tbody>
				<tfoot class="bg-info">
	               	<tr>
	               		<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col"></th>
	           		</tr>
               </tfoot>
			</table>
	</div>
	
	<hr>
		
</div>

<%@include file="../includes/scripts.jsp"%>

<%@include file="../includes/dataTablesGenericas.jsp"%>

<%@include file="../includes/footer.jsp"%>