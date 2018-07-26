<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>

<h1>Registro de libros</h1>

<form class="libro" action="libro" method="post">
		<input type="text" name="titulo" placeholder="Introduzca el título del libro"required autofocus />
		<input type="number" name="isbn" placeholder="Introduzca el isbn" required minlength="5"/>
		<input type="text" name="editorial" placeholder="Introduzca la editorial" required />
		<input type="checkbox" name="prestado"value=false />
		
		
		<br/> <input type="submit" value="Crear" required />

	</form>
	<p>${msg}</p>
<%@ include file="includes/footer.jsp"%>