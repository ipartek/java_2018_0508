<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Videos</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-8">Todo Buscador con su lupita todo txula</div>
		<div class="col-md-4">
			<a href="videos?id=-1" class="btn btn-success">Crear Nuevo</a>
		</div>
	</div>

	<div class="row">
		<table id="tablaOrdenable" class="display" style="width: 100%">
			<thead>
				<tr>
					<th>id</th>
					<th>codigo</th>
					<th>nombre</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${videos}" var="v">
					<tr>
						<td>${v.id}</td>
						<td>${v.codigo}</td>
						<td><a href="videos?id=${v.id}">${v.nombre}</td></a>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>id</th>
					<th>codigo</th>
					<th>nombre</th>
				</tr>
			</tfoot>
		</table>
	</div>

</div>

<%@ include file="../includes/footer.jsp" %>    