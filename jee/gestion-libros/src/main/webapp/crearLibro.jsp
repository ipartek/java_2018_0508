
	<%@ include file = "includes/header.jsp" %>

	<%@ include file = "includes/navbar.jsp" %>
	
	
	<div class="media center ">
		
		<h1>Crear Libro</h1>
	
		<form action="crear-libro" method="POST">
			
			<input name="titulo" type="text" placeholder="Titulo" value="${titulo}" autofocus><br><br>
			<input name="isbn" type="text" placeholder="ISBN" value="${isbn}"><br><br>
			<input name="editorial" type="text" placeholder="Editorial" value="${editorial}"><br><br>
			<input name="prestado" type="checkbox" value="${prestado}"><span class="texto-check">Prestado</span><br><br>
			<input class="btn btn-gestion-libros" type="submit" value="Crear Libro">
			
		</form>
		
		<h3 class="center text-danger">${msg}</h3>
	</div>

	<%@ include file = "includes/footer.jsp" %>