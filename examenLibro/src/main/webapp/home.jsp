<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>
<div class="container-fluid" style="width: 60rem;">
	<div class="row">
		<div class="col-sm">
			<form method="get" action="navegacion" class="form-inline">
				<div class="form-group row">
					<button type="submit" class="btn btn-link">Ir a Página</button>
					<input class="form-control col-sm-2" type="text" name="selecPagina">
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm">
			<a href="navegacion?operacion=anterior" class="btn btn-primary">Anterior</a>
		</div>
		<div class="col-sm">
			<a href="navegacion?operacion=siguiente" class="btn btn-primary float-right">Siguiente</a>
		</div>
	</div>
	<div class="row">
		<div class="col-sm">
			<h1>PAGINA : ${numPagina +1 } / ${numPagTotal}</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm">
			<div class=" jumbotron">
				<h2>${pagina.texto}</h2>
				<p>Autor ${pagina.usuario.nombre}</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm">
			<a href="navegacion?operacion=anterior" class="btn btn-primary">Anterior</a>
		</div>
		<div class="col-sm">
			<a href="navegacion?operacion=siguiente" class="btn btn-primary float-right">Siguiente</a>
		</div>
	</div>
	<div class="row">
		<c:if test="${not empty usuario}">
			<h3>Insertar nueva página</h3>
			<form method="post" action="alta">
				<textarea name="texto"></textarea>
				<button type="submit">Insertar</button>
			</form>
		</c:if>
	</div>
</div>

<%@ include file="includes/footer.jsp"%>