<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<h1>Crear Libro</h1>
<form action="libro" method="post">
	<label for="titulo">Titulo: </label>
	<input name="titulo" type="text" value="${valorTitulo}"></input><br><br>
	
	<label for="editorial">Editorial: </label>
	<input name="editorial" type="text" value="${valorEditorial}"></input><br><br>
	
	<label for="isbn">ISBN: </label>
	<input name="isbn" type="text" "></input><br><br>
	
	<input type="submit" value="CREAR">
</form>

<p class="text-danger">${msg}</p>


<%@ include file="includes/footer.jsp" %>
