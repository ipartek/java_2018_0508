<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>

<div class="contenedor col-sm-12">
   <main role="main" class="container">
   
	<table class="table">
		<tr>
			<th scope="col">Nombre</th>
			<th scope="col">Edad</th>
			<th scope="col">Raza</th>
			<th scope="col">Peso</th>
			<th scope="col">Imagen (URL)</th>
			<th scope="col">Apadrinado</th>
			<th scope="col">Chip</th>
			<th scope="col">Longitud</th>
			<th scope="col">Latitud</th>
		</tr>
		<c:forEach items="${perros}" var="perro">
			<tr>
				<td>${perro.nombre}</td>
				<td>${perro.edad }</td>
				<td>${perro.raza }</td>
				<td>${perro.peso }</td>
				<td><img src="${perro.imagen}" /></td>
			

				<td>${perro.chip.numIdentificacion }</td>
				<td>${perro.chip.longitud }</td>
				<td>${perro.chip.latitud }</td>
					<c:if test="${perro.apadrinado}">
					<td>Apadrinado</td>
				</c:if>
				<c:if test="${!perro.apadrinado}">
					<td>no Apadrinado</td>
					<td><button type="submit" class="btn btn-link">Adoptar</button></td>
				</c:if>
				
			</tr>
		</c:forEach>
	</table>
	     </main>

</div>
<!-- /.contenido -->


<%@ include file="includes/footer.jsp"%>
