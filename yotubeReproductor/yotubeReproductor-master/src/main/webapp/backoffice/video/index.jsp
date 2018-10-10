<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Videos <span class="badge">${videos.size()}</span></h1> 
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-8">Todo Buscador con su lupita todo txula</div>
		<div class="col-md-4">
			<a href="videos?id=-1&op=4"" class="btn btn-success">Crear Nuevo</a>
		</div>
	</div>

	<div class="row">
		<table id="tablaOrdenable" class="display" style="width: 100%">
			<thead>
				<tr>
					<th>id</th>
					<th>nombre</th>
					<th>usuario</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${videos}" var="v">
					<tr>
						<td>${v.id}</td>
						<td><a href="videos?id=${v.id}&op=4">${v.nombre}</td></a>
						<td>${v.usuario.nombre}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>id</th>
					<th>nombre</th>
					<th>usuario</th>
				</tr>
			</tfoot>
		</table>
	</div>

</div>

<%@ include file="../includes/footer.jsp" %>    