<%@page import="com.ipartek.formacion.youtube.Usuario"%>
<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

<div id="page-wrapper">
	<div class="row">

		<div class="col-lg-12">
			<h1 class="page-header">${(video.id == -1)?'Crear Video': video.nombre }</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">

		<form action="videos" method="post">


			<div class="form-group">
				<label for="id">Id</label> <input type="text" class="form-control"
					name="id" id="id" value="${video.id}" readonly>
			</div>

			<div class="form-group">
				<label for="codigo">Codigo</label> <input type="text"
					class="form-control" name="codigo" id="codigo"
					value="${video.codigo}" autofocus>
			</div>

			<div class="form-group">
				<label for="nombre">Nombre</label> <input type="text"
					class="form-control" name="nombre" id="nombre"
					value="${video.nombre}" autofocus>
			</div>


			<input type="submit"
				value="${(video.id == -1)?'Crear': 'Modificar'}"
				class="btn btn-primary btn-block">
			<c:if test="${video.id > 0 }">
				<a href="videos?id=${video.id}&op=borrar" onclick="confirmar(event)"
					class="btn btn-danger btn-block">Eliminar(Confirmar)</a>
			</c:if>
		</form>

		
</div>
</div>


<%@ include file="../includes/footer.jsp" %>