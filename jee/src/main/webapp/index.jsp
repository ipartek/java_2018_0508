
	<%@ include file = "includes/header.jsp" %>

	<%@ include file = "includes/navbar.jsp" %>

	<h1>CMS Prestamo Libros</h1>

	<%
		// Esto es Java
		//out.print("<p>Soy Java</p>");
	%>
	<br><br>
	<h2>Por POST</h2>
	<form action="saludo" method="POST">
		
		<input name="nombre" type="text" placeholder="Dime tu nombre">
		<p class="text-danger">${msg}</p>
		<input name="ap1" type="text" placeholder="Dime tu primer apellido"><br><br>
		<input name="ap2" type="text" placeholder="Dime tu segundo apellido"><br><br>
		<input class="btn btn-gestion-libros" type="submit" value="Enviar">
		
	</form>

	<%@ include file = "includes/footer.jsp" %>