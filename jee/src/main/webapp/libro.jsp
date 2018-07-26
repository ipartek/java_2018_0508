<%@ include file="includes/header.jsp" %>	
<%@ include file="includes/navbar.jsp" %>

	<form action="libro" method="post">
		<fieldset>
			
			<legend>Información del libro</legend>
			
			<label for="titulo">Título</label>
			<input type="text" name="titulo" value="${titulo}" />
			
			<label for="isbn">ISBN</label>
			<input type="text" name="isbn" value="${isbn}" />
			
			<label for="editorial">Editorial</label>
			<input type="text" name="editorial" value="${editorial}" />
			
			<input type="checkbox" name="prestado" />
			<label for="prestado">El libro está prestado</label>
			
			<p class="text-danger">${msg}</p>
			
			<input type="submit" value="Crear libro" />
			
		</fieldset>
	</form>


<%@ include file="includes/footer.jsp" %>