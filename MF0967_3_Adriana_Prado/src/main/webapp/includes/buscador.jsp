<div>
	<form action="home" method="post">
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="Buscar por nombre o chip..." minlength="2" aria-describedby="button-addon2" name="palabra">
			<div class="input-group-append">
				<input class="form-control btn btn-secondary" type="submit" value="Buscar" id="button-addon2">
			</div>
		</div>
	</form>
	
	<c:if test="${not empty palabra}">
		<p>Perros encontrados en la búsqueda: <b>${palabra}</b></p>
	</c:if>
</div>

