	<%@ include file = "includes/header.jsp" %>

	<%@ include file = "includes/navbar.jsp" %>
	
	<h1>Conversor</h1>
	
	<div class="container">
		<section class="contain">	
			<div class="conversor">
				<h2>De Metros a Pies:</h2>
				<form action="conversor" method="POST">
					<input type="text" name="metros" placeholder="Introduce el numero de metros...">
					<input type="hidden" name="formulario" value="1">
					<br>
					<input class="btn btn-gestion-libros" type="submit" value="Convertir">
				</form>
			</div>
			
			<div class="conversor">
				<h2>De Pies a Metros:</h2>
				<form action="conversor" method="POST">
					<input type="text" name="pies" placeholder="Introduce el numero de pies...">
					<input type="hidden" name="formulario" value="2">
					<br>
					<input class="btn btn-gestion-libros" type="submit" value="Convertir">
				</form>
			</div>
			<h3 class="center">${msg}</h3>
		</section>
		<section class="contain">
			<div>
				<h2 class="conversion">${conversion}</h2>
			</div>
		</section>
	</div>
	
	<%@ include file = "includes/footer.jsp" %>